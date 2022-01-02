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
import Model.DiseaseVO;
import Model.RawVO;

/**
 * Servlet implementation class diseaseSearch
 */
@WebServlet("/diseaseSearch")
public class diseaseSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String dis_name=request.getParameter("searchText");
		
		DAO dao = new DAO();
		
		DiseaseVO dvo= dao.SelectDiseaseName(dis_name);
		
		ArrayList<RawVO> rawlist = dao.RawSelect();	//영양성분 정보 출력
		ArrayList<String> raw_name = new ArrayList<String>();	//영양성분 이름
		ArrayList<String> raw_func = new ArrayList<String>();	//영양성분 기능
		
		String[] tags = dvo.getDis_tag().replace(" ", "").split(",");
		
		System.out.println(dis_name);
		if(dvo != null) {
			System.out.println("성공");
			
			for(int i =0; i<tags.length; i++){	//질병에 대한 태그 검색하기 위한 tag
				
				for(int j=0; j<rawlist.size(); j++){	//전체 영양성분에서 질병에 대한 tag 찾기
					
					String taglist = rawlist.get(j).getDis_tag();
					
					if(taglist.contains(tags[i])==true){
						raw_name.add(rawlist.get(j).getRaw_name());
						raw_func.add(rawlist.get(j).getRaw_func());
					}
				}
			}
			
			request.setAttribute("dvo", dvo);	//dvo 전송
			request.setAttribute("raw_name", raw_name);	//raw_name 전송
			request.setAttribute("raw_func", raw_func);	//raw_func 전송
			
		}else {
			System.out.println("실패");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("diseaseSearch.jsp");
		rd.forward(request, response);
			
	}
}
