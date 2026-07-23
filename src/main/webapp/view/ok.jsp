<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>大数据连接</title>
    <link rel="stylesheet" type="text/css" href="../css/style_index.css"/>
</head>
<body>
<!--/*header部分=========================================*/-->
<header>
    <h1></h1>
</header>
<!--/*main部分=========================================*/-->
<section id="main">
    <figure id="main-left">
        <a href="/"><img src="../img/ok_ok.jpg"/></a>
    </figure>

    <section id="main-right">
        <!--表单域集合，作用是将form中的表单项包围起来，形成一个整体-->
        <fieldset>
            <legend>恭&nbsp;喜</legend>
            <span>CONGRATULATION</span>
        </fieldset>

        <form action="#" method="post">
            <div id="alert">
                <a href="#">${requestScope.alert}</a><br/>
                <a href="#">手机号：${requestScope.mp} </a><br/>
                <a href="#">密码：${requestScope.pwd} </a><br/>
                <a href="#">${sessionScope.state} </a>
            </div>
        </form>
    </section>

</section>


<!--/*main-left 部分=========================================*/-->

<!--/*main-right 部分=========================================*/-->
</body>

</html>