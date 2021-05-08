<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel = "stylesheet" href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"
            integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"
            integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
    <title>Форум Job4j</title>
</head>
<body>
<div class="container pt-3">
    <div class="row">
        <h4>Форум Job4j</h4>
    </div>
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="navbarText">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="/forum/index">Главная</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/forum/create">Добавить пост</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/forum/login">Вход/Регистрация</a>
                        </li>
                    </ul>
                    <span class="navbar-text">
                        <c:if test="${not empty user}">
                            Добро пожаловать <c:out value="${user.username}"/>!
                        </c:if>
                    </span>
                </div>
            </div>
        </nav>
    </div>
    <div class="row">
        <div class="row">
            <div class="mb-3">
                <label for="name" class="form-label">Тема #<c:out value="${post.id}"/></label>
                <input type="text" class="form-control" id="name" aria-describedby="emailHelp" readonly value="<c:out value="${post.name}"/>">
            </div>
            <div class="mb-3">
                <label for="desc" class="form-label">Описание</label>
                <textarea class="form-control" id="desc" rows="3" readonly><c:out value="${post.desc}"/></textarea>
            </div>
        </div>
    </div>
</div>
</body>
</html>