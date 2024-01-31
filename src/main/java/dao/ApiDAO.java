package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import util.DBManager;
import vo.AccVO;
import vo.FoodVO;
import vo.PlaceVO;

public class ApiDAO {
	
	//관광지 api데이터 DB에 insert
	public int place() throws IOException {
		int result = 0;
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/areaBasedList1");
		urlBuilder.append("?" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("83", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8"));
		urlBuilder
				.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("Jeonjuwiki", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + 
				"EltYgOtgsmzMXzOm4K7Tr6k8EBk4W3tuB7y0Pd8nY5RzJh69mMhNwnsNBj%2FbF95qdG6IegUlPkSlIoLDaRfaJg%3D%3D");
		urlBuilder.append("&" + URLEncoder.encode("listYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=" + URLEncoder.encode("O", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=" + URLEncoder.encode("12", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + URLEncoder.encode("37", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("sigunguCode", "UTF-8") + "=" + URLEncoder.encode("12", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("cat1", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("cat2", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("cat3", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json;charset=UTF-8");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();

		try {
			JSONParser jsonParser = new JSONParser();

			Object obj = jsonParser.parse(sb.toString());
			
			JSONObject jsonObj = (JSONObject) obj;
			JSONObject jsonObj2 = (JSONObject) jsonObj.get("response");
			JSONObject jsonObj3 = (JSONObject) jsonObj2.get("body");
			JSONObject jsonObj4 = (JSONObject) jsonObj3.get("items");
			JSONArray jsonObj5 = (JSONArray) jsonObj4.get("item");

			String contentid = "";
			String title = "";
			String addr1 = "";
			String addr2 = "";
			String mapx = "";
			String mapy = "";
			int mlevel = 00;
			String tel = "";
			String firstimage = "";
			String firstimage2 = "";
			
			List<PlaceVO> placeVOlist = new ArrayList<PlaceVO>();

			for (int i = 0; i < jsonObj5.size(); i++) {
				JSONObject jsonObj6 = (JSONObject) jsonObj5.get(i);
				contentid = (String) jsonObj6.get("contentid");
				title = (String) jsonObj6.get("title");
				addr1 = (String) jsonObj6.get("addr1");
				addr2 = (String) jsonObj6.get("addr2");
				mapx = (String) jsonObj6.get("mapx");
				mapy = (String) jsonObj6.get("mapy");
				if((String)jsonObj6.get("mlevel")!=null && !((String)jsonObj6.get("mlevel")).equals("")) {
					mlevel = Integer.parseInt((String)jsonObj6.get("mlevel"));
				}
				tel = (String) jsonObj6.get("tel");
				firstimage = (String) jsonObj6.get("firstimage");
				firstimage2 = (String) jsonObj6.get("firstimage2");
				PlaceVO placeVO = new PlaceVO(title, addr1, addr2, contentid, tel, firstimage, firstimage2, mapx, mapy,
						mlevel);
				placeVOlist.add(placeVO);
			}

			DBManager dbm = DBManager.getInstance();
			dbm.DBOpen();
			
			for (int i = 0; i < placeVOlist.size(); i++) {
				String sql = "insert into place (pname,paddr1,paddr2,pcontentid,ptel,pimg1,pimg2,pmapx,pmapy,pmlevel) values(?,?,?,?,?,?,?,?,?,?) ";
				dbm.prepStmt(sql);
				List<Object> list = new ArrayList<Object>();
				list.add(placeVOlist.get(i).getPname());
				list.add(placeVOlist.get(i).getPaddr1());
				list.add(placeVOlist.get(i).getPaddr2());
				list.add(placeVOlist.get(i).getPcontentid());
				list.add(placeVOlist.get(i).getPtel());
				list.add(placeVOlist.get(i).getPimg1());
				list.add(placeVOlist.get(i).getPimg2());
				list.add(placeVOlist.get(i).getPmapx());
				list.add(placeVOlist.get(i).getPmapy());
				list.add(placeVOlist.get(i).getPmlevel());
				dbm.setStringInt(list);
				result = dbm.executeUpdate();
				dbm.dbClosePsmt();
			}
			dbm.dbCloseConn();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//음식점 api데이터 DB에 insert
	public int food() throws IOException {
		int result = 0;
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/areaBasedList1");
		urlBuilder.append("?" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("121", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8"));
		urlBuilder
				.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("Jeonjuwiki", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + 
				"EltYgOtgsmzMXzOm4K7Tr6k8EBk4W3tuB7y0Pd8nY5RzJh69mMhNwnsNBj%2FbF95qdG6IegUlPkSlIoLDaRfaJg%3D%3D");
		urlBuilder.append("&" + URLEncoder.encode("listYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=" + URLEncoder.encode("O", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=" + URLEncoder.encode("39", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + URLEncoder.encode("37", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("sigunguCode", "UTF-8") + "=" + URLEncoder.encode("12", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("cat1", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("cat2", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("cat3", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json;charset=UTF-8");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();

		System.out.println(sb.toString());
		
		try {
			JSONParser jsonParser = new JSONParser();

			Object obj = jsonParser.parse(sb.toString());
			
			JSONObject jsonObj = (JSONObject) obj;
			JSONObject jsonObj2 = (JSONObject) jsonObj.get("response");
			JSONObject jsonObj3 = (JSONObject) jsonObj2.get("body");
			JSONObject jsonObj4 = (JSONObject) jsonObj3.get("items");
			JSONArray jsonObj5 = (JSONArray) jsonObj4.get("item");

			String contentid = "";
			String title = "";
			String addr1 = "";
			String addr2 = "";
			String mapx = "";
			String mapy = "";
			int mlevel = 00;
			String tel = "";
			String firstimage = "";
			String firstimage2 = "";
			
			List<FoodVO> FoodVOlist = new ArrayList<FoodVO>();

			for (int i = 0; i < jsonObj5.size(); i++) {
				JSONObject jsonObj6 = (JSONObject) jsonObj5.get(i);
				contentid = (String) jsonObj6.get("contentid");
				title = (String) jsonObj6.get("title");
				addr1 = (String) jsonObj6.get("addr1");
				addr2 = (String) jsonObj6.get("addr2");
				mapx = (String) jsonObj6.get("mapx");
				mapy = (String) jsonObj6.get("mapy");
				if((String)jsonObj6.get("mlevel")!=null && !((String)jsonObj6.get("mlevel")).equals("")) {
					mlevel = Integer.parseInt((String)jsonObj6.get("mlevel"));
				}
				tel = (String) jsonObj6.get("tel");
				firstimage = (String) jsonObj6.get("firstimage");
				firstimage2 = (String) jsonObj6.get("firstimage2");
				FoodVO foodVO = new FoodVO(title, addr1, addr2, contentid, tel, firstimage, firstimage2, mapx, mapy,
						mlevel);
				FoodVOlist.add(foodVO);
			}

			DBManager dbm = DBManager.getInstance();
			dbm.DBOpen();
			
			for (int i = 0; i < FoodVOlist.size(); i++) {
				String sql = "insert into food (fname,faddr1,faddr2,fcontentid,ftel,fimg1,fimg2,fmapx,fmapy,fmlevel) values(?,?,?,?,?,?,?,?,?,?) ";
				dbm.prepStmt(sql);
				List<Object> list = new ArrayList<Object>();
				list.add(FoodVOlist.get(i).getFname());
				list.add(FoodVOlist.get(i).getFaddr1());
				list.add(FoodVOlist.get(i).getFaddr2());
				list.add(FoodVOlist.get(i).getFcontentid());
				list.add(FoodVOlist.get(i).getFtel());
				list.add(FoodVOlist.get(i).getFimg1());
				list.add(FoodVOlist.get(i).getFimg2());
				list.add(FoodVOlist.get(i).getFmapx());
				list.add(FoodVOlist.get(i).getFmapy());
				list.add(FoodVOlist.get(i).getFmlevel());
				dbm.setStringInt(list);
				result = dbm.executeUpdate();
				dbm.dbClosePsmt();
			}
			dbm.dbCloseConn();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//숙소 api데이터 DB에 insert
		public int acc() throws IOException {
			int result = 0;
			
			StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/areaBasedList1");
			urlBuilder.append("?" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("113", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8"));
			urlBuilder
					.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("Jeonjuwiki", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + 
					"EltYgOtgsmzMXzOm4K7Tr6k8EBk4W3tuB7y0Pd8nY5RzJh69mMhNwnsNBj%2FbF95qdG6IegUlPkSlIoLDaRfaJg%3D%3D");
			urlBuilder.append("&" + URLEncoder.encode("listYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=" + URLEncoder.encode("O", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=" + URLEncoder.encode("32", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + URLEncoder.encode("37", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("sigunguCode", "UTF-8") + "=" + URLEncoder.encode("12", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("cat1", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("cat2", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("cat3", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json;charset=UTF-8");
			System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();

			System.out.println(sb.toString());
			
			try {
				JSONParser jsonParser = new JSONParser();

				Object obj = jsonParser.parse(sb.toString());
				
				JSONObject jsonObj = (JSONObject) obj;
				JSONObject jsonObj2 = (JSONObject) jsonObj.get("response");
				JSONObject jsonObj3 = (JSONObject) jsonObj2.get("body");
				JSONObject jsonObj4 = (JSONObject) jsonObj3.get("items");
				JSONArray jsonObj5 = (JSONArray) jsonObj4.get("item");

				String contentid = "";
				String title = "";
				String addr1 = "";
				String addr2 = "";
				String mapx = "";
				String mapy = "";
				int mlevel = 00;
				String tel = "";
				String firstimage = "";
				String firstimage2 = "";
				
				List<AccVO> AccVOlist = new ArrayList<AccVO>();

				for (int i = 0; i < jsonObj5.size(); i++) {
					JSONObject jsonObj6 = (JSONObject) jsonObj5.get(i);
					contentid = (String) jsonObj6.get("contentid");
					title = (String) jsonObj6.get("title");
					addr1 = (String) jsonObj6.get("addr1");
					addr2 = (String) jsonObj6.get("addr2");
					mapx = (String) jsonObj6.get("mapx");
					mapy = (String) jsonObj6.get("mapy");
					if((String)jsonObj6.get("mlevel")!=null && !((String)jsonObj6.get("mlevel")).equals("")) {
						mlevel = Integer.parseInt((String)jsonObj6.get("mlevel"));
					}
					tel = (String) jsonObj6.get("tel");
					firstimage = (String) jsonObj6.get("firstimage");
					firstimage2 = (String) jsonObj6.get("firstimage2");
					AccVO accVO = new AccVO(title, addr1, addr2, contentid, tel, firstimage, firstimage2, mapx, mapy,
							mlevel);
					AccVOlist.add(accVO);
				}

				DBManager dbm = DBManager.getInstance();
				dbm.DBOpen();
				
				for (int i = 0; i < AccVOlist.size(); i++) {
					String sql = "insert into acc (aname,aaddr1,aaddr2,acontentid,atel,aimg1,aimg2,amapx,amapy,amlevel) values(?,?,?,?,?,?,?,?,?,?) ";
					dbm.prepStmt(sql);
					List<Object> list = new ArrayList<Object>();
					list.add(AccVOlist.get(i).getAname());
					list.add(AccVOlist.get(i).getAaddr1());
					list.add(AccVOlist.get(i).getAaddr2());
					list.add(AccVOlist.get(i).getAcontentid());
					list.add(AccVOlist.get(i).getAtel());
					list.add(AccVOlist.get(i).getAimg1());
					list.add(AccVOlist.get(i).getAimg2());
					list.add(AccVOlist.get(i).getAmapx());
					list.add(AccVOlist.get(i).getAmapy());
					list.add(AccVOlist.get(i).getAmlevel());
					dbm.setStringInt(list);
					result = dbm.executeUpdate();
					dbm.dbClosePsmt();
				}
				dbm.dbCloseConn();

			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
}
