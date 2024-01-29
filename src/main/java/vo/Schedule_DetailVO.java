package vo;

public class Schedule_DetailVO {
	
	int sdno;
	int sno;
	int mno;
	String sddate;
	
	public Schedule_DetailVO() {}
	
	public Schedule_DetailVO(int sdno, int sno, int mno, String sddate) {
		super();
		this.sdno = sdno;
		this.sno = sno;
		this.mno = mno;
		this.sddate = sddate;
	}

	public int getSdno() {
		return sdno;
	}

	public void setSdno(int sdno) {
		this.sdno = sdno;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getSddate() {
		return sddate;
	}

	public void setSddate(String sddate) {
		this.sddate = sddate;
	}
	
}
