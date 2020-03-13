<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Interceptor拦截器</title>
</head>
<body>

    <h1>Interceptor拦截器</h1>
    <h3>原内容： ${requestScope.get("origin")} </h3>
    <h3>过滤后： ${requestScope.get("text")} </h3>

</body>
</html>
