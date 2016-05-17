package net.answeris.web.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customer/notice-edit")

public class NoticeEditController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String c = request.getParameter("c");

		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String sql = "select * from NOTICE where CODE = '" + c + "'";

		String code = "";
		String title = "";
		String writer = "";
		String content = "";
	Date regdate = null;
		int hit = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) { // 서버에서 레코드 하나 가져옴

				code = rs.getString("CODE");
				title = rs.getString("TITLE");
				regdate = rs.getDate("REGDATE");
				writer = rs.getString("WRITER");
				hit = rs.getInt("HIT");
				content = rs.getString("CONTENT");
			}
			rs.close();
			st.close();
			con.close();

			request.setAttribute("code", code);
			request.setAttribute("title", title);
			request.setAttribute("writer", writer);
			request.setAttribute("content", content);
			request.setAttribute("regdate", regdate);
			request.setAttribute("hit", hit);

			RequestDispatcher dispatcher = request.getRequestDispatcher("notice-edit.jsp");
			dispatcher.forward(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
	
		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		
		
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
				String sql = "Update NOTICE set TITLE =?, CONTENT=? where CODE = ?";
				PreparedStatement pst = con.prepareStatement(sql);
				
				pst.setString(1, title);
				pst.setString(2, content);
				pst.setString(3, code);

				pst.executeUpdate();
				response.sendRedirect("notice-detail?c=" + code);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//게시글 등록 
	}
	
}
