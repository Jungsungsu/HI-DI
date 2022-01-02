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

/**
 * Servlet implementation class ExchangeService
 */
@WebServlet("/ExchangeService")
public class ExchangeService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		
		DAO dao = new DAO();
		if(vo.getMb_point() >0) {
			int exchangePoint = vo.getMb_point();
			dao.UpdatePoint(vo.getMb_id(), 0);
			dao.InsertPoint(exchangePoint, "exchange", vo.getMb_id(), "-");
			
			session.setAttribute("vo", new MemberVO(vo.getMb_id(), vo.getMb_pw(), vo.getMb_email(), vo.getMb_name(), vo.getMb_gender(),
					vo.getMb_phone(), vo.getMb_birthdate(), vo.getMb_addr(), vo.getMb_joindate(), vo.getAdmin_yn(), 0));
			
			
		}
		response.sendRedirect("mypage.jsp");

	}

}
