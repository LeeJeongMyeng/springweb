package a01_diexp.homework.a03_0117;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Bus;
import homework_vo.BusDriver;
import homework_vo.Pencil;

public class A03_0117 {

	public static void main(String[] args) {

		//컨테이너 객체 호출 처리
		String path="a01_diexp\\homework\\a03_0117\\a03_0117.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		//DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
		
		// 10.번문제
		Pencil Pencil01 = ctx.getBean("Pencil01",Pencil.class);
		System.out.println("컨테이너 객체 호출:"+Pencil01);
		System.out.println(Pencil01.getName());
		System.out.println(Pencil01.getEraser().getName());
		
		
		
		 BusDriver busdriver01 = ctx.getBean("busdriver01",BusDriver.class);
		  busdriver01.driveinfo();
		 
		System.out.println("종료");
		ctx.close();
		//di10.xml
		//<bean id="obj" class="java.lang.Object"/>
	}

}
