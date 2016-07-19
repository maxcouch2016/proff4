$(document).ready(function() {
	
	var citiesList;
	var teachersList;
	var schoolsList;
	var disciplinesList;
	
	function setData(table, city, school){
		$.ajax({
        	dataType: 'json',
    		type: "POST",
    		data: "table=" + table + "&city=" + city + "&school=" + school,
    		url:'/andrey_maznov_yellow_pages_schools/dataCitySchool',
        	success: function(data){
        		if (table == "city" && data.success) {
        			addOption(document.getElementById("citiesChoose_CS"), city, city, false);
					addOption(document.getElementById("citiesFilter_CS"), city, city, false);
					$("#table_CS").append("<tr><td>" + city + "</td><td></td></tr>");
        		}
        		else if (table == "school" && data.success) {
        			addOption(document.getElementById("schoolsFilter_CS"), school, school, false);
        			$("#table_CS").html(data.tableFill);
        		}
        	},
        	error: function() {
            	alert("Some error occured during data adding!");
        	}
    	});
	}
	
	function getDataForTable(tableName, chooseCity, chooseSchool){
		$.ajax({
        	dataType: 'json',
    		type: "GET",
    		data: "tableName=" + tableName + "&chooseCity=" + chooseCity + "&chooseSchool=" + chooseSchool,
    		url:'/andrey_maznov_yellow_pages_schools/tableCitySchool',
        	success: function(data){
        		if (data.tableFill != null) {
        			$("#" + tableName).html(data.tableFill);
        		}
        	},
        	error: function() {
            	alert("Some error occured during data adding!");
        	}
    	});
	}
	
	function getDataForInputsCitySchool(getType, cityVal){
		$.ajax({
        	dataType: 'json',
    		type: "GET",
    		data: "getType=" + getType + "&cityVal=" + cityVal,
    		url:'/andrey_maznov_yellow_pages_schools/dataCitySchool',
        	success: function(data){
        		
        		if (getType == "All") {
        			if (data.cities != null) {
        				clearSelect("citiesChoose_CS", true);
        				clearSelect("citiesFilter_CS", false);
        				for(var i = 0; i < data.cities.length; i++) {
        					addOption(document.getElementById("citiesChoose_CS"), data.cities[i], data.cities[i], true);
        					addOption(document.getElementById("citiesFilter_CS"), data.cities[i], data.cities[i], false);
        				}
        			}
        			if (data.schools != null) {
        				clearSelect("schoolsFilter_CS", false);
        				for(var i = 0; i < data.schools.length; i++) {
        					addOption(document.getElementById("schoolsFilter_CS"), data.schools[i], data.schools[i], false);
        				}
        			}
        		}
        		else if (getType == "School" && cityVal != "") {
        			clearSelect("schoolsFilter_CS", false);
        			if (data.schools != null) {
        				for(var i = 0; i < data.schools.length; i++) {
        					addOption(document.getElementById("schoolsFilter_CS"), data.schools[i], data.schools[i], false);
        				}
        			}
        		}
        	},
        	error: function() {
            	alert("Some error occured during data adding!");
        	}
    	});
	}
	
	$("#cityAdd_CS").click(function() {
		setData("city", $("#cityName_CS").val(), "");
		$("#cityName_CS").val("");
	});
	$("#schoolAdd_CS").click(function() {
		setData("school", $("#citiesChoose_CS option:selected").val(), $("#schoolName_CS").val());
		$("#schoolName_CS").val("");
	});
	$("#citiesFilter_CS").change(function(){
		var list = document.getElementById("citiesFilter_CS");
		var schoolList = document.getElementById("schoolsFilter_CS");
		if (list.selectedIndex != -1) {
			getDataForInputsCitySchool("School", list.options[list.selectedIndex].value);
			getDataForTable("table_CS", list.options[list.selectedIndex].value, schoolList.options[0].value);
		}
	});
	$("#schoolsFilter_CS").change(function(){
		var list = document.getElementById("citiesFilter_CS");
		var schoolList = document.getElementById("schoolsFilter_CS");
		if (list.selectedIndex != -1) {
			getDataForTable("table_CS", list.options[list.selectedIndex].value, schoolList.options[schoolList.selectedIndex].value);
		}
	});
	
	$("#citySchoolEdit").click(function(){
		getDataForInputsCitySchool("All", "");
		getDataForTable("table_CS");
		showContent("#citySchool");
	});
	$("#teacherEdit").click(function(){
		showContent("#teacher");
	});
	$("#disciplineEdit").click(function(){
		showContent("#discipline");
	});
	
	$(".back").click(function(){
		$(".main").css('display', 'block');
		if($("#citySchool").css('display') == 'block'){
			$("#citySchool").css('display', 'none');
		}
		if($("#teacher").css('display') == 'block'){
			$("#teacher").css('display', 'none');
		}
		if($("#discipline").css('display') == 'block'){
			$("#discipline").css('display', 'none');
		}
	});
	
	
	function clearSelect(inputId, deleteAll)
	{
	  var oListbox = document.getElementById(inputId);
	  var toIndex = 1;
	  if (deleteAll) {
		  toIndex = 0;
	  }
	  for (var i = oListbox.options.length - 1; i >= toIndex; i--)
	  {
	      oListbox.remove(i);
	  }
	};

	
	function addOption (oListbox, text, value, isDefaultSelected, isSelected)
	{
		var oOption = document.createElement("option");
		oOption.appendChild(document.createTextNode(text));
		oOption.setAttribute("value", value);

		if (isDefaultSelected) oOption.defaultSelected = true;
		else if (isSelected) oOption.selected = true;

		oListbox.appendChild(oOption);
	}
	
	function showContent(sectionId) {
		$(".main").css('display', 'none');
		$(sectionId).css('display', 'block');
	}
}); 