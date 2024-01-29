package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginDAO;
import VO.MemberVO;



@WebServlet("/login/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login/login.jsp");
		requestDispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String mid = req.getParameter("mid");
		String mpass = req.getParameter("mpassword");
		
		MemberVO m = null;
		
		try {
			m = new LoginDAO().login(mid, mpass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		res.setContentType("text/html; charset=utf-8");
		res.setCharacterEncoding("utf-8");
		
		if(m!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("login", m);
			
			res.getWriter().append("<script>alert('로그인 되었습니다.'); location.href='http://localhost:8080/jspboard'</script>");
			
		}else{
			
			res.getWriter().append("<script>alert('로그인되지 않았습니다.'); location.href='http://localhost:8080/jspboard'</script>");

		}
		
		res.getWriter().flush();

		
		
	}

}
