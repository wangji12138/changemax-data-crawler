<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增问题 - changeMax智慧问答社区</title>
<%@ include file="/views/common/link.jsp"%>

</head>

<body>

	<%@ include file="/views/common/header.jsp"%>

	<div class="main layui-clear">
		<div class="fly-panel" pad20>
			<h2 class="page-title">发布问题</h2>

			<!-- <div class="fly-none">并无权限</div> -->

			<div class="layui-form layui-form-pane">
				<form
					action="${pageContext.request.contextPath }/question/doAdd.action"
					method="post">
					<div class="layui-form-item">
						<label for="L_title" class="layui-form-label">问题标题</label>
						<div class="layui-input-block">
							<input type="text" id="L_questionTitle" name="questionTitle"
								required lay-verify="required" placeholder="请一句话概括问题"
								autocomplete="off" class="layui-input">
						</div>
					</div>

					<div class="layui-form-item">
						<div class="layui-form-item">
							<label class="layui-form-label">问题类型</label>
							<div class="layui-input-block">
								<select name="questionCategoryId" lay-verify="required">
									<option value=""></option>
									<option value="0">北京</option>
									<option value="1">上海</option>
									<option value="2">广州</option>
									<option value="3">深圳</option>
									<option value="4">杭州</option>
									<option value="">直接选择或搜索选择问题类型</option>
									<c:if test="${qaCategoryList!=null }">
										<c:forEach items="${qaCategoryList }" var="qaCategory">
											<option value="${qaCategory.id }">${qaCategory.name }</option>
										</c:forEach>
									</c:if>
								</select>
							</div>
						</div>
					</div>



					<div class="layui-form-item layui-form-text">
						<div class="layui-input-block">
							<textarea id="L_questionDetail" name="questionDetail" required
								lay-verify="required" placeholder="请输入问题内容详细描述"
								class="layui-textarea fly-editor" style="height: 260px;"></textarea>
						</div>
						<label for="L_content" class="layui-form-label" style="top: -2px;">问题详细描述</label>
					</div>

					<div class="layui-form-item">
						<label for="L_title" class="layui-form-label">问题悬赏金额</label>
						<div class="layui-input-block">
							<input type="text" id="L_questionReward" name="questionReward"
								required lay-verify="required" placeholder="cm币"
								autocomplete="off" class="layui-input">
						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">是否匿名</label>
						<div class="layui-input-block">
							<input type="radio" name="isAnonymous" value="0" title="不匿名"
								checked=""> <input type="radio" name="isAnonymous"
								value="1" title="匿名">
						</div>
					</div>

					<div class="layui-form-item">
						<label for="L_vercode" class="layui-form-label">人类验证</label>
						<div class="layui-input-inline">
							<input type="text" id="L_vercode" name="vercode" required
								lay-verify="required" placeholder="请回答后面的问题" autocomplete="off"
								class="layui-input">
						</div>
						<div class="layui-form-mid">
							<span style="color: #c00;">1+1=?</span>
						</div>
					</div>
					<div class="layui-form-item">
						<button class="layui-btn" lay-filter="*" lay-submit>立即发布悬赏</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		layui.use('form', function() {
			var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功

			//……

			//但是，如果你的HTML是动态生成的，自动渲染就会失效
			//因此你需要在相应的地方，执行下述方法来手动渲染，跟这类似的还有 element.init();
			form.render();
		});
	</script>

	<%@ include file="/views/common/footer.jsp"%>

</body>
</html>