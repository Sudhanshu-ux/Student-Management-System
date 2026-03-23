package controller;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;


@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String course=request.getParameter("course");
		
		Student s=new Student();
		s.setId(id);
		s.setName(name);
		s.setEmail(email);
		s.setCourse(course);
		
		StudentDao sd=new StudentDao();
		sd.updateStudent(s);
		
		response.sendRedirect("ViewStudentServlet");
		
		
	}

}
