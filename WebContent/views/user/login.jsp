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

	<div class="main layui-clear">

		<div class="fly-panel fly-panel-user" pad20>
			<div class="layui-tab layui-tab-brief">
				<ul class="layui-tab-title">
					<li class="layui-this">登入</li>
					<li><a href="${pageContext.request.contextPath }/user/reg.action">注册</a></li>
				</ul>
				<div class="layui-form layui-tab-content" id="LAY_ucm"
					style="padding: 20px 0;">
					<div class="layui-tab-item layui-show">
						<div class="layui-form layui-form-pane">
							<form
								action="${pageContext.request.contextPath }/user/doLogin.action"
								method="post">
								<div class="layui-form-item">
									<label for="L_email" class="layui-form-label">用户名</label>
									<div class="layui-input-inline">
										<input type="text" id="L_username" name="username" required
											lay-verify="required" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label for="L_pass" class="layui-form-label">密码</label>
									<div class="layui-input-inline">
										<input type="password" id="L_password" name="password"
											required lay-verify="required" autocomplete="off"
											class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label for="L_vercode" class="layui-form-label">人类验证</label>
									<div class="layui-input-inline">
										<input type="text" id="L_vercode" name="vercode" required
											lay-verify="required" placeholder="请回答后面的问题"
											autocomplete="off" class="layui-input">
									</div>
									<div class="layui-form-mid">
										<span style="color: #c00;">1+1=?</span>
									</div>
								</div>
								<div class="layui-form-item">
									<button class="layui-btn" lay-filter="*" lay-submit>立即登录</button>
									<span style="padding-left: 20px;"> <a href="forget.jsp">忘记密码？</a>
									</span>
								</div>
								<div class="layui-form-item fly-form-app">
									<span>或者使用社交账号登入</span> <a href="#"
										onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})"
										class="iconfont icon-qq" title="QQ登入"></a> <a href="#"
										onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})"
										class="iconfont icon-weibo" title="微博登入"></a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<%@ include file="/views/common/footer.jsp"%>

</body>
</html>