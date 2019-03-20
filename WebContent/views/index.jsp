<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>欢迎来到changeMax智慧问答社区</title>

<%@ include file="/views/common/link.jsp"%>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>

	<div class="main layui-clear">
		<div class="wrap">
			<div class="content">
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


				<c:if test="${fineQuestionList != null }">
					<div>
						<ul class="fly-list fly-list-top">

							<c:forEach items="${fineQuestionList }" var="fineQuestion">
								<li class="fly-list-li"><a
									href="${pageContext.request.contextPath }/user/home.action?userId=${fineQuestion.userId }"
									class="fly-list-avatar"> <img
										src="${fineQuestion.user.userAvatar }" alt="" />            
										     
								</a>

									<h2 class="fly-tip">
										<a
											href="${pageContext.request.contextPath }/question/detail.action?questionId=${fineQuestion.questionId }">${fineQuestion.questionTitle }</a>
										<c:if test="${fineQuestion.isAddFine == 1 }">
											<span class="fly-tip-stick">置顶</span>
										</c:if>
										<c:if test="${fineQuestion.isTop == 1 }">
											<span class="fly-tip-jing">精帖</span>
										</c:if>
									</h2>

									<p>
										<span><a
											href="${pageContext.request.contextPath }/user/home.action?userId=${fineQuestion.userId }">${fineQuestion.user.userName }</a></span>
										<span>${fineQuestion.generationDate}</span> <span>${fineQuestion.qaCategory.name}</span>
										<span class="fly-list-hint"> <i class="iconfont"
											title="回答">&#xe60c;</i> ${fineQuestion.answerNumber} <i
											class="iconfont" title="人气">&#xe60b;</i> ${fineQuestion.views }
										</span>
									</p></li>

							</c:forEach>
						</ul>
					</div>
				</c:if>

				<c:if test="${hotViewsQuestionList!=null }">
					<div>
						<ul class="fly-list">

							<c:forEach items="${hotViewsQuestionList }" var="hotQuestion">

								<li class="fly-list-li"><a
									href="${pageContext.request.contextPath }/user/home.action?userId=${hotQuestion.userId }"
									class="fly-list-avatar"> <img
										src="${fineQuestionList[i].user.userAvatar }" alt="">
								</a>
									<h2 class="fly-tip">
										<a
											href="${pageContext.request.contextPath }/question/detail.action?questionId=${hotQuestion.questionId }">${hotQuestion.questionTitle }</a>
									</h2>
									<p>
										<span><a
											href="${pageContext.request.contextPath }/user/home.action?userId=${hotQuestion.userId }">${hotQuestion.user.userName }</a></span>
										<span>${hotQuestion.generationDate }</span> <span>${hotQuestion.qaCategory.name }</span>
										<span class="fly-list-hint"> <i class="iconfont"
											title="回答">&#xe60c;</i> ${fineQuestionList[i].answerNumber} <i
											class="iconfont" title="人气">&#xe60b;</i>
											${fineQuestionList[i].views }
										</span>
									</p></li>
							</c:forEach>
						</ul>
					</div>
				</c:if>

				<div style="text-align: center">
					<div class="laypage-main">
						<a
							href="${pageContext.request.contextPath }/question/likeSearchQuestion.action"
							class="laypage-next">更多问答</a>
					</div>
				</div>

			</div>
		</div>

		<div class="edge">
			<div class="fly-panel leifeng-rank">
				<c:if test="${monthTopUserList!=null }">
					<h3 class="fly-panel-title">近一月回答榜 - TOP 12</h3>
					<dl>
						<c:forEach items="${monthTopUserList }" var="monthTopUser">
							<dd>
								<a
									href="${pageContext.request.contextPath }/user/home.action?userId=${monthTopUser.userId }">
									<img src="${monthTopUser.userAvatar }" alt="" /> <cite>${monthTopUser.userName }</cite>
									<i>${monthTopUser.userAnswerNumber }次回答</i>
								</a>
							</dd>
						</c:forEach>
					</dl>
				</c:if>
			</div>

			<c:if test="${newDateQuestionList!=null }">
				<dl class="fly-panel fly-list-one">
					<dt class="fly-panel-title">最新待解答问答</dt>
					<c:forEach items="${newDateQuestionList }" var="newQuestion">
						<dd>
							<a
								href="${pageContext.request.contextPath }/question/detail.action?questionId=${newQuestion.questionId }">${newQuestion.questionTitle }</a>
							<span><i class="iconfont">&#xe60b;</i>
								${newQuestion.generationDate }</span>
						</dd>
					</c:forEach>
				</dl>
			</c:if>

			<c:if test="${hotQaCategoryList!=null }">
				<dl class="fly-panel fly-list-one">
					<dt class="fly-panel-title">最近热问答分类</dt>
					<c:forEach items="${hotQaCategoryList }" var="hotQaCategory">
						<dd>
							<a
								href="${pageContext.request.contextPath }/qaCategory/detail.action?id=${hotQaCategory.id }">${hotQaCategory.name }</a>
							<span><i class="iconfont">&#xe60c;</i>
								${hotQaCategory.questionNumber }</span>
						</dd>
					</c:forEach>
				</dl>
			</c:if>

			<div class="fly-panel fly-link">
				<h3 class="fly-panel-title">友情链接</h3>
				<dl>
					<dd>
						<a href="https://zhidao.baidu.com/" target="_blank">百度知道</a>
					</dd>
					<dd>
						<a href="https://www.zhihu.com/" target="_blank">知乎</a>
					</dd>
					<dd>
						<a href="https://blog.csdn.net/qq_40223688" target="_blank">changeMax博客</a>
					</dd>
				</dl>
			</div>


		</div>
	</div>

	<%@ include file="/views/common/footer.jsp"%>

</body>
</html>