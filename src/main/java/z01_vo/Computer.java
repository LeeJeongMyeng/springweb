package z01_vo;

public class Computer {
	private String company;
	private int price;
	private String kind;
	public Computer() {
	}
	public Computer(String company, int price, String kind) {
		this.company = company;
		this.price = price;
		this.kind = kind;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
}
