package springweb.z01_vo;

public class Code {
	private String key;
	private String svalue;
	private int ivalue;
	public Code() {
	}
	public Code(String key, String svalue) {
		this.key = key;
		this.svalue = svalue;
	}
	public Code(String key, int ivalue) {
		this.key = key;
		this.ivalue = ivalue;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSvalue() {
		return svalue;
	}
	public void setSvalue(String svalue) {
		this.svalue = svalue;
	}
	public int getIvalue() {
		return ivalue;
	}
	public void setIvalue(int ivalue) {
		this.ivalue = ivalue;
	}
	
	
	
	
}
