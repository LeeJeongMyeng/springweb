package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a02_diexp.z07_web.A0119_Controller;
import z01_vo.Emp;


public class DIExp92 {

	public static void main(String[] args) {

		//컨테이너 객체 호출 처리
		String path="a01_diexp\\di92.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		//DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
		A0119_Controller obj = ctx.getBean("a0119_Controller",A0119_Controller.class);
		System.out.println("컨테이너 객체 호출:"+obj);
		obj.getEmpSch(new Emp());
		System.out.println("종료");
		ctx.close();
		//di10.xml
		//<bean id="obj" class="java.lang.Object"/>
	}

}
