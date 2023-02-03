package a01_diexp.homework.a04_0118;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z06_vo.Product;
import a01_diexp.z06_vo.Mart;

public class A04_0118 {

	public static void main(String[] args) {

		//컨테이너 객체 호출 처리
		String path="a01_diexp\\homework\\a04_0118\\a04_0118.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		/*
		  2023-01-19
		[1단계:개념] 1. 스프링의 컨테이너 안에 backend단 처리순서를 기술하세요.
		
		[1단계:확인] 2. 다음은 컨터이너 객체 처리방법입니다. 단계별로 처리하세요
               1) a01_diexp.z06_vo 패키지 만들기 1:1, 1:다 관계로 (물건, 마트)  (쇼핑몰,회원)클래스 선언
               2) di91.xml에 위 패키지 클래스 로딩 처리
               3) DIExp91.java에 해당 클래스 소스 코딩을 통해 autowire를 호출*/
		Mart mart = ctx.getBean("mart",Mart.class);
		mart.setTname("하이마트");
		Product prod = ctx.getBean("product",Product.class);
        prod.setProduct("핸드폰");
        prod.setPrice(10000);
        prod.setCnt(3);
        
        mart.Martinfo();
               
	/*	[1단계:확인] 3. 다음은 컨터이너 객체 처리방법입니다. 단계별로 처리하세요
               1) a02_diexp.z07_web 패키지 만들기 controller, service, dao, A02_EmpDao.java(기본 dao 복사) 객체 할당.
               2) di92.xml에 위 패키지 클래스 로딩 처리
               3) DIExp92.java에 해당 클래스 소스 코딩을 통해 autowire를 호출 controller를 통해 사원정보 조회 출력하세요.
               
               
               
		[1단계:개념] 4. mybatis 환경 설정 순서를 기술하세요.

		 */
		
		System.out.println("종료");
		ctx.close();
		//di10.xml
		//<bean id="obj" class="java.lang.Object"/>
	}

}
