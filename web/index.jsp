<%--
  Created by IntelliJ IDEA.
  User: xlu
  Date: 2020/9/22
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<br>
<h1>这是小程序天猫商城后端</h1>
<hr>
<br>

<form action="user/addWxUser" method="post">
    <input type="text" name="username">
    <br>
    <input type="text" name="openid">
    <br>
    <input type="submit" value="注册">

</form>
<hr>
<br><br>
<a href="pages/login/login.jsp" style="font-size: 30px">登录界面</a>
<br>
<hr>
<h1>测试文件上传</h1>
<form action="manager/addProduceImage" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="file"/><br/>
    <input type="submit" value="上传"/>
</form>

<hr>
</body>
</html>
