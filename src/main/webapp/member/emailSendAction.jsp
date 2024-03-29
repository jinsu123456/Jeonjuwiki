<%@page import="javax.mail.internet.MimeMessage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.mail.*"%>
<%@ page import="util.Gmail"%>
<%@ page import="util.SHA256"%>
<%@ page import="java.util.Properties"%>
<%@ page import="java.io.PrintWriter"%>
<%@page import="dao.MemberDAO"%>
<%@page import="vo.MemberVO"%>

<%
	MemberDAO memberDAO = new MemberDAO();
	MemberVO memberVO = new MemberVO();
	String userID = null;
	
	if(session.getAttribute("userID") != null){
		userID = (String) session.getAttribute("userID");
	}
	
	if(userID == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 해주세요');");
		script.println("location.href ='userLogin.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
	
//	boolean emailChecked = memberDAO.getUserEmailChecked(userID);

	/* if(emailChecked){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 인증이 완료된 회원입니다.');");
		script.println("location.href ='index.jsp'"); 
		script.println("</script>");
		script.close();
		return;
	}  */
	
	// 사용자 인증 이메일 발송 내용
	String host = "http://192.168.0.123/jeonjuwiki/";
	String from = "ezentester@gmail.com";
	String to = memberVO.getMemail();
	String subject = "회원가입 이메일 인증 메일"; 
	String content = "링크에 접속해 이메일 인증을 진행해주세요." +
		"<a href='" + host + "emailCheckAction.jsp?code=" + new SHA256().getSHA256(to) + "'>이메일 인증하기</a>";
	
	// 이메일 전송 : SMTP 이용을 위함
	Properties p = new Properties();
	p.put("mail.smtp.user", from);
	p.put("mail.smtp.host", "smtp.googlemail.com"); // google SMTP 주소
	p.put("mail.smtp.port", "465");
	p.put("mail.smtp.starttls.enable", "true");
	p.put("mail.smtp.auth", "true");
	p.put("mail.smtp.debug", "true");
	p.put("mail.smtp.socketFactory.port", "465");
	p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	p.put("mail.smtp.socketFactory.fallback", "false");
	p.put("mail.smtp.ssl.protocols", "TLSv1.2"); // 추가된 코드
	p.put("mail.smtp.ssl.enable", "true");  // 추가된 코드

	try {
		Authenticator auth = new Gmail();
	    Session ses = Session.getInstance(p, auth);
	    ses.setDebug(true);
	    MimeMessage msg = new MimeMessage(ses); 
	    msg.setSubject(subject);		// 메일 제목
	    Address fromAddr = new InternetAddress(from); 	// 보내는 사람 정보
	    msg.setFrom(fromAddr);
	    Address toAddr = new InternetAddress(to);		// 받는 사람 정보
	    msg.addRecipient(Message.RecipientType.TO, toAddr);
	    msg.setContent(content, "text/html;charset=UTF-8");
	    Transport.send(msg); // 메세지 전송
	    
	}catch (Exception e) {
		e.printStackTrace();
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('메일 전송 중 오류가 발생했습니다.');");
		script.println("history.back();"); 
		script.println("</script>");
		script.close();
	}
%>