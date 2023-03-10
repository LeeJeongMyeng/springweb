package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.backend.A01_Controller;
import z01_vo.Dept;


public class DIExp21 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 컨테이너 객체 호출 처리
		String path = "a01_diexp\\di21.xml";
		AbstractApplicationContext 
		ctx = new GenericXmlApplicationContext(path);
		// DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
//		DB obj = ctx.getBean("dbCon", DB.class);
//		System.out.println("컨테이너의 객체호출:"+obj);
//		A06_PreparedDao dao = ctx.getBean("a06_PreparedDao", A06_PreparedDao.class);
//		System.out.println("컨테이너의 객체호출:"+dao);
//		System.out.println("컨테이너의 객체호출:"+
//				dao.getDeptList(new Dept(0,"","")).size());
		A01_Controller con = ctx.getBean("a01_Controller", A01_Controller.class);
		con.getDeptList(new Dept());
		
		System.out.println("종료");
		ctx.close();
		// di10.xml
		// <bean id="obj" class="java.lang.Object" />

		
		
	}

}
