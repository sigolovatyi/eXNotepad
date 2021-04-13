<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 12.04.2021
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/src/main/resources/css/movies.css" rel="stylesheet" type="text/css">
</head>
<body>

<form id="movie-form" action="/movies/create_some_film" method="post" modelAttribute="${movie}">
    <p class="films-name">Title : <input type="text" name="title"></p>
    <p>Style : <input type="text" name="style"></p>
    <p>Reference : <input type="text" name="ref"></p>
    <input type="submit" value="Pass data">
</form>
</body>
</html>
