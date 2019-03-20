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

	<div class="main layui-clear" id="app">
		<div class="wrap">
			<div class="content" style="margin-right: 0">
				<div class="fly-tab fly-tab-index">
					<form
						action="${pageContext.request.contextPath }/question/likeSearchQuestion.action"
						class="fly-search">
						<i class="iconfont icon-sousuo"></i> <input class="layui-input"
							autocomplete="off" placeholder="搜索内容，按回车跳转" type="text"
							name="searchQuestion">
					</form>
					<a href="${pageContext.request.contextPath }/question/add.action"
						class="layui-btn qa-add">发布问题</a>
				</div>

				<c:if test="${questionList!=null }">
					<ul class="fly-list">
						<c:forEach items="${questionList }" var="question">
							<li class="card">
								<div class="AuthorInfo-head">
									<a href="${pageContext.request.contextPath }/user/home.action">
										<img src="${question.user.userAvatar }" alt="">
									</a> <span>${question.user.userName }</span>
								</div>
								<div class="ContentItem-actions">
									<div class="title">
										<a
											href="${pageContext.request.contextPath }/question/detail.action">${question.questionTitle }</a>

									</div>
									<div class="content">
										<p>${question.questionDetail }</p>
									</div>
									<div class="content-footer">
										<span>新人</span>
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
		</div>
	</div>

	<div id="page_id"></div>
	<script
		src="${pageContext.request.contextPath }/assets/before/layui/layui.js"
		charset="utf-8"></script>
	<script type="text/javascript">
		layui.use([ 'laypage', 'layer' ], function() {
			var laypage = layui.laypage, layer = layui.layer;

			//总页数大于页码总数
			laypage.render({
				elem : 'page_id',
				count : 70, //数据总数
				jump : function(obj) {
					console.log(obj)
				}
			});
		});
	</script>

	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>