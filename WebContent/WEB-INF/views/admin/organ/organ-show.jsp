<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/assets/rear/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/assets/rear/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/assets/rear/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/assets/rear/skin/default/skin.css"
	id="skin" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/assets/rear/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>人体器官信息</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		人体器官管理 <span class="c-gray en">&gt;</span> 人体器官列表<span
			class="c-gray en">&gt;</span> ${organ.organName } <a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="text-c">
			<button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button>
			<span class="select-box inline"> <select name=""
				class="select">
					<option value="0">全部分类</option>
					<option value="1">分类一</option>
					<option value="2">分类二</option>
			</select>
			</span> 人体器官名称：${organ.organName }
		</div>
		<div>简介：略</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<a class="btn btn-success" href="">显示所包含疾病集</a> <a
				class="btn btn-success" href="">显示所包含症状集</a>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"><a href="javascript:;" onclick="datadel()"
				class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
					批量删除</a> <a class="btn btn-primary radius" data-title="添加人体器官器官"
				data-href="article-add.html" onclick="Hui_admin_tab(this)"
				href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加疾病</a><a
				class="btn btn-primary radius" data-title="添加人体器官器官"
				data-href="article-add.html" onclick="Hui_admin_tab(this)"
				href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加症状</a></span> <span
				class="r">共包含：<strong>${organ.diseaseList.size() }</strong>
				疾病，共包含：<strong>${organ.symptomList.size() }</strong> 症状
			</span>
		</div>
		<div class="mt-20">

			<c:choose>
				<c:when test="${organ.diseaseList!=null }">
					<table
						class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
						<thead>
							<tr class="text-c">
								<th width="25"><input type="checkbox" name="" value=""></th>
								<th width="40">序号</th>
								<th width="250">疾病ID</th>
								<th>疾病名称</th>
								<th width="120">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${organ.diseaseList }" var="disease"
								varStatus="status">
								<tr class="text-c">
									<td><input type="checkbox" value="" name=""></td>
									<td>${status.index + 1}</td>
									<td>${disease.diseaseId }</td>
									<td><a style="cursor: pointer" class="text-primary"
										href="${pageContext.request.contextPath }/disease/showDisease?diseaseId=${disease.diseaseId }">${disease.diseaseName }</a></td>
									<td class="f-14 td-manage"><a
										style="text-decoration: none"
										onClick="article_shenhe(this,'10001')" href="javascript:;"
										title="审核">审核</a> <a style="text-decoration: none"
										class="ml-5"
										onClick="article_edit('人体器官器官编辑','article-add.html','10001')"
										href="${pageContext.request.contextPath }/#" title="编辑"><i
											class="Hui-iconfont">&#xe6df;</i></a> <a
										style="text-decoration: none" class="ml-5"
										onClick="article_del(this,'10001')" href="javascript:;"
										title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:when test="${organ.symptomList!=null }">
					<table
						class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
						<thead>
							<tr class="text-c">
								<th width="25"><input type="checkbox" name="" value=""></th>
								<th width="40">序号</th>
								<th width="250">症状ID</th>
								<th>症状名称</th>
								<th width="120">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${organ.symptomList }" var="symptom"
								varStatus="status">
								<tr class="text-c">
									<td><input type="checkbox" value="" name=""></td>
									<td>${status.index + 1}</td>
									<td>${symptom.symptomId }</td>
									<td><a style="cursor: pointer" class="text-primary"
										href="${pageContext.request.contextPath }/symptom/showSymptom?symptomId=${symptom.symptomId }">${symptom.symptomName }</a></td>
									<td class="f-14 td-manage"><a
										style="text-decoration: none"
										onClick="article_shenhe(this,'10001')" href="javascript:;"
										title="审核">审核</a> <a style="text-decoration: none"
										class="ml-5"
										onClick="article_edit('人体器官器官编辑','article-add.html','10001')"
										href="${pageContext.request.contextPath }/#" title="编辑"><i
											class="Hui-iconfont">&#xe6df;</i></a> <a
										style="text-decoration: none" class="ml-5"
										onClick="article_del(this,'10001')" href="javascript:;"
										title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<h3>数据为空。</h3>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/assets/rear/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/assets/rear/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/assets/rear/js/H-ui.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/assets/rear/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/assets/rear/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/assets/rear/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/assets/rear/lib/laypage/1.2/laypage.js"></script>
</body>
</html>