package controller;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;


@WebServlet("/AddstudentServlet")
public class AddstudentServlet extends HttpServlet {
	
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String course=request.getParameter("course");
		String email=request.getParameter("email");
		
		Student s=new Student();
		
		s.setName(name);
		s.setEmail(email);
		s.setCourse(course);
		
		StudentDao sd=new StudentDao();
		
		if(sd.addstudent(s)) {
			response.sendRedirect("ViewStudentServlet");
		}else {
			response.getWriter().println("Error adding student");
		}
		
		
		
		
		
		
	}

}
