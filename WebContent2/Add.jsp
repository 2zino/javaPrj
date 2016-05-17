<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
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
		application.setAttribute("sum", sum);

	} else if (btn.equals("session")) {
		session.setAttribute("sum", sum);

	} else if (btn.equals("cookie")) {
		Cookie cookie = new Cookie("sum", String.valueOf(sum));
		cookie.setMaxAge(5*60); //쿠키 생존시간 정하는
		response.addCookie(cookie);

	}

	else {
		sum =x+y;
	}
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Form</title>
</head>
<body>

	<form action="add" method="post">
		<fieldset>
			<ul>
				<li><label for="x">X:</label><input name="x" /></li>
				<li><label for="y">Y:</label><input name="y" /></li>
			</ul>
			<p>
				 <input type="text" name="sum" value= <%=sum%>/> 
				 <input type="submit" value="sum" /> 
				<!--  <input type="submit" value="SAVE" /><br /> -->
				 <input type="submit" name="btn" value="application" /> 
				 <input type="submit" name="btn" value="session" /> 
				 <input type="submit" name="btn" value="cookie" />
			
			RESULT: <%=sum%>
			</p>
				<a href="mypage">MYPAGE</a>
		</fieldset>
	</form>
</body>
</html>


