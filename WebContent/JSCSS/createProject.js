window.onload = function() {
	document.getElementById('submit').onclick = submit;
};
var id;
var submit = function() {
	var name = document.getElementById('name').value;
	var TOS = getSelectValues(document.getElementById('TOSSelect'));
	var date = document.getElementById('date').value;
	var location = document.getElementById('locationSelect').value;
	var fName = document.getElementById('fName').value;
	var lName = document.getElementById('lName').value;
	var phoneNumber = document.getElementById('phoneNumber').value;
	var email = document.getElementById('email').value;
	var age = document.getElementById('age').value;
	var skills = document.getElementById('skill').value;
	var donations = document.getElementById('need').value;
	var comments= document.getElementById('comments').value;
	id = document.getElementById('id').innerHTML;
	
	if(name.trim() == '') { alert('Please insert the project name'); return; }
	if(TOS.trim() == '') { alert('Please insert the type of service'); return; }
	if(date.trim() == '') { alert('Please insert the preferred date'); return; }
	if(location.trim() == '') { alert('Please insert the location '); return; }
	if(fName.trim() == '') { alert('Please insert the contact person\' first name'); return; }
	if(lName.trim() == '') { alert('Please insert the contact person\'s last name'); return; }
	if(phoneNumber.trim() == '') { alert('Please insert the contact person\'s phone number'); return; }
	if(email.trim() == '') { alert('Please insert the contact person\'s email'); return; }
	if(age.trim() == '') { alert('Please insert the age range'); return; }
	if(skills.trim() == '') { alert('Please insert the skills needed'); return; }
	if(donations.trim() == '') { alert('Please insert the donations needed'); return; }
	if(comments.trim() == '') { alert('Please insert a brief description of the project'); return; }
	
	var data = {
			name: name, TOS: TOS, date: date, location: location, fName: fName, lName: lName, phoneNumber: phoneNumber, email: email, age: age, 
			skills: skills, donations: donations, comments: comments, id: id
	};
	ajaxRequest('POST', '/Project/EditProject?projectId' + id, data, response);
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
		window.location.replace('/Project/ProjectProfile?projectId=' + id);
	}
	else alert('Sorry something went wrong, please try again');
};