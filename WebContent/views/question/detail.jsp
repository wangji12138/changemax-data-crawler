<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${question.searchQuestion }-changeMax智慧问答社区</title>
<%@ include file="/views/common/link.jsp"%>
</head>
<body>

	<%@ include file="/views/common/header.jsp"%>

	<div class="main layui-clear">
		<div class="wrap">
			<div class="content detail">
				<div class="fly-panel detail-box">
					<h1>${question.searchQuestion }</h1>
					<div class="fly-tip fly-detail-hint" data-id="{{rows.id}}">
						<c:if test="${question.isAddFine == 1 }">
							<span class="fly-tip-stick">置顶问题</span>
						</c:if>
						<c:if test="${question.isTop == 1 }">
							<span class="fly-tip-jing">精品问题</span>
						</c:if>

						<c:choose>
							<c:when
								test="${question.desirableQaId==null || desirableQaId == 0 }">
								<span>未解决</span>
							</c:when>
							<c:otherwise>
								<span class="fly-tip-jie">已解决</span>
							</c:otherwise>
						</c:choose>

						<div class="fly-list-hint">
							<i class="iconfont" title="解答">&#xe60c;</i>
							${question.answerNumber } <i class="iconfont" title="人气">&#xe60b;</i>
							${question.views }
						</div>
					</div>
					<div class="detail-about">
						<a class="jie-user"
							href="${pageContext.request.contextPath }/user/detail.action?userId=${question.user.userId }">
							<img src="${question.user.userAvatar }" alt=""> <cite>
								${question.user.userName } <em>${question.searchDate }</em>
						</cite>
						</a>
						<div class="detail-hits" data-id="{{rows.id}}">
							<span style="color: #FF7200">悬赏：${question.reward }cm豆</span>
							<c:if test="${user.userId == question.user.userId}">
								<span class="layui-btn layui-btn-mini jie-admin" type="edit">
									<a
									href="${pageContext.request.contextPath }/question/update.action?id=${question.id }">编辑此贴</a>
								</span>
							</c:if>

							<span class="layui-btn layui-btn-mini jie-admin " type="collect"
								data-type="add"> <a
								href="${pageContext.request.contextPath }/question/collection.action?id=${question.id }">收藏</a></span>

							<!--<span class="layui-btn layui-btn-mini jie-admin  layui-btn-danger" type="collect" data-type="add">取消收藏</span>-->
						</div>
					</div>

					<div class="detail-body photos" style="margin-bottom: 20px;">
						<p>问题详细描述：</p>
						<pre>${question.questionDetail }</pre>

						<p>
							<img
								src="${pageContext.request.contextPath }/before/images/fly.jpg"
								alt="changemax社区">
						</p>
					</div>
				</div>

				<div class="fly-panel detail-box" style="padding-top: 0;">
					<a name="comment"></a>
					<ul class="jieda photos" id="jieda">

						<c:choose>
							<c:when
								test="${question.adoptionQa!=null || question.qaList!=null}">
								<c:if test="${question.adoptionQa!=null }">
									<li data-id="${question.adoptionQa.id }" class="jieda-daan"><a
										name="item-${question.adoptionQa.id }"></a>
										<div class="detail-about detail-about-reply">
											<a class="jie-user"
												href="${pageContext.request.contextPath }/user/home.action?userId=${question.adoptionQa.userId }">
												<img src="${question.adoptionQa.user.userAvatar }" alt="">
												<cite> <i>${question.adoptionQa.user.userName }</i>
											</cite>
											</a>
											<div class="detail-hits">
												<span>${question.adoptionQa.qaDate }</span>
											</div>
											<i class="iconfont icon-caina" title="最佳解答"></i>
										</div>
										<div class="detail-body jieda-body">
											<p>${question.adoptionQa.answer }</p>
										</div>
										<div class="jieda-reply">
											<span class="jieda-zan zanok" type="zan"><i
												class="iconfont icon-zan"></i><em>${question.adoptionQa.goodNumber }</em></span>
											<!-- <span type="reply"><i class="iconfont icon-svgmoban53"></i>回复</span> -->

											<div class="jieda-admin">
												<c:if test="${user!=null && user.userId == question.adoptionQa.userId }">
													<span type="edit"><a
														href="${pageContext.request.contextPath }/qa/edit.action?questionId=${question.id }&id=${question.adoptionQa.id }">编辑</a></span>
													<span type="del"><a
														href="${pageContext.request.contextPath }/qa/del.action?questionId=${question.id }&id=${question.adoptionQa.id }">删除</a></span>
												</c:if>
											</div>

										</div></li>
								</c:if>

								<c:if test="${question.qaList!=null }">
									<c:forEach items="${question.qaList }" var="qa">
										<li data-id="${qa.id }"><a name="item-${qa.id }"></a>
											<div class="detail-about detail-about-reply">
												<a class="jie-user"
													href="${pageContext.request.contextPath }/user/home.action?userId=${qa.userId }">
													<img src="${qa.user.userAvatar }" alt=""> <cite>
														<i>${qa.user.userName }</i> <em style="color: #FF9E3F">新人</em>
												</cite>
												</a>
												<div class="detail-hits">
													<span>${qa.qaDate }</span>
												</div>
											</div>
											<div class="detail-body jieda-body">
												<p>${qa.answer }</p>
											</div>
											<div class="jieda-reply">
												<span class="jieda-zan" type="zan"><i
													class="iconfont icon-zan"></i><em>${qa.goodNumber }</em></span>
												<!-- <span type="reply"><i class="iconfont icon-svgmoban53"></i>回复</span> -->
												<div class="jieda-admin">
													<c:if test="${user!=null }">
													<c:if test="${user.userId == qa.userId }">
														<span type="edit"><a
															href="${pageContext.request.contextPath }/qa/edit.action?questionId=${question.id }&id=${qa.id }">编辑</a></span>
														<span type="del"><a
															href="${pageContext.request.contextPath }/qa/del.action?questionId=${question.id }&id=${qa.id }">删除</a></span>
													</c:if>
													<c:if test="${user.userId == qa.userId }">
														<span class="jieda-accept" type="accept"><a
															href="${pageContext.request.contextPath }/question/adoption.action?id=${question.id }&qaId=${qa.id }">采纳</a></span>
													</c:if>
													</c:if>
												</div>
											</div></li>
									</c:forEach>
								</c:if>
							</c:when>
							<c:otherwise>
								<li class="fly-none">没有任何回答</li>
							</c:otherwise>
						</c:choose>
					</ul>

					<div class="layui-form layui-form-pane">
						<form
							action="${pageContext.request.contextPath }/qa/answer.action"
							method="post">
							<div class="layui-form-item layui-form-text">
								<div class="layui-input-block">
									<textarea id="L_content" name="userAnswer" required
										lay-verify="required" placeholder="我要解答"
										class="layui-textarea fly-editor" style="height: 150px;">
										</textarea>
								</div>
							</div>
							<div class="layui-form-item">
								<input type="hidden" name="questionId" value="${question.id }" />
								<button class="layui-btn" lay-filter="*" lay-submit>提交解答</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="edge">
			<dl class="fly-panel fly-list-one">
				<dt class="fly-panel-title">最近热门问答</dt>
				<c:choose>
					<c:when test="${hotViewsQuestionList!=null }">
						<c:forEach items="${hotViewsQuestionList }" var="hotViewsQuestion">
							<dd>
								<a
									href="${pageContext.request.contextPath }/question/detail.action?id=${hotViewsQuestion.id }">${hotViewsQuestion.searchQuestion }</a>
								<span><i class="iconfont">&#xe60b;</i>
									${hotViewsQuestion.views }</span>
							</dd>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<dd>
							<a>空空如也</a>
						</dd>
					</c:otherwise>
				</c:choose>

			</dl>

			<dl class="fly-panel fly-list-one">
				<dt class="fly-panel-title">最近热门讨论</dt>
				<c:choose>
					<c:when test="${hotAnswerQuestionList!=null }">
						<c:forEach items="${hotAnswerQuestionList }"
							var="hotAnswerQuestion">
							<dd>
								<a
									href="${pageContext.request.contextPath }/question/detail.action?id=${hotAnswerQuestion.id }">${hotAnswerQuestion.searchQuestion }</a>
								<span><i class="iconfont">&#xe60c;</i>
									${hotAnswerQuestion.answerNumber }</span>
							</dd>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<dd>
							<a>空空如也</a>
						</dd>
					</c:otherwise>
				</c:choose>
			</dl>
		</div>
	</div>
	<%@ include file="/views/common/footer.jsp"%>

</body>
</html>