package net.answeris.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.answeris.web.dao.JdbcNoticeDao;
import net.answeris.web.model.Notice;

@WebServlet("/customer/notice")
public class NoticeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String _page = request.getParameter("pg");
		String _field = request.getParameter("f");
		String _query = request.getParameter("q");
		
		int page = 1;
		String field = "title";
		String query = "";
		
		if (_field !=null && _field.equals("CONTENT")) {
			field = _field;
		}
		

		if (_query != null && !_query.equals("")) {

			query = _query;
		}

		if (_page != null && !_page.equals("")) {

			page = Integer.parseInt(_page);
		}

		List<Notice> list = new JdbcNoticeDao().getList(page, field, query);
		request.setAttribute("list", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("notice.jsp");
		dispatcher.forward(request, response);

	}
}
