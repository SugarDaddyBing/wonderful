<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<input type="text" id="email" />
	<input type="text" id="pswd" />
	<input type="radio" id="remeberme" />记住我
	<br>
	<button id="submit">走你</button>
	<div id="msg"></div>
	<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript">
		$('#submit').click(function() {
			var email = $('#email').val();
			var pswd = $('#pswd').val();
			var data = {
				"email" : email,
				"pswd" : pswd,
			//"remeberMe" : false
			}
			$.post("/wonderful/submitLogin.do", data, showMessage, 'json')
		});

		function showMessage(ata) {
			alert("状态：" + ata.status + "信息：" + ata.message);
			if (ata.status == '200') {
				window.location.href='/wonderful/home.html';
			}
		}
	</script>
</body>
</html>