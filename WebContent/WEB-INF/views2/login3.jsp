<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<style type=text/css>
body {
	font-size: 12px;
	color: #ffffff;
	font-family: 宋体
}

td {
	font-size: 12px;
	color: #ffffff;
	font-family: 宋体
}
</style>
<meta content="MSHTML 6.00.6000.16809" name="GENERATOR">
</head>
<body>
	<form id="form1" name="form1"
		action="${pageContext.request.contextPath}/admin/doLogin"
		method="post">
		<div id=UpdatePanel1>
			<div id=div1
				style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
			<div id=div2
				style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
			<div>&nbsp;&nbsp;</div>
			<div>
				<table cellSpacing=0 cellPadding=0 width=900 align=center border=0>
					<tbody>
						<tr>
							<td style="HEIGHT: 105px"><img
								src="<%=request.getContextPath() %>/assets/images/login_1.gif"
								border=0></td>
						</tr>
						<tr>
							<td
								background="<%=request.getContextPath() %>/assets/images/login_2.jpg"
								height=300>
								<table height=300 cellPadding=0 width=900 border=0>
									<tbody>
										<tr>
											<td colSpan=2 height=35></td>
										</tr>
										<tr>
											<td width=360></td>
											<td>
												<table cellSpacing=0 cellPadding=2 border=0>
													<tbody>
														<tr>
															<td style="HEIGHT: 28px" width=80>登 录 名：</td>
															<td style="HEIGHT: 28px" width=150><input
																type="text" id="adminUsername" style="WIDTH: 130px"
																name="adminUsername"></td>
															<td style="HEIGHT: 28px" width=370><span
																id="RequiredFieldValidator3"
																style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white">请输入登录名</span>
															</td>
														</tr>
														<tr>
															<td style="HEIGHT: 28px">登录密码：</td>
															<td style="HEIGHT: 28px"><input id="adminPassword"
																style="WIDTH: 130px" type="password"
																name="adminPassword"></td>
															<td style="HEIGHT: 28px"><span
																id=RequiredFieldValidator4
																style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white">请输入密码</span>
															</td>
														</tr>

														<tr>
															<td style="HEIGHT: 18px"></td>
															<td style="HEIGHT: 18px"></td>
															<td style="height: 18px"></td>
														</tr>
														<tr>
															<td></td>
															<td><input id=btn
																style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px"
																type="image"
																src="<%=request.getContextPath() %>/assets/images/login_button.gif"
																name=btn onclick="this.form.submit()"></td>
														</tr>
													</tbody>
												</table>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td><img
								src="<%=request.getContextPath() %>/assets/images/login_3.jpg"
								border=0></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form>
</body>
</html>
