<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>confirm</title>
</head>
<body>
  <h1>confirm</h1>
  <c:if test="${signUpDto.message != null}" >
    <p>${signUpDto.message}</p>
  </c:if>
  <form action="" method="post">
    <p>
      <label for="name">name: </label>
      <input type="text" name="name" id="name" value="${signUpDto.name}" readonly>
    </p>
    <p>
      <label for="email">email: </label>
      <input type="email" name="email" id="email" value="${signUpDto.email}" readonly>
    </p>
    <button type="button" onclick="back()">back</button>
    <button>complete</button>
  </form>
<script>
function back() {
  location.href = '/sample-servlet-jsp/signup/index';
}
</script>
</body>
</html>