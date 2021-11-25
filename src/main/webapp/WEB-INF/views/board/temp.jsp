<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>MyBatis Test</title>
</head>
<body>
${viewAll }

    <c:forEach items="${viewAll }" var="list">
        <p>제목: ${list.title }</p>
        <p>작성자: ${list.writer }</p>
        <p>내용: ${list.content }</p>
        <hr>
    </c:forEach>
</body>
</html>