<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>症状列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/assets/css/Style.css"
	type=text/css rel=stylesheet>
<link href="<%=request.getContextPath()%>/assets/css/Manage.css"
	type=text/css rel=stylesheet>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/assets/js/jquery-1.4.4.min.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/assets/js/WdatePicker.js"></script>

<script language=javascript>
	function to_page(pageIndex) {
		if (pageIndex) {
			$("#pageIndex").val(pageIndex);
		}
		document.symptomForm.submit();
	}
</script>
<meta content="MSHTML 6.00.2900.3492" name=GENERATOR>
</head>
<body>
	<form id="symptomForm" name="symptomForm"
		action="${pageContext.request.contextPath }/symptom/listSymptom"
		method=post>
		<table cellSpacing=0 cellPadding=0 width="98%" border=0>
			<tbody>
				<tr>
					<td width=15><IMG
						src="<%=request.getContextPath() %>/assets/images/new_019.jpg"
						border=0></TD>
					<td width="100%"
						background="<%=request.getContextPath() %>/assets/images/new_020.jpg"
						height=20></TD>
					<td width=15><IMG
						src="<%=request.getContextPath() %>/assets/images/new_021.jpg"
						border=0></TD>
				</tr>
			</tbody>
		</table>
		<table cellSpacing=0 cellPadding=0 width="98%" border=0>
			<tbody>
				<tr>
					<td width=15
						background="<%=request.getContextPath() %>/assets/images/new_022.jpg"><img
						src="<%=request.getContextPath() %>/assets/images/new_022.jpg"
						border=0></td>
					<td vAlign=top width="100%" bgColor=#ffffff>
						<table cellSpacing=0 cellPadding=5 width="100%" border=0>
							<tr>
								<td class=manageHead>当前位置：症状 &gt; 症状列表</td>
							</tr>
							<tr>
								<td height=2></td>
							</tr>
						</table>
						<table borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<tbody>
								<tr>
									<td height=25>
										<table cellSpacing=0 cellPadding=2 border=0>
											<tbody>
												<tr>
													<td>症状问题：</td>

													<td><div class="cell" style="width: 126px;">
															<input type="text" class="Wdate" id="d1" name="startTime"
																value="<%=request.getParameter("startTime") == null ? "" : request.getParameter("startTime")%>"
																onFocus="var d2=$dp.$('d2');WdatePicker({onpicked:function(){d2.focus();},maxDate:'#F{$dp.$D(\'d2\')}'})" />
														</div></td>
													<td>至</td>
													<td>
														<div class="cell" style="width: 126px;">
															<input type="text" class="Wdate" id="d2" name="endTime"
																value="<%=request.getParameter("endTime") == null ? "" : request.getParameter("endTime")%>"
																onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d1\')}'})" />
														</div>
													</td>
													<td><div class="cell"
															style="width: 200px; margin-left: 33px;">
															<input class="list_btn" value="筛选" type="submit" />
														</div></td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td><c:choose>
											<c:when test="${symptomList!=null }">
												<table id=grid
													style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
													cellSpacing=1 cellPadding=2 rules=all border=0>
													<tbody>
														<tr
															style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
															<td>症状名称</td>
														</tr>
														<c:forEach items="${symptomList }" var="symptom">
															<tr
																style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">

																<td><a
																	href="${pageContext.request.contextPath }/symptom/detailedSymptom?symptomId=${symptom.symptomId}">${symptom.symptomName }</a></td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</c:when>

											<c:otherwise>
												<a>数据为空！！</a>
											</c:otherwise>
										</c:choose></td>
								</tr>
								<tr>
									<td><span id=pagelink>
											<div
												style="line-height: 20px; height: 20px; text-align: right">
												共[<b>${pageModel.getRecordCount() }</b>]条记录,[<b>${pageModel.getTotalSize() }</b>]页
												,每页显示 <select name="pagesize">
													<option value="1"
														<c:if test="${pageModel.getPageSize()==1 }">selected</c:if>>1</option>
													<option value="30"
														<c:if test="${pageModel.getPageSize()==30 }">selected</c:if>>30</option>
												</select> 条 [<a
													href="javascript:to_page(${pageModel.getPageIndex() -1})">前一页</a>]
												<b>${pageModel.getPageIndex() }</b> [<a
													href="javascript:to_page(${pageModel.getPageIndex() +1})">后一页</a>]
												到 <input type="text" size="3" id="pageIndex"
													name="pageIndex" /> 页 <input type="button" value="go"
													onclick="to_page()" />
											</div>
									</span></td>
								</tr>
							</tbody>
						</table>
					</td>
					<td width=15
						background="<%=request.getContextPath() %>/assets/images/new_023.jpg"><img
						src="<%=request.getContextPath() %>/assets/images/new_023.jpg"
						border=0></td>
				</tr>
			</tbody>
		</table>
		<table cellSpacing=0 cellPadding=0 width="98%" border=0>
			<tbody>
				<tr>
					<td width=15><img
						src="<%=request.getContextPath() %>/assets/images/new_024.jpg"
						border=0></TD>
					<td align="center" width="100%"
						background="<%=request.getContextPath() %>/assets/images/new_025.jpg"
						height=15></td>
					<td width=15><img
						src="<%=request.getContextPath() %>/assets/images/new_026.jpg"
						border=0></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
