package a01_diexp.z04_vo;

public class HPUser {
	
	
	private String name;
	private HandPhone handPhone;
	public HPUser() {
	}
	public HPUser(String name) {
		super();
		this.name = name;
	}
	
	public void usingMyPhone() {
		System.out.println("이름:"+name);
		if(handPhone!=null) {
			System.out.println("소유폰은");
			System.out.println("폰번호:"+handPhone.getHnumber());
			System.out.println("제조사:"+handPhone.getCompany());
		}else{
			System.out.println("폰이 없습니다.");
		}
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public HandPhone getHandPhone() {
		return handPhone;
	}
	public void setHandPhone(HandPhone handPhone) {
		this.handPhone = handPhone;
	}
	
	//autowire="byName"으로하면 객체가 id명과 setXXX property가 동일하면
	//해당 메서드를 통해 객체가 할당이된다.
	public void setHp01(HandPhone handPhone) {
		this.handPhone = handPhone;
	}
	public void setHp02(HandPhone handPhone) {
		this.handPhone = handPhone;
	}
	
	
	
}
