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
		
		// 0. �ѱ� ���ڵ�
		request.setCharacterEncoding("euc-kr");
				
		// 1. �Ķ���� ����
		// �̸��� --> ���ǿ����� ����Ǿ��ִ� vo
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

		// Dao��ü ����
		DAO dao = new DAO();

		// dao�κ��� ������ �޼���
		// ���� ���� ���(executeUpdate) : intŸ��, ������ ���� ��
		int cnt = dao.Update(name, id, pw, email, gender, tel, birthdate, addr);

		// �α��� ���� / ���� �Ǵ�
		// vo�� null�̸� : �α��� ����
		// vo�� null�� �ƴ϶�� : �α��� ����

		if (cnt > 0) {
			// ����
			System.out.println("���� ����");
			
			// ���� �̸����� �ٸ� �����͸� ��������� �����ȴ�.
			session.setAttribute("vo", new MemberVO(id, pw, email,name, gender, tel, birthdate, addr));
			System.out.println("��?" + name);
		} else {
			// ����
			System.out.println("���� ����");
		}

		// ������ �̵�
		response.sendRedirect("mypage.jsp");
		
	}

}
