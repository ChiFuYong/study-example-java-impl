<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>上传下载</title>
</head>
<body>
    <h1> 文件上传下载页面 </h1>

    <%-- enctype属性
            application/x-www-form-urlencoded：普通表单数据.(少量文字信息)
            text/plain： 大文字量时使用的类型.邮件,论文
            multipart/form-data：表单中包含二进制文件内容.
     --%>
    <form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">
        请选择上传文件：<input type="file" name="file" value="选择文件"/><br/>
        <input type="submit" value="提交"/>
    </form>

    <a href="${pageContext.request.contextPath}/file/download">点击测试下载</a>

</body>
</html>
