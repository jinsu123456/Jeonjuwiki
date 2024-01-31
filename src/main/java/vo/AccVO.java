package vo;

public class AccVO {
	private String ano;
	private String aname;
	private String aaddr1;
	private String aaddr2;
	private String acontentid;
	private String atel;
	private String aimg1;
	private String aimg2;
	private String amapx;
	private String amapy;
	private int amlevel;
	
	public AccVO() {}

	public AccVO(String aname, String aaddr1, String aaddr2, String acontentid, String atel, String aimg1, String aimg2,
			String amapx, String amapy, int amlevel) {
		super();
		this.aname = aname;
		this.aaddr1 = aaddr1;
		this.aaddr2 = aaddr2;
		this.acontentid = acontentid;
		this.atel = atel;
		this.aimg1 = aimg1;
		this.aimg2 = aimg2;
		this.amapx = amapx;
		this.amapy = amapy;
		this.amlevel = amlevel;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAaddr1() {
		return aaddr1;
	}

	public void setAaddr1(String aaddr1) {
		this.aaddr1 = aaddr1;
	}

	public String getAaddr2() {
		return aaddr2;
	}

	public void setAaddr2(String aaddr2) {
		this.aaddr2 = aaddr2;
	}

	public String getAcontentid() {
		return acontentid;
	}

	public void setAcontentid(String acontentid) {
		this.acontentid = acontentid;
	}

	public String getAtel() {
		return atel;
	}

	public void setAtel(String atel) {
		this.atel = atel;
	}

	public String getAimg1() {
		return aimg1;
	}

	public void setAimg1(String aimg1) {
		this.aimg1 = aimg1;
	}

	public String getAimg2() {
		return aimg2;
	}

	public void setAimg2(String aimg2) {
		this.aimg2 = aimg2;
	}

	public String getAmapx() {
		return amapx;
	}

	public void setAmapx(String amapx) {
		this.amapx = amapx;
	}

	public String getAmapy() {
		return amapy;
	}

	public void setAmapy(String amapy) {
		this.amapy = amapy;
	}

	public int getAmlevel() {
		return amlevel;
	}

	public void setAmlevel(int amlevel) {
		this.amlevel = amlevel;
	}
}
