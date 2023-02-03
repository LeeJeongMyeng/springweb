package homework_vo;

import a01_diexp.z01_vo.Bus;

public class BusDriver {
	private String name;
	private Bus bus;
	
	public void driveinfo() {
		System.out.println("<"+name+"기사님의 운행정보");
		if(bus!=null) {
			System.out.print("버스번호:"+bus.getName()+"\t");
			System.out.println("버스노선:"+bus.getBusInfo());
		}else {
		System.out.println("오늘은 운행하지 않으십니다.");
		}
	}
	
	public BusDriver() {
	}
	public BusDriver(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public void setBus021(Bus bus) {
		this.bus = bus;
	}
	
	
}
