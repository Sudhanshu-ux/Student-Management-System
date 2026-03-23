<%@ page import="java.util.*,model.Student"%>
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
<div class="navbar">
    <div>Student Management</div>
    <div>
        <a href="DashboardServlet">Dashboard</a>
        <a href="addStudent.jsp">Add Student</a>
        <a href="ViewStudentServelt">View Students</a>
        <a href="LogoutServlet">Logout</a>
    </div>
</div>
<div class="container">

    <h2>Welcome Admin</h2>
<h2>Student list</h2>

<form action="SearchStudentServlet" method="get">
    <input type="text" name="keyword" placeholder="Search by name">
    <input type="submit" value="Search">
</form>

<table border="1">

<tr>
<th>Id</th>
<th>name</th>
<th>Email</th>
<th>Course</th>
<%
List<Student>list=(List<Student>)request.getAttribute("student");

for(Student s:list){
	%>
	<tr>
<td><%= s.getId() %></td>
<td><%= s.getName() %></td>
<td><%= s.getEmail() %></td>
<td><%= s.getCourse() %></td>
<td>
<a href="EditStudent?id=<%=s.getId() %>">Edit</a>
<a href="DeleteStudentServlet?id=<%=s.getId() %>" onclick="return confirm('Delete this student?')">Delete</a>
</td>
</tr>
<%
}
%>
</table>
</div>
<div style="margin-top:20px;">
<%
Integer currentPage = (Integer) request.getAttribute("currentPage");
Integer totalPages = (Integer) request.getAttribute("totalPages");

if(currentPage == null) currentPage = 1;
if(totalPages == null) totalPages = 1;

for(int i = 1; i <= totalPages; i++){
%>
    <a href="ViewStudentServlet?page=<%= i %>">
        <button <%= (i == currentPage) ? "style='background:black;color:white;'" : "" %>>
            <%= i %>
        </button>
    </a>
<%
}
%>
</div>


</body>
</html>