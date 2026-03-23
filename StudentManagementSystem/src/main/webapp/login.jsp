<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
</head>
<body>
<div class="navbar">
    <div>Student Management</div>
    <div>
        <a href="DashboardServlet">Dashboard</a>
        <a href="addStudent.jsp">Add Student</a>
        <a href="ViewStudentServlet">View Students</a>
        <a href="LogoutServlet">Logout</a>
    </div>
</div>
<div class="container">

    <h2>Welcome Admin</h2>
<h2>Login</h2>

<form action="LoginServlet" method="post">
    
    Username:
    <input type="text" name="username" required>
    
    <br><br>
    
    Password:
    <input type="password" name="password" required>
    
    <br><br>
    
    <input type="submit" value="Login">

</form>


</div>
</body>

</html>