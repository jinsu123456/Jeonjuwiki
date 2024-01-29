package VO;

public class Board_ReplyVO {

	int brno; 
	int bno;
	int mno;
	String brcontent;
	String brrdate;
	String brdelyn;
	
	public Board_ReplyVO() {}
	
	public Board_ReplyVO(int brno, int bno, int mno, String brcontent, String brrdate, String brdelyn) {
		super();
		this.brno = brno;
		this.bno = bno;
		this.mno = mno;
		this.brcontent = brcontent;
		this.brrdate = brrdate;
		this.brdelyn = brdelyn;
	}

	public int getBrno() {
		return brno;
	}

	public void setBrno(int brno) {
		this.brno = brno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getBrcontent() {
		return brcontent;
	}

	public void setBrcontent(String brcontent) {
		this.brcontent = brcontent;
	}

	public String getBrrdate() {
		return brrdate;
	}

	public void setBrrdate(String brrdate) {
		this.brrdate = brrdate;
	}

	public String getBrdelyn() {
		return brdelyn;
	}

	public void setBrdelyn(String brdelyn) {
		this.brdelyn = brdelyn;
	}
	
	
}
