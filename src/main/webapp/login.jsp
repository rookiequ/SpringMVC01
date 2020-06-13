<%--
  Created by IntelliJ IDEA.
  User: Zhouziqin
  Date: 2020/6/13
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>传参案例</h2>
    <a href="user/login01?username=zs&password=123">传参案例</a><br>

    <form action="user/login02" method="post">
        姓名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        金额：<input type="text" name="money"><br>
        <input type="submit" value="提交">
    </form>

    <form action="user/login03" method="post">
        账号名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        金额：<input type="text" name="money"><br>
        用户姓名：<input type="text" name="user.username"><br>
        用户年龄：<input type="text" name="user.age"><br>
        <input type="submit" value="提交">
    </form>

    <form action="user/login04" method="post">
        账号名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        金额：<input type="text" name="money"><br>
        用户姓名：<input type="text" name="userList[0].username"><br>
        用户年龄：<input type="text" name="userList[0].age"><br>
        用户姓名：<input type="text" name="userList[1].username"><br>
        用户年龄：<input type="text" name="userList[1].age"><br>
        用户姓名：<input type="text" name="userMap['one'].username"><br>
        用户年龄：<input type="text" name="userMap['one'].age"><br>
        用户姓名：<input type="text" name="userMap['two'].username"><br>
        用户年龄：<input type="text" name="userMap['two'].age"><br>
        <input type="submit" value="提交">
    </form>

    <form action="user/login05" method="post">
        姓名：<input type="text" name="name"><br>
        生日：<input type="text" name="date"><br>
        <input type="submit" value="提交">
    </form>

    <form action="user/httpServlet" method="post">
        姓名：<input type="text" name="name"><br>
        生日：<input type="text" name="date"><br>
        <input type="submit" value="提交">
    </form>

    <a href="user/testPut">session存入</a><br>
    <a href="user/testGet">session取出</a><br>
    <a href="user/testClean">session清除</a><br>
</body>
</html>
