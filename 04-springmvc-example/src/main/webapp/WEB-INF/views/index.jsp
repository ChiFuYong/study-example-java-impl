<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
    <h4> XML 配置(需重新指定SpringMVC XML配置文件)</h4>
    <a href="${pageContext.request.contextPath}/test1">test1</a></br>
    <a href="${pageContext.request.contextPath}/test2">test2</a></br>
    <a href="${pageContext.request.contextPath}/test3">test3</a></br>
    <a href="${pageContext.request.contextPath}/test4">test4</a></br>
    <hr/>

    <h4> Annotation 配置（AnnotationController）</h4>
    <a href="${pageContext.request.contextPath}/annotation/index">/annotation/index ——> 跳转到主页 </a></br>
        Index：${message} </br>
    <a href="${pageContext.request.contextPath}/annotation/responsebody">/annotation/responsebody ——> 测试返回Map转json </a></br>
    <a href="${pageContext.request.contextPath}/annotation/forward">/annotation/forward ——> 请求转发 </a></br>
    <a href="${pageContext.request.contextPath}/annotation/redirect">/annotation/redirect ——> 重定向</a></br>
    <hr/>

    <h4> 参数传递表单页（ParamterController） </h4>
    <a href="${pageContext.request.contextPath}/parameter/formpage">/parameter/formpage ——> 跳至表单页 </a></br>
    <hr/>

    <h4> 作用域传值（ScopeController） </h4>
    <a href="${pageContext.request.contextPath}/scope/servlet">/scope/servlet ——> 原生Servlet </a></br>
    <hr/>

    <h4> 上传下载（FileUpLoadAndDownLoadController） </h4>
    <a href="${pageContext.request.contextPath}/file/fileload">/file/fileload -> 上传下载页面</a></br>
    <hr/>

    <h4> 拦截器（InterceptorController） </h4>
    <a href="${pageContext.request.contextPath}/interceptor/interceptor">/interceptor/interceptor -> 测试拦截器</a></br>
    <hr/>

</body>
</html>
