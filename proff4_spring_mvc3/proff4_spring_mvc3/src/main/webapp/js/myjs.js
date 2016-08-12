	
function myFunction(){
	alert("until send");
		$.ajax({
			type: "POST",
			data: "par=10",
			url: "ajax",
			dataType: "json",
			success: function(data)	{
				alert("attr1="+data.attr1);
				if(data.url != "") location.replace(data.url);
			},
		});

	

}

function ajaxFunctionPage(vCount){
	// ajaxPageContent
	$.ajax({
		type: "GET",
		data: "count="+vCount,
		url: "ajaxPageContent",
		dataType: "json",
		success: function(data)	{
			// tableUsers
			// countPages
			if(data.tableUsers!=''){
				$("#myTable").html(data.tableUsers);
			}
		},
	});
}