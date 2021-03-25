<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
음식명: <input type="text" id="fiName"><br>
가격: <input type="text" id="fiPrice"><br>
종류: <input type="text" id="fiType"><br>
<button onclick="getList()">검색</button>
<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>음식명</th>
			<th>가격</th>
			<th>종류</th>
		</tr>
	</thead>
	<tbody id="tBody">
	</tbody>
</table>
<button onclick="location.href='/views/food/food-info-insert'">등록</button>
<script>
function getList(){
	var objs = document.querySelectorAll('[type="text"]');
	var query = '?';
	for(obj of objs){
		if(obj.value){
			query += obj.id + '=' + obj.value + '&'; 
		}
	}
	console.log(query);
	
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/food-infos' + query);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var res = JSON.parse(xhr.responseText);
			var html = '';
			for(food of res){
				html += '<tr onclick="location.href=\'/views/food/food-info-view?fiNum=' + food.fiNum + '\'" style="cursor:pointer">';
				html += '<td>' + food.fiNum + '</td>';
				html += '<td>' + food.fiName + '</td>';
				html += '<td>' + food.fiPrice + '</td>';
				html += '<td>' + food.fiType + '</td>';
				html += '</tr>';
			}
			document.querySelector('#tBody').innerHTML = html;
		}
	}
	xhr.send();
}
window.onload = getList;
</script>
</body>
</html>