<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<title>MENU</title>
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
	font-size: 11px;
	color: #003366;
	font-family: Verdana
}

td {
	font-size: 11px;
	color: #003366;
	font-family: Verdana
}

div {
	font-size: 11px;
	color: #003366;
	font-family: Verdana
}

p {
	font-size: 11px;
	color: #003366;
	font-family: Verdana
}

.mainmenu {
	font-weight: bold;
	font-size: 14px;
	cursor: pointer;
	color: #000000
}

a.style2:link {
	padding-left: 4px;
	color: #0055bb;
	text-decoration: none
}

a.style2:visited {
	padding-left: 4px;
	color: #0055bb;
	text-decoration: none
}

a.style2:hover {
	padding-left: 4px;
	color: #ff0000;
	text-decoration: none
}

a.active {
	padding-left: 4px;
	color: #ff0000;
	text-decoration: none
}

.span {
	color: #ff0000;
}
</style>

<script type="text/javascript">
	function MenuDisplay(obj_id) {
		for (var i = 1; i <= 9; i++) {
			var obj = document.getElementById('table_' + i);
			if (obj) {
				document.getElementById('table_' + i).style.display = 'none';
				document.getElementById('table_' + i + 'Span').innerText = '＋';
			}

		}
		var obj = document.getElementById(obj_id);
		if (obj) {
			if (obj.style.display == 'none') {
				obj.style.display = 'block';
				document.getElementById(obj_id + 'Span').innerText = '－';
			} else {
				obj.style.display = 'none';
				document.getElementById(obj_id + 'Span').innerText = '＋';
			}
		}

	}
</script>

<meta content="mshtml 6.00.2900.3492" name=generator>
</head>
<body>
	<form id=form1 name=form1 action=YHMenu.aspx method=post>
		<!-- 菜单头部 首 -->
		<table cellSpacing=0 cellPadding=0 width=210 align=center border=0>
			<tbody>
				<tr>
					<td width=15><img
						src="<%=request.getContextPath() %>/assets/images/new_005.jpg"
						border=0></td>
					<td align="center" width=180
						background="<%=request.getContextPath() %>/assets/images/new_006.jpg"
						height=35><b> － 功能菜单</b></td>
					<td width=15><img
						src="<%=request.getContextPath() %>/assets/images/new_007.jpg"
						border=0></td>
				</tr>
			</tbody>
		</table>
		<!-- 菜单头部 尾-->
		<!-- 菜单内容 首 -->
		<table cellSpacing=0 cellPadding=0 width=210 align=center border=0>
			<tbody>
				<tr>
					<td width=15
						background="<%=request.getContextPath() %>/assets/images/new_008.jpg"></td>
					<td vAlign=top width=180 bgColor=#ffffff>
						<table cellSpacing=0 cellPadding=3 width=165 align=center border=0>
							<tbody>
								<tr>
									<td class=mainMenu onClick="MenuDisplay('table_1');"><span
										class=span id=table_1Span>＋</span> 问答搜索管理</td>
								</tr>
								<tr>
									<td>
										<table id=table_1 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<tbody>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/qaSearch/listQaSearch"
														target=main>－ 问答搜索列表</a></td>
												</tr>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/qaSearch/toQaSearchIndex"
														target=main>－ 问答搜索测试</a></td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td
										background="<%=request.getContextPath() %>/assets/images/new_027.jpg"
										height=1></td>
								</tr>
								<tr>
									<td class=mainMenu onClick="MenuDisplay('table_2');"><span
										class=span id=table_2Span>＋</span> 问答管理</td>
								</tr>
								<tr>
									<td>
										<table id=table_2 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<tbody>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/qa/listQa"
														target=main>－ 问答列表</a></td>
												</tr>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/linkman/findAllLinkman.action"
														target=main>－ 问答图示</a></td>
												</tr>

											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td
										background="<%=request.getContextPath() %>/assets/images/new_027.jpg"
										height=1></td>
								</tr>
								<tr>
									<td class=mainMenu onClick="MenuDisplay('table_3');"><span
										class=span id=table_3Span>＋</span> 百科管理</td>
								</tr>
								<tr>
									<td>
										<table id=table_3 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<tbody>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/encyclopedia/listEncyclopedia"
														target=main>－百科列表</a></td>
												</tr>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/welcome.jsp"
														target=main>－百科图示</a></td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td
										background="<%=request.getContextPath() %>/assets/images/new_027.jpg"
										height=1></td>
								</tr>
								<tr>
									<td class=mainMenu onClick="MenuDisplay('table_4');"><span
										class=span id=table_4Span>＋</span> 知道管理</td>
								</tr>
								<tr>
									<td>
										<table id=table_4 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<tbody>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/bdzdQuestionAnswer/listBdzdQuestionAnswer"
														target=main>－知道列表</a></td>
												</tr>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/welcome.jsp"
														target=main>－知道图示</a></td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td
										background="<%=request.getContextPath() %>/assets/images/new_027.jpg"
										height=1></td>
								</tr>
								<tr>
									<td class=mainMenu onClick="MenuDisplay('table_5');"><span
										class=span id=table_5Span>＋</span> 疾病管理</td>
								</tr>
								<tr>
									<td>
										<table id=table_5 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<tbody>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/disease/listDisease"
														target=main>－疾病列表</a></td>
												</tr>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/welcome.jsp"
														target=main>－疾病统计</a></td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td
										background="<%=request.getContextPath() %>/assets/images/new_027.jpg"
										height=1></td>
								</tr>
								<tr>
									<td class=mainMenu onClick="MenuDisplay('table_6');"><span
										class=span id=table_6Span>＋</span> 症状管理</td>
								</tr>
								<tr>
									<td>
										<table id=table_6 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<tbody>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/symptom/listSymptom"
														target=main>－症状列表</a></td>
												</tr>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/welcome.jsp"
														target=main>－症状统计</a></td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td
										background="<%=request.getContextPath() %>/assets/images/new_027.jpg"
										height=1></td>
								</tr>
								<tr>
									<td class=mainMenu onClick="MenuDisplay('table_7');"><span
										class=span id=table_7Span>＋</span>部位器官管理</td>
								</tr>
								<tr>
									<td>
										<table id=table_7 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<tbody>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/part/listPart"
														target=main>－部位列表</a></td>
												</tr>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/organ/listOrgan"
														target=main>－器官列表</a></td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td
										background="<%=request.getContextPath() %>/assets/images/new_027.jpg"
										height=1></td>
								</tr>
								<tr>
									<td class=mainMenu onClick="MenuDisplay('table_8');"><span
										class=span id=table_8Span>＋</span>AI问答管理</td>
								</tr>
								<tr>
									<td>
										<table id=table_8 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<tbody>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/qaAi/listQaAi"
														target=main>－AI问答列表</a></td>
												</tr>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/welcome.jsp"
														target=main>－数据字典</a></td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td
										background="<%=request.getContextPath() %>/assets/images/new_027.jpg"
										height=1></td>
								</tr>
								<tr>
									<td class=mainMenu onClick="MenuDisplay('table_9');"><span
										class=span id=table_9Span>＋</span>用户管理</td>
								</tr>
								<tr>
									<td>
										<table id=table_9 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<tbody>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/user/listUser"
														target=main>－用户列表</a></td>
												</tr>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/welcome.jsp"
														target=main>－数据字典</a></td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td
										background="<%=request.getContextPath() %>/assets/images/new_027.jpg"
										height=1></td>
								</tr>
								<tr>
									<td class=mainMenu onClick="MenuDisplay('table_10');"><span
										class=span id=table_10Span>＋</span>文本管理</td>
								</tr>
								<tr>
									<td>
										<table id=table_10 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<tbody>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/text/listText"
														target=main>－文本列表</a></td>
												</tr>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/welcome.jsp"
														target=main>－数据字典</a></td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td
										background="<%=request.getContextPath() %>/assets/images/new_027.jpg"
										height=1></td>
								</tr>
								<tr>
									<td class=mainMenu onClick="MenuDisplay('table_11');"><span
										class=span id=table_11Span>＋</span>其他管理</td>
								</tr>
								<tr>
									<td>
										<table id=table_11 style="DISPLAY: none" cellSpacing=0
											cellPadding=2 width=155 align=center border=0>
											<tbody>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/text/listText"
														target=main>－其他列表</a></td>
												</tr>
												<tr>
													<td class=menuSmall><a class=style2
														href="${pageContext.request.contextPath}/welcome.jsp"
														target=main>－数据字典</a></td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
					<td width=15
						background="<%=request.getContextPath() %>/assets/images/new_009.jpg"></td>
				</tr>
			</tbody>
		</table>
		<!-- 菜单内容 尾 -->



		<!-- 菜单尾部 首 -->
		<table cellSpacing=0 cellPadding=0 width=210 align=center border=0>
			<tbody>
				<tr>
					<td width=15><img
						src="<%=request.getContextPath() %>/assets/images/new_010.jpg"
						border=0></td>
					<td align="center" width=180
						background="<%=request.getContextPath() %>/assets/images/new_011.jpg"
						height=15></td>
					<td width=15><img
						src="<%=request.getContextPath() %>/assets/images/new_012.jpg"
						border=0></td>
				</tr>
			</tbody>
		</table>
		<!-- 菜单尾部 尾 -->



	</form>

</body>
</html>
