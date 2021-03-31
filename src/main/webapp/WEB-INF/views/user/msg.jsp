<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	alert('로그인이 만료되었거나 권한이 없습니다. \r\n로그인 페이지로 이동합니다');
	location.href = '/views/user/login';
</script>
</body>
</html>