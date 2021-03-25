<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button onclick="location.href='/views/file/file-info-list'">사진게시판 이동</button>
<c:if test="${customerInfo eq null }">
<button onclick="location.href='/views/user/login'">로그인</button>
</c:if>
<c:if test="${customerInfo ne null }">
<button onclick="logout()">로그아웃</button>
<script>
function logout(){
	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/logout');
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			if(xhr.responseText === 'true'){
				location.href = '/';
			}
			
		}
	}
	xhr.send();
}
</script>
</c:if>
</body>
</html>