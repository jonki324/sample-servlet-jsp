<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top</title>
</head>
<body>
  <h1>top</h1>
  <p>Sign in user: ${signInUserDto.name}</p>
  <ul>
    <c:forEach var="user" items="${topDto.users}">
      <li>
        ID: <c:out value="${user.id}"/>, Name: <a href=""><c:out value="${user.name}"/></a>
      </li>
    </c:forEach>
  </ul>
</body>
</html>