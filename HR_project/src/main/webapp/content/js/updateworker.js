function findWorkerById(){
	
	var searchForm = document.forms["search-id-form"];
	var workersId = searchForm.id.value;
	document.getElementById("current-id-text").textContent = "current ID: ";
	document.getElementById("current-id").textContent = workersId;
	
	$.ajax({
		type: "GET",
		data: "id="+workersId , 
		url: "search",
		dataType: "json",
		success: function(data)	{
		/*	alert("1");
			alert(data.workerid);
			alert(data.firstname);
			alert(data.lastname);
			alert(data.salary);
			alert(data.date);*/
			if (data.answer == "FALSE") {
				alert("Invalid id, please type correct and existing id");
				document.getElementById("current-id").textContent = "Invalid id";
				}
			var updateForm = document.forms["updateWorkerForm"];
			updateForm.firstname.value = data.firstname;
			updateForm.lastname.value = data.lastname;
			updateForm.salary.value = data.salary;
			updateForm.birthdate.value = data.date;
			if (data.answer === "FALSE") {
				alert("error");
				}
		},
		error: function(){
			alert("error");
		}
	});
	
}

function updateWorker(){
	
	var foundedId = document.getElementById("current-id").textContent;
	alert(foundedId);
	
	var updateUserForm = document.forms["updateWorkerForm"];
	var firstName = updateUserForm.firstname.value;
	var lastName = updateUserForm.lastname.value;
	var salary = updateUserForm.salary.value;
	var birthDate = updateUserForm.birthdate.value;
	
	var status = document.getElementById("status").value;
	var department = document.getElementById("department").value;
	

	
	$.ajax({
		type: "POST",
		data: {id: foundedId , firstName: firstName , lastName: lastName , salary: salary , birthDate: birthDate ,
				status: status , department: department},  
		url: "update",
		dataType: "json",
		success: function(data)	{
			alert("ajax");
			if (data.answer =="OK"){
				alarm("worker updated succesfully");
			}
			if (data.answer == "FALSE") {
				alert("Invalid data, please type correct parametrs");
				document.getElementById("current-id").textContent = "Invalid id";
				}
			
		},
		error: function(){
			alert("error");
		}
	});
	
}
