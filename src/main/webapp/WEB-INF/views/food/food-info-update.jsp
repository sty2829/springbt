<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>푸드수정</h2>
<input type="hidden" id="fiNum" value="${param.fiNum }" placeholder="히든">
<input type="text" id="fiName" placeholder="음식명"><br>
<input type="text" id="fiPrice" placeholder="가격"><br>
<input type="text" id="fiType" placeholder="종류"><br>
<textarea rows="10" cols="23" placeholder="음식 설명을 입력하셈" id="fiDesc"></textarea><br>
<button onclick="goUpdate()">수정</button>
<script>
	function goUpdate(){
		var param = {};
		var objs = document.querySelectorAll('[placeholder]');
		for(obj of objs){
			param[obj.id] = obj.value;
		}
		var xhr = new XMLHttpRequest();
		xhr.open('POST', "/food-info-update");
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var res = JSON.parse(xhr.responseText);
				if(res.fiNum == param['fiNum']){
					alert('업데이트 성공');
					location.href = '/views/food/food-info-view?fiNum=' + param['fiNum'];
					return;
				}
				alert('업데이트 실패');
			}
		}
		xhr.setRequestHeader('content-type', 'application/json;charset=UTF-8');
		xhr.send(JSON.stringify(param));
	}

	window.onload = function() {
		var xhr = new XMLHttpRequest();
		xhr.open('GET', "/food-info?fiNum=" + ${param.fiNum});
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var res = JSON.parse(xhr.responseText);
				for(key in res){
					var obj = document.querySelector('#' + key);
					if(obj){
						obj.value = res[key];
					}
					
				}
			}
		}
		xhr.send();
	}
</script>
</body>
</html>