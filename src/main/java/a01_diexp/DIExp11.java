package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Music;
import a01_diexp.z01_vo.Person;
import a01_diexp.z01_vo.Product;

public class DIExp11 {

	public static void main(String[] args) {

		//컨테이너 객체 호출 처리
		String path="a01_diexp\\di11.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		//DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
		Person p01 = ctx.getBean("p01",Person.class);
		System.out.println("컨테이너 객체 호출:"+p01);
		System.out.println("이름:"+p01.getName());
		System.out.println("이름:"+p01.getAge());
		System.out.println("이름:"+p01.getLoc());
		System.out.println("종료");
		
		//di10.xml
		//<bean id="obj" class="java.lang.Object"/>
		//ex) vo a01_diexp.z01_vo 하위에 Product클래스 만들고, dill.xml에서 prod01로 호출
		
		Product prod01 = ctx.getBean("prod01",Product.class);
		System.out.println("product객체 호출:"+prod01);
		System.out.println("물건명:"+prod01.getProduct());
		System.out.println("물건명:"+prod01.getPrice());
		System.out.println("물건명:"+prod01.getCnt());
		System.out.println("Product객체 호출 종료");
		
		Product prod02 = ctx.getBean("prod02",Product.class);
		System.out.println("prod02 객체호출:"+prod02);
		System.out.println("물건명:"+prod02.getProduct());
		System.out.println("물건명:"+prod02.getPrice());
		System.out.println("물건명:"+prod02.getCnt());
		System.out.println("Prod02객체 호출 종료");
		
		Music m01 = ctx.getBean("music01",Music.class);
		System.out.println("music01 객체호출:"+m01);
		System.out.println("제목:"+m01.getTitle());
		System.out.println("가수:"+m01.getSinger());
		System.out.println("Prod02객체 호출 종료");
		
		
		
		
		
		
		ctx.close();
	}

}
