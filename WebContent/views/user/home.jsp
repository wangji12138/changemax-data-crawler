<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${user.userName }-用户主页</title>
</head>
<%@ include file="/views/common/link.jsp"%>


<body>
	<%@ include file="/views/common/header.jsp"%>

	<div class="fly-home" style="background-image: url();">
		<img src="${user.userAvatar }" alt="img-${user.userId }">
		<h1>
			${user.userName } <i class="iconfont icon-nan"></i>
			<!-- <i class="iconfont icon-nv"></i> -->

			<!-- <span style="color: #c00;">（超级码农）</span> -->
			<!-- <span style="color: #5FB878;">（活雷锋）</span> -->
			<span style="color: #FF9E3F">新人</span>
			<!-- <span>（该号已被封）</span> -->

		</h1>
		<p class="fly-home-info">
			<i class="iconfont icon-zuichun" title="cm豆"></i><span
				style="color: #FF7200;">1000 cm豆</span> <i
				class="iconfont icon-shijian"></i><span>${user.userRegistrationTime }
				加入</span> <i class="iconfont icon-chengshi"></i><span>来自 浙江杭州</span>
		</p>
		<p class="fly-home-sign">这个世界因我而改变一点点。</p>
	</div>

	<div class="main fly-home-main">
		<div class="layui-inline fly-home-jie">
			<div class="fly-panel">
				<h3 class="fly-panel-title">${user.userName }最近的问答</h3>
				<c:choose>
					<c:when
						test="${user.topQuestionList!=null || user.addFineQuestionList!=null || user.ordinaryQuestionList!=null }">
						<ul class="jie-row">
							<c:if test="${user.topQuestionList!=null }">

								<c:forEach items="${user.topQuestionList }" var="topQuestion">
									<li><span class="fly-stick">置顶</span> <a
										href="${pageContext.request.contextPath }/question/detail.action?id=${topQuestion.id }"
										class="jie-title">${topQuestion.searchQuestion }</a> <i>${topQuestion.searchDate }</i>
										<em>${topQuestion.views }阅/${topQuestion.answerNumber }答</em></li>
								</c:forEach>
							</c:if>

							<c:if test="${user.addFineQuestionList!=null }">
								<c:forEach items="${user.addFineQuestionList }"
									var="addFineQuestion">
									<li><span class="fly-jing">加精</span> <a
										href="${pageContext.request.contextPath }/question/detail.action?id=${addFineQuestion.id }"
										class="jie-title">${addFineQuestion.searchQuestion }</a> <i>${addFineQuestion.searchDate }</i>
										<em>${addFineQuestion.views }阅/${addFineQuestion.answerNumber }答</em></li>
								</c:forEach>
							</c:if>

							<c:if test="${user.ordinaryQuestionList!=null }">
								<c:forEach items="${user.ordinaryQuestionList }"
									var="ordinaryQuestion">
									<li><span class="fly-jing">加精</span> <a
										href="${pageContext.request.contextPath }/question/detail.action?id=${ordinaryQuestion.id }"
										class="jie-title">${ordinaryQuestion.searchQuestion }</a> <i>${ordinaryQuestion.searchDate }</i>
										<em>${ordinaryQuestion.views }阅/${ordinaryQuestion.answerNumber }答</em></li>
								</c:forEach>
							</c:if>

						</ul>
					</c:when>
					<c:otherwise>
						<div class="fly-none"
							style="min-height: 50px; padding: 30px 0; height: auto;">
							<i style="font-size: 14px;">该用户无视了changeMax智慧问答社区的强大功能，所以没有发布任何问题。</i>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>

		<div class="layui-inline fly-home-da">
			<div class="fly-panel">
				<h3 class="fly-panel-title">${user.userName }最近的解答</h3>
				<c:choose>
					<c:when test="${user.qaList }">
						<ul class="home-jieda">
							<c:forEach items="${user.qaList }" var="qa">
								<li>
									<p>
										<span>${qa.qaDate }</span> 在<a
											href="${pageContext.request.contextPath }/question/detail.action?id=${qa.questionId }"
											target="_blank">${qa.originalQuestion }</a>中回答：
									</p>
									<div class="home-dacontent">${qa.answer }</div>
								</li>
							</c:forEach>
						</ul>
					</c:when>
					<c:otherwise>
						<div class="fly-none"
							style="min-height: 50px; padding: 30px 0; height: auto;">
							<span>这家伙很懒，没有回答任何问题</span>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>

	</div>

	<%@ include file="/views/common/footer.jsp"%>

</body>
</html>