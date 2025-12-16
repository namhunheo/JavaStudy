package sec01.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO;
	
	public void init() throws ServletException {
		memberDAO = new MemberDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null; // 포워딩할 페이지
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getPathInfo();
		System.out.println("action:"+action);
		
		if (action == null || "/listMembers.do".equals(action)) {
			MemberVO vo = new MemberVO();
			// 검색어
			
			List<MemberVO> memberList = memberDAO.listMembers(vo);
			request.setAttribute("memberList", memberList);
			nextPage = "/test01/listMembers.jsp";
		} else if ("/addMember.do".equals(action)) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO.addMember(memberVO);
			nextPage = "/member/listMembers.do";
			request.setAttribute("msg", "addMember");
		} else if ("/memberForm.do".equals(action)) {
			nextPage = "/test01/memberForm.jsp";
		} else if ("/modMemberForm.do".equals(action)) {
			MemberVO memInfo = memberDAO.findMember(request.getParameter("id"));
			request.setAttribute("memInfo", memInfo);
			nextPage = "/test01/modMemberForm.jsp";
		} else if ("/modMember.do".equals(action)) {
			MemberVO memberVO = new MemberVO(
					request.getParameter("id"),
					request.getParameter("pwd"),
					request.getParameter("name"),
					request.getParameter("email")
					);
			memberDAO.modMember(memberVO);
			request.setAttribute("msg", "modified");
			nextPage = "/member/listMembers.do";
		} else if ("/delMember.do".equals(action)) {
			memberDAO.delMember(request.getParameter("id"));
			request.setAttribute("msg", "deleted");
			nextPage = "/member/listMembers.do";
		} else {
			MemberVO vo = new MemberVO();
			// 검색어
			
			List<MemberVO> memberList = memberDAO.listMembers(vo);
			request.setAttribute("memberList", memberList);
			nextPage = "/test01/listMembers.jsp";
		}
		
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}
