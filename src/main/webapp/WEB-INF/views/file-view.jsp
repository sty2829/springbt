<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>VIEW</h2>
<table border="1">
	<tr>
		<th>번호</th>
		<td data-col="fiiNum"></td>
	</tr>
	<tr>
		<th>제목</th>
		<td data-col="fiiTitle"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td data-col="fiiContent"></td>
	</tr>
	<tr>
		<th>이미지</th>
		<td data-col="fiiFilePath" data-type="img"></td>
	</tr>
	<tr>
		<th>파일이름</th>
		<td data-col="fiiFileName"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<button onclick="location.href='/views/file-update?fiiNum=${param.fiiNum}'">수정</button>
		<button onclick="goDelete()">삭제</button>
		</td>
	</tr>
</table>
<script>
var url = '/file-info?fiiNum=' + ${param.fiiNum};
window.onload = function() {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var res = JSON.parse(xhr.responseText);
			var tds = document.querySelectorAll('td[data-col]');
			for(td of tds){
				var key = td.getAttribute('data-col');
				var data = res[key];
				var type = td.getAttribute('data-type');
				if(type === 'img'){
					data = '<img width="300" src="/resources/' + res[key] + '">';
				}
				td.innerHTML = data;	
			}
		}
	}
	xhr.send();
}
function goDelete(){
	var xhr = new XMLHttpRequest();
	xhr.open('DELETE', url);
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			if(xhr.responseText == 1){
				alert('삭제 성공');
				location.href = '/views/file-info-list';
			}else{
				alert('삭제 실패');
			}	
		}
	}
	xhr.send();
}
</script>
</body>
</html>