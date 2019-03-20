<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>changeMax-QA搜索引擎交互测试界面</title>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="team" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link rel="stylesheet"
	href="<%=request.getContextPath() %>/assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/assets/css/vegas.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/assets/css/font-awesome.min.css">

<!-- MAIN CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/assets/css/templatemo-style.css">

</head>
<body>

	<!-- PRE LOADER -->
	<section class="preloader">
		<div class="spinner">
			<span class="spinner-rotate"></span>
		</div>
	</section>

	<div class="menu-bg"></div>
	<div class="menu-burger">☰</div>


	<div class="menu-items">

		<div class="container">

			<div class="row">

				<div class="col-md-offset-2 col-md-4 col-sm-6">
					<h1>导航</h1>
					<ul class="menu">
						<li><a href="#">主页</a></li>
						<li><a href="#">Test</a></li>
						<li><a href="#">Test</a></li>
						<li><a href="#">Test</a></li>
						<li><a href="#">关于本站</a></li>
					</ul>
				</div>

				<div class="col-md-4 col-sm-6">
					<address>
						<h2>我们的工作室</h2>
						<p>changeMax-WangJi</p>
					</address>
				</div>

			</div>
		</div>
	</div>
	<!-- HOME -->
	<section id="home">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<div class="home-info">
						<h2 style="color: white;">
							changeMax-QA<br>搜索引擎交互测试界面
						</h2>
						<!-- <ul class="countdown">
							<li><span class="days">14</span>
								<h3>天</h3></li>
							<li><span class="hours">10</span>
								<h3>时</h3></li>
							<li><span class="minutes">15</span>
								<h3>分</h3></li>
							<li><span class="seconds">34</span>
								<h3>秒</h3></li>
						</ul> -->
						<div class="subscribe-form">
							<form
								action="${pageContext.request.contextPath }/qaSearch/searchQa"
								method="post">
								<input type="text" name="searchQuestion" class="form-control"
									placeholder="请简单描述你的问题" required=""><br> <br>
								<br> <input type="submit" value="提交响应"
									class="btn btn-block btn-info" /> <i class="fa fa-envelope-o"></i>

							</form>
						</div>


						<br> <br>

						<div class="panel-body" style="height: 400px; overflow-y: scroll">
							<div style="border: 1px #000000; width: 90%; margin: 0 auto;">
								<table id="tab" border="1" cellspacing="0">
									<c:if test="${nextSearchQuestion!=null }">
										<h4>上个问题：${nextSearchQuestion }</h4>

										<br>
										<br>
									</c:if>

									<c:if test="${qaList!=null }">
										<c:forEach var="qa" items="${qaList }">
											<li>${qa.answer }</li>

											<br>
											<br>
										</c:forEach>
									</c:if>

									<c:if test="${qa!=null }">
										<li>${qa.answer }</li>
										<br>
										<br>
									</c:if>
								</table>
							</div>
						</div>

					</div>
				</div>

			</div>
		</div>
	</section>

	<!-- SCRIPTS -->
	<script src="<%=request.getContextPath() %>/assets/js/jquery.js"></script>
	<script src="<%=request.getContextPath() %>/assets/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath() %>/assets/js/vegas.min.js"></script>
	<script src="<%=request.getContextPath() %>/assets/js/countdown.js"></script>
	<script src="<%=request.getContextPath() %>/assets/js/custom.js"></script>

</body>
</html>