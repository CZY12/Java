<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head lang="en">
<meta charset="UTF-8">
<title>登录</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet" href="AmazeUI-2.4.2/assets/css/amazeui.css" />
<link href="css/dlstyle.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function login(){
		document.getElementById("form").submit();
	}
</script>

</head>

<body>

<%
	Cookie[] cookies = request.getCookies();
	String user_name = "";
	String pwd = "";
	if (cookies!=null){
		for (Cookie s:
		cookies){
			if (s.getName().equals("user_name")){
				user_name = URLDecoder.decode(s.getValue(),"utf-8");
			}else if(s.getName().equals("pwd")){
				pwd = s.getValue();
			}
		}
		request.setAttribute("user_name",user_name);
		request.setAttribute("pwd",pwd);
	}
%>
<!-- 检查是否存在对应的cookie，有则登录到主页 -->
	<div class="login-boxtitle">
		<a href="index.jsp"><img alt="logo" src="images/indexlogo.png" /></a>
	</div>

	<div class="login-banner">
		<div class="login-main">
			<div class="login-banner-bg">
				<span></span><img src="images/big.jpg" />
			</div>
			<div class="login-box">

				<h3 class="title">登录商城</h3>

				<div class="clear"></div>

				<div class="login-form">
					<form action="UserServlet?action=login" method="post" id="form">
					<input type="hidden" name="remember" value="" id="remember">
						<div class="user-name">
							<label for="user"><i class="am-icon-user"></i></label> <input
								type="text" name="user_name" id="user" placeholder="请输入用户名" value="${user_name}">
						</div>
						<div class="user-pass">
							<label for="password"><i class="am-icon-lock"></i></label> <input
								type="password" name="pwd" id="password"
								placeholder="请输入密码" value="${pwd}">
						</div>
					</form>
				</div>

				<div class="login-links">
					<label for="remember_me">&nbsp;<input id="remember_me"
						type="checkbox" name="remember" value="1">&nbsp;记住密码
					</label> <a href="register.jsp" class="zcnext am-fr am-btn-default">注册</a>
					<br />
				</div>
				<div class="am-cf">
					<input type="submit" onclick="login();" value="登 录"
						class="am-btn am-btn-primary am-btn-sm">
				</div>


			</div>
		
		</div>
		
	</div>



	<div class="footer ">
		<div class="footer-hd ">
			<p>
				<a href="# ">恒望科技</a> <b>|</b> <a href="# ">商城首页</a> <b>|</b> <a
					href="# ">支付宝</a> <b>|</b> <a href="# ">物流</a>
			</p>
		</div>
		<div class="footer-bd ">
			<p>
				<a href="# ">关于恒望</a> <a href="# ">合作伙伴</a> <a href="# ">联系我们</a> <a
					href="# ">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有</em>
			</p>
		</div>
	</div>
</body>

</html>