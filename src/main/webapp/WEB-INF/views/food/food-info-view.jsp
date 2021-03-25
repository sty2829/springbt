<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>${param.fiNum }의 VIEW 입니다.</h2>
<table border="1">
	<tr>
		<th>번호</th>
		<td data-col="fiNum"></td>
	</tr>
	<tr>
		<th>음식명</th>
		<td data-col="fiName"></td>
	</tr>
	<tr>
		<th>가격</th>
		<td data-col="fiPrice"></td>
	</tr>
	<tr>
		<th>설명</th>
		<td data-col="fiDesc"></td>
	</tr>
	<tr>
		<th>등록시간</th>
		<td data-col="credat"></td>
	</tr>
	<tr>
		<th>상태</th>
		<td data-col="active"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button onclick="location.href='/views/food/food-info-update?fiNum=${param.fiNum}'">수정</button>
			<button onclick="goDelete()">삭제</button>
		</td>
	</tr>
</table>
<script>
var url = '/food-info?fiNum=${param.fiNum}';
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET', url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var res = JSON.parse(xhr.responseText);
			var objs = document.querySelectorAll('[data-col]');
			for(obj of objs){
				var key = obj.getAttribute('data-col');
				var data = res[key];
				obj.innerHTML = data;
			}
		}
	}
	xhr.send();
}
function goDelete(){
	var param = {
			fiNum : ${param.fiNum}
	};
	var xhr = new XMLHttpRequest();
	xhr.open('DELETE', "/food-info");
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			if(xhr.responseText == 1){
				alert('삭제 성공');
				location.href = '/views/food/food-info-list';
				return;
			}
			alert('삭제 실패');
		}
	}
	xhr.setRequestHeader('content-type', 'application/json;charset=UTF-8');
	xhr.send(JSON.stringify(param));
}
</script>
</body>
</html>