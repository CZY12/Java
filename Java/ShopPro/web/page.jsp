<%--
  Created by IntelliJ IDEA.
  User: czy61
  Date: 2019/8/13
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link href="layui/css/layui.css" rel="stylesheet" media="all">
    <script src="layui/layui.js"></script>
</head>
<script>
    layui.use('laypage', function(){
        var laypage = layui.laypage;

        //执行一个laypage实例
        laypage.render({
            elem: 'page', //注意，这里的 test1 是 ID，不用加 # 号
            count: ${page.totalCount} ,//数据总数，从服务端得到
            limit: ${page.pageSize},//每页显示的条数
            limits:[1,2,3,4,5],//每页条数的选择项
            curr:${page.currentPage},//当前页
            groups:5,//连续出现页码个数
            layout:['count','prev','page','next','limit','refresh','skip'],
            jump: function(obj, first){
                //obj包含了当前分页的所有参数，比如：
                console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                console.log(obj.limit); //得到每页显示的条数

                //首次不执行
                if(!first){
                    //发送请求去查询当前页的数据
                    location.href='${page.url}&currentPage='+obj.curr+"&pageSize="+obj.limit;
                }
            }
        });
    });
</script>
<body>
<div id="page"></div>
</body>
</html>
