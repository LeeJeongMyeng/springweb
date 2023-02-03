package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Bus;
import a01_diexp.z01_vo.Monitor;
import a01_diexp.z01_vo.Sensor;
import a01_diexp.z01_vo.StudentMapVO;

public class DIExp14 {

	public static void main(String[] args) {

		//컨테이너 객체 호출 처리
		String path="a01_diexp\\di14.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		//DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
		Sensor sensor01 = ctx.getBean("sensor01",Sensor.class);
		System.out.println("컨테이너 객체 호출:"+sensor01);
		System.out.println(sensor01.getAgent());
		System.out.println("구매 정보(addInfo):"+sensor01.getAddInfo());
		
		/*
		  EX) class Bus  setPassenger(Set<String> name)
		  		DI로 할당 후, getPassenger()호출 출력
		  
		 */
		Bus bus01 = ctx.getBean("bus01",Bus.class);
		System.out.println(bus01.getName());
		System.out.println("버스정보:"+bus01.getBusInfo());
		
		Monitor monitor01 = ctx.getBean("monitor01",Monitor.class);
		System.out.println(monitor01.getConfig());
		System.out.println(monitor01.getConfig().keySet());
		System.out.println(monitor01.getConfig().values());
		
		StudentMapVO record01 = ctx.getBean("record01",StudentMapVO.class);
		System.out.println(record01.getRecords());
		System.out.println(record01.getRecords().keySet());
		System.out.println(record01.getRecords().values());
		
		
		/*
		  class Student Map<String,Integer> records
		  과목당 점수를 설정할 수 있는 Map선언 di에서 할당 후 출력 
		 */
		
		
		
		System.out.println("종료");
		ctx.close();
	
		
		
	}

}
