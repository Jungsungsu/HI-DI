package Controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO;
import Model.MemberVO;


@WebServlet("/checkResultService")
public class checkResultService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		
		DAO dao = new DAO();
		

		String mb_id = request.getParameter("id");
		String check_name = request.getParameter("name");
		int check_seq = Integer.parseInt(request.getParameter("seq"));
		String result = request.getParameter("result");

		//포인트 적립
		String point = request.getParameter("point");
		// 현재 날짜 구하기
		LocalDate now = LocalDate.now();
		// 포맷 정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");
		// 포맷 적용
		String formatedNow = now.format(formatter);
		
		if(point.equals("o")) {
			if(dao.SelectPoint(mb_id, "dailycheck", formatedNow) == null) {
				dao.InsertPoint(100, "dailycheck", mb_id, "+");
				
				dao.UpdatePoint(mb_id, vo.getMb_point()+100);
				session.setAttribute("vo", new MemberVO(vo.getMb_id(), vo.getMb_pw(), vo.getMb_email(), vo.getMb_name(), vo.getMb_gender(),
						vo.getMb_phone(), vo.getMb_birthdate(), vo.getMb_addr(), vo.getMb_joindate(), vo.getAdmin_yn(), vo.getMb_point()+100));
				System.out.println(vo.getMb_point());
				
				System.out.println("포인트 적립 성공");
			}else {
				System.out.println("포인트 적립실패");
			}
		}
		
		System.out.println(check_name);
		
		dao.InsertCheck(check_seq, result, mb_id);
		
		String url = null;
		if(result.equals("y")) {
			url = "checkResult.jsp?name="+URLEncoder.encode(check_name, "euc-kr") ;
			System.out.println(url);
		}else {
			url ="main.jsp";
		}
		response.setCharacterEncoding("EUC-KR");
		response.sendRedirect(url);
	}

}
