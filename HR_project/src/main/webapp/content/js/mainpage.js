

function setTable (vNumber){
	
	$.ajax({
		type: "GET",
		data: "number="+vNumber,
		url: "returnValues",
		dataType: "json",
		success: function(data)	{
			// tableWorkers
			// countPages
			if(data.tableWorkers!=''){
				$("#myTable").html(data.tableWorkers);
			}
		},
	});
}

function getFoundWorkers(){
	var searchForm = document.forms["searchForm"];
	var name =  searchForm.names.value;
	
	$.ajax({
		type: "GET",
		data: "name="+name,
		url: "findWorkers",
		dataType: "json",
		success: function(data)	{
			
			
				
				$("#myTable").html(data.foundWorkers);
			
			
		},
	});
}