<%--
  Created by IntelliJ IDEA.
  User: demde
  Date: 14.09.2022
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    </head>
    <title>Game Over</title>
</head>
<body>
<div class="card text-center w-50" style="max-width: 720px;">
    <img src="${pageContext.request.contextPath}/picture/the_end.png" class="card-img-top" alt="...">
    <div class="card-body">
        <c:if test="${answers.getIsFinish()==true && message.getId()=='1'}">
            <h5 class="card-title">${message.getAnswers().get(2).getText()}</h5>
            <h5 class="card-title">${gameOver.getText()}</h5>
        </c:if>
        <c:if test="${answers.getIsFinish()==true && message.getId()=='2'}">
            <h5 class="card-title">${message.getAnswers().get(2).getText()}</h5>
            <h5 class="card-title">${gameOver.getText()}</h5>
        </c:if>
        <c:if test="${answers.getIsFinish()==false && message.getId()=='3'}">
            <h5 class="card-title">${message.getAnswers().get(2).getText()}</h5>
            <h5 class="card-title">${gameOver.getText()}</h5>
        </c:if>
        <c:if test="${answers.getIsFinish()==true && message.getId()=='3'}">
            <h5 class="card-title">${message.getAnswers().get(3).getText()}</h5>
            <h5 class="card-title">${gameOver.getText()}</h5>
        </c:if>
        <div class="d-grid gap-2 col-4 mx-auto">
            <form action="${pageContext.request.contextPath}/restart" method="get">
                <button type="submit" class="btn btn-outline-success">Начать игру заново</button>
            </form>
            <form action="${pageContext.request.contextPath}/stat" method="post">
                <button type="submit" class="btn btn-outline-primary">Статистика</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
