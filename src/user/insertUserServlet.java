package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertUser")
public class insertUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public insertUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		
		String uID = request.getParameter("uId");
		String uName = request.getParameter("uName");
		String species = request.getParameter("species");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		
		InfoVO vo = new InfoVO();
		vo.setUserId(Integer.parseInt(uID));
		vo.setUserName(uName);
		vo.setUserSpecies(species);
		vo.setUserGender(gender);
		vo.setUserAge(Integer.parseInt(age));
		
		InfoDAO dao = new InfoDAO();
		int insertCnt = dao.insertUser(vo);
		
		response.getWriter().print(insertCnt);
	}

}