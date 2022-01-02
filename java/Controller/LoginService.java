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


@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�Ķ���� ����
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//DAO��ü ����
		DAO dao = new DAO();
		MemberVO vo = dao.Login(id, pw);
		
		//�α��� ���� ����
		if(vo != null) {
			System.out.println("�α��� ����");
			
			HttpSession session = request.getSession();
			
			session.setAttribute("vo", vo);
		
		}else {
			System.out.println("�α��� ����");
		}
		
		response.sendRedirect("main.jsp");
	}

}
