package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;
import util.DBConnection;

@WebServlet("/ViewStudentServlet")
public class ViewStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int page = 1;
        int recordsPerPage = 5;

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        List<Student> list = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {

            // ✅ Get paginated data
            String sql ="SELECT * FROM students ORDER BY id ASC LIMIT ?, ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, (page - 1) * recordsPerPage);
            ps.setInt(2, recordsPerPage);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setCourse(rs.getString("course"));
                list.add(s);
            }

            // ✅ Get total records
            String countQuery = "SELECT COUNT(*) FROM students";
            PreparedStatement ps2 = conn.prepareStatement(countQuery);
            ResultSet rs2 = ps2.executeQuery();

            int totalRecords = 0;
            if (rs2.next()) {
                totalRecords = rs2.getInt(1);
            }

            int totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);

            // ✅ Send data to JSP
            request.setAttribute("student", list);
            request.setAttribute("currentPage", page);
            request.setAttribute("totalPages", totalPages);

            request.getRequestDispatcher("viewStudent.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}