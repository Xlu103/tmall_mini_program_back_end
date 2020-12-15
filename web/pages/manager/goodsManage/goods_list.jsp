<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
    <!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
    <meta name="renderer" content="webkit">
    <!--国产浏览器高速模式-->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- 定义页面的最新版本 -->
    <meta name="description" content="网站简介"/>
    <!-- 网站简介 -->
    <meta name="keywords" content="搜索关键字，以半角英文逗号隔开"/>
    <title>商城后台</title>

    <!-- 公共样式 开始 -->

    <script type="text/javascript" src="../../../static/js/framework/jquery-1.11.3.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../../../static/js/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="../../../static/css/base.css">
    <link rel="stylesheet" type="text/css" href="../../../static/css/iconfont.css">


    <script type="text/javascript" src="../../../static/js/layui/layui.js"></script>
    <!-- 滚动条插件 -->
    <link rel="stylesheet" type="text/css" href="../../../static/css/jquery.mCustomScrollbar.css">
    <script src="../../../static/js/framework/jquery-ui-1.10.4.min.js"></script>
    <script src="../../../static/js/framework/jquery.mousewheel.min.js"></script>
    <script src="../../../static/js/framework/jquery.mCustomScrollbar.min.js"></script>
    <script src="../../../static/js/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
    <!-- 公共样式 结束 -->

    <style>
        .layui-table img {
            max-width: none;
        }
    </style>

</head>

<body>
<div class="cBody">
    <div class="console">
        <form class="layui-form" action="">
            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <input type="text" name="name" required lay-verify="required" placeholder="输入商品名称" autocomplete="off"
                           class="layui-input">
                </div>

                <button class="layui-btn" lay-submit lay-filter="formDemo">检索</button>

            </div>
        </form>

        <script>
            layui.use('form', function () {
                var form = layui.form;
                //监听提交
                form.on('submit(formDemo)', function (data) {
                    layer.msg(JSON.stringify(data.field));
                    return false;
                });
            });
        </script>
    </div>

    <table class="layui-table">
        <thead>
        <tr>
            <th>商品名称</th>
            <th>商品图片</th>
            <th>商品详细</th>
            <th>商品价格</th>
            <th>商品库存</th>
            <th>商品销量</th>

            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sessionScope.page.items}" var="item">

            <form action="${pageContext.request.contextPath}/manager/selectProduceById">
                <input type="hidden" name="produceId" value="${item.id}">
                <tr>
                    <td>${item.title}</td>
                    <td><img src="${item.img}" width="20" height="20" onmouseenter="imgBig(this)"
                             onmouseleave="imgSmall(this)"/></td>
                    <td>${item.detail}</td>
                    <td>${item.price}</td>
                    <td>${item.stock}</td>
                    <td>${item.sales}</td>
                    <td>
                        <button class="layui-btn  " type="submit">修改</button>
                    </td>
                </tr>
            </form>
        </c:forEach>
        </tbody>
    </table>

    <form action="${pageContext.request.contextPath}/manager/selectPage" id="selectPageForm">
        <input type="hidden" name="pageNo" id="pageNo">
        <input type="hidden" name="pageSize" id="pageSize">
    </form>


    <!-- layUI 分页模块 -->
    <div id="pages"></div>
    <script>
        layui.use('laypage', function () {
            var laypage = layui.laypage;
            //总页数大于页码总数
            laypage.render({
                elem: 'pages'
                , layout: ['count', 'first', 'prev', 'page', 'next', 'last', 'limit', 'skip']
                , count: ${page.pageTotalCount}
                , limit:${page.pageSize}
                , limits: [5, 10, 15, 20]
                , curr:${page.pageNo}
                , jump: function (obj, first) {
                    let pageNo = obj.curr;
                    let pageSize = obj.limit;
                    if (!first) {
                        $("#pageNo").val(pageNo);
                        $("#pageSize").val(pageSize);
                        $("#selectPageForm")[0].submit();
                    }

                }
            });
        });


    /*    //修改按钮
        var updateFrame = null;

        function updateBut() {
            // 本来这里是弹出一个框，现在变成跳转了
            /!*   layui.use('layer', function () {
                   var layer = layui.layer;
                   //iframe层-父子操作
                   updateFrame = layer.open({
                       title: "商品信息修改",
                       type: 2,
                       area: ['70%', '60%'],
                       scrollbar: false,	//默认：true,默认允许浏览器滚动，如果设定scrollbar: false，则屏蔽
                       maxmin: true,
                       content: 'goods_update.jsp'
                   });
               });*!/


        }*/
    </script>
</div>
</body>

</html>