$(document).ready(function() {

	function setData(username, password){
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "auth",
			data : "username=" + username + "pass=" + password,
			dataType : 'json',
			timeout : 100000,
			success : function(res) {
				console.log("SUCCESS");
				console.log(res);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	}
	
	$("#login_btn").click(function() {
		
//		var regLogin = new RegExp("\\s");
//		var regLogin = new RegExp("a-Z");
		
		if ($("#login_input").val() == '') {
			$("#login_input").css("background-color", "orange");
		}
//		else if ($("#login_input").val().search("\\s") != -1) {
//			$("#login_input").css("background-color", "orange");
//		}
//		else if ($("#login_input").val().search("^[a-zA-Z]") != -1) {
//		else if (!(/[a-zA-Z]/.test($("#login_input").val()))) {
		else if (!(/\w/.test($("#login_input").val()))) {
			$("#login_input").css("background-color", "orange");
			alert("!!!");
		}
		else {
			$("#login_input").css("background-color", "#3b4148");
			$("#login_input").css("border", "none");
		}
		
		
		if ($("#login_pass").val() == '') {
			$("#login_pass").css("background-color", "orange");
		}
		
		setData($("#login_input").val(), $("#login_pass").val());
		
	});
	
});