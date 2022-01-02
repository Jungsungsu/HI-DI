package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO;
import Model.MemberVO;

@WebServlet("/UpdateService")
public class UpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. 한글 인코딩
		request.setCharacterEncoding("euc-kr");
				
		// 1. 파라미터 수집
		// 이메일 --> 세션영역에 저장되어있는 vo
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		
		String name = request.getParameter("name");
		String id = vo.getMb_id();
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel");
		String birthdate = request.getParameter("birthdate");
		String addr = request.getParameter("address");

		// Dao객체 생성
		DAO dao = new DAO();

		// dao로부터 꺼내올 메서드
		// 쿼리 실행 결과(executeUpdate) : int타입, 성공한 행의 수
		int cnt = dao.Update(name, id, pw, email, gender, tel, birthdate, addr);

		// 로그인 실패 / 성공 판단
		// vo가 null이면 : 로그인 실패
		// vo가 null이 아니라면 : 로그인 성공

		if (cnt > 0) {
			// 성공
			System.out.println("수정 성공");
			
			// 같은 이름으로 다른 데이터를 집어넣으면 덮어쓰기된다.
			session.setAttribute("vo", new MemberVO(id, pw, email,name, gender, tel, birthdate, addr));
			System.out.println("음?" + name);
		} else {
			// 실패
			System.out.println("수정 실패");
		}

		// 페이지 이동
		response.sendRedirect("mypage.jsp");
		
	}

}
