<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>confirm</title>
</head>
<body>
confirm
<form action="" method="post">
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