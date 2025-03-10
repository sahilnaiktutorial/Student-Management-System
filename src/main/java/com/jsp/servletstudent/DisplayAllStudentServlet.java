package com.jsp.servletstudent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/display-all-student")
public class DisplayAllStudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_student-management-system","root","1234");
			PreparedStatement psmt = con.prepareStatement("select * from student");
			
			
			ResultSet rs  = psmt.executeQuery();
			
			req.setAttribute("resultset", rs);  
		RequestDispatcher rd= req.getRequestDispatcher("DisplayAllStudents.jsp");
			rd.forward(req, resp);
//			resp.sendRedirect("index.jsp");
		
			
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
