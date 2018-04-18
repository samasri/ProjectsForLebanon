window.onload = function() {
	if(document.getElementById('editOrgName')) document.getElementById('editOrgName').onclick = makeEditable;
	if(document.getElementById('editGroupName')) document.getElementById('editGroupName').onclick = makeEditable;
	if(document.getElementById('editFName')) document.getElementById('editFName').onclick = makeEditable;
	if(document.getElementById('editLName')) document.getElementById('editLName').onclick = makeEditable;
	if(document.getElementById('editEmail')) document.getElementById('editEmail').onclick = makeEditable;
	if(document.getElementById('editPhoneNumber')) document.getElementById('editPhoneNumber').onclick = makeEditable;
	if(document.getElementById('editComments')) document.getElementById('editComments').onclick = makeEditable;
	if(document.getElementById('editSkills')) document.getElementById('editSkills').onclick = makeEditable;
	if(document.getElementById('editDonations')) document.getElementById('editDonations').onclick = makeEditable;
	if(document.getElementById('editWebsite')) document.getElementById('editWebsite').onclick = makeEditable;
	if(document.getElementById('editTOS')) document.getElementById('editTOS').onclick = handleTOS;
	if(document.getElementById('editLivingLocation')) document.getElementById('editLivingLocation').onclick = handleLocation;
	if(document.getElementById('editWorkingLocation')) document.getElementById('editWorkingLocation').onclick = handleLocation;
	if(document.getElementById('toggleEmail')) document.getElementById('toggleEmail').onclick = togglePrivacy;
	if(document.getElementById('togglePhoneNumber')) document.getElementById('togglePhoneNumber').onclick = togglePrivacy;
	$('.delete').click(deleteProject);
	document.getElementById('about').onclick = showAbout;
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
				onlyOne: id, element: element.value
		};
		ajaxRequest('POST', '/Project/EditProfile', data, response);
	};
};

var getTargetId = function(id) {
	return id.charAt(4).toLowerCase() + id.substring(5);
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

var response = function(data) {
	if(data == 'true') {
		alert('Your response has been recorded');
		window.location.replace('/Project/UserProfile');
	}
	else alert('Sorry something went wrong, please try again');
};

var handleWebsite = function() {
	$('#webAnchor').hide(500);
	$('#editWebsite').html('Save');
	var detached = $('#editWebsite').detach();
	var p = document.createElement('p');
	var input = document.createElement('input');
	p.innerHTML = 'Enter new website';
	p.id = 'newWebAnchor';
	input.id = 'website';
	document.getElementById('webDiv').appendChild(p);
	document.getElementById('webDiv').appendChild(input);
	detached.appendTo($('#webDiv'));
	this.onclick = function() {
		var id = getTargetId(this.id);
		var element = document.getElementById(id);
		element.readOnly = true;
		data = {
				onlyOne: id, element: element.value
		};
		ajaxRequest('POST', '/Project/EditProfile', data, response);
		this.onclick = handleWebsite;
	};
};

var handleTOS = function() {
	ajaxRequest('GET', '/Project/GetTOS', null, handleTOS2);
};

var handleTOS2 = function(data) {
	$('#editTOS').hide();
	$('#TOS1').hide(500);
	$('#TOS2').hide(500);
	data = data.split(', ');
	
	var p = document.createElement('p');
	p.innerHTML = 'Enter the new TOS';
	
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
	
	var editButton = document.createElement('button');
	editButton.id = 'editTOS2';
	editButton.innerHTML = 'Save';
	
	document.getElementById('TOSp').appendChild(p);
	document.getElementById('TOSp').appendChild(select);
	document.getElementById('TOSp').appendChild(editButton);
	
	document.getElementById('editTOS2').onclick = function() {
		var select = document.getElementById('TOSSelect');
		var element = getSelectValues(select);
		data = {
				onlyOne: 'tOS', element: element
		};
		ajaxRequest('POST', '/Project/EditProfile', data, response);
		this.onclick = handleTOS;
	};
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

var handleLocation = function() {
	if(this.id == 'editLivingLocation') ajaxRequest('GET', '/Project/GetKadaa', null, handleLivingLocation);
	else ajaxRequest('GET', '/Project/GetKadaa', null, handleWorkingLocation);
};
var handleLivingLocation = function(data) {
	var div = document.getElementById('livingLocationP');
	$('#editLivingLocation').hide();
	$('#livivngLocation1').hide(500);
	$('#livivngLocation2').hide(500);
	data = data.split(', ');
	
	var p = document.createElement('p');
	p.innerHTML = 'Enter the new location: ';
	
	var select = document.createElement('select');
	select.id = 'livingLocationSelect';
    var option;

	for (var i = 0; i < data.length; i++) {
	    option = document.createElement('option');
	    option.setAttribute('value', data[i]);
	    option.appendChild(document.createTextNode(data[i]));
	    select.appendChild(option);
	}
	
	var button = document.createElement('button');
	button.id = 'editLivingLocation2';
	button.innerHTML = 'Save';
	
	div.appendChild(p);
	div.appendChild(select);
	div.appendChild(button);
	
	
	document.getElementById('editLivingLocation2').onclick = function() {
		var select = document.getElementById('livingLocationSelect');
		var element = getSelectValues(select);
		data = {
				onlyOne: 'livingLocation', element: element
		};
		ajaxRequest('POST', '/Project/EditProfile', data, response);
		this.onclick = handleLivingLocation;
	};
};

var handleWorkingLocation = function(data) {
	var div = document.getElementById('workingLocationP');
	$('#livivngLocation1').hide(500);
	$('#livivngLocation2').hide(500);
	$('#editWorkingLocation').html('Save');
	var detached = $('#editWorkingLocation').detach();
	data = data.split(', ');
	
	var p = document.createElement('p');
	p.innerHTML = 'Enter the new working location: ';
	
	var select = document.createElement('select');
	select.id = 'workingLocationSelect';
	select.multiple = true;
    var option;

	for (var i = 0; i < data.length; i++) {
	    option = document.createElement('option');
	    option.setAttribute('value', data[i]);
	    option.appendChild(document.createTextNode(data[i]));
	    select.appendChild(option);
	}
	
	div.appendChild(p);
	div.appendChild(select);
	detached.appendTo($('#workingLocationP'));
	
	document.getElementById('editWorkingLocation').onclick = function() {
		var select = document.getElementById('workingLocationSelect');
		var element = getSelectValues(select);
		data = {
				onlyOne: 'workingLocation', element: element
		};
		ajaxRequest('POST', '/Project/EditProfile', data, response);
		this.onclick = handleLivingLocation;
	};
};

var togglePrivacy = function() {
	var id = this.id.charAt(6).toLowerCase() + this.id.substring(7);
	data = {typeOfPrivacy : id};
	ajaxRequest('POST', '/Project/TogglePrivacy', data, function(data) {
		if(data = 'success') {
			alert('Your response has been recorded');
			location.reload();
		}
		else alert('Are you trying to hack us?! If not, then log out and try again');
	});
};

var clickedProject;
var deleteProject = function() {
	var data = {id: this.id};
	clickedProject = this.id;
	ajaxRequest('POST', '/Project/DeleteProject', data, function(data) {
		if(data == 'success') $('#project'+clickedProject).hide(500);
		else alert("Error. Please log out and try again");
	});
};

var showAbout = function() {
	$('#info').hide(500);
	this.onclick = function() {
		$('#info').show(500);
		this.onclick = showAbout;
	};
};