<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/8/27
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>接受邮件页面</title>
</head>
<body>


<table border="1px">
    <tr>
        <th>标题</th>
        <th>时间</th>
        <th>发送人</th>
    </tr>
    <c:forEach items="${list}" var="em">
        <tr>
            <th>${em.etitle}</th>
            <th><fmt:formatDate value="${em.edate}"  pattern="yyyy-MM-dd"/></th>
            <th>${em.us.uname}</th>
        </tr>

    </c:forEach>
</table>

<%--相对路径 相对于本身--当前浏览器所在路径地址--%>
<a href="../emailSend.jsp">发送邮件</a>

<%--根路径--%>
<a href="/4px_logistics/emailSend.jsp">发送邮件</a>

<%--绝对路径--%>
<a href="http://127.0.0.1:8080/4px_logistics/emailSend.jsp">发送邮件</a>



</body>
</html>
