<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
    <hr/>
    <h3> 填写表单，传递基本类型参数 </h3>
    <form action="${pageContext.request.contextPath}/parameter/test1" method="post">
        姓名<input type="text" name="name"><br/>
        年龄<input type="text" name="age"><br/>
        <input type="submit" value="确认"></input>
    </form>

    <hr/>
    <h3> 填写表单，传递数组 </h3>
    <form action="${pageContext.request.contextPath}/parameter/test11" method="post">
        姓名<input type="checkbox" name="hobby" value="篮球"><br/>
        年龄<input type="checkbox" name="hobby" value="写代码"><br/>
        年龄<input type="checkbox" name="hobby" value="读书"><br/>
        <input type="submit" value="确认"></input>
    </form>

    <hr/>
    <h3> 填写表单，传递Bean类参数 </h3>
    <form action="${pageContext.request.contextPath}/parameter/test2" method="post">
        姓名<input type="text" name="name"><br/>
        编号<input type="text" name="id"><br/>
        年龄<input type="text" name="age"><br/>
        <input type="submit" value="确认"></input>
    </form>

    <hr/>
    <h3> 填写表单，包装参数 </h3>
    <form action="${pageContext.request.contextPath}/parameter/test3" method="post">
        <h4>包装参数里的student</h4>
        姓名<input type="text" name="student.name"><br/>
        编号<input type="text" name="student.id"><br/>
        年龄<input type="text" name="student.age"><br/>
        <h4>包装参数里的List1</h4>
        姓名1<input type="text" name="list[0].name"><br/>
        编号1<input type="text" name="list[0].id"><br/>
        年龄1<input type="text" name="list[0].age"><br/>
        <h4>包装参数里的List2</h4>
        姓名2<input type="text" name="list[1].name"><br/>
        编号2<input type="text" name="list[1].id"><br/>
        年龄2<input type="text" name="list[1].age"><br/>
        <h4>包装参数里的Map</h4>
        姓名3<input type="text" name="maps['name']"><br/>
        编号3<input type="text" name="maps['id']"><br/>
        年龄3<input type="text" name="maps['age']"><br/>
        <input type="submit" value="确认"></input> 6块钱
    </form>

    <hr/>
    <h3> 填写表单，以 restful 的方式传递参数 </h3>
    <a href="${pageContext.request.contextPath}/parameter/test4/120/救护车">点击这里测试restful</a>

</body>
</html>
