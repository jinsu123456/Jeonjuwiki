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
		
		//DB ???₯ ??€κ³? κ°??  (DB?? emailAuth ??κ°? ??΄?Ό ?κ³? μ΅μ΄?? 0?΄ ???₯??΄ ??) 1 ?Έμ¦? 0 λ―ΈμΈμ¦?
		
		//DB? ???₯??Ό? google email ?Έμ¦? ??΄μ§?λ‘? ?΄?
		response.sendRedirect("/AuthGoogle/gmailSendAction.jsp?email="+email);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}