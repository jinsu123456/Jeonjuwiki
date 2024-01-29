package VO;

public class Board_ImgVO {

	int bino;
	int bno;
	int mno;
	
	public Board_ImgVO() {}
	
	public Board_ImgVO(int bino, int bno, int mno) {
		super();
		this.bino = bino;
		this.bno = bno;
		this.mno = mno;
	}

	public int getBino() {
		return bino;
	}

	public void setBino(int bino) {
		this.bino = bino;
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
	
}