<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 13.04.2021
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recommend</title>
</head>
<body>

<h1>Recommended films:</h1>

<table cellpadding="1" cellspacing="1" border="1">

    <tr>
        <td>Movie</td>
        <td>Style</td>
        <td>Reference</td>

    </tr>
    <c:forEach items="${movies}" var="movie">
        <tr>
            <td>${movie.title}</td>
            <td>${movie.style}</td>
            <td>${movie.ref}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
