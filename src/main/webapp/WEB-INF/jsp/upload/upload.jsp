<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>

	<form action="file" method="post" enctype="multipart/form-data">
		<input type="file" name="file" /> <br>
		
		<input type="submit" value="Submit" />
	</form>
	
<br><br><br>
	<form action="streamfiles" method="post" enctype="multipart/form-data">
		<input type="file" name="file" /> <br>
		<input type="file" name="file" /> <br>
		
		<input type="submit" value="Submit" />
	</form>
	
<br><br><br>
    <form action="multifiles" method="post" enctype="multipart/form-data">
        <input type="file" name="file" /> <br>
        <input type="file" name="file_1" /> <br>
        
        <input type="submit" value="Submit" />
    </form>

</body>
</html>