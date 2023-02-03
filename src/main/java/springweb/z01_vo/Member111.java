package springweb.z01_vo;

public class Member111 {
	private String mid;
	private String pass;
	private String name;
	private String auth;
	public Member111() {
	}
	public Member111(String mid, String pass, String name, String auth) {
		this.mid = mid;
		this.pass = pass;
		this.name = name;
		this.auth = auth;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
	
}
