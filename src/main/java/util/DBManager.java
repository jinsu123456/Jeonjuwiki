package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	
	private static DBManager DBM = new DBManager();
	
	private String host;	
	private String uID;		
	private String uPW;	
	
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	public PreparedStatement getPsmt() {
		return psmt;
	}
	public void setPsmt(PreparedStatement psmt) {
		this.psmt = psmt;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
	
	// 생성자
	private DBManager() {
		this.host = "jdbc:mysql://192.168.0.123/jeonjuwiki";
		this.host += "?useUnicode=true";
		this.host += "&characterEncoding=utf-8";
		this.host += "&serverTimezone=UTC";
		
		this.uID = "ezen";
		this.uPW = "aws3rd";
	}
	
	public void setConn(Connection conn) { 
		this.conn = conn; 
	}
	public Connection getConn() {
		return conn; 
	}
	
	// DBM 인스턴스 반환
	public static DBManager getInstance() {
		return DBM;
	}
	
	// DB 연결 메소드
	public boolean DBOpen(){
		try{	
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection(host, uID, uPW);
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// prepareStatement 메소드
	public PreparedStatement prepStmt(String sql) {
		
		try {
			this.psmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return psmt;
	}
	
	// psmt.setString(), setInt() 메소드
	public void setStringInt(List<Object> list) {
		try {
			for(int i=0; i<list.size(); i++) {
				if(list.get(i) instanceof String) {
					this.psmt.setString(i+1, (String)list.get(i));
				}else {
					this.psmt.setInt(i+1, (int)list.get(i));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void setInt(int num1, int num2) throws SQLException {
		this.psmt.setInt(num1, num2);
	}
	
	public void setString(int num1, String str) throws SQLException {
		this.psmt.setString(num1, str);
	}
	
	// executeQuery() 메소드
	public void executeQuery() throws SQLException {
		setRs(this.psmt.executeQuery());
	}
	
	// rs.next() 메소드
	public boolean next() throws SQLException {
		return this.rs.next();
	}
	
	// executeUpdate() 메소드
	public int executeUpdate() throws SQLException {
		return this.psmt.executeUpdate();
	}
	
	public int getInt(String colName) throws SQLException{
		return this.rs.getInt(colName);
	}
	
	public String getString(String colName) throws SQLException{
		return this.rs.getString(colName);
	}
	
	
	
	// DB 종료 메소드
	public boolean dbCloseConn(){
		try{
			if(this.conn!=null) this.conn.close();
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean dbCloseRs(){
		try{
			if(this.rs!=null) this.rs.close();
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean dbClosePsmt(){
		try{
			if(this.psmt!=null) this.psmt.close();
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
}