<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signin</title>
</head>
<body>
  <h1>signin</h1>
  <form action="" method="post">
    <p>
      <label for="name">name: </label>
      <input type="text" name="name" id="name" value="">
    </p>
    <p>
      <label for="email">email: </label>
      <input type="email" name="email" id="email" value="">
    </p>
    <button>signin</button>
  </form>
  <a href="/sample-servlet-jsp/signup/index">signup</a>
</body>
</html>