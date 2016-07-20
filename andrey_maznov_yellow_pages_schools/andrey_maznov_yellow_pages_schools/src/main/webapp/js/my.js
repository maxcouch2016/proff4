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
					if ($("#citiesFilter_CS option:selected").val() == "Все города") {
						$("#table_CS").append("<tr><td>" + city + "</td><td></td></tr>");
					}
        		}
        		else if (table == "school" && data.success) {
        			addOption(document.getElementById("schoolsFilter_CS"), school, school, false);
        			if (($("#citiesFilter_CS option:selected").val() == "Все города" || $("#citiesFilter_CS option:selected").val() == city) && ($("#schoolsFilter_CS option:selected").val() == "Все школы" || $("#schoolsFilter_CS option:selected").val() == school)) {
        				$("#table_CS").html(data.tableFill);
        			}
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
            	alert("Some error occured during data reading!");
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
            	alert("Some error occured during data reading!");
        	}
    	});
	}
	
	$("#citySchoolEdit").click(function(){
		getDataForInputsCitySchool("All", "");
		getDataForTable("table_CS");
		showContent("#citySchool");
	});
	
	
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
		if (list.selectedIndex > 0) {
			$("#schoolsFilter_CS").prop("disabled", false);
		}
		else {
			$("#schoolsFilter_CS").prop("disabled", "disabled");
		}
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
	
	///////////////////////////////////////////
	
	function getDataForInputsTeacher(getType, cityVal, schoolVal){
		$.ajax({
        	dataType: 'json',
    		type: "GET",
    		data: "getType=" + getType + "&cityVal=" + cityVal + "&schoolVal=" + schoolVal,
    		url:'/andrey_maznov_yellow_pages_schools/dataTeacher',
        	success: function(data){
        		
        		if (getType == "All") {
        			if (data.cities != null) {
        				clearSelect("citiesChoose_T", true);
        				clearSelect("citiesFilter_T", false);
        				for(var i = 0; i < data.cities.length; i++) {
        					addOption(document.getElementById("citiesChoose_T"), data.cities[i], data.cities[i], true);
        					addOption(document.getElementById("citiesFilter_T"), data.cities[i], data.cities[i], false);
        				}
        			}
        			if (data.schools != null) {
        				clearSelect("schoolsChoose_T", true);
        				clearSelect("schoolsFilter_T", false);
        				for(var i = 0; i < data.schools.length; i++) {
        					addOption(document.getElementById("schoolsChoose_T"), data.schools[i], data.schools[i], true);
        					addOption(document.getElementById("schoolsFilter_T"), data.schools[i], data.schools[i], false);
        				}
        			}
        			if (data.teachers != null) {
        				clearSelect("teachersFilter_T", false);
        				for(var i = 0; i < data.schools.length; i++) {
        					addOption(document.getElementById("teachersFilter_T"), data.schools[i], data.schools[i], false);
        				}
        			}
        		}
        		else if (getType == "SchoolChoose" && cityVal != "") {
        			clearSelect("schoolsChoose_T", true);
        			if (data.schools != null) {
        				for(var i = 0; i < data.schools.length; i++) {
        					addOption(document.getElementById("schoolsChoose_T"), data.schools[i], data.schools[i], true);
        				}
        			}
        		}
        		else if (getType == "SchoolFilter" && cityVal != "") {
        			clearSelect("schoolsFilter_T", false);
        			if (data.schools != null) {
        				for(var i = 0; i < data.schools.length; i++) {
        					addOption(document.getElementById("schoolsFilter_T"), data.schools[i], data.schools[i], false);
        				}
        			}
        		}
        		else if (getType == "TeacherFilter" && cityVal != "" && schoolVal != "") {
        			clearSelect("teachersFilter_T", false);
        			if (data.teachers != null) {
        				for(var i = 0; i < data.teachers.length; i++) {
        					addOption(document.getElementById("teachersFilter_T"), data.teachers[i], data.teachers[i], false);
        				}
        			}
        		}
        	},
        	error: function() {
            	alert("Some error occured during data reading!");
        	}
    	});
	}
	
	function setDataTeacher(table, city, school, teacher){
		$.ajax({
        	dataType: 'json',
    		type: "POST",
    		data: "table=" + table + "&city=" + city + "&teacher=" + teacher + "&school=" + school,
    		url:'/andrey_maznov_yellow_pages_schools/dataTeacher',
        	success: function(data){
        		if (table == "teacher" && data.success) {
        			addOption(document.getElementById("teachersFilter_T"), teacher, teacher, false);
        			if (($("#citiesFilter_T option:selected").val() == "Все города" || $("#citiesFilter_T option:selected").val() == city)
        					&& ($("#schoolsFilter_T option:selected").val() == "Все школы" || $("#schoolsFilter_T option:selected").val() == school)
        					&& ($("#teachersFilter_T option:selected").val() == "Все учителя" || $("#teachersFilter_T option:selected").val() == teacher)) {
        				$("#table_T").html(data.tableFill);
        			}
        		}
        	},
        	error: function() {
            	alert("Some error occured during data adding!");
        	}
    	});
	}
	
	function getDataForTableTeacher(tableName, chooseCity, chooseSchool, chooseTeacher){
		$.ajax({
        	dataType: 'json',
    		type: "GET",
    		data: "tableName=" + tableName + "&chooseCity=" + chooseCity + "&chooseSchool=" + chooseSchool + "&chooseTeacher=" + chooseTeacher,
    		url:'/andrey_maznov_yellow_pages_schools/tableTeacher',
        	success: function(data){
        		if (data.tableFill != null) {
        			$("#" + tableName).html(data.tableFill);
        		}
        	},
        	error: function() {
            	alert("Some error occured during data reading!");
        	}
    	});
	}
	
	$("#teacherEdit").click(function(){
		getDataForInputsTeacher("All", "", "");
		getDataForTableTeacher("table_T");
		showContent("#teacher");
	});
	
	$("#teacherAdd_T").click(function() {
		setDataTeacher("teacher", $("#citiesChoose_T option:selected").val(), $("#schoolsChoose_T option:selected").val(), $("#teacherName_T").val());
		$("#teacherName_T").val("");
	});
	
	$("#citiesChoose_T").change(function(){
		var list = document.getElementById("citiesChoose_T");
		var schoolList = document.getElementById("schoolsChoose_T");
		if (list.selectedIndex != -1) {
			getDataForInputsTeacher("SchoolChoose", list.options[list.selectedIndex].value);		
		}
	});
	
	$("#citiesFilter_T").change(function(){
		var list = document.getElementById("citiesFilter_T");
		var schoolList = document.getElementById("schoolsFilter_T");
		var teacherList = document.getElementById("teachersFilter_T");
		if (list.selectedIndex > 0) {
			$("#schoolsFilter_T").prop("disabled", false);
		}
		else {
			$("#schoolsFilter_T").prop("disabled", "disabled");
			$("#teachersFilter_T").prop("disabled", "disabled");
		}
		if (list.selectedIndex != -1) {
			getDataForInputsTeacher("SchoolFilter", list.options[list.selectedIndex].value, "");
			getDataForTableTeacher("table_T", list.options[list.selectedIndex].value, schoolList.options[0].value, teacherList.options[0].value);
		}
	});

	$("#schoolsFilter_T").change(function(){
		var citiesList = document.getElementById("citiesFilter_T");
		var list = document.getElementById("schoolsFilter_T");
		var teacherList = document.getElementById("teachersFilter_T");
		if (list.selectedIndex > 0) {
			$("#teachersFilter_T").prop("disabled", false);
		}
		else {
			$("#teachersFilter_T").prop("disabled", "disabled");
		}
		if (list.selectedIndex != -1) {
			getDataForInputsTeacher("TeacherFilter", citiesList.options[citiesList.selectedIndex].value, list.options[list.selectedIndex].value);
			getDataForTableTeacher("table_T", citiesList.options[citiesList.selectedIndex].value, list.options[list.selectedIndex].value, teacherList.options[0].value);
		}
	});
	
	$("#teachersFilter_T").change(function(){
		var citiesList = document.getElementById("citiesFilter_T");
		var schoolList = document.getElementById("schoolsFilter_T");
		var teacherList = document.getElementById("teachersFilter_T");
		if (teacherList.selectedIndex != -1) {
			getDataForTableTeacher("table_T", citiesList.options[citiesList.selectedIndex].value, schoolList.options[schoolList.selectedIndex].value, teacherList.options[teacherList.selectedIndex].value);
		}
	});
	
	////////////////////////////////////////////////////
	
	$("#disciplineEdit").click(function(){
		showContent("#discipline");
	});
	
	/////////////////////////////////////////////////////
	
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
	
}); 