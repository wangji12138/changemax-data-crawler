<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>关于网站</title>
<%@ include file="/views/common/link.jsp"%>


</head>
<body>

	<%@ include file="/views/common/header.jsp"%>

	<div class="main fly-user-main layui-clear">
		<ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
			<li class="layui-nav-item"><a
				href="${pageContext.request.contextPath }/user/home.action"> <i
					class="layui-icon">&#xe609;</i> 咱的脸面
			</a></li>
			<li class="layui-nav-item layui-this"><a href="#"> <i
					class="layui-icon">&#xe612;</i> 问答列表
			</a></li>
			<li class="layui-nav-item"><a
				href="${pageContext.request.contextPath }/user/set.action"> <i
					class="layui-icon">&#xe620;</i> 个人资料
			</a></li>
			<li class="layui-nav-item"><a
				href="${pageContext.request.contextPath }/user/message.action">
					<i class="layui-icon">&#xe611;</i> 问答信息
			</a></li>
		</ul>

		<div class="site-tree-mobile layui-hide">
			<i class="layui-icon">&#xe602;</i>
		</div>
		<div class="site-mobile-shade"></div>

		<div class="fly-panel fly-panel-user" pad20>

			<div class="fly-msg" style="margin-top: 15px;">
				您的邮箱尚未验证，这比较影响您的帐号安全，<a href="activate.jsp">立即去激活？</a>
			</div>

			<div class="layui-tab layui-tab-brief" lay-filter="user">
				<ul class="layui-tab-title" id="LAY_mine">
					<li data-type="mine-jie" lay-id="question" class="layui-this">我发布的问答（<span>12156</span>）
					</li>
					<li data-type="collectionQa" data-url="/collection/s/"
						lay-id="collection">我解答的问答（<span>1616</span>）
					</li>
					<li data-type="collectionQuestion" data-url="/collection/find/"
						lay-id="collection">我收藏的问答（<span>1616</span>）
					</li>
				</ul>
				<div class="layui-tab-content" style="padding: 20px 0;">
					<div class="layui-tab-item layui-show">
						<ul class="mine-view jie-row">
							<li><a class="jie-title" href="/jie/8116.jsp"
								target="_blank">LayIM 3.5.0 发布，移动端版本大更新（带演示图）</a> <i>2017/3/14
									上午8:30:00</i> <a class="mine-edit" href="/jie/edit/8116">编辑</a> <em>661阅/10答</em>
							</li>
						</ul>
						<div id="LAY_page"></div>
					</div>
					<div class="layui-tab-item">
						<ul class="mine-view jie-row">
							<li><a class="jie-title"
								href="http://fly.layui.com/jie/5366.jsp" target="_blank">layui
									常见问题的处理和实用干货集锦</a> <i>收藏于23小时前</i></li>
						</ul>
						<div id="LAY_page1"></div>
					</div>
					<div class="layui-tab-item">
						<ul class="mine-view jie-row">
							<li><a class="jie-title"
								href="http://fly.layui.com/jie/5366.jsp" target="_blank">layui
									常见问题的处理和实用干货集锦</a> <i>收藏于23小时前</i></li>
						</ul>
						<div id="LAY_page2"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/views/common/footer.jsp"%>

</body>
</html>