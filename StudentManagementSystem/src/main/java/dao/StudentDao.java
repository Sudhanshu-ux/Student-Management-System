package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import util.DBConnection;

public class StudentDao {

	public boolean addstudent(Student s) {
		boolean status=false;
		
		try {
			Connection conn=DBConnection.getConnection();
			String query="insert into students(name,email,course)values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getCourse());
			int a=ps.executeUpdate();
			if(a>0) {
				status=true;
			}
				
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return status;
	}
	
	public List<Student> getAllStudent(){
		
		List<Student>list=new ArrayList<>();
		try {
		Connection conn=DBConnection.getConnection();
		String query="select * from students";
		PreparedStatement ps=conn.prepareStatement(query);
	ResultSet rs=ps.executeQuery();
	
	while(rs.next()) {
		Student s=new Student();
		s.setId(rs.getInt("id"));
		s.setName(rs.getString("name"));
		s.setEmail(rs.getString("email"));
		s.setCourse(rs.getString("course"));
		list.add(s);
	}
	
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return list;
		
	}
	
	public void deleteStudent(int id) {
		try {
			Connection conn=DBConnection.getConnection();
			String query="delete from students where id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			int a=ps.executeUpdate();
			
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	
	public void updateStudent(Student s) {
		try {
			Connection conn=DBConnection.getConnection();
			String query="update students set name=?,email=?,course=? where id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getCourse());
			ps.setInt(4, s.getId());
			
			int a=ps.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Student getStudentById(int id) {
		Student s=null;
		try {
			Connection conn=DBConnection.getConnection();
			String query="select * from students where id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 s=new Student();
				 s.setId(rs.getInt("id"));
				 s.setName(rs.getString("name"));
				 s.setEmail(rs.getString("email"));
				 s.setCourse(rs.getString("course"));
			}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		return s;
		
	}
	
	public List<Student> searchStudent(String keyword){
		List<Student>list=new ArrayList<>();
		try {
			Connection conn=DBConnection.getConnection();
			String query="select * from students where name like ?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, "%"+keyword+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Student s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setCourse(rs.getString("course"));
				
				list.add(s);
			}
		
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return list;
		
	}
	
	
	
}
