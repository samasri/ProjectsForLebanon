window.onload = function() {
	document.getElementById('signUpButton').onclick = signUp;
	document.getElementById('loginButton').onclick = login;
};

var signUp = function() {
	var fname = document.getElementById('form-first-name');
	var lname = document.getElementById('form-last-name');
	var email = document.getElementById('form-email');
	var mobileNumber = document.getElementById('form-mobile');
	var password1 = document.getElementById('form-password');
	var password2 = document.getElementById('form-repassword');
	var type;
	var type1 = document.getElementById('Whoareyou_0');
	var type2 = document.getElementById('Whoareyou_1');
	var type3 = document.getElementById('Whoareyou_2');
	var type4 = document.getElementById('Whoareyou_3');
	//alert(type1.checked + " " + type2.checked + " " + type3.checked + " " + type4.checked);
	//alert(fname.value + " " + lname.value + " " + mobileNumber.value + " " + password1.value + " " + password2.value);
	if(fname.value == '') {alert("First name is not set"); return;};
	if(lname.value == '') {alert("Last name is not set"); return;};
	if(email.value == '') {alert("Email is not set"); return;};
	if(email.value.indexOf('@') == -1) {alert("Email is invalid"); return;}
	if(mobileNumber.value == '') {alert("Mobile Number is not set"); return;};
	if(password1.value == '') {alert("Password is not set"); return;};
	if(password1.value != password2.value) {alert("Passwords are not identical"); return;};
	if(!(type1.checked || type2.checked || type3.checked || type4.checked)) {alert("Please choose the user type"); return;}
	else {
		if(type1.checked) type = 0;
		if(type2.checked) type = 1;
		if(type3.checked) type = 2;
		if(type4.checked) type = 3;
	}
	var data = {
			'fname': fname.value,
			'lname' : lname.value,
			'email' : email.value,
			'mobileNumber' : mobileNumber.value,
			'password1' : password1.value,
			'password2' : password2.value,
			'type' : type
	};
	ajaxRequest('POST', '/Project/SignUp', data);
	alert("You are now signed up, please sign in to continue");
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

var login = function() {
	var email = document.getElementById('email');
	var password= document.getElementById('password');
	ajaxRequest('POST', '/Project/Login', {'email' : email.value, 'password' : password.value}, processLogin );
};

var processLogin = function(data) {
	if(data == 'fail') alert('email/password combination does not exist');
	else {
		window.location.replace(data);
	}
};