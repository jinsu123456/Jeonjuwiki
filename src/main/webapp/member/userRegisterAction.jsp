<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="vo.MemberVO"%>
<%@page import="dao.MemberDAO"%>
<%@ page import="util.SHA256"%>
<%@ page import="java.io.PrintWriter"%>

<%
	request.setCharacterEncoding("UTF-8");

	/* 로그인한 상태라면 가입을 진행할 수 없다. */
	String mid = request.getParameter("mid");
	String mpw = request.getParameter("mpw");
	String mphone = request.getParameter("mphone");
	String memail = request.getParameter("memail");
	String mnick = request.getParameter("mnick");
	String mname = request.getParameter("mname");
	
	
	/********** 입력하지 않은 사항이 있을 때 처리 ***********/
	
	if(mid == null || mpw == null || memail == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력을 다시 확인해주세요');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	}
	
	MemberDAO memberDAO = new MemberDAO();
	MemberVO memberVO = new MemberVO();
	memberVO.setMid(mid);
	memberVO.setMpw(mpw);
	memberVO.setMphone(mphone);
	memberVO.setMemail(memail);
	memberVO.setMnick(mnick);
	memberVO.setMname(mname);
	memberVO.setMemail_hash(SHA256.getSHA256(memail));
	
	int result = memberDAO.join(memberVO);
	
	if(result == -1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 존재하는 아이디입니다.');");
		script.println("history.back();"); 
		script.println("</script>");
		script.close();
	} else{
		session.setAttribute("mid", mid);    // ID 등록
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href = 'emailSendAction.jsp'"); // 이메일 인증
		script.println("</script>");
		script.close();
	}
	
%>