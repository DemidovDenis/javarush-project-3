<%--
  Created by IntelliJ IDEA.
  User: demde
  Date: 11.09.2022
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    </head>
    <title>RPG-games</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/dialog" method="post">
    <div class="card text-center w-50" style="max-width: 720px;">
        <img src="${pageContext.request.contextPath}/picture/board_ship.png" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">${message.getText()}</h5>
            <p class="card-text">Что интуиция тебе подскажет? Выбирай...</p>
            <div class="d-grid gap-2 col-4 mx-auto">
                <input type="hidden" name="message" value="${message.getId()}"/>
                <button class="btn btn-outline-primary" type="submit" name="answers" id="1" value="1">${message.getAnswers().get(0).getText()}</button>
                <button class="btn btn-outline-danger" type="submit" name="answers" id="2" value="2">${message.getAnswers().get(1).getText()}</button>
            </div>
        </div>
    </div>
</form>
</body>
</html>
