package controller;

import java.io.IOException;
import java.util.List;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;


@WebServlet("/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword=request.getParameter("keyword");
		
		StudentDao sd=new StudentDao();
		
		List<Student>list=sd.searchStudent(keyword);
		
		request.setAttribute("student", list);
		request.getRequestDispatcher("viewStudent.jsp").forward(request, response);
		
		
	}

	

}
