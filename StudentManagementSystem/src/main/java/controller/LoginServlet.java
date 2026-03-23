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
import jakarta.servlet.http.HttpSession;
import util.DBConnection;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try {
			Connection conn=DBConnection.getConnection();
			String query="select * from admin where username=? and password=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				HttpSession session=request.getSession();
				session.setAttribute("user", username);
				response.sendRedirect("index.jsp");
				
			}else {
				response.getWriter().println(
					    "<script>alert('Invalid username or password'); window.location='login.jsp';</script>"
					);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
