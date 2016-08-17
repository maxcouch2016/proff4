


function loginValidation() {
	
	var loginForm = document.forms["loginForm"];
	var login = loginForm.email.value;
	var password = loginForm.password.value;

		$.ajax({
			type: "POST",
			data: {login: login , password: password}, 
			url: "login",
			dataType: "json",
			success: function(data)	{
				if(data.url != "") {
					location.replace(data.url);
				} else if (data.url == ""){
					alert("invalid login or password! please try again.")
				}
			},
		});
}
