<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Форум job4j</title>
</head>
<body>

<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand mb-0 h1" href="/">Форум</a>
        </div>
        <div class="container-fluid">
            <a class="navbar-brand mb-0 h1" href="/posts/create">Новая тема</a>
        </div>
        <div class="container-fluid">
            <a class="navbar-brand mb-0" href="/reg">Регистрация</a>
        </div>
        <div class="container-fluid">
            <a class="navbar-brand mb-0" href="/login">Логин</a>
        </div>
    </nav>
</div>

<div class="container mt-3">
    <div class="row">
        <h4>Форум job4j</h4>
    </div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">Тема</th>
                <th scope="col">Редактировать</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td><c:out value="${post.id}"/></td>
                    <td><c:out value="${post.name}"/></td>
                    <td>
                        <a class="btn btn-secondary" href='<c:url value="/posts/${post.id}"/>'>
                            Редактировать
                        </a>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Optional JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>