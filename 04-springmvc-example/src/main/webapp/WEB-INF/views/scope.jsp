<%--@elvariable id="page" type=""--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Scope主页</title>
</head>
<br>
    <h1> Scope主页 </h1>

    <hr/>
    <a href="${pageContext.request.contextPath}/scope/servlet">/scope/servlet</a></br>
    Page: 无 </br>
    Request: ${requestScope.get("request")}</br>
    Session: ${sessionScope.get("session")}</br>
    Application: ${applicationScope.get("application")}</br>

    <hr/>
    <a href="${pageContext.request.contextPath}/scope/map">/scope/map</a></br>
    Map：${requestScope.get("map")}</br>

    <hr/>
    <a href="${pageContext.request.contextPath}/scope/model">/scope/model</a></br>
    Model：${requestScope.get("Model")}</br>

    <hr/>
    <a href="${pageContext.request.contextPath}/scope/mav">/scope/mav</a></br>
    ModelAndView：${requestScope.get("ModelAndView")}</br>

</body>
</html>
