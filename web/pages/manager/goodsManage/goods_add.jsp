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
    <script type="text/javascript" src="../../../static/js/layui/layui.js"></script>
    <link rel="stylesheet" type="text/css" href="../../../static/css/base.css">
    <link rel="stylesheet" type="text/css" href="../../../static/css/iconfont.css">

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

        .layui-form {
            margin-right: 30%;
        }
    </style>

</head>

<body>
<div class="cBody">
    <form id="addForm" class="layui-form" action="${pageContext.request.contextPath}/manager/addProduceDetail" method="post"
          enctype="multipart/form-data">

        <input type="hidden" name="fileName" id="fileName">
        <div class="layui-form-item">
            <label class="layui-form-label">商品名称</label>
            <div class="layui-input-block">
                <input type="text" name="title" required lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">商品图片</label>
            <div class="layui-upload-drag" id="img">
                <i class="layui-icon" id="y-icon"></i>
                <img class="layui-upload-img" id="my-img">
                <p id="y-info">点击上传，或将文件拖拽到此处</p>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">商品价格</label>
            <div class="layui-input-block">
                <input type="text" name="price" required lay-verify="required|number" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商品库存</label>
            <div class="layui-input-block">
                <input type="text" name="stock" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-block">
                <textarea name="detail" class="layui-textarea"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="submitBut">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>


    <script>

        layui.use(['upload', 'form'], function () {

            var $ = layui.jquery, upload = layui.upload;

            //普通图片上传
            var uploadInst = upload.render({
                elem: '#img'
                , url: '${pageContext.request.contextPath}/manager/addProduceImage' //改成您自己的上传接口
                , before: function (obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result) {
                        $('#my-img').attr('src', result); //图片链接（base64）
                        $('#my-img').css('height', "200px");
                        $('#my-img').css('width', "200px");
                        $("#y-icon").css("display", "none");
                        $("#y-info").css("display", "none");
                    });
                }
                , done: function (res) {
                    console.log(res);
                    //如果上传失败
                    if (res.code > 0) {
                        return layer.msg('上传失败');
                    } else {
                        //上传成功
                        $("#fileName").val(res.fileName);
                    }

                }

            })
        })
    </script>


</div>
</body>

</html>