<%--
  Created by IntelliJ IDEA.
  User: leowj
  Date: 2020/7/2
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>test</title>
</head>
<body>
<form action="/4px_logistics/UserController/add" method="post" enctype="multipart/form-data">

    <p>
        uname：<input type="text" name="uname"/>${msg}

    </p>

    <p>
        telephone：<input type="text" name="telephone"/>

    </p>

    <p>
        photo：<input type="file" name="fi"/>

    </p>

    <p>
        mail：<input type="text" name="mail"/>

    </p>
    <p>
        gender：<input type="text" name="gender"/>

    </p>
    <p>
        birthday：<input type="text" name="birthday"/>

    </p>
    <p>
        currentbalance：<input type="text" name="currentbalance"/>

    </p>
    <p>
        rebate：<input type="text" name="rebate"/>

    </p>
    <p>
        pwd：<input type="text" name="pwd"/>

    </p>
    <p>
        <input type="submit" value="发送"/>

    </p>



</form>
</body>
</html>
