package a01_diexp.z05_vo;

public class Ram {
	private String name;
	private String size;
	
	public void raminfo() {
		if(this.getName()!=null) {
			System.out.println("[RAM 정보]");
			System.out.println("이름:"+this.getName());
			System.out.println("용량:"+this.getSize());
		}else {
			System.out.println("[현재 삽입된 Ram 없음]");
		}
		
	}
	
	
	public Ram() {
	}
	public Ram(String name, String size) {
		this.name = name;
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
}
