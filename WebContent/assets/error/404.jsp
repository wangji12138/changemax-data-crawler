<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>页面找不到了。。。</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<%@ include file="/views/common/link.jsp"%>

</head>
<body>
	<%@ include file="/views/common/header.jsp"%>

	<div class="main">
		<div class="fly-panel">
			<div class="fly-none">
				<h2>
					<i class="iconfont icon-404">不好意思，您访问的页面不存在~</i>
				</h2>
				<p>
					您可以： <a href="javascript:;" onclick="history.go(-1)"
						class="c-primary" style="color: #DCDCDC">&lt; 返回上一页</a> <span
						class="ml-20">|</span> <a href="/" class="c-primary ml-20"
						style="color: #DCDCDC">去首页 &gt;</a>
				</p>

			</div>
		</div>
	</div>

	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>