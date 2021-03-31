<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>푸드등록</h2>
<input type="text" id="fiName" placeholder="메뉴명"><br>
<input type="number" id="fiPrice" placeholder="가격"><br>
<input type="text" id="fiType" placeholder="종류"><br>
<textarea rows="10" cols="23" placeholder="음식 설명을 입력하셈" id="fiDesc"></textarea><br>
<button onclick="insertFoodInfo()">등록</button><br>
<script>
	function insertFoodInfo(){
		var param = {
				customerInfo : {
					cuiNum : ${customerInfo.cuiNum}
				}
		};
		var objs = document.querySelectorAll('[placeholder]');
		for(obj of objs){
			param[obj.id] = obj.value;
		}
		console.log(param);
		var xhr = new XMLHttpRequest();
		xhr.open('POST', "/food-info");
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				if(xhr.responseText >= 1){
					alert('인서트 성공');
					location.href = '/views/food/food-info-list';
					return;
				}
				alert('인서트 실패');
			}
		}
		xhr.setRequestHeader('content-type', 'application/json;charset=UTF-8');
		xhr.send(JSON.stringify(param));
	}
</script>
</body>
</html>