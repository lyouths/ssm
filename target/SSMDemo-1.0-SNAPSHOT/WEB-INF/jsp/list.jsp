<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/23
  Time: 下午 02:26
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>${list}</td>
        <td>Book NAME</td>
        <td>BOOK Number</td>
    </tr>
    <c:forEach items="${list}" var="list">
        <tr>
            <td>${list.bookId}</td>
            <td>${list.name}</td>
            <td>${list.number}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
