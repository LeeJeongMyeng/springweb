package a01_diexp.z03_vo;

import java.util.List;

import homework_vo.Tire;

public class Car {
 private String name;
 private int maxspeed;
 private List<Tire> tire;
 
 
 public void carInfo() {
	 if(tire!=null && tire.size()>0) {
		 System.out.println("<"+name+"의 차량 정보>");
		 System.out.println("최고속력:"+maxspeed);
		 for(Tire t:tire) {
		 System.out.println("타이어 제조사:"+t.getCompany());
		 System.out.println("최고속력:"+t.getPrice());
		 }
	 }else {
		 System.out.println("타이어가 없습니다.");
	 }
	 
 }
 
 
public Car() {
}
public Car(String name, int maxspeed) {
	this.name = name;
	this.maxspeed = maxspeed;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getMaxspeed() {
	return maxspeed;
}
public void setMaxspeed(int maxspeed) {
	this.maxspeed = maxspeed;
}
public List<Tire> getTire() {
	return tire;
}
public void setTire(List<Tire> tire) {
	this.tire = tire;
}


 
 
}
