<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
	String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/backstyle.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
	<link href="js/uploadify/uploadifive.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript" src="js/uploadify/jquery.uploadifive.js"></script>
	<script type="text/javascript">
		$(function () {
			$("#bigType").change(function () {
				$.ajax({
					type:"get",
					url:"back/GoodsTypeServlet?action=querySmallTypeByBigType",
					data:"id="+$(this).val(),
					success:function (data) {
						var str ="<option value='0'>无</option>";
						var array = eval(data);
						for (var i = 0 ; i < array.length;i++){
							str += "<option value="+array[i].id+">"+array[i].gtype_name+"</option>"
						}
						$("#smallType").html(str);
					}
				})
			})
		});
		$(function () {
			$('#file_upload').uploadifive({
				'uploadScript' : 'ImageServlet?action=upload',
				'onUploadComplete' : function(file, data) {
					var imagesPath = "images/"+data;
					$("#img").attr("src",imagesPath);
					//给goods_pic的输入框赋值
					$("#goods_pic").val(data);
				}
			});
		})
	</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>修改商品信息</span></div>
    <form action="back/GoodsInfoServlet?action=update&id=${good.id}" method="post" >
    	<input type="hidden" name="id" value="${good.id}"/>
    	<ul class="forminfo">
	    <li><label>商品名称</label><input name="goods_name" value="${good.goods_name}"  type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
	    <li><label>所属大类</label>
	    		<select name="goods_parentid" id="bigType">
	    			<option value="0">无</option>
	    			<c:forEach items="${goodTypeList}" var="big">
						<c:if test="${big.gtype_parentid eq 0}">
							<option value="${big.id}">${big.gtype_name}</option>
						</c:if>
					</c:forEach>
	    		</select>
	    		
	    </i></li>
	    <li><label>所属小类</label>
	    	<select name="goods_fatherid" id="smallType">
	    		<option value="0">无</option>
	    		
	    	</select>
	    </i></li>
	    <li><label>商品价格</label><input name="goods_price" type="text" class="dfinput" value="${good.goods_price}"/><i>标题不能超过30个字符</i></li>
	    <li>
			<label>商品图片</label>
			<input name="file_upload" id="file_upload"/>
			<img src="images/${good.goods_pic}" alt="" id="img"/>
			<input type="text" name="goods_pic" id="goods_pic" value="${good.goods_pic}"/>
		</li>
	    <li><label>商品描述</label><textarea rows="8" cols="40" name="goods_description" >${good.goods_description}</textarea><i>标题不能超过30个字符</i></li>
	    <li><label>商品库存</label><input name="goods_stock" type="text" class="dfinput" value="${good.goods_stock}" /><i>标题不能超过30个字符</i></li>
	    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    
    </form>
    </div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

