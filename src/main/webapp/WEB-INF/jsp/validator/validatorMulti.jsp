<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix= "sfw" uri= "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>登录</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/validatorMulti/login" method="post" >
        <input type="text" name="usera.userName" value="user"/> <br>
        <input type="password" name="usera.password" value="passward" /><br>
        <input type="text" name="usera.age" value="age"/> <br>
        <input type="text" name="usera.money" value="money"/> <br>
        <br>
        <input type="text" name="userb.userName" value="user"/> <br>
        <input type="password" name="userb.password" value="passward" /><br>
        <input type="text" name="userb.age" value="age"/> <br>
        <input type="text" name="userb.money" value="money"/> <br>
        
        <input type="submit" value="Submit" />
	</form>

    <br><br><br>
    <sfw:form commandName= "usera">
        <sfw:errors path= "*" cssStyle= "color:red"></sfw:errors><br/>
    </sfw:form>
    <br><br><br>
    <sfw:form commandName= "userb">
        <sfw:errors path= "*" cssStyle= "color:red"></sfw:errors><br/>
    </sfw:form>

</body>
</html>