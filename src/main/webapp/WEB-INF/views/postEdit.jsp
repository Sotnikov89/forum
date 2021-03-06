<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"
            integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"
            integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
    <title>Accident</title>
</head>
<body>
<div class="container pt-3">
    <div class="row">
        <c:if test="${post.id!=0}">
            <h4>Редактирование поста</h4>
        </c:if>
        <c:if test="${post.id==0}">
            <h4>Создание поста</h4>
        </c:if>
    </div>
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="navbarText">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href=${pageContext.request.contextPath}/index>Главная</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href=${pageContext.request.contextPath}/create>Добавить пост</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href=${pageContext.request.contextPath}/login>Вход/Регистрация</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="row">
        <div class="row">
            <form:form action='${pageContext.request.contextPath}/saveOrUpdate' method="post" modelAttribute="post">
                <form:input path="id" type="hidden" value="${post.id}"/>
                <div class="mb-3">
                    <label for="name" class="form-label">Название темы</label>
                    <form:input path="name" value="${post.name}" type="text" class="form-control" id="name" aria-describedby="emailHelp"/>
                </div>
                <div class="mb-3">
                    <label for="description" class="form-label">Описание</label>
                    <form:textarea path="description" value="${post.description}" class="form-control" id="description" rows="3"/>
                </div>
                <button type="submit" class="btn btn-primary">Сохранить</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>