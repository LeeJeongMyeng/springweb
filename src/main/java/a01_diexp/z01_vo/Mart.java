package a01_diexp.z01_vo;

import java.util.List;

public class Mart {
	private String mname;
	private List<Product> plist;
	
	
	public void buyList() {
		System.out.println("<"+mname+"에서 구매한 목록>");
		if(plist!=null && plist.size()>0) {
			for(Product p : plist) {
				System.out.print(p.getProduct()+"\t");
				System.out.print(p.getPrice()+"\t");
				System.out.print(p.getCnt()+"\n");
			}
		}else {
			System.out.println("아직 구매한 물건이 없습니다.");
		}
	}


	public Mart(String mname) {
		this.mname = mname;
	}


	public Mart() {
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public List<Product> getPlist() {
		return plist;
	}


	public void setPlist(List<Product> plist) {
		this.plist = plist;
	}


	
	
	
}
