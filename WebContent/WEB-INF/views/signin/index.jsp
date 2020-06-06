<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signin</title>
</head>
<body>
  <h1>signin</h1>
  <c:if test="${signInDto.message != null}" >
    <p>${signInDto.message}</p>
  </c:if>
  <form action="" method="post">
    <p>
      <label for="name">name: </label>
      <input type="text" name="name" id="name" value="${signInDto.name}">
    </p>
    <p>
      <label for="email">email: </label>
      <input type="email" name="email" id="email" value="${signInDto.email}">
    </p>
    <button>signin</button>
  </form>
  <a href="/sample-servlet-jsp/signup/index">signup</a>
</body>
</html>