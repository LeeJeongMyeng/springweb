package a01_diexp.z04_vo;


public class HandPhone {
	
	private String hnumber;
	private String company;
	public HandPhone() {
	}
	public HandPhone(String hnumber, String company) {
		this.hnumber = hnumber;
		this.company = company;
	}
	public String getHnumber() {
		return hnumber;
	}
	public void setHnumber(String hnumber) {
		this.hnumber = hnumber;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
}
