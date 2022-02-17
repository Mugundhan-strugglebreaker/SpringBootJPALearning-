<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p><b>Simple List:</b><p>
	
	${studentList}
	
	<p><b>Iterated List:</b><p>

	<ol>
		<c:forEach var="student" items="${studentList}">
		
			<li>${student}</li>
			
		</c:forEach>
	</ol>
</body>
</html>