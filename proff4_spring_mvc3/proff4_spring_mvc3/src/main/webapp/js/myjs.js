	
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