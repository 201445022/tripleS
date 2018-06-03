package db;

public class Bean {
	private String strCompany; // 상호명
	private String strManager; // 담당자
	private String strTel; // 연락처
	private String strFax; // 팩스
	private String strEmail; // 이메일
	public String getStrCompany() {
		return strCompany;
	}
	public void setStrCompany(String strCompany) {
		this.strCompany = strCompany;
	}
	public String getStrManager() {
		return strManager;
	}
	public void setStrManager(String strManager) {
		this.strManager = strManager;
	}
	public String getStrTel() {
		return strTel;
	}
	public void setStrTel(String strTel) {
		this.strTel = strTel;
	}
	public String getStrFax() {
		return strFax;
	}
	public void setStrFax(String strFax) {
		this.strFax = strFax;
	}
	public String getStrEmail() {
		return strEmail;
	}
	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}
}
