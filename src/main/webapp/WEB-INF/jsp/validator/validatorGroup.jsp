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


    <form action="${pageContext.request.contextPath}/validatorGroup/nogroup" method="post" >
        <input type="text" name="userName" value="user"/> <br>
        <input type="password" name="password" value="passward" /><br>
        <input type="text" name="age" value="age"/> <br>
        <input type="text" name="money" value="money"/> <br>
        
        <input type="submit" value="Submit" />
    </form>
    <form action="${pageContext.request.contextPath}/validatorGroup/group" method="post" >
        <input type="text" name="userName" value="user"/> <br>
        <input type="password" name="password" value="passward" /><br>
        <input type="text" name="age" value="age"/> <br>
        <input type="text" name="money" value="money"/> <br>
        
        <input type="submit" value="Submit" />
    </form>
    <form action="${pageContext.request.contextPath}/validatorGroup/groupa" method="post" >
        <input type="text" name="userName" value="user"/> <br>
        <input type="password" name="password" value="passward" /><br>
        <input type="text" name="age" value="age"/> <br>
        <input type="text" name="money" value="money"/> <br>
        
        <input type="submit" value="Submit" />
    </form>
    <form action="${pageContext.request.contextPath}/validatorGroup/groupb" method="post" >
        <input type="text" name="userName" value="user"/> <br>
        <input type="password" name="password" value="passward" /><br>
        <input type="text" name="age" value="age"/> <br>
        <input type="text" name="money" value="money"/> <br>
        
        <input type="submit" value="Submit" />
    </form>
    
    <br><br><br>
    <sfw:form commandName= "userGroup">
        <sfw:errors path= "*" cssStyle= "color:red"></sfw:errors><br/>
    </sfw:form>

</body>
</html>