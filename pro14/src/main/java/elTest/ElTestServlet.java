package elTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ElTestServlet
 */
@WebServlet("/elTest") // 요청받는 URL
public class ElTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비즈니스 로직 처리(연산, DB작업....)
		// 출력값 저장
		// request에 저장
		request.setAttribute("name", "홍길동"); // request에 name
		MemberVO vo = new MemberVO();
		vo.setName("김길동");
		request.setAttribute("member", vo);
		// 세션에 저장
		HttpSession session = request.getSession();
		session.setAttribute("id", "hong");
		session.setAttribute("name", "최길동"); // session에 name
		
		// 로그인 세션
		session.setAttribute("loginSession", vo);
		
		// List안에 Map 넣어서 request에 저장
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("title", "제목1");
		list.add(map);
		
		map = new HashMap<>();
		map.put("title", "제목2");
		list.add(map);
		
		map = new HashMap<>();
		map.put("title", "제목3");
		list.add(map);
		
		request.setAttribute("list", list);
		
		// 포맷팅
		request.setAttribute("price", 1000000); // 천단위 숫자
		request.setAttribute("date", new Date());// 날짜
		
		
		// 응답(리다이렉트, 포워딩)
		System.out.println("elTest");
		request.getRequestDispatcher("/elTest.jsp").forward(request, response);
	}

}
