package a01_diexp.z01_vo;

import java.util.List;

public class ShoppingMall {
	private String sname;
	private List<MemberVO> mlist;
	
	
	public void MemberList() {
		if(mlist!=null && mlist.size()>0) {
			System.out.println("<"+sname+"쇼핑몰 회원리스트>");
			for(MemberVO m: mlist) {
				System.out.print("이름:"+m.getName()+"\t");
				System.out.print("아이디:"+m.getId()+"\t");
				System.out.print("비밀번호:"+m.getPass()+"\t");
				System.out.print("권한:"+m.getAuthority()+"\t");
				System.out.println("포인트:"+m.getPass());
			}
		}else {
			System.out.println("회원이 없습니다.");
		}
		
	}
	
	public ShoppingMall() {
	}
	public ShoppingMall(String sname) {
		this.sname = sname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public List<MemberVO> getMlist() {
		return mlist;
	}
	public void setMlist(List<MemberVO> mlist) {
		this.mlist = mlist;
	}
	
	
	
}
