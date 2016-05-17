package net.answeris.web.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

import net.answeris.web.model.Notice;

@WebServlet("/customer/notice-detail")

public class NoticeDetailController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String c = request.getParameter("c");

		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String sql = "select * from NOTICE where CODE = '" + c + "'";

		Notice n = new Notice();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) { // 서버에서 레코드 하나 가져옴

				/*
				 * code = rs.getString("CODE"); title = rs.getString("TITLE");
				 * regdate = rs.getDate("REGDATE"); writer =
				 * rs.getString("WRITER"); hit = rs.getInt("HIT"); content =
				 * rs.getString("CONTENT");
				 */

				n.setCode(rs.getString("CODE"));
				n.setTitle(rs.getString("TITLE"));
				n.setRegdate(rs.getDate("REGDATE"));
				n.setWriter(rs.getString("WRITER"));
				n.setHit(rs.getInt("HIT"));
				n.setContent(rs.getString("CONTENT"));

			}
			rs.close();
			st.close();
			con.close();

			request.setAttribute("n", n);
			RequestDispatcher dispatcher = request.getRequestDispatcher("notice-detail.jsp");
			dispatcher.forward(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
