package vo;

public class BoardVO {

	int bno;
	int sno; 
	int mno;
	String btitle;
	String bcontent ;
	int bhit;
	int brecommcount; 
	String brdate; 
	String bdelyn;
	
	public BoardVO() {}
	
	public BoardVO(int bno, int sno, int mno, String btitle, String bcontent, int bhit, int brecommcount, String brdate,
			String bdelyn) {
		super();
		this.bno = bno;
		this.sno = sno;
		this.mno = mno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bhit = bhit;
		this.brecommcount = brecommcount;
		this.brdate = brdate;
		this.bdelyn = bdelyn;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public int getBhit() {
		return bhit;
	}

	public void setBhit(int bhit) {
		this.bhit = bhit;
	}

	public int getBrecommcount() {
		return brecommcount;
	}

	public void setBrecommcount(int brecommcount) {
		this.brecommcount = brecommcount;
	}

	public String getBrdate() {
		return brdate;
	}

	public void setBrdate(String brdate) {
		this.brdate = brdate;
	}

	public String getBdelyn() {
		return bdelyn;
	}

	public void setBdelyn(String bdelyn) {
		this.bdelyn = bdelyn;
	}
	
	
	
}
