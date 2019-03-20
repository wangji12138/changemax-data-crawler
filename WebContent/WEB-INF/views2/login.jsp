<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0064)http://www.17sucai.com/preview/137615/2015-01-15/demo/index.html -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="IE=11.0000" http-equiv="X-UA-Compatible">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>changeMax智慧问答后台登录系统</title>
<script
	src="<%=request.getContextPath()%>/assets/rear/js/jquery-1.9.1.min.js"
	type="text/javascript"></script>

<style>
body {
	background: #ebebeb;
	font-family: "Helvetica Neue", "Hiragino Sans GB", "Microsoft YaHei",
		"\9ED1\4F53", Arial, sans-serif;
	color: #222;
	font-size: 12px;
}

* {
	padding: 0px;
	margin: 0px;
}

.top_div {
	background: #008ead;
	width: 100%;
	height: 400px;
}

.ipt {
	border: 1px solid #d3d3d3;
	padding: 10px 10px;
	width: 290px;
	border-radius: 4px;
	padding-left: 35px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s
}

.ipt:focus {
	border-color: #66afe9;
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6)
}

.u_logo {
	background:
		url("<%=request.getContextPath()%>/assets/rear/images/username.png")
		no-repeat;
	padding: 10px 10px;
	position: absolute;
	top: 43px;
	left: 40px;
}

.p_logo {
	background:
		url("<%=request.getContextPath()%>/assets/rear/images/password.png")
		no-repeat;
	padding: 10px 10px;
	position: absolute;
	top: 12px;
	left: 40px;
}

a {
	text-decoration: none;
}

.tou {
	background:
		url("<%=request.getContextPath()%>/assets/rear/images/tou.png")
		no-repeat;
	width: 97px;
	height: 92px;
	position: absolute;
	top: -87px;
	left: 140px;
}

.left_hand {
	background:
		url("<%=request.getContextPath()%>/assets/rear/images/left_hand.png")
		no-repeat;
	width: 32px;
	height: 37px;
	position: absolute;
	top: -38px;
	left: 150px;
}

.right_hand {
	background:
		url("<%=request.getContextPath()%>/assets/rear/images/right_hand.png")
		no-repeat;
	width: 32px;
	height: 37px;
	position: absolute;
	top: -38px;
	right: -64px;
}

.initial_left_hand {
	background:
		url("<%=request.getContextPath()%>/assets/rear/images/hand.png")
		no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -12px;
	left: 100px;
}

.initial_right_hand {
	background:
		url("<%=request.getContextPath()%>/assets/rear/images/hand.png")
		no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -12px;
	right: -112px;
}

.left_handing {
	background:
		url("<%=request.getContextPath()%>/assets/rear/images/left-handing.png")
		no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -24px;
	left: 139px;
}

.right_handinging {
	background:
		url("<%=request.getContextPath()%>/assets/rear/images/right_handing.png")
		no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -21px;
	left: 210px;
}
</style>



<meta name="GENERATOR" content="MSHTML 11.00.9600.17496">
</head>
<body>
	<div class="top_div" align="center"><h1>changeMax智慧问答后台登录系统</h1></div>
	<div
		style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 200px; text-align: center;">
		<div style="width: 165px; height: 96px; position: absolute;">
			<div class="tou"></div>
			<div class="initial_left_hand" id="left_hand"></div>
			<div class="initial_right_hand" id="right_hand"></div>
		</div>
		<form id="form1" name="form1"
			action="${pagecontext.request.contextpath}/admin/dologin"
			method="post">
			<p style="padding: 30px 0px 10px; position: relative;">
				<span class="u_logo"></span> <input class="ipt" type="text"
					id="adminusername" name="adminusername" placeholder="请输入用户名或邮箱"
					value="${adminusername }"><a style="color: red">${errormessage }</a>
			</p>
			<p style="position: relative;">
				<span class="p_logo"></span> <input class="ipt" id="adminpassword"
					name="adminpassword" type="password" placeholder="请输入密码"
					value="${adminpassword }">
			</p>
			<div
				style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
				<p style="margin: 0px 35px 20px 45px;">
					<span style="float: left;"><a
						style="color: rgb(204, 204, 204);" href="#">忘记密码?</a></span> <span
						style="float: right;"><a
						style="color: rgb(204, 204, 204); margin-right: 10px;" href="#">注册</a>
						<input type="submit" value="登录系统"
						style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;">
					</span>
				</p>
			</div>
		</form>
	</div>
	<div style="text-align: center;">
		<p>
			changemax智慧问答引擎后台 - <a>登录系统</a>
		</p>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		//得到焦点
		$("#password").focus(function() {
			$("#left_hand").animate({
				left : "150",
				top : " -38"
			}, {
				step : function() {
					if (parseint($("#left_hand").css("left")) > 140) {
						$("#left_hand").attr("class", "left_hand");
					}
				}
			}, 2000);
			$("#right_hand").animate({
				right : "-64",
				top : "-38px"
			}, {
				step : function() {
					if (parseint($("#right_hand").css("right")) > -70) {
						$("#right_hand").attr("class", "right_hand");
					}
				}
			}, 2000);
		});
		//失去焦点
		$("#password").blur(function() {
			$("#left_hand").attr("class", "initial_left_hand");
			$("#left_hand").attr("style", "left:100px;top:-12px;");
			$("#right_hand").attr("class", "initial_right_hand");
			$("#right_hand").attr("style", "right:-112px;top:-12px");
		});
	});
</script>
</html>