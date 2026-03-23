<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
String user = (String) session.getAttribute("user");
if(user == null){
   %>
   <<script>
   alert("please login first!");
   window.location="login.jsp";

</script>
    
    
    
   <%  
    return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
</head>
<body>
<!-- ✅ Navbar -->
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


<form action="AddstudentServlet" method="post">
Name: <input type="text" name="name" required><br/>
Email: <input type="email" name="email" required><br/>
Course: <input type="text" name="course" required><br/>

<button type="submit">Add student</button>


</form>
</div>

</body>
</html>