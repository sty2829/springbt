<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" id="cuiId" placeholder="아이디"><br>
<input type="text" id="cuiPwd" placeholder="비밀번호"><br>
<button onclick="login()">로그인</button>
<script>
function login(){
	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/login');
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var res = null;
			if(xhr.responseText){
				res = JSON.parse(xhr.responseText);
			}
			if(res){
				alert('로그인성공');
			}else{
				alert('로그인실패');
			}
		}
	}
	var param = {};
	var objs = document.querySelectorAll('input[type="text"]');
	for(obj of objs){
		param[obj.id] = obj.value;
	}
	xhr.setRequestHeader('content-type', 'application/json;charSet="UTF-8"');
	xhr.send(JSON.stringify(param));
}
</script>
</body>
</html>