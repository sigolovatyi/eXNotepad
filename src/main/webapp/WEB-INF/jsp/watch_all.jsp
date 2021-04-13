<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 12.04.2021
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Films</title>
</head>
<body>

<h1>All films:</h1>

<table cellpadding="1" cellspacing="1" border="1">

    <tr>
        <td>Id</td>
        <td>Movie</td>
        <td>Style</td>
        <td>Reference</td>
    </tr>
    <c:forEach items="${movies}" var="movie">
        <tr>
            <td>${movie.id}</td>
            <td>${movie.title}</td>
            <td>${movie.style}</td>
            <td>${movie.ref}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>