<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Register</h1>
	<form action="AddStudent">
		<input type="text" name="name"></input>
		<input type="text" name="phone_number"></input>
		<input type="submit"></input>
	</form>
	<h1>Fetch</h1>
	<form action="GetStudent">
		<input type="text" name="id"></input>
		<input type="submit"></input>
	</form>
	<h1>Update</h1>
	<form action="UpdateStudent">
		<input type="text" name="id"></input>
		<input type="text" name="name"></input>
		<input type="text" name="phone_number"></input>
		<input type="submit"></input>
	</form>
	<h1>Delete</h1>
	<form action="DeleteStudent">
		<input type="text" name="id"></input>
		<input type="submit"></input>
	</form>
	
	<h1>Find by Name</h1>
	<form action = "GetStudentByName">
		<input type="text" name="name"></input>
		<input type="submit"></input>
	</form>
	
	<h1>Get All Student</h1>
	<form action="GetAllStudents">
		<input type="submit"></input>
	</form>
	
	
</body>
</html>