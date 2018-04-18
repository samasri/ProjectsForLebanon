window.onload = function() {
	ajaxRequest('GET', '/Project/GetNotifications', null, processNotifications);
	ajaxRequest('GET', '/Project/GetProjects', null, displayProjects);
	
	$('#updateProfileB').click(function () {
		window.location.href = '/Project/UserProfile';
	});
	$('#createProjectB').click(function () {
		window.location.href = '/Project/CreateProject';
	});
	//searchOnLoad();
};

var processNotifications = function(data) {
	data = data.split('\n');
	var ul = document.getElementById('notificationDiv');

	for(var i = 0; i < data.length-1; i++) {
		data[i] = JSON.parse(data[i]);
		var current = data[i];

		if(current.type == 'ACCEPTEDProject') {
			var li = document.createElement('div');
			li.innerHTML = 'Your project <a href="/Project/ProjectProfile?projectId=' + current.projectID + '"> ' + current.projectName + ' </a>' +  
			 'has been accepted and now will be displayed publicly!';
			ul.appendChild(li);
		}
		else if (current.type == 'REJECTEDProject') {
			var li = document.createElement('div');
			li.innerHTML = 'Your project <a href="/Project/ProjectProfile?projectId=' + current.projectID + '"> ' + current.projectName + ' </a>' +  
			 'has been rejected: ' + current.comment;
			ul.appendChild(li);
		}
		else if (current.type == 'CONNECTED') {
			var li = document.createElement('div');
			li.innerHTML = 'Your project <a href="/Project/ProjectProfile?projectId=' + current.projectID + '"> ' + current.projectName + ' </a>' +  
			 'has been chosen by <a href="/Project/VolunteerProfile?email=' + current.groupEmail + '"> ' + current.groupName + ' </a>';
			li.innerHTML += '<br>Would you like to accept this group to do the project?';
			
			var yes = document.createElement('button');
			yes.className = 'decision';
			yes.innerHTML = 'yes';
			yes.id = 'yes' + current.projectID + ':' + current.groupEmail; //used to send ajax response (if the user accepts this connection or not)
			
			var no = document.createElement('button');
			no.className = 'decision';
			no.innerHTML = 'no';
			no.id = 'no' + current.projectID + ':' + current.goupEmail; //used to send ajax response (if the user accepts this connection or not)
			
			var responseDiv = document.createElement('div');
			responseDiv.className = 'response';
			responseDiv.hidden = true;
			
			var textarea = document.createElement('textarea');
			textarea.placeholder = 'Please provide your feedback for acceptance or  rejection';
			textarea.id = 'textarea' + current.projectID;
			
			var submitResponse = document.createElement('button');
			submitResponse.hidden = true;
			submitResponse.innerHTML = 'submit';
			submitResponse.id = 'submitResponse' + current.projectID;

			responseDiv.appendChild(textarea);
			responseDiv.appendChild(submitResponse);
			responseDiv.id = 'responseDiv' + current.projectID;
			
			yes.onclick = function() {
				var id = this.id.substring(3);
				id.split(':');
				var groupEmail = id[1];
				id = id[0];
				$('#responseDiv'+ id).show(500);
				$('#submitResponse' + id).show(500);
				document.getElementById('submitResponse' + id).id = 'Y' + id;
				ajaxRequest('POST', '/Project/DecideProject', { 'choice' : 'yes', 'project' : id, 'group' : groupEmail});
				$(this).hide(1000);
				$('#no'+ id).hide(1000);
			};
			no.onclick = function() {
				var id = this.id.substring(2);
				$('#responseDiv'+ id).show(500);
				$('#submitResponse' + id).show(500);
				document.getElementById('submitResponse' + id).id = 'N' + id;
				$(this).hide(1000);
				$('#yes' + id).hide(1000);		
			};
			submitResponse.onclick = function() {
				var choice = (this.id.substring(0, 1) == 'Y' ? 'yes' : 'no');
				var id = this.id.substring(1);
				var comment = document.getElementById('textarea' + id).value;
				ajaxRequest('POST', '/Project/DecideProject', { 'choice' : choice, 'project' : id, 'comment': comment});
				$(this.parentNode.parentNode).hide(500);
			};
			
			li.appendChild(yes);
			li.appendChild(no);
			ul.appendChild(li);
			if(responseDiv != null) li.appendChild(responseDiv);
		}
		
		else if(current.type == 'ACCEPTEDUser') {
			var li = document.createElement('div');
			li.innerHTML = 'You were accepted to work in <a href="/Project/ProjectProfile?projectId=' + current.projectID + '"> ' + current.projectName 
			+ ' </a>!';
			ul.appendChild(li);
		}
		
		else if(current.type == 'REJECTEDUser') {
			var li = document.createElement('div');
			li.innerHTML = 'You were not accepted to work in <a href="/Project/ProjectProfile?projectId=' + 
			current.projectID + '"> ' + current.projectName + '. </a>: ' + current.comment;
			ul.appendChild(li);
		}
			li.className = 'caption';
			var notifications = document.getElementById('notifications');
			notifications.appendChild(li);
			if(i != data.length - 2) {
				var hr = document.createElement('hr');
				notifications.appendChild(hr);
			}
	}
	
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

var displayProjects = function(data) {
	data = data.split('\n');
	if(data.length == 1) {
		var noProject = document.createElement('p');
		noProject.innerHTML = 'No projects yet';
		var projectDiv = document.getElementById('projectDiv');
		projectDiv.appendChild(noProject);
		return;
	}
	var ul = document.getElementById('projectDiv');
	
	for(var i = 0; i < data.length-1; i++) {
		var current = JSON.parse(data[i]);
		
		var li = document.createElement('div');
		li.className = 'caption';
		
		var a = document.createElement('a');
		var img = document.createElement('img');
		img.src = current.picURL;
		img.className = 'projectImages';
		a.appendChild(img);
		a.href='/Project/ProjectProfile?projectId=' + current.projectID;
		
		var par = document.createElement('p');
		par.innerHTML = 'Name: ' + current.name + '<br>';
		par.innerHTML += 'Status: ' + current.status + '<br>';
		par.className = 'projectPar';

		li.appendChild(a);
		if(current.owner == 'true') {
			var icon = document.createElement('img');
			icon.className = 'owner';
			//icon.src = img.src;
			icon.src = 'img/project.png';
			icon.className = 'projectOwnerImages';
			icon.title = 'Created by you';
			li.appendChild(icon);
		}
		li.appendChild(par);
		ul.appendChild(li);
		//ul.innerHTML += '<br><br>';
	}
	document.getElementById('action').appendChild(ul);
};