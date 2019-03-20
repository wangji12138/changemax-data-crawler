<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>后台管理系统</title>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<meta content="MSHTML 6.00.2900.3492" name=GENERATOR>
</head>
<frameset frameSpacing=0 rows=80,* frameBorder=0>
	<frame name=top src="${pageContext.request.contextPath}/backstage/top"
		frameBorder=0 noResize scrolling=no>
	<frameset frameSpacing=0 frameBorder=0 cols=220,*>
		<frame name=menu src="${pageContext.request.contextPath}/backstage/menu"
			frameBorder=0 noResize>
		<frame name=main src="${pageContext.request.contextPath}/backstage/welcome"
			frameBorder=0>
	</frameset>
	<noframes>
		<p>this page requires frames, but your browser does not support
			them.</p>
	</noframes>
</frameset>
</html>
