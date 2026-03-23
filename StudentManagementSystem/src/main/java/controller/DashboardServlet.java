package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DBConnection;


@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int totalstudent = 0;

	       try {
	    	   Connection conn=DBConnection.getConnection();
	    	   PreparedStatement ps=conn.prepareStatement("select count(*) from students");
	    	   ResultSet rs=ps.executeQuery();
	    	   if(rs.next()) {
	    		   totalstudent=rs.getInt(1);
	    	   }
	    	   
	    	   
	       }catch(Exception e) {
	    	   e.printStackTrace();
	    	   
	       }
	       request.setAttribute("totalstudent", totalstudent);
	       request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	
	}

	

}
