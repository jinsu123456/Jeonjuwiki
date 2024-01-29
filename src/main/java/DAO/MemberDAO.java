package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VO.MemberVO;
import util.DBManager;

public class MemberDAO {

	DBManager DBM = DBManager.getInstance();
	
	// 회원가입 메소드
	public int join(MemberVO vo) throws SQLException {
		
		String sql = "INSERT INTO member (mid, mpw, mphone, memail, mnick, mrdate, mgrade, mpimg_realnm, mname, memail_hash) ";
			   sql+= "VALUES (?, ?, ?, ?, ?, now(), 'N', null, ?, ?)";
			   
		DBM.DBOpen();
		
		DBM.prepStmt(sql);
		
		List<Object> list = new ArrayList<>();
		list.add(vo.getMid());
		list.add(vo.getMpw());
		list.add(vo.getMphone());
		list.add(vo.getMemail());
		list.add(vo.getMnick());
		list.add(vo.getMname());
		list.add(vo.getMemail_hash());
		
		DBM.setStringInt(list);
		
		int result = 0;
		
		result = DBM.executeUpdate();
		
		return result;
	}
	
}
