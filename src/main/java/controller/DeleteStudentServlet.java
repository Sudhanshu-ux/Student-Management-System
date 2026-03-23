package controller;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		int id=Integer.parseInt(request.getParameter("id"));
		StudentDao sd=new StudentDao();
		
		sd.deleteStudent(id);
		response.sendRedirect("ViewStudentServlet");
	}catch(Exception e) {
		e.printStackTrace();
		
	}
		
		
	}

}
