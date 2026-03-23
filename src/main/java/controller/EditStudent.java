package controller;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;


@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		
		int id=Integer.parseInt(request.getParameter("id"));
		StudentDao sd=new StudentDao();
		Student s=sd.getStudentById(id);
		request.setAttribute("student", s);
		
		RequestDispatcher rd=request.getRequestDispatcher("editstudent.jsp");
		rd.forward(request, response);
		
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}
