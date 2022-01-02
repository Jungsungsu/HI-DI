package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.MemberVO;
import Model.StatisticsVO;

@WebServlet("/StatisticsService")
public class StatisticsService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		String age = request.getParameter("ageselect");
		String year = request.getParameter("yearselect");
		
		System.out.println(age);
		System.out.println(year);
		
		DAO dao = new DAO();
		ArrayList<StatisticsVO> stalist = dao.SelectAgeYearSta(age, year);
		
		if(stalist != null) {
			request.setAttribute("stalist", stalist);
			
			//Forward ¹æ½Ä
			RequestDispatcher rd = request.getRequestDispatcher("statistics.jsp");
			rd.forward(request, response);
		}
	}

}
