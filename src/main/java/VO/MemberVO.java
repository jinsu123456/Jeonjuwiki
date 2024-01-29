package VO;

public class MemberVO {

	int mno;
	String mid;
	String mpw;
	String mphone;
	String memail;
	String mnick;
	String mrdate;
	int mgrade;
	String mpimg_realnm;
	String mname;
	String memail_hash;
	
	
	public MemberVO() {}

	public MemberVO(int mno, String mid, String mpw, String mphone, String memail, String mnick, String mrdate,
			int mgrade, String mpimg_realnm, String mname, String memail_hash) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
		this.mphone = mphone;
		this.memail = memail;
		this.mnick = mnick;
		this.mrdate = mrdate;
		this.mgrade = mgrade;
		this.mpimg_realnm = mpimg_realnm;
		this.mname = mname;
		this.memail_hash = memail_hash;
	}

	
	public String getMemail_hash() {
		return memail_hash;
	}
	public void setMemail_hash(String memail_hash) {
		this.memail_hash = memail_hash;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMnick() {
		return mnick;
	}
	public void setMnick(String mnick) {
		this.mnick = mnick;
	}
	public String getMrdate() {
		return mrdate;
	}
	public void setMrdate(String mrdate) {
		this.mrdate = mrdate;
	}
	public int getMgrade() {
		return mgrade;
	}
	public void setMgrade(int mgrade) {
		this.mgrade = mgrade;
	}
	public String getMpimg_realnm() {
		return mpimg_realnm;
	}
	public void setMpimg_realnm(String mpimg_realnm) {
		this.mpimg_realnm = mpimg_realnm;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	
	
	
}
