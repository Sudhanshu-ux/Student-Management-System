<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String user = (String) session.getAttribute("user");

if(user == null){
    response.sendRedirect("login.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

<link rel="stylesheet" href="css/style.css">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">

</head>

<body>

<!-- NAVBAR -->
<div class="navbar">
    <div><b>Student Management</b></div>
    <div class="nav-links">
        <a href="DashboardServlet">Dashboard</a>
        <a href="addStudent.jsp">Add Student</a>
        <a href="ViewStudentServlet">View Students</a>
        <a href="LogoutServlet">Logout</a>
    </div>
</div>

<!-- MAIN CONTAINER -->
<div class="container">

    <h2>Welcome, Admin 👋</h2>
    <h1 class="title">Student Management System</h1>

    <!-- DASHBOARD CARDS -->
    <div class="card-container">

        <div class="card">
            <h3>Delete Student</h3>

            <form action="DeleteStudentServlet" method="get">
                <input type="number" name="id" placeholder="Enter Student ID" required>
                <button class="btn">Delete</button>
            </form>

        </div>

        <div class="card">
            <h3>Quick Actions</h3>
            <p>Manage students easily</p>
            <a href="addStudent.jsp" class="btn">Add Student</a>
        </div>

    </div>

</div>

</body>
</html>