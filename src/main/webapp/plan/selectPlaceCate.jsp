<%@page import="java.util.HashMap"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="vo.FoodVO"%>
<%@page import="vo.AccVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.PlaceVO"%>
<%@page import="java.util.List"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String placeCate = request.getParameter("placeCate");
	
	if(placeCate.equals("추천 장소")){
		//좋아요나 별점 댓글순으로 정렬후 보여줌 아직은 관광지로 대체
		DBManager dbm = DBManager.getInstance();
		dbm.DBOpen();
		
		String sql = "select * from place";
		dbm.prepStmt(sql);
		dbm.executeQuery();
		
		List<PlaceVO> placeVOlist = new ArrayList<PlaceVO>();
		
		while(dbm.next()){
			PlaceVO placeVO = new PlaceVO(
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
			placeVOlist.add(placeVO);
		}
		
		dbm.dbClosePsmt();
		dbm.dbCloseRs();
		dbm.dbCloseConn();
		
		//json 변환
				HashMap<String, String> aHashMap = new HashMap<String, String>();
				JSONArray jsonArray = new JSONArray();
				JSONObject json = null;
				
				for(int i=0; i<placeVOlist.size(); i++){
					PlaceVO vo = placeVOlist.get(i);
					aHashMap.put("name", vo.getPname());
					aHashMap.put("addr1", vo.getPaddr1());
					aHashMap.put("addr2", vo.getPaddr2());
					aHashMap.put("contentid", vo.getPcontentid());
					aHashMap.put("tel", vo.getPtel());
					aHashMap.put("img1", vo.getPimg1());
					aHashMap.put("img2", vo.getPimg2());
					aHashMap.put("mapx", vo.getPmapx());
					aHashMap.put("mapy", vo.getPmapy());
					aHashMap.put("mlevel", Integer.toString(vo.getPmlevel()));
					json = new JSONObject(aHashMap);
					jsonArray.add(json);
				}
				out.print(jsonArray);
	}
	if(placeCate.equals("관광지")){
		DBManager dbm = DBManager.getInstance();
		dbm.DBOpen();
		
		String sql = "select * from place";
		dbm.prepStmt(sql);
		dbm.executeQuery();
		
		List<PlaceVO> placeVOlist = new ArrayList<PlaceVO>();
		
		while(dbm.next()){
			PlaceVO placeVO = new PlaceVO(
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
			placeVOlist.add(placeVO);
		}
		
		dbm.dbClosePsmt();
		dbm.dbCloseRs();
		dbm.dbCloseConn();
		
		//json 변환
				HashMap<String, String> aHashMap = new HashMap<String, String>();
				JSONArray jsonArray = new JSONArray();
				JSONObject json = null;
				
				for(int i=0; i<placeVOlist.size(); i++){
					PlaceVO vo = placeVOlist.get(i);
					aHashMap.put("name", vo.getPname());
					aHashMap.put("addr1", vo.getPaddr1());
					aHashMap.put("addr2", vo.getPaddr2());
					aHashMap.put("contentid", vo.getPcontentid());
					aHashMap.put("tel", vo.getPtel());
					aHashMap.put("img1", vo.getPimg1());
					aHashMap.put("img2", vo.getPimg2());
					aHashMap.put("mapx", vo.getPmapx());
					aHashMap.put("mapy", vo.getPmapy());
					aHashMap.put("mlevel", Integer.toString(vo.getPmlevel()));
					json = new JSONObject(aHashMap);
					jsonArray.add(json);
				}
				out.print(jsonArray);
	}
	if(placeCate.equals("식당")){
		DBManager dbm = DBManager.getInstance();
		dbm.DBOpen();
		
		String sql = "select * from food";
		dbm.prepStmt(sql);
		dbm.executeQuery();
		
		List<FoodVO> foodVOlist = new ArrayList<FoodVO>();
		
		while(dbm.next()){
			FoodVO foodVO = new FoodVO(
					dbm.getString("fname"),
					dbm.getString("faddr1"),
					dbm.getString("faddr2"),
					dbm.getString("fcontentid"),
					dbm.getString("ftel"),
					dbm.getString("fimg1"),
					dbm.getString("fimg2"),
					dbm.getString("fmapx"),
					dbm.getString("fmapy"),
					dbm.getInt("fmlevel"));
			foodVOlist.add(foodVO);
		}
		
		dbm.dbClosePsmt();
		dbm.dbCloseRs();
		dbm.dbCloseConn();
		
		//json 변환
				HashMap<String, String> aHashMap = new HashMap<String, String>();
				JSONArray jsonArray = new JSONArray();
				JSONObject json = null;
				
				for(int i=0; i<foodVOlist.size(); i++){
					FoodVO vo = foodVOlist.get(i);
					aHashMap.put("name", vo.getFname());
					aHashMap.put("addr1", vo.getFaddr1());
					aHashMap.put("addr2", vo.getFaddr2());
					aHashMap.put("contentid", vo.getFcontentid());
					aHashMap.put("tel", vo.getFtel());
					aHashMap.put("img1", vo.getFimg1());
					aHashMap.put("img2", vo.getFimg2());
					aHashMap.put("mapx", vo.getFmapx());
					aHashMap.put("mapy", vo.getFmapy());
					aHashMap.put("mlevel", Integer.toString(vo.getFmlevel()));
					json = new JSONObject(aHashMap);
					jsonArray.add(json);
				}
				out.print(jsonArray);
	}
	if(placeCate.equals("숙소")){
		DBManager dbm = DBManager.getInstance();
		dbm.DBOpen();
		
		String sql = "select * from acc";
		dbm.prepStmt(sql);
		dbm.executeQuery();
		
		List<AccVO> accVOlist = new ArrayList<AccVO>();
		
		while(dbm.next()){
			AccVO accVO = new AccVO(
					dbm.getString("aname"),
					dbm.getString("aaddr1"),
					dbm.getString("aaddr2"),
					dbm.getString("acontentid"),
					dbm.getString("atel"),
					dbm.getString("aimg1"),
					dbm.getString("aimg2"),
					dbm.getString("amapx"),
					dbm.getString("amapy"),
					dbm.getInt("amlevel"));
			accVOlist.add(accVO);
		}
		
		dbm.dbClosePsmt();
		dbm.dbCloseRs();
		dbm.dbCloseConn();
		
		//json 변환
		HashMap<String, String> aHashMap = new HashMap<String, String>();
		JSONArray jsonArray = new JSONArray();
		JSONObject json = null;
		
		for(int i=0; i<accVOlist.size(); i++){
			AccVO vo = accVOlist.get(i);
			aHashMap.put("name", vo.getAname());
			aHashMap.put("addr1", vo.getAaddr1());
			aHashMap.put("addr2", vo.getAaddr2());
			aHashMap.put("contentid", vo.getAcontentid());
			aHashMap.put("tel", vo.getAtel());
			aHashMap.put("img1", vo.getAimg1());
			aHashMap.put("img2", vo.getAimg2());
			aHashMap.put("mapx", vo.getAmapx());
			aHashMap.put("mapy", vo.getAmapy());
			aHashMap.put("mlevel", Integer.toString(vo.getAmlevel()));
			json = new JSONObject(aHashMap);
			jsonArray.add(json);
		}
		out.print(jsonArray);
	}
%>