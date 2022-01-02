package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO;
import Model.MemberVO;


@WebServlet("/InsertPoll")
public class InsertPoll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		
		DAO dao = new DAO();
		
		//포인트 적립
		dao.InsertPoint(100, "poll", vo.getMb_id(), "+");
		dao.UpdatePoint(vo.getMb_id(), vo.getMb_point()+100);
		session.setAttribute("vo", new MemberVO(vo.getMb_id(), vo.getMb_pw(), vo.getMb_email(), vo.getMb_name(), vo.getMb_gender(),
				vo.getMb_phone(), vo.getMb_birthdate(), vo.getMb_addr(), vo.getMb_joindate(), vo.getAdmin_yn(), vo.getMb_point()+100));
		
		for(int i=1; i<=23; i++){
			String answer = request.getParameter("answer"+i);
			System.out.println(answer);
			if(answer != null) {
				dao.InsertPoll(i, answer, vo.getMb_id());
			}
		}
				
		response.sendRedirect("main.jsp");
				
	}

}
