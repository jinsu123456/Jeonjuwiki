package vo;

public class PlaceVO {
	private String pno;
	private String pname;
	private String paddr1;
	private String paddr2;
	private String pcontentid;
	private String ptel;
	private String pimg1;
	private String pimg2;
	private String pmapx;
	private String pmapy;
	private String pmlevel;
	
	public PlaceVO(){};
	
	public PlaceVO(String pno, String pname, String paddr1, String paddr2, String pcontentid, String ptel, String pimg1,
			String pimg2, String pmapx, String pmapy, String pmlevel) {
		this.pno = pno;
		this.pname = pname;
		this.paddr1 = paddr1;
		this.paddr2 = paddr2;
		this.pcontentid = pcontentid;
		this.ptel = ptel;
		this.pimg1 = pimg1;
		this.pimg2 = pimg2;
		this.pmapx = pmapx;
		this.pmapy = pmapy;
		this.pmlevel = pmlevel;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPaddr1() {
		return paddr1;
	}
	public void setPaddr1(String paddr1) {
		this.paddr1 = paddr1;
	}
	public String getPaddr2() {
		return paddr2;
	}
	public void setPaddr2(String paddr2) {
		this.paddr2 = paddr2;
	}
	public String getPcontentid() {
		return pcontentid;
	}
	public void setPcontentid(String pcontentid) {
		this.pcontentid = pcontentid;
	}
	public String getPtel() {
		return ptel;
	}
	public void setPtel(String ptel) {
		this.ptel = ptel;
	}
	public String getPimg1() {
		return pimg1;
	}
	public void setPimg1(String pimg1) {
		this.pimg1 = pimg1;
	}
	public String getPimg2() {
		return pimg2;
	}
	public void setPimg2(String pimg2) {
		this.pimg2 = pimg2;
	}
	public String getPmapx() {
		return pmapx;
	}
	public void setPmapx(String pmapx) {
		this.pmapx = pmapx;
	}
	public String getPmapy() {
		return pmapy;
	}
	public void setPmapy(String pmapy) {
		this.pmapy = pmapy;
	}
	public String getPmlevel() {
		return pmlevel;
	}
	public void setPmlevel(String pmlevel) {
		this.pmlevel = pmlevel;
	}
}
