<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="css/backstyle.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
    <link href="js/uploadify/uploadifive.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="js/uploadify/jquery.uploadifive.js"></script>
    <script type="text/javascript">
        $(function () {
            var bigType = $("#bigType");
            var smallType = $("#smallType");
            bigType.change(function () {
                $.post("back/GoodsTypeServlet?action=querySmallTypeByBigType", {"id": $("#bigType").val()}, function (data) {
                    var str;
                    var array = eval(data);
                    for (var i = 0; i < array.length; i++) {
						str += "<option value="+array[i].id+">"+array[i].gtype_name+"</option>";
                    }
                    smallType.html(str);
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

    <div class="formtitle"><span>添加商品信息</span></div>
    <form action="back/GoodsInfoServlet?action=add" method="post">
        <ul class="forminfo">
            <li><label>商品名称</label><input name="goods_name" type="text" class="dfinput"/><i>标题不能超过30个字符</i></li>
            <li><label>所属大类</label>
                <select name="goods_parentid" id="bigType">
                    <option value="null">请选择</option>
                    <c:forEach var="good" items="${gList}">
                        <c:if test="${good.gtype_parentid eq '0'}">
                            <option value="${good.id}">${good.gtype_name}</option>
                        </c:if>
                    </c:forEach>
                </select>

            </li>
            <li><label>所属小类</label>
                <select name="goods_fatherid" id="smallType">
                    <option value="null">请选择</option>

                </select>
            </li>
            <li>
                <label>商品图片</label>
                <input name="file_upload" id="file_upload"/>
                <img src="" alt="" id="img"/>
                <input type="text" name="goods_pic" id="goods_pic"/>
            </li>
            <li><label>商品价格</label><input name="goods_price" type="text" class="dfinput"/></li>
            <li><label>商品折扣</label><input name="goods_discount" type="text" class="dfinput"/>折</li>
            <li><label>商品优惠价</label><input name="goods_price_off" type="text" class="dfinput"/></li>
            <li><label>商品描述</label><textarea rows="8" cols="40" name="goods_description"></textarea></li>
            <li><label>商品库存</label><input name="goods_stock" type="text" class="dfinput"/></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
        </ul>

    </form>
</div>
<div style="display:none">
    <script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script>
</div>
</body>
</html>

