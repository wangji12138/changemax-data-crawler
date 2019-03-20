<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>网站底部声明</title>
</head>
<body>

	<div class="footer">
		<p>
			<a href="${pageContext.request.contextPath }/">changeMax智慧问答社区</a>
			2019 &copy; <a href="${pageContext.request.contextPath }/">changeMax.cn</a>
		</p>
		<p>
			<a href="${pageContext.request.contextPath }/" target="_blank">产品授权</a>
			<a href="${pageContext.request.contextPath }/" target="_blank">获取changeMax智慧问答社区</a> <a href="${pageContext.request.contextPath }/views/about.jsp"
				target="_blank">关于网站</a>
		</p>
	</div>
	<script
		src="${pageContext.request.contextPath }/assets/before/layui/layui.js"></script>
</body>
</html>