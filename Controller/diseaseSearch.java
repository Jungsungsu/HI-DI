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
		
		ArrayList<RawVO> rawlist = dao.RawSelect();	//���缺�� ���� ���
		ArrayList<String> raw_name = new ArrayList<String>();	//���缺�� �̸�
		ArrayList<String> raw_func = new ArrayList<String>();	//���缺�� ���
		
		String[] tags = dvo.getDis_tag().replace(" ", "").split(",");
		
		System.out.println(dis_name);
		if(dvo != null) {
			System.out.println("����");
			
			for(int i =0; i<tags.length; i++){	//������ ���� �±� �˻��ϱ� ���� tag
				
				for(int j=0; j<rawlist.size(); j++){	//��ü ���缺�п��� ������ ���� tag ã��
					
					String taglist = rawlist.get(j).getDis_tag();
					
					if(taglist.contains(tags[i])==true){
						raw_name.add(rawlist.get(j).getRaw_name());
						raw_func.add(rawlist.get(j).getRaw_func());
					}
				}
			}
			
			request.setAttribute("dvo", dvo);	//dvo ����
			request.setAttribute("raw_name", raw_name);	//raw_name ����
			request.setAttribute("raw_func", raw_func);	//raw_func ����
			
		}else {
			System.out.println("����");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("diseaseSearch.jsp");
		rd.forward(request, response);
			
	}
}
