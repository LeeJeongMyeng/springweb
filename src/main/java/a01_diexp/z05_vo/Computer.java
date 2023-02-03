package a01_diexp.z05_vo;

import org.springframework.beans.factory.annotation.Autowired;


public class Computer {
	private String company;
	@Autowired
	private Ram ram;
	
	public void cominfo() {
		System.out.println("제조사:"+company);
		ram.raminfo();
	}
	
	public Computer() {
	}
	public Computer(String company) {
		this.company = company;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Ram getRam() {
		return ram;
	}
	public void setRam(Ram ram) {
		this.ram = ram;
	}
	
	
}
