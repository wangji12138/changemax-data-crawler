<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>网站顶部信息</title>
</head>
<body>
	<div class="header">
		<div class="main">
			<a class="logo" href="${pageContext.request.contextPath }/" title="changeMax智慧问答社区">changeMax智慧问答社区</a>
			<div class="nav">
				<a class="nav-this"
					href="${pageContext.request.contextPath }/question/list.action">
					<i class="iconfont icon-wenda"></i>问答
				</a> <a href="${pageContext.request.contextPath }/medical/home.action"
					target="_blank"> <i class="iconfont icon-ui"></i>医疗数据
				</a>
			</div>

			<div class="nav-user">

				<c:choose>
					<c:when test="${user!=null }">
						<!-- 登入后的状态 -->
						<a class="avatar"
							href="${pageContext.request.contextPath }/user/index.action">
							<img src="${user.userAvatar }"> <cite>${user.userName }</cite>
							<!-- <i>称号</i> -->
						</a>
						<div class="nav">
							<a href="${pageContext.request.contextPath }/user/set.action"><i
								class="iconfont icon-shezhi"></i>设置</a> <a
								href="${pageContext.request.contextPath }/user/logout.action"><i
								class="iconfont icon-tuichu" style="top: 0; font-size: 22px;"></i>注销</a>
						</div>

					</c:when>

					<c:otherwise>
						<!-- 未登入状态 -->
						<a class="unlogin"
							href="${pageContext.request.contextPath }/user/login.action"><i
							class="iconfont icon-touxiang"></i></a>
						<span><a
							href="${pageContext.request.contextPath }/user/login.action">登录</a><a
							href="${pageContext.request.contextPath }/user/reg.action">注册</a></span>
						<p class="out-login">
							<a href="#"
								onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})"
								class="iconfont icon-qq" title="QQ登入"></a> <a href="#"
								onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})"
								class="iconfont icon-weibo" title="微博登入"></a>
						</p>

					</c:otherwise>
				</c:choose>

			</div>
		</div>
	</div>
</body>
</html>