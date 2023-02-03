package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z05_vo.Computer;
import a01_diexp.z05_vo.Ram;

public class DIExp20 {

	public static void main(String[] args) {

		//컨테이너 객체 호출 처리
		String path="a01_diexp\\di20.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		//DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
		Ram ram = ctx.getBean("ram",Ram.class);
		//ram.setName("시금치램");
		//ram.setSize("16GB");
		
		Computer com = ctx.getBean("computer",Computer.class);
		com.setCompany("삼성전자");
		com.cominfo();
		
		System.out.println("종료");
		ctx.close();
		//di10.xml
		//<bean id="obj" class="java.lang.Object"/>
	}

}
