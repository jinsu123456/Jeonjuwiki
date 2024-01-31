package vo;

public class FoodVO {
	private String fno;
	private String fname;
	private String faddr1;
	private String faddr2;
	private String fcontentid;
	private String ftel;
	private String fimg1;
	private String fimg2;
	private String fmapx;
	private String fmapy;
	private int fmlevel;
	
	public FoodVO() {}
	
	public FoodVO(String fname, String faddr1, String faddr2, String fcontentid, String ftel, String fimg1,
			String fimg2, String fmapx, String fmapy, int fmlevel) {
		this.fname = fname;
		this.faddr1 = faddr1;
		this.faddr2 = faddr2;
		this.fcontentid = fcontentid;
		this.ftel = ftel;
		this.fimg1 = fimg1;
		this.fimg2 = fimg2;
		this.fmapx = fmapx;
		this.fmapy = fmapy;
		this.fmlevel = fmlevel;
	}
	
	public String getFno() {
		return fno;
	}
	public void setFno(String fno) {
		this.fno = fno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFaddr1() {
		return faddr1;
	}
	public void setFaddr1(String faddr1) {
		this.faddr1 = faddr1;
	}
	public String getFaddr2() {
		return faddr2;
	}
	public void setFaddr2(String faddr2) {
		this.faddr2 = faddr2;
	}
	public String getFcontentid() {
		return fcontentid;
	}
	public void setFcontentid(String fcontentid) {
		this.fcontentid = fcontentid;
	}
	public String getFtel() {
		return ftel;
	}
	public void setFtel(String ftel) {
		this.ftel = ftel;
	}
	public String getFimg1() {
		return fimg1;
	}
	public void setFimg1(String fimg1) {
		this.fimg1 = fimg1;
	}
	public String getFimg2() {
		return fimg2;
	}
	public void setFimg2(String fimg2) {
		this.fimg2 = fimg2;
	}
	public String getFmapx() {
		return fmapx;
	}
	public void setFmapx(String fmapx) {
		this.fmapx = fmapx;
	}
	public String getFmapy() {
		return fmapy;
	}
	public void setFmapy(String fmapy) {
		this.fmapy = fmapy;
	}
	public int getFmlevel() {
		return fmlevel;
	}
	public void setFmlevel(int fmlevel) {
		this.fmlevel = fmlevel;
	}
	
}
