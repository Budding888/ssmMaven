<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/24
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>编辑页面</title>
</head>
<body>

     <%--注意!!!!!!!!!!!!!!!!!: 千万别加  enctype="multipart/form-data" --%>

   <form action="/user/SaveOrUpdate.do" method="post" >

       <input type="hidden" name="id" value="${user.id}"/>

       姓名<input type="text" name="name" value="${user.name}"  /><br/>
       年龄<input type="text" name="age" value="${user.age}" /> <br/>
           <input type="submit" value="提交"/>

   </form>


</body>
</html>
