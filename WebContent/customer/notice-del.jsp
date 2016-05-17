<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String code = request.getParameter("c");

	String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection(url, "c##sist", "dclass");

	//게시글 등록 
	String sql = "Delete NOTICE where CODE = ?";
	PreparedStatement pst = con.prepareStatement(sql);
	pst.setString(1, code);
	pst.executeUpdate();

	response.sendRedirect("notice");
%>