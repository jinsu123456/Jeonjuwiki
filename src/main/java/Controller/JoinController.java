package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import VO.MemberVO;

@WebServlet("/Join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public JoinController() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		vo.setMphone(request.getParameter("mphone"));
		vo.setMemail(request.getParameter("memail"));
		vo.setMnick(request.getParameter("mnick"));
		vo.setMname(request.getParameter("mname"));
		
		int result = 0;
		
		try {
			result = new MemberDAO().join(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		if(result>0) {
			
			response.getWriter().append("<script>alert('회원가입 되었습니다.'); location.href='http://localhost:8080/jeonjuwiki'</script>");
			
		}else{
			
			response.getWriter().append("<script>alert('회원가입에 실패했습니다.'); location.href='http://localhost:8080/jeonjuwiki'</script>");

		}
		
		response.getWriter().flush();
	}

}
