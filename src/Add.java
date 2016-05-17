
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/add")
public class Add extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		int x = 0;
		int y = 0;
		int sum = 0;
		String btn = "add";

		if (request.getMethod().equals("POST")) {
			String _btn = request.getParameter("btn");
			String _x = request.getParameter("x");
			String _y = request.getParameter("y");
			String _sum = request.getParameter("sum");

			if (_btn != null && !_btn.equals("")) {
				btn = _btn;
			}

			if (_sum != null && !_sum.equals("")) {
				sum = Integer.parseInt(_sum);
			}

			if ((_x != null && _y != null) && (!_x.equals("") && !_y.equals(""))) {
				x = Integer.parseInt(_x);
				y = Integer.parseInt(_y);
			}

			/*---------버튼에 따른 처리------------*/

			if (btn.equals("application")) {
				ServletContext application = request.getServletContext();
				application.setAttribute("sum", sum);

			} else if (btn.equals("session")) {

				HttpSession session = request.getSession();
				session.setAttribute("sum", sum);

			} else if (btn.equals("cookie")) {
				Cookie cookie = new Cookie("sum", String.valueOf(sum));
				cookie.setMaxAge(5*60); //쿠키 생존시간 정하는
				response.addCookie(cookie);

			}

			else {

				sum = x + y;
			}
		}

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"EUC-KR\">");
		out.println("<title>Add Form</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("	<form action=\"add\" method=\"post\">");
		out.println("	<fieldset>");
		out.println("		<ul>");
		out.println("			<li><label for=\"x\">X:</label><input name=\"x\" /></li>");
		out.println("			<li><label for=\"y\">Y:</label><input name=\"y\" /></li>");
		out.println("		</ul>");
		out.println("		<p>");
		out.printf("			<input type=\"hidden\" name=\"sum\" value=\"%d\"/>", sum);
		out.println("			<input type=\"submit\" value=\"sum\" />");
		out.println("			<input type=\"submit\" value=\"SAVE\" /><br/>");
		out.println("			<input type=\"submit\" name = \"btn\" value=\"application\" />");
		out.println("			<input type=\"submit\" name = \"btn\" value=\"session\" />");
		out.println("			<input type=\"submit\" name = \"btn\" value=\"cookie\" />");
		out.println("	<p>");
		out.println("RESULT:" + sum);
		out.println("	</p>");
		out.println("			<p><a href = \"mypage\">Mypage</a>");

		out.println("	</fieldset>");
		out.println("	</form>");
		out.println("</body>");
		out.println("</html>");

	}
}
