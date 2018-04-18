var counter = 0;
var type;

var searchOnLoad = function() {
	document.getElementById('header').onclick = hide;
	document.onkeydown = exitSearch;
	
};

var hide = function() {
	$('#action').hide(500);
	$('#notifications').hide(500);
	$('#info').hide(500);
	$('#subConent').hide(500);
};

var show = function() {
	$('#action').show(500);
	$('#notifications').show(500);
	$('#info').show(500);
	$('#subConent').show(500);
};

var exitSearch = function(e) {
	
	if (e.keyCode == 27) {
		$('.searchResults').hide();		
		show();
		counter = 0;
    }
	else if((e.keyCode > 64 && e.keyCode < 91) || e.keyCode == 8 || (e.keyCode > 47 && e.keyCode < 58)){
		$('.searchResults').hide();
		var keyword = document.getElementById('search').value;
		type = getRadioValue('type');
		if(type == '') return;
		
		data = {
			keyword: keyword, type: type
		};
		
		if(counter == 0) {
			var div = document.createElement('div');
			div.id = 'searchResults';
			document.getElementById('content').appendChild(div);
		}
		
		ajaxRequest('GET', '/Project/GetSearch', data, showResults);
	}
};

var getRadioValue = function(name) {
	
	var radios = document.getElementsByName(name);

	for (var i = 0, length = radios.length; i < length; i++) {
	    if (radios[i].checked) {

	    	var type = radios[i].id;
	    	type = type.substring(0, type.length-5);
	    	
	        return type;
	    }
	}
	
	return '';
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

var showResults = function(data) {
	data = data.split('\n');
	//alert(data[0]);
	for(var i = 0; i < data.length-1; i++) {
		data[i] = JSON.parse(data[i]);
		var current = data[i];
		
		var currentDiv = document.createElement('div');
		currentDiv.className = 'searchResults';
		
		var img = document.createElement('img');
		img.src = current.imgURL;
		
		var p = document.createElement('p');
		if(type == 'needs') {
			p.innerHTML = 'Name: ' + current.fname + ' ' + current.lname + '<br>';
			p.innerHTML += 'Donations: ' + current.donations;
		}
		if (type == 'skill') {
			p.innerHTML = 'Name: ' + current.fname + ' ' + current.lname + '<br>';
			p.innerHTML += 'Skills: ' + current.skills;
		}
		if (type == 'name' | type == 'kadaa') {
			if(current.orgName != '') {
				p.innerHTML = 'Organization Name: ' + current.orgName + '<br>' +
				'Location: ' + current.workingLocation;
			}
			else if (current.groupName != '') p.innerHTML = 'Group Name: ' + current.groupName;
		}
		
		currentDiv.appendChild(img);
		currentDiv.appendChild(p);
		document.getElementById('searchResults').appendChild(currentDiv);
		
	}
};