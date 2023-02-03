package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.CarRacer;
import a01_diexp.z01_vo.HPUser;

public class DIExp12 {

	public static void main(String[] args) {

		//컨테이너 객체 호출 처리
		String path="a01_diexp\\di12.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		//DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
		HPUser hu01 = ctx.getBean("hu01",HPUser.class);
		HPUser hu02 = ctx.getBean("hu02",HPUser.class);
		System.out.println("컨테이너 객체 호출:"+hu01);
		System.out.println("컨테이너 객체 호출:"+hu02);
		
		hu01.usingMyPhone();
		hu02.usingMyPhone();
		
		CarRacer cr01 = ctx.getBean("cr01",CarRacer.class);
		CarRacer cr02 = ctx.getBean("cr02",CarRacer.class);
		System.out.println("컨테이너 객체 호출:"+cr01);
		cr01.driving();
		System.out.println("컨테이너 객체 호출:"+cr02);
		cr02.driving();
		
		System.out.println("종료");
		ctx.close();
		//di10.xml
		//<bean id="obj" class="java.lang.Object"/>
	}

}
