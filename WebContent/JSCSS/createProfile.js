window.onload = function() {
	document.getElementById('submit').onclick = submit;
	
};

var submit = function() {
	var orgName = document.getElementById('orgName');
	var groupName = document.getElementById('groupName');
	var website = document.getElementById('website');
	var livingLocation = document.getElementById('livingLocation');
	var workingLocation = document.getElementById('workingLocation');
	var donations = document.getElementById('donations');
	var skills = document.getElementById('skills');
	var TOS = document.getElementById('TOSselect');
	var desc = document.getElementById('desc');
	var type = document.getElementById('type').innerHTML;

	if (type.toLowerCase() == 'organization' && orgName.value.trim() == '') { alert('Please add the name of your organization'); return; }
	if (type.toLowerCase() == 'group' && groupName.value.trim() == '') { alert('Please add the name of your group'); return; }
	if (workingLocation != null && workingLocation.value.trim() == '') { alert('Please add your working location'); return; }
	if (type.toLowerCase() == 'donor' && donations.value.trim() == '') { alert('Please add the donations you would like to volunteer with'); return; }
	if (type.toLowerCase() == 'mentor' && skills.value.trim() == '') { alert('Please add the skills you would like to share'); return; }
	if (TOS.value.trim() == '') { alert('Please add the Type of service you prefer to volunteer in'); return; }
	if (desc.value.trim() == '') { alert('Please add a small description to let people know more about you'); return; }
	
	if(orgName != null) orgName = orgName.value; else orgName = '';
	if(groupName != null) groupName = groupName.value; else groupName = '';
	if(website != null) website = website.value; else website = '';
	if(livingLocation != null) livingLocation = livingLocation.value; else livingLocation = '';
	if(workingLocation != null) workingLocation = getSelectValues(workingLocation); else workingLocation = '';
	if(donations != null) donations = donations.value; else donations = '';
	if(skills != null) skills = skills.value; else skills = '';
	if(TOS != null) TOS = getSelectValues(TOS); else TOS = '';
	if(desc != null) desc = desc.value; else desc = '';

	var data = {
			orgName : orgName, groupName : groupName, website : website, livingLocation : livingLocation, workingLocation : workingLocation, 
			donations : donations, skills : skills, TOS : TOS, desc : desc, type : type
	};
	ajaxRequest('POST', '/Project/EditProfile', data, response);
} ;

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