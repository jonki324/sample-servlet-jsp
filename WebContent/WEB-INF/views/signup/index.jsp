<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signup</title>
</head>
<body>
signup index
<form action="" method="post">
  <p>
    <label for="name">name: </label>
    <input type="text" name="name" id="name" value="">
  </p>
  <p>
    <label for="email">email: </label>
    <input type="email" name="email" id="email" value="">
  </p>
  <button type="button" onclick="back()">back</button>
  <button>confirm</button>
</form>
<script>
function back() {
  location.href = '/sample-servlet-jsp/signin/index';
}
</script>
</body>
</html>