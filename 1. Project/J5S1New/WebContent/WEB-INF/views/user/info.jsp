<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Spring MVC</title>
	<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
	<h3>USER INFO</h3>
	<ul>
		<li>User Name: ${uid}</li>
		<li>Password: ${pwd}</li>
	</ul>
</body>
</html>
