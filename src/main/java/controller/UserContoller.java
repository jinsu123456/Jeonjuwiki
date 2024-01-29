package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class UserContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserContoller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		//DB ???û• ?ñà?ã§Í≥? Í∞??†ï (DB?óê?äî emailAuth ?ïÑ?ìúÍ∞? ?ûà?ñ¥?ïº ?ïòÍ≥? ÏµúÏ¥à?óê?äî 0?ù¥ ???û•?êò?ñ¥ ?ûà?ùå) 1 ?ù∏Ï¶? 0 ÎØ∏Ïù∏Ï¶?
		
		//DB?óê ???û•?ñà?úº?ãà google email ?ù∏Ï¶? ?éò?ù¥Ïß?Î°? ?ù¥?èô
		response.sendRedirect("/AuthGoogle/gmailSendAction.jsp?email="+email);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}