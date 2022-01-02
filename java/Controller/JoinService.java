package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.MemberVO;


@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//받아올 파라미터 인코딩
		request.setCharacterEncoding("euc-kr");

		//파라미터 수집
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String birthdate = request.getParameter("birthdate");
		String addr = request.getParameter("addr");
		
		//DAO 객체 생성
		DAO dao = new DAO();
		int cnt = dao.Join(id, pw, email, name, gender, phone, birthdate, addr);
		
		//회원가입 성공, 실패 여부
		if (cnt > 0) {
			System.out.println("회원가입 성공!");
			
			request.setAttribute("vo", new MemberVO(id, pw, email, name, gender, phone, birthdate, addr));
			
			//Forward 방식
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		} else {
			System.out.println("회원가입 실패!");
			// Main
			response.sendRedirect("join.jsp");
		}
	}

}
