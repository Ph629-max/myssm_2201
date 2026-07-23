<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>通用管理</title>
    <meta name="description" content="通用管理">
    <meta name="keywords" content="通用管理">
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- 引入样式 -->
    <link rel="stylesheet" href="../js/el/lib/theme-chalk/index.css">
    <link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min(1).css">
    <link rel="stylesheet" href="../css/style_mgr.css">
    <style type="text/css">
        .el-main {
            position: absolute;
            top: 70px;
            bottom: 0px;
            left: 200px;
            right: 10px;
            padding: 0;
        }
    </style>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<div id="app">
    <el-container>
        <el-header class="main-header" style="height:70px;">
            <nav class="navbar navbar-static-top" :class=''>
                <!-- Logo -->
                <a href="#" class="logo" style="text-align:center">
                    <span class="logo-lg">后台管理系统</span>
                </a>
                <div class="right-menu">
                    <span class="help"><i class="fa fa-exclamation-circle" aria-hidden="true"></i>帮助</span>
                    <el-dropdown class="avatar-container right-menu-item" trigger="click">
                        <div class="avatar-wrapper">
                            <img src="../img/user2-160x160.jpg" class="user-avatar">
                            ${sessionScope.state}
                        </div>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item divided>
                                <span style="display:block;">修改密码</span>
                            </el-dropdown-item>
                            <el-dropdown-item divided>
                                <span style="display:block;"><el-link href="/mgr/logout">退出</el-link></span>
                            </el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </div>
            </nav>
        </el-header>
        <el-container>
            <el-aside width="200px">
                <!--菜单的遍历生成-->
                <el-menu>
                    <el-submenu v-for="(menu,index) in menuList" :index="menu.path" :key="index">
                        <template slot="title">
                            <i class="fa" :class="menu.icon"></i>
                            {{menu.title}}
                        </template>
                        <template v-for="child in menu.children">
                            <el-menu-item :index="child.path">
                                <a :href="child.linkUrl" target="right">{{child.title}}</a>
                            </el-menu-item>
                        </template>
                    </el-submenu>
                </el-menu>
            </el-aside>
            <el-container>
                <iframe name="right" class="el-main" src="/mgr/userlist" width="100%" height="580px"
                        frameborder="0"></iframe>
            </el-container>
        </el-container>
    </el-container>
</div>
</body>
<!-- 引入组件库 -->
<script src="../js/vue.js"></script>
<script src="../js/axios.js"></script>
<script src="../js/el/lib/index.js"></script>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script>
    new Vue({
        el: '#app',
        data: {
            //菜单的集合
            menuList: [
               {
                    "path": "1",
                    "title": "员工信息管理",
                    "icon": "el-icon-setting",
                    "children": [
                        {
                            "path": "/1-1",
                            "title": "员工列表",
                            "linkUrl": "/mgr/userlist",
                            "children": []
                        },
                        {
                            "path": "/1-2",
                            "title": "子菜单12",
                            "linkUrl": "/mgr/userlist",
                            "children": []
                        }
                    ]
                },
                {
                    "path": "2",
                    "title": "部门信息管理",
                    "icon": "el-icon-setting",
                    "children": [
                        {
                            "path": "/2-1",
                            "title": "部门列表",
                            "linkUrl": "/mgr/userlist",
                            "children": []
                        },
                        {
                            "path": "/2-2",
                            "title": "子菜单2",
                            "linkUrl": "/mgr/userlist",
                            "children": []
                        }, {
                            "path": "/2-3",
                            "title": "任务计划",
                            "linkUrl": "/mgr/userlist",
                            "children": []
                        }
                    ]
                },
              

            ]
        },
      
    });
    $(function () {
        var wd = 200;
        $(".el-main").css('width', $('body').width() - wd + 'px');
    });
</script>
</html>
