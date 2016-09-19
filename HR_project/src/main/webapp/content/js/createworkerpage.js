

function createWorker() {
	

	
	var createUserForm = document.forms["createWorkerForm"];
	var firstName = createUserForm.firstname.value;
	var lastName = createUserForm.lastname.value;
	var salary = createUserForm.salary.value;
	var birthDate = createUserForm.birthdate.value;
	
	var status = document.getElementById("status").value;
	var department = document.getElementById("department").value
	
	alert(department);

		$.ajax({
			type: "POST",
			data: {firstName: firstName , lastName: lastName , salary: salary , birthDate: birthDate ,
					status: status , department: department}, 
			url: "create_worker",
			dataType: "json",
			success: function(data)	{
				if (data.answer =="!"){
					alarm("worker created succesfully");
				} else {
					alarma(data.answer);
				}
			},
		});
}