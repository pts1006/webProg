package dog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertDogServlet")
public class InsertDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertDogServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		
		// 이름, 종, 나이, 색깔, 크기. getParameter() 괄호 안에 들어갈 명칭은 값을 받아오는 곳의 name.
		String dName = request.getParameter("dName");
		String species = request.getParameter("species");
		String age = request.getParameter("age");
		String color = request.getParameter("dColor");
		String bSize = request.getParameter("dSize");
		
		DogVO vo = new DogVO();
		vo.setPetName(dName);
		vo.setSpecies(species);
		vo.setAge(age);
		vo.setColor(color);
		vo.setBodySize(bSize);
		
		System.out.println("등록 데이터 확인 : " + vo.toString());
		
		DogDAO dao = new DogDAO();
		int rsCnt = dao.insertDog(vo);
		
		System.out.println("query result : " + rsCnt);
		
		response.sendRedirect("/WebProject/exer_alone_1.html");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
