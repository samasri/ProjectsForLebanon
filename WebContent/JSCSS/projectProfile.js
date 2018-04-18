var projectId;

window.onload = function() {
	projectId = document.getElementById('projectId').innerHTML;
	document.getElementById('editName').onclick= makeEditable;
	document.getElementById('editDate').onclick= makeEditable;
	document.getElementById('editfName').onclick= makeEditable;
	document.getElementById('editlName').onclick= makeEditable;
	document.getElementById('editEmail').onclick= makeEditable;
	document.getElementById('editPhoneNumber').onclick= makeEditable;
	document.getElementById('editAge').onclick= makeEditable;
	document.getElementById('editSkills').onclick= makeEditable;
	document.getElementById('editNeeds').onclick= makeEditable;
	document.getElementById('editLocation').onclick= handleLocation;
	document.getElementById('editTOS').onclick= handleTOS;
	document.getElementById('editStatus').onclick= startProject;
	searchOnLoad();
};

var makeEditable = function() {
	this.innerHTML = 'Save';
	var id = getTargetId(this.id);
	id = document.getElementById(id);
	id.readOnly = false;
	this.onclick = function(e, id) {
		var id = getTargetId(this.id);
		var element = document.getElementById(id);
		element.readOnly = true;
		data = {
				element: id, value: element.value, id: projectId
		};
		ajaxRequest('POST', '/Project/EditProject', data, response);
		this.onclick = makeEditable;
	};
};

var getTargetId = function(id) {
	return id.charAt(4).toLowerCase() + id.substring(5);
};

var response = function(data) {
	if(data == 'true') {
		alert('Your response has been recorded');
		window.location.replace('/Project/ProjectProfile?projectId='+projectId);
	}
	else alert('Sorry something went wrong, please try again');
};

var ajaxRequest = function(type, url, data, success, arg1, arg2, arg3) {
	 $.ajax (
      {
          type : type,
          url : url,
          data : data,
          cache: false,
          success: success,
          fail: function(){}
	});
};

var handleLocation = function() {
	ajaxRequest('GET', '/Project/GetKadaa', null, function(data) {
		var div = document.getElementById('locationP');
		$('#location1').html('Enter the new location');
		$('#location2').hide(500);
		$('#editLocation').html('Save');
		var detached = $('#editLocation');
		data = data.split(', ');
		
		var select = document.createElement('select');
		select.id = 'locationSelect';
	    var option;

		for (var i = 0; i < data.length; i++) {
		    option = document.createElement('option');
		    option.setAttribute('value', data[i]);
		    option.appendChild(document.createTextNode(data[i]));
		    select.appendChild(option);
		}
		
		div.appendChild(select);
		detached.appendTo($('#locationDiv'));
		
		document.getElementById('editLocation').onclick = function() {
			var element = document.getElementById('locationSelect');
			data = {
					element: 'location', value: element.value, id: projectId
			};
			ajaxRequest('POST', '/Project/EditProject', data, response);
			this.onclick = handleLocation;
		};
	});
};

var getSelectValues = function(select) {
	var result = '';
	var options = select && select.options;
	var opt;

	for (var i=0, iLen=options.length; i<iLen; i++) {
		opt = options[i];

		if (opt.selected) {
			result += (opt.value || opt.text);
			if(i != iLen-1) result += ', ';
		} 
	}
	result = result.trim();
	if(result.charAt(result.length-1) == ',') result = result.substring(0, result.length-1);
	return result.trim();
};

var handleTOS = function() {
	ajaxRequest('GET', '/Project/GetTOS', null, function(data) {
		$('#TOS1').html('Enter new set of services: ');
		$('#TOS2').hide(500);
		var div = document.getElementById('TOSp');
		
		var detached = $('#editTOS').html('Save').detach();
		
		data = data.split(', ');
		
		var select = document.createElement('select');
		select.id = 'TOSSelect';
		select.multiple = true;
	    var option;

		for (var i = 0; i < data.length; i++) {
		    option = document.createElement('option');
		    option.setAttribute('value', data[i]);
		    option.appendChild(document.createTextNode(data[i]));
		    select.appendChild(option);
		}
		
		div.appendChild(select);
		detached.appendTo($('#TOSp'));
		
		document.getElementById('editTOS').onclick = function() {
			var element = document.getElementById('TOSSelect');
			element = getSelectValues(element);
			data = {
					element: 'TOS', value: element, id: projectId
			};
			ajaxRequest('POST', '/Project/EditProject', data, response);
			this.onclick = handleLocation;
		};
	});
};

var startProject = function() {
	var projectId = document.getElementById('projectId').innerHTML;
	var data = {
			projectId: projectId
	};
	ajaxRequest('POST', '/Project/StartProject', data, startConfirm);
};

var startConfirm = function(data) {
	if(data == 'success') {
		alert('Your project is now started');
		window.location.replace('/Project/ProjectProfile?projectId='+projectId);
	}
	else {
		alert(data);
	}
};