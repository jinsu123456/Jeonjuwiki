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
		
		//DB ???�� ?��?���? �??�� (DB?��?�� emailAuth ?��?���? ?��?��?�� ?���? 최초?��?�� 0?�� ???��?��?�� ?��?��) 1 ?���? 0 미인�?
		
		//DB?�� ???��?��?��?�� google email ?���? ?��?���?�? ?��?��
		response.sendRedirect("/AuthGoogle/gmailSendAction.jsp?email="+email);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}