package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final float USD_RATE = 1471.20f;
	private static final float JPY_RATE = 943.92f;
	private static final float CNY_RATE = 208.09f;
	private static final float GBP_RATE = 1960.89f;
	private static final float EUR_RATE = 1713.51f;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handle(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handle(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 파라미터 한글처리
		response.setContentType("text/html;charset=utf-8"); // mime type & 응답의 한글처리
		PrintWriter pw = response.getWriter(); // 출력객체 (응답하기 위해)
		String command = request.getParameter("command"); // 사용자가 변환버튼 클릭했는지여부
		String won = request.getParameter("won"); // 사용자가 입력한 금액
		String operator = request.getParameter("operator"); // 통화
		
		if (command != null && "calculate".equals(command)) { // 변환버튼 클릭한 경우
			String result = calculate(Float.parseFloat(won), operator); // calculate(사용자가 입력한 금액, 통화) 메서드  실행
			pw.print("<html><font size=10>변환 결과</font><br>");
			pw.print("<font size=10>"+result+"</font><br>");
			pw.print("<a href='/pro06/calc'>환율 계산기</a>");
			return;
		}
		
		// html출력
		pw.print("<html><title>환율 계산기</title>");
		pw.print("<font size=5>환율 계산기</font><br>");
		pw.print("<form name='frmCalc' method='post' action='/pro06/calc' />");
		pw.print("원화: <input type='text' name='won' size=10 />");
		pw.print("<select name='operator'>");
		pw.print("<option value='dollar'>달러</option>");
		pw.print("<option value='en'>엔화</option>");
		pw.print("<option value='wian'>위안</option>");
		pw.print("<option value='pound'>파운드</option>");
		pw.print("<option value='euro'>유로</option>");
		pw.print("</select>");
		pw.print("<input type='hidden' name='command' value='calculate'/>");
		pw.println("<input type='submit' value='변환'/>");
		pw.println("</form>");
		pw.print("</html>");
		pw.close();
	}
	
	// 원화(금액)을 통화단위 환율로 나누는 값 리턴
	private static String calculate(float won, String operator) {
		String result = null;
		if ("dollar".equals(operator)) {
			result = String.format("%.6f",  won / USD_RATE);
		} else if ("en".equals(operator)) {
			result = String.format("%.6f",  won / JPY_RATE);
		} else if ("wian".equals(operator)) {
			result = String.format("%.6f",  won / CNY_RATE);
		} else if ("pound".equals(operator)) {
			result = String.format("%.6f",  won / GBP_RATE);
		} else if ("euro".equals(operator)) {
			result = String.format("%.6f",  won / EUR_RATE);
		}
		return result;
	}

}
