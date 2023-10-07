<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <title>RPG-games</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/start" method="post">
    <div class="card w-50" style="max-width: 720px;">
        <img src="${pageContext.request.contextPath}/picture/kosmos_baza.png" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">Пролог</h5>
            <p class="card-text">Ты стоишь в космическом порту и готов подняться на борт своего корабля.
                Разве ты не об этом мечтал? Стать капитаном галактического судна с экипажем, который будет
             совершать подвиги под твоим командованием.
            Так что вперёд!</p>
            <h5 class="card-title">Знакомство с экипажем</h5>
            <p class="card-text">Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в рукахЖ
                Здравствуйте командир! Я Зинаида - Ваша помощница. Видите? там в углу пьет кофе наш штурман - сержант
                Перегарный Шлейф, под штурвалом стоит наш бортмеханик - Черный Богдан, а фотографирует его - Сергей
                Стальная пятка - наш навигатор.
                А как обращаться к Вам?</p>
            <div class="container">
                <label for="inputUser" class="visually-hidden">Имя игрока</label>
                <input type="text" class="form-control w-50" name="username" id="inputUser" placeholder="Имя игрока">
                <button class="btn btn-success" type="submit" >Начать</button>
            </div>
        </div>
    </div>
</form>
</body>
</html>
