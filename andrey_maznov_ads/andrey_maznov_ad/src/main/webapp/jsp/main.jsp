<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Advertisements</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/my.js"></script>
</head>
<body>
	<div class="wrap">
		<div class="banner">
			<img src="img/main_banner1.jpg" alt=""> <img
				src="img/main_banner2.jpg" alt=""> <img
				src="img/main_banner2.png" alt="">
		</div>
		<div class="content">
			<div class="menu">
				<h4>Дополнительное меню</h4>
				<ul>
				    <li><a href="/andrey_maznov_ad/content">Все</a></li>
                    <li><a href="/andrey_maznov_ad/content?contenttype=1">Авто</a></li>
					<li><a href="/andrey_maznov_ad/content?contenttype=2">Недвижимость</a></li>
                    <li><a href="/andrey_maznov_ad/content?contenttype=3">Работа</a></li>		
				</ul>
			</div>
			<div class="mainContent">
				<div class="aboutProject">
					Хотите продать автомобиль, квартиру или найти работу?<br>
					Самое эффективное решение для вас – добавить объявление на сайте
					объявлений.<br> Наш сайт – доска объявлений, охватывающая всю
					Украину.<br> Ежедневно здесь ищут товары более 10 000
					пользователей из разных городов нашей страны.<br> Расскажите
					им о своем предложении, а мы поможем вам найти клиента.
				</div>
				<div class="findblock">Блок поиска</div>
			</div>
			<form method="post">
				<input type="text" name="login" placeholder="Логин"> 
				<input type="password" name="pass" placeholder="Пароль"> 
				<input type="submit">
			</form>
		</div>
		<div class="footer">&#174;2020г. Права защищены.</div>
	</div>
</body>
</html>
