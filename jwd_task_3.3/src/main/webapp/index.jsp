<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Choose parser</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<form action="Controller" method="get" >
		<input type="hidden" name="command" value="PARSE" />
		<div class="center">
		    <input type="submit" name="parser" value="SAX" id="submit" />
		    <br>
		    <input type="submit" name="parser" value="STAX" id="submit" />
		    <br>
		    <input type="submit" name="parser" value="DOM" id="submit" />
		</div>
	</form>
</body>
</html>