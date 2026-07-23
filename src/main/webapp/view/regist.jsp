<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="../css/style_index.css"/>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/js_reg.js"></script>
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
        <a href="/"> <img src="../img/login02.jpg"/></a>
    </figure>

    <section id="main-right">
        <!--表单域集合，作用是将form中的表单项包围起来，形成一个整体-->
        <fieldset>
            <legend>注&nbsp;册</legend>
            <span>REGISTER</span>
        </fieldset>

        <form action="/reg/action" method="post" id="myform">
            <div class="input-group">
                <input type="text" name="mp" id="mp" value="" placeholder="输入手机号码" required="true"/>
            </div>
            <div class="input-group">
                <input type="text" name="code" id="code" value="" placeholder="图形验证码" required="true"/>
                <img id="verifycode" src="/captcha"/>
            </div>
            <div class="input-group">
                <input type="text" name="code2" id="code2" value="" placeholder="验证码" required="true"/>
                <button>获取验证码</button>
            </div>
            <div class="input-group">
                <input type="password" name="pwd" id="pwd" value="" placeholder="密码" required="true"/>
            </div>
            <div class="input-group">
                <input type="password" name="repwd" id="repwd" value="" placeholder="确认密码" required="true"/>
            </div>

            <div class="input-group1">
                <span>选择性别：</span> <input type="radio" name="gender" value="1" checked>男
                <input type="radio" name="gender" value="0" >女
            </div>

            <div class="input-group read">
                <input type="checkbox" name="confirm" id="confirm" value="" required="true"/>我已经阅读并接受
                <a href="#">《用户注册协议》</a>
            </div>
            <div class="input-group">
                <a href="/login">已有账号？立刻登录</a>
                <button>注&nbsp;册</button>
            </div>
            <div>
                <div id="alert"></div>
            </div>
        </form>

    </section>

</section>


<!--/*main-left 部分=========================================*/-->

<!--/*main-right 部分=========================================*/-->
</body>

</html>