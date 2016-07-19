<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Schools yellow pages</title>
    <link rel="stylesheet" type="text/css" href="css/style_schools.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" src="js/my.js"></script>
</head>
<body>
    <div class="wrap">
        <div class="banner">
            <img src="img/banner.png" alt="">
        </div>
        <div class="main">
            <p id="citySchoolEdit">Перейти на редактирование городов и школ</p>
            <p id="teacherEdit">Перейти на редактирование учителей</p>
            <p id="disciplineEdit">Перейти на редактирование дисциплин</p>
        </div>
        <div class="section" id="citySchool">
            <p class="back">&#8592;назад</p>
           <h3>Редактирование городов и школ</h3>
           <div>
               <input type="text" name="Название города" placeholder="Название города" id="cityName_CS">
               <input type="button" value="Добавить" id="cityAdd_CS">
           </div>
           <div>
               <select name="cityChoose_CS" id="citiesChoose_CS">
               </select>
               <input type="text" name="Название школы" placeholder="Название школы" id="schoolName_CS">
               <input type="button" value="Добавить" id="schoolAdd_CS">
           </div>
           <div>
               <select name="cityChooseFilter_CS" id="citiesFilter_CS">
                   <option value="Все города">Все города</option>
               </select>
               <select name="schoolChooseFilter_CS" id="schoolsFilter_CS">
                   <option value="Все школы">Все школы</option>
               </select>
           </div>
           <div>
               <table border=1 px id="table_CS">
               <tr><th>Город</th><th>Школа</th></tr>
               </table>
           </div>
        </div>
        
        <div class="section" id="teacher">
            <p class="back">&#8592;назад</p>
            <h3>Редактирование списка учителей</h3>
            <div>
                <select name="cityChoose_T" id="citiesChoose_T">
                </select>
                <select name="schoolChoose_T" id="schoolsChoose_T">
                </select>
                <input type="text" name="Имя учителя" placeholder="Имя учителя" id="teacherName_T">
                <input type="button" value="Добавить" id="teacherAdd_T">
            </div>
            <div>
                <select name="cityFilter_T" id="citiesFilter_T">
                    <option value="0">Все города</option>
                </select>
                <select name="schoolFilter_T" id="schoolsFilter_T">
                    <option value="0">Все школы</option>
                </select>
                <select name="teacherFilter_T" id="teachersFilter_T">
                    <option value="0">Все учителя</option>
                </select>
            </div>
            <div>
               <table border=1 px id="table_T">
               <tr><th>Город</th><th>Школа</th><th>Учитель</th></tr>
               <tr><td>City 1</td><td>School 1</td><td>Teacher 1</td></tr>
               <tr><td>City 2</td><td>School 2</td><td>Teacher 2</td></tr>
               <tr><td>City 3</td><td>School 3</td><td>Teacher 3</td></tr>
               </table>
            </div>
       </div>
       
       <div class="section" id="discipline">
           <p class="back">&#8592;назад</p>
           <h3>Редактирование списка дисциплин</h3>
           <div>
                <input type="text" name="Название дисциплины" placeholder="Дисциплина" id="disciplineName_D">
                <input type="button" value="Добавить" id="disciplineAdd_D">
            </div>
            <div>
                <select name="cityChoose_D" id="citiesChoose_D">
                </select>
                <select name="schoolChoose_D" id="schoolsChoose_D">
                </select>
                <select name="teacherChoose_D" id="teachersChoose_D">
                </select>
                <select name="disciplineChoose_D" id="disciplinesChoose_D">
                </select>
                <input type="button" value="Добавить связь" id="connectionAdd_D">
           </div>
           <div>
               <select name="cityFilter_D" id="citiesFilter_D">
                    <option value="0">Все города</option>
                </select>
                <select name="schoolFilter_D" id="schoolsFilter_D">
                    <option value="0">Все школы</option>
                </select>
                <select name="teacherFilter_D" id="teachersFilter_D">
                    <option value="0">Все учителя</option>
                </select>
                <select name="disciplineFilter_D" id="disciplinesFilter_D">
                    <option value="0">Все дисциплины</option>
                </select>
           </div>
           <div>
               <table border=1 px id="table_T">
               <tr><th>Город</th><th>Школа</th><th>Учитель</th><th>Дисциплина</th></tr>
               <tr><td>City 1</td><td>School 1</td><td>Teacher 1</td><td>Discipline 1</td></tr>
               <tr><td>City 2</td><td>School 2</td><td>Teacher 2</td><td>Discipline 2</td></tr>
               <tr><td>City 3</td><td>School 3</td><td>Teacher 3</td><td>Discipline 3</td></tr>
               </table>
            </div>
       </div>
       <div class="footer">&#174;2016г. Права защищены.</div>
    </div>
</body>
</html>