<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
    <!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
    <meta name="renderer" content="webkit">
    <!--国产浏览器高速模式-->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- 网站简介 -->
    <meta name="keywords" content="搜索关键字，以半角英文逗号隔开"/>
    <title>商城后台</title>

    <!-- 公共样式 开始 -->
    <script type="text/javascript" src="../../static/js/framework/jquery-1.11.3.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../../static/js/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="../../static/css/base.css">
    <link rel="stylesheet" type="text/css" href="../../static/css/iconfont.css">

    <!--[if lt IE 9]>
    <script src="../../static/js/framework/html5shiv.min.js"></script>
    <script src="../../static/js/framework/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="../../static/js/layui/layui.js"></script>
    <!-- 滚动条插件 -->
    <link rel="stylesheet" type="text/css" href="../../static/css/jquery.mCustomScrollbar.css">
    <script src="../../static/js/framework/jquery-ui-1.10.4.min.js"></script>
    <script src="../../static/js/framework/jquery.mousewheel.min.js"></script>
    <script src="../../static/js/framework/jquery.mCustomScrollbar.min.js"></script>
    <script src="../../static/js/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
    <!-- 公共样式 结束 -->

    <link rel="stylesheet" type="text/css" href="../../static/css/frameStyle.css">
    <script type="text/javascript" src="../..//static/js/framework/frame.js"></script>

</head>

<body>
<!-- 左侧菜单 - 开始 -->
<div class="frameMenu">
    <div class="logo">

        <div class="logoText">
            <h1>商城后台管理</h1>
            <p>tmallmanager</p>
        </div>
    </div>
    <div class="menu">
        <ul>

            <li>
                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-shangpin left"></i>商品管理<i
                        class="iconfont icon-dajiantouyou right"></i></a>
                <dl>

                    <dt><a href="javascript:void(0)"
                           onclick="menuCAClick('${pageContext.request.contextPath}/pages/manager/goodsManage/goods_list.jsp',this)">基本商品库</a>
                    </dt>
                    <dt><a href="javascript:void(0)"
                           onclick="menuCAClick('${pageContext.request.contextPath}/pages/manager/goodsManage/goods_add.jsp',this)">添加商品</a>
                    </dt>
                </dl>
            </li>

        </ul>
    </div>
</div>
<!-- 左侧菜单 - 结束 -->

<div class="main">
    <!-- 头部栏 - 开始 -->
    <div class="frameTop">
        <div class="topMenu">
            <ul>
                <li><a href="javascript:void(0)" onclick="menuCAClick('tgls/modify_password.html',this)"><i
                        class="iconfont icon-yonghu1"></i>管理员</a></li>

                <li><a href="../login/login.jsp"><i class="iconfont icon-084tuichu"></i>注销</a></li>
            </ul>
        </div>
    </div>
    <!-- 头部栏 - 结束 -->

    <!-- 核心区域 - 开始 -->
    <div class="frameMain">
        <div class="title" id="frameMainTitle">
            <span><i class="iconfont icon-xianshiqi"></i>后台首页</span>
        </div>
        <div class="con">
            <iframe id="mainIframe" src="${pageContext.request.contextPath}/pages/manager/goodsManage/goods_list.jsp"
                    scrolling="no"></iframe>
        </div>
    </div>
    <!-- 核心区域 - 结束 -->
</div>
</body>

</html>