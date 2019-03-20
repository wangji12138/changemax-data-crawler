<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0064)http://www.17sucai.com/preview/137615/2015-01-15/demo/index.html -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="IE=11.0000" http-equiv="X-UA-Compatible">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>changeMax智慧问答后台登录系统</title>
<meta name="description"
	content="particles.js is a lightweight JavaScript library for creating particles.">
<meta name="author" content="Vincent Garreau" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" media="screen"
	href="<%=request.getContextPath()%>/assets/rear/css/login-style.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/assets/rear/css/reset.css" />


</head>
<body>

	<div id="particles-js">

		<div class="login">
			<form action="${pageContext.request.contextPath}/admin/doLogin"
				id="formId" name="formName" method="post">
				<div class="login-top">changeMax后台登录系统</div>
				<div class="login-center clearfix">
					<div class="login-center-img">
						<img
							src="<%=request.getContextPath()%>/assets/rear/images/name.png" />
					</div>
					<div class="login-center-input">
						<input type="text" name="" id="adminUsername" name="adminUsername"
							value="${adminUsername }" placeholder="请输入您的用户名"
							onfocus="this.placeholder=''"
							onblur="this.placeholder='请输入您的用户名'" />
						<div class="login-center-input-text">用户名</div>
					</div>
				</div>
				<div class="login-center clearfix">
					<div class="login-center-img">
						<img
							src="<%=request.getContextPath()%>/assets/rear/images/password.png" />
					</div>
					<div class="login-center-input">
						<input type="password" id="adminUsername" name="adminPassword"
							value="${adminPassword }" placeholder="请输入您的密码"
							onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'" />
						<div class="login-center-input-text">密码</div>
					</div>
				</div>
				<div class="login-button">登录</div>
			</form>
		</div>

		<div class="sk-rotating-plane"></div>

	</div>
	<div style="text-align: center;">
		<p>
			changemax智慧问答引擎后台 - <a>登录系统</a>
		</p>
	</div>
</body>
<!-- scripts -->
<script
	src="<%=request.getContextPath()%>/assets/rear/js/particles.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/rear/js/app.js"></script>
<script type="text/javascript">
	function hasClass(elem, cls) {
		cls = cls || '';
		if (cls.replace(/\s/g, '').length == 0)
			return false; //当cls没有参数时，返回false
		return new RegExp(' ' + cls + ' ').test(' ' + elem.className + ' ');
	}

	function addClass(ele, cls) {
		if (!hasClass(ele, cls)) {
			ele.className = ele.className == '' ? cls : ele.className + ' '
					+ cls;
		}
	}

	function removeClass(ele, cls) {
		if (hasClass(ele, cls)) {
			var newClass = ' ' + ele.className.replace(/[\t\r\n]/g, '') + ' ';
			while (newClass.indexOf(' ' + cls + ' ') >= 0) {
				newClass = newClass.replace(' ' + cls + ' ', ' ');
			}
			ele.className = newClass.replace(/^\s+|\s+$/g, '');
		}
	}

	document.querySelector(".login-button").onclick = function() {
		var formId = document.getElementById('formId');

		formId.submit();
	}
</script>
</html>