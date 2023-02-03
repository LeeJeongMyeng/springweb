package a01_diexp.z04_vo;

import org.springframework.beans.factory.annotation.Autowired;

public class CarRacer {
	
	private String name;
	@Autowired
	private Car car;
	public CarRacer() {
	}
	public CarRacer(String name) {
		this.name = name;
	}
	
	public void driving() {
		System.out.println("<"+name+"선수>");
		if(car!=null) {
			car.carInfo();
		}else {
			System.out.println("차가 없습니다.");
		}
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	public void setCarinfo03(Car car) {
		this.car = car;
	}
}
