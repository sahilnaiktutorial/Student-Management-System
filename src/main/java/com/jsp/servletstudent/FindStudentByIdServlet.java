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
@WebServlet("/find-by-id")
public class FindStudentByIdServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("studentId"));
		Connection con= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_student-management-system","root","1234");
			PreparedStatement psmt = con.prepareStatement("select * from student where studentId=?");
		psmt.setInt(1,id);
			
			ResultSet rs =psmt.executeQuery();
			
			req.setAttribute("resultset",rs);
			RequestDispatcher rd= req.getRequestDispatcher("UpdateStudent.jsp");
				rd.forward(req, resp);
		
			
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
