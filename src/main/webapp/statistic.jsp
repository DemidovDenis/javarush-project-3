
<%--
  Created by IntelliJ IDEA.
  User: demde
  Date: 17.09.2022
  Time: 0:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    </head>
    <title>Statistic</title>
</head>
<body>
<h2>Статистика:</h2>
<ul class="list-group list-group-horizontal-md">
    <form action="${pageContext.request.contextPath}/start" method="post">
        <li class="list-group-item">
            Имя в игре
            <span class="badge text-bg-info rounded-bottom">${username}</span>
        </li>
        <li class="list-group-item">
            Количество игр
            <span class="badge text-bg-info rounded-bottom">${visitCount}</span>
        </li>
    </form>
</ul>
</body>
</html>
