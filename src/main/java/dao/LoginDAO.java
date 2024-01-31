package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;
import vo.MemberVO;

public class LoginDAO {

	DBManager DBM = DBManager.getInstance();
	
	public MemberVO login(String mid, String mpass) throws SQLException{
		
		MemberVO m = null;
		
		try{
			DBM.DBOpen();
			
			String sql = "SELECT * FROM member WHERE mid = ? AND mpassword = ?";
			
			DBM.prepStmt(sql);
			
			List<Object> list = new ArrayList<>();
			list.add(mid);
			list.add(mpass);
			DBM.setStringInt(list);
			
			DBM.executeQuery();
			
			if(DBM.next()) {
				m = new MemberVO();
				m.setMno(DBM.getRs().getInt("mno"));
				m.setMid(DBM.getRs().getString("mid"));
				m.setMname(DBM.getRs().getString("mname"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBM.dbCloseConn();
			DBM.dbClosePsmt();
			DBM.dbCloseRs();
		}
		
		return m;
		
	}
	
}
