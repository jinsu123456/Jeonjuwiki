package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;
import vo.MemberVO;

public class MemberDAO {

	DBManager DBM = DBManager.getInstance();
	
	// ?šŒ?›ê°??… ë©”ì†Œ?“œ
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
