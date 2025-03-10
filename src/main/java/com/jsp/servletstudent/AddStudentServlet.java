package com.jsp.servletstudent;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addstudent")
public class AddStudentServlet extends HttpServlet{
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	 String sname= req.getParameter("name");
 		int sid = Integer.parseInt(req.getParameter("id"));
 		String semail= req.getParameter("email");
 		String scourse= req.getParameter("course");
 		String scity= req.getParameter("city");
 		int sage = Integer.parseInt(req.getParameter("age"));
 		
 		Connection con= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_student-management-system","root","1234");
			PreparedStatement psmt = con.prepareStatement("insert into student values(?,?,?,?,?,?)");
			psmt.setInt(1,sid);
			psmt.setString(2,sname);
			psmt.setString(3,semail);
			psmt.setInt(4,sage);
			psmt.setString(5,scourse);
			psmt.setString(6,scity);
			
			psmt.execute();
			
			resp.sendRedirect("index.jsp");
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (con != null) 
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }

}
