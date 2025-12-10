package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name= request.getParameter("name");
		String address = (String)request.getAttribute("address");
		out.print("<html><body>");
		out.print("이름 : "+name+"<br>");
		out.print("주소 : "+address+"<br>");
		out.print("dispatch를 이용한 forward 실습입니다.");
		out.print("</body></html>");
	}

}
