package vo;

public class Schedule {

	int sno;
	String stitle;
	String srdate;
	String sdelyn;
	int mno;
	
	public Schedule() {}
	
	public Schedule(int sno, String stitle, String srdate, String sdelyn, int mno) {
		super();
		this.sno = sno;
		this.stitle = stitle;
		this.srdate = srdate;
		this.sdelyn = sdelyn;
		this.mno = mno;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getStitle() {
		return stitle;
	}

	public void setStitle(String stitle) {
		this.stitle = stitle;
	}

	public String getSrdate() {
		return srdate;
	}

	public void setSrdate(String srdate) {
		this.srdate = srdate;
	}

	public String getSdelyn() {
		return sdelyn;
	}

	public void setSdelyn(String sdelyn) {
		this.sdelyn = sdelyn;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}
	
	
}
