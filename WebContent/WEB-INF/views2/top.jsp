<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id=Head1>
<title>Top</title>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<style type=text/css>
body {
	padding-right: 0px;
	padding-left: 0px;
	padding-bottom: 0px;
	margin: 0px;
	padding-top: 0px;
	background-color: #2a8dc8
}

body {
	font-size: 12px;
	color: #003366;
	font-family: Verdana, Arial, Helvetica, sans-serif
}

td {
	font-size: 12px;
	color: #003366;
	font-family: Verdana, Arial, Helvetica, sans-serif
}

div {
	font-size: 12px;
	color: #003366;
	font-family: Verdana, Arial, Helvetica, sans-serif
}

p {
	font-size: 12px;
	color: #003366;
	font-family: Verdana, Arial, Helvetica, sans-serif
}
</style>

<meta content="MSHTML 6.00.2900.3492" name=generator>
</head>
<body>
	<form id=form1 name=form1 action="" method=post>
		<table cellSpacing=0 cellPadding=0 width="100%" border=0>
			<tbody>
				<tr>
					<td width=10><img
						src="<%=request.getContextPath()%>/assets/images/new_001.jpg"
						border=0></td>
					<td
						background="<%=request.getContextPath()%>/assets/images/new_002.jpg"><font
						size=5><b>changeMax-QA搜索引擎后台管理系统</b></font></td>
					<td
						background="<%=request.getContextPath()%>/assets/images/new_002.jpg">
						<table cellSpacing=0 cellPadding=0 width="100%" border=0>
							<tbody>
								<tr>
									<td align=right height=35></td>
								</tr>
								<tr>
									<td height=35 align="right"><c:choose>
											<c:when test="${admin!=null }"> 
											当前管理员：【${admin.adminUsername }】 
											</c:when>

											<c:otherwise>
												<a href="${pageContext.request.contextPath }/admin/login"
													style="color: red;" target=_top>请注意，您非法登入！</a>
											</c:otherwise>
										</c:choose> &nbsp;&nbsp;&nbsp;&nbsp; <a
										href="${pageContext.request.contextPath }/admin/login"
										target=_top><font color=red>修改密码</font></a>
										&nbsp;&nbsp;&nbsp;&nbsp; <a
										href="${pageContext.request.contextPath }/admin/doLogout"
										target=_top><font color=red>安全退出</font></a></td>
								</tr>
							</tbody>
						</table>
					</td>
					<td width=10><img
						src="<%=request.getContextPath()%>/assets/images/new_003.jpg"
						border=0></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
