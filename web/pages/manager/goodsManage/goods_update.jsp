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
    <title></title>

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
        .layui-form-label {
            width: 100px;
        }

        .layui-input-block {
            margin-left: 130px;
        }
    </style>

</head>

<body>
<div class="cBody" id="update-div">
    <form id="addForm" class="layui-form" action="${pageContext.request.contextPath}/manager/updateProduce">

        <input type="hidden" name="id" value="${sessionScope.produce.id}">

        <div class="layui-form-item">
            <label class="layui-form-label">商品名称</label>
            <div class="layui-input-block">
                <input type="text" name="title" value="${sessionScope.produce.title}" required lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商品图片</label>
            <div class="layui-upload-drag" id="goodsPic">
                <%--<i class="layui-icon" id="y-icon"></i>--%>
                <img class="layui-upload-img" id="my-img" src="${sessionScope.produce.img}"
                     style="width: 150px;height:150px;">
                <%--<p id="y-info">点击上传，或将文件拖拽到此处</p>--%>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">商品价格</label>
            <div class="layui-input-block">
                <input type="text" name="price" value="${sessionScope.produce.price}" required lay-verify="required|number"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商品库存</label>
            <div class="layui-input-block">
                <input type="text" name="stock" value="${sessionScope.produce.stock}" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-block">
                <textarea name="detail" class="layui-textarea">${sessionScope.produce.detail}</textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="submitBut">立即提交</button>
                <button class="layui-btn layui-btn-primary" onclick="clickCancel()">取消</button>
            </div>
        </div>

    </form>

    <form action="${pageContext.request.contextPath}/manager/cancelUpdateProduce" id="cancelForm"></form>
    <script>
        function clickCancel() {
            <%--window.location.href = "${pageContext.request.contextPath}/pages/manager/goodsManager/goods_list.jsp";--%>
            // window.location.reload();

            $("#cancelForm")[0].submit();

        }
    </script>

    <script>
        layui.use(['upload', 'form'], function () {
            var form = layui.form;
            var upload = layui.upload;
            var layer = layui.layer;
            //监听提交
            //解决了layui.open弹窗从内部关闭这个弹窗的问题
            form.on('submit(submitBut)', function (data) {
                var updateFrame = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(updateFrame);  //再改变当前层的标题
            });
            form.verify({
                //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
                ZHCheck: [
                    /^[\u0391-\uFFE5]+$/
                    , '只允许输入中文'
                ]
            });
            //拖拽上传
            upload.render({
                elem: '#goodsPic',
                url: '/upload/',
                done: function (res) {
                    console.log(res)
                }
            });

        });

        $(function () {
            setTimeout(function () {
                $("#update-div").css("height", "100%");
            }, 1000);
        })
    </script>

</div>
</body>

</html>