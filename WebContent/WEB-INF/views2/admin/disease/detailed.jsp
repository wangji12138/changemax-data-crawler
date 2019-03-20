<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:choose>
		<c:when test="${disease!=null }">${disease.question }_changeMax疾病</c:when>
		<c:otherwise>数据为空 </c:otherwise>
	</c:choose></title>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/assets/js/jquery-1.4.4.min.js"></script>
</head>
<body>
	<table cellSpacing=0 cellPadding=0 width="98%" border=0>
		<tbody>
			<tr>
				<td width=15><IMG
					src="<%=request.getContextPath()%>/assets/images/new_019.jpg"
					border=0></TD>
				<td width="100%"
					background="<%=request.getContextPath()%>/assets/images/new_020.jpg"
					height=20></TD>
				<td width=15><IMG
					src="<%=request.getContextPath()%>/assets/images/new_021.jpg"
					border=0></TD>
			</tr>
		</tbody>
	</table>
	<table cellSpacing=0 cellPadding=0 width="98%" border=0>
		<tbody>
			<tr>
				<td width=15
					background="<%=request.getContextPath()%>/assets/images/new_022.jpg"><img
					src="<%=request.getContextPath()%>/assets/images/new_022.jpg"
					border=0></td>
				<td vAlign=top width="100%" bgColor=#ffffff>
					<table cellSpacing=0 cellPadding=5 width="100%" border=0>
						<tr>
							<td class=manageHead>当前位置：疾病 &gt; 疾病详细</td>
						</tr>
						<tr>
							<td height=2></td>
						</tr>
					</table>
					<table borderColor=#cccccc cellSpacing=0 cellPadding=0 width="100%"
						align=center border=0>
						<tbody>
							<tr>
								<td><c:choose>
										<c:when test="${disease!=null }">
											<table id=grid
												style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
												cellSpacing=1 cellPadding=2 rules=all border=0>
												<tbody>
													<tr
														style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
														<td>${disease.diseaseName }</td>
														<td>${disease.diseaseIntro }</td>
													</tr>
												</tbody>
											</table>
										</c:when>

										<c:otherwise>
											<a>数据为空！！</a>
										</c:otherwise>
									</c:choose></td>
							</tr>
						</tbody>
					</table>
				</td>
				<td width=15
					background="<%=request.getContextPath()%>/assets/images/new_023.jpg"><img
					src="<%=request.getContextPath()%>/assets/images/new_023.jpg"
					border=0></td>
			</tr>
		</tbody>
	</table>
	<table cellSpacing=0 cellPadding=0 width="98%" border=0>
		<tbody>
			<tr>
				<td width=15><img
					src="<%=request.getContextPath()%>/assets/images/new_024.jpg"
					border=0></TD>
				<td align="center" width="100%"
					background="<%=request.getContextPath()%>/assets/images/new_025.jpg"
					height=15></td>
				<td width=15><img
					src="<%=request.getContextPath()%>/assets/images/new_026.jpg"
					border=0></td>
			</tr>
		</tbody>
	</table>

</body>
</html>