<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>

    ${string}
<form action="/login.do" method="post" >
    <p> 账户名<input type="text" name="username" > </p>
    <p> 密--码<input type="password" name="password" > </p>
    <p> <input type="submit" value="登录" ></p>

</form>


</body>
</html>