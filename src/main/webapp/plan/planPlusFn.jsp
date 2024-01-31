<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.HashMap"%>
<%@page import="vo.PlaceVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String objNo = request.getParameter("objNo");
	int no = 0;
	if(objNo != null && !objNo.equals("")){
		no = Integer.parseInt(objNo);
	}
	String objCate = request.getParameter("placeCate");
	
	DBManager dbm = DBManager.getInstance();
	dbm.DBOpen();
	
	List<Object> list = new ArrayList<Object>();
	
	String sql = "";
	
	if(objCate.equals("추천 장소")){
		sql = "select * from place where pno = ?";
	}
	if(objCate.equals("관광지")){
		sql = "select * from place where pno = ?";
	}
	if(objCate.equals("식사")){
		sql = "select * from place where fno = ?";
	}
	if(objCate.equals("숙소")){
		sql = "select * from place where ano = ?";
	}
	
	dbm.prepStmt(sql);
	dbm.setInt(1, no);
	dbm.executeQuery();
	
	PlaceVO vo = null;
	
	if(dbm.next()){
		vo = new PlaceVO(
				dbm.getInt("pno"),
				dbm.getString("pname"),
				dbm.getString("paddr1"),
				dbm.getString("paddr2"),
				dbm.getString("pcontentid"),
				dbm.getString("ptel"),
				dbm.getString("pimg1"),
				dbm.getString("pimg2"),
				dbm.getString("pmapx"),
				dbm.getString("pmapy"),
				dbm.getInt("pmlevel"));
	}
	dbm.dbClosePsmt();
	dbm.dbCloseRs();
	dbm.dbCloseConn();
	
	HashMap<String, String> hashMap = new HashMap<String, String>();
	JSONObject json = null;
	
	hashMap.put("name", vo.getPname());
	hashMap.put("addr1", vo.getPaddr1());
	hashMap.put("addr2", vo.getPaddr2());
	hashMap.put("contentid", vo.getPcontentid());
	hashMap.put("tel", vo.getPtel());
	hashMap.put("img1", vo.getPimg1());
	hashMap.put("img2", vo.getPimg2());
	hashMap.put("mapx", vo.getPmapx());
	hashMap.put("mapy", vo.getPmapy());
	hashMap.put("mlevel", Integer.toString(vo.getPmlevel()));
	json = new JSONObject(hashMap);
	
	out.print(json);
%>