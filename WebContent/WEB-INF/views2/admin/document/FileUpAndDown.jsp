<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$("#form1").submit(function(){
           $.ajax({
        	 //几个参数需要注意一下
               type: "POST",//方法类型
               dataType: "json",//预期服务器返回的数据类型
               url: "/users/login" ,//url
               data: $('#form1').serialize(),
               success: function (result) {
                   console.log(result);//打印服务端返回的数据(调试用)
                   if (result.resultCode == 200) {
                       alert("SUCCESS");
                   }
                   ;
               },
               error : function() {
                   alert("异常！");
               }
          });


	function ajaxRequest() {
		 $.ajax({
	            //几个参数需要注意一下
	                type: "POST",//方法类型
	                dataType: "json",//预期服务器返回的数据类型
	                url: "/users/login" ,//url
	                data: $('#form1').serialize(),
	                success: function (result) {
	                    console.log(result);//打印服务端返回的数据(调试用)
	                    if (result.resultCode == 200) {
	                        alert("SUCCESS");
	                    }
	                    ;
	                },
	                error : function() {
	                    alert("异常！");
	                }
	            });

	}
</script>
<body>

	<form id="form1" onsubmit="return false" action="##" method="post">
		<p>
			文件名：<input type="file" name="file" id="file" tabindex="1" size="15"
				value="" />
		</p>
		<p>
			<input type="text" name="desc" id="desc" tabindex="2" size="16"
				value="" />
		</p>
		<p>
			<input type="button" value="开始转换" onclick="ajaxRequest()">&nbsp;<input
				type="reset" value="重置">
		</p>
	</form>


	<h3>${conversionFileName }</h3>
	<div id=""></div>

	<c:if test="${conversionFileName!=null }">
		<a href="#">前去下载</a>
	</c:if>

</body>
</html>