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
		
		//�޾ƿ� �Ķ���� ���ڵ�
		request.setCharacterEncoding("euc-kr");

		//�Ķ���� ����
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String birthdate = request.getParameter("birthdate");
		String addr = request.getParameter("addr");
		
		//DAO ��ü ����
		DAO dao = new DAO();
		int cnt = dao.Join(id, pw, email, name, gender, phone, birthdate, addr);
		
		//ȸ������ ����, ���� ����
		if (cnt > 0) {
			System.out.println("ȸ������ ����!");
			
			request.setAttribute("vo", new MemberVO(id, pw, email, name, gender, phone, birthdate, addr));
			
			//Forward ���
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		} else {
			System.out.println("ȸ������ ����!");
			// Main
			response.sendRedirect("join.jsp");
		}
	}

}
