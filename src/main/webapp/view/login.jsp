<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>用户登录</title>
		<link rel="stylesheet" type="text/css" href="../css/style_index.css"/>
		<script type="text/javascript" src="../js/jquery.js"></script>
	</head>
	<script type="text/javascript">
		$().ready(function () {
			//点击验证码，刷新验证码
			$("#verifycode").click(function () {
				$("#verifycode").attr("src", "/captcha?t=" + new Date().getTime());
			});
		});
	</script>
	<body>
		<!--/*header部分=========================================*/-->
		<header>
			<h1></h1>
		</header>
		<!--/*main部分=========================================*/-->
		<section id="main">
			<figure id="main-left">
				<a href="/"><img src="../img/logintupin.jpg"  /></a>
			</figure>
			
			<section id="main-right">
				<!--表单域集合，作用是将form中的表单项包围起来，形成一个整体-->
				<fieldset>
					<legend>登&nbsp;录</legend>
					<span>LOGIN</span>
				</fieldset>

				<form action="/login/action" method="post" id="myform">
					<div class="input-group">
						<input type="text" name="mp" id="mp" value="" placeholder="输入注册账号（手机号码）" required="true"/>
					</div>
					<div class="input-group">
						<input type="password" name="pwd" id="pwd" value="" placeholder="输入密码"  required="true"/>
					</div>
					<div class="input-group">
						<input type="text" name="code" id="code" value="" placeholder="输入验证码"  required="true"/>
						<img id="verifycode" src="/captcha"/>
					</div>
					<div class="input-group">
						<a href="/regist">没有有账号？立刻注册</a>
						<button>登&nbsp;录</button>
					</div>
				</form>
			</section>
			
		</section>




		<!--/*main-left 部分=========================================*/-->

		<!--/*main-right 部分=========================================*/-->
	</body>

</html>