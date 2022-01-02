package kr.flasktest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FlaskController")
public class FlaskController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 형호
		String corona = request.getParameter("corona");
		String corona1 = request.getParameter("corona1");
		String corona2 = request.getParameter("corona2");
		String corona3 = request.getParameter("corona3");

		String day1 = request.getParameter("day1");
		String day2 = request.getParameter("day2");
		String day3 = request.getParameter("day3");
		String day4 = request.getParameter("day4");
		String day5 = request.getParameter("day5");
		String day6 = request.getParameter("day6");
		String day7 = request.getParameter("day7");
		
		String day_increase1 = request.getParameter("day_increase1");
		String day_increase2 = request.getParameter("day_increase2");
		String day_increase3 = request.getParameter("day_increase3");
		String day_increase4 = request.getParameter("day_increase4");
		String day_increase5 = request.getParameter("day_increase5");
		String day_increase6 = request.getParameter("day_increase6");
		String day_increase7 = request.getParameter("day_increase7");

		
		System.out.println("Flask로부터 받은 데이터 >> " + corona);
		System.out.println("Flask로부터 받은 데이터 >> " + corona1);
		System.out.println("Flask로부터 받은 데이터 >> " + corona2);
		System.out.println("Flask로부터 받은 데이터 >> " + corona3);

		System.out.println("Flask로부터 받은 날짜 >>" + day1);
		System.out.println("Flask로부터 받은 확진자 수 >>" + day_increase1);
		System.out.println("Flask로부터 받은 확진자 수 >>" + day_increase2);
		System.out.println("Flask로부터 받은 확진자 수 >>" + day_increase3);
		System.out.println("Flask로부터 받은 확진자 수 >>" + day_increase4);
		System.out.println("Flask로부터 받은 확진자 수 >>" + day_increase5);
		System.out.println("Flask로부터 받은 확진자 수 >>" + day_increase6);
		System.out.println("Flask로부터 받은 확진자 수 >>" + day_increase7);

		HttpSession session = request.getSession();

		session.setAttribute("corona", corona);
		session.setAttribute("corona1", corona1);
		session.setAttribute("corona2", corona2);
		session.setAttribute("corona3", corona3);
		
		session.setAttribute("day1", day1);
		session.setAttribute("day2", day2);
		session.setAttribute("day3", day3);
		session.setAttribute("day4", day4);
		session.setAttribute("day5", day5);
		session.setAttribute("day6", day6);
		session.setAttribute("day7", day7);
		
		session.setAttribute("day_increase1", day_increase1);
		session.setAttribute("day_increase2", day_increase2);
		session.setAttribute("day_increase3", day_increase3);
		session.setAttribute("day_increase4", day_increase4);
		session.setAttribute("day_increase5", day_increase5);
		session.setAttribute("day_increase6", day_increase6);
		session.setAttribute("day_increase7", day_increase7);
		
		response.sendRedirect("main.jsp");

	}
}
