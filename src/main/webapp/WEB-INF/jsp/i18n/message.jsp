<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>message</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/i18n/init" method="post" >
        <input type="text" name="lng" value="${chglng}"/> <br>
        
        <input type="submit" value="Submit" />
    </form>
    
	<br><br><br>
	
    <form action="${pageContext.request.contextPath}/i18n/init2" method="post" >
        <input type="text" name="lng" value="${chglng}"/> <br>
        
        <input type="submit" value="Submit" />
    </form>

</body>
</html>