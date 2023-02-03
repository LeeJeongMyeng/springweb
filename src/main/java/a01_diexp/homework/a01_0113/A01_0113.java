package a01_diexp.homework.a01_0113;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import homework_vo.BaseBallPlayer;
import homework_vo.BaseBallTeam;

public class A01_0113 {

	public static void main(String[] args) {
		String path="a01_diexp\\homework\\a01_0113\\a01_0113.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		//DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
		/*
		 2023-01-13
[1단계:개념] 1. 스프링에서 DI란 무엇인가?
	DL(Dependency Loopup) 컨테이너에 저장된 객체들을 찾을 때 사용되는
		키워드 또는 개념이다.
[1단계:개념] 2. 스프링에서 IOC란 무엇인가

	2) IOC(Inversion of controller)이해
		제어권의 역전이란?
			객체의 생성, 사용, 소멸로 처리되는 생명주기의 관리까지
			기존에 개발자의 각 객체 안에서 호출하여 처리되는 내용을
			컨테이너에 의해서 처리되게끔 객체에 대한 제어권을 바뀌었다는 것을 의미한다.
			
	 <의존성 관계 설정>
	 의존성관리란 객체간에 Controller ==> service ==> Dao 형태로
			상호의존을 하여 처리하는것을 말하고, 이러한 것을 컨테이너에서 관리하는것을 말한다..
			
			
[1단계:개념] 3. DI설정의 위한 가상환경 설정 방법을 기술하세요
			1)src java밑에 a01_diexp폴더 생성
			   - DIExp10.java(컨테이너에 있는 객체를 DL호출해서 활용)
			   - di10.xml(가상 컨테이너생성)
			   - z01_vo 패키

[1단계:확인] 4. property를 활용해서 가상 컨테이너안에서 BaseBallPlayer(이름, 팀명, 타율)를 선언하세요*/
		BaseBallPlayer bp01 = ctx.getBean("bp01",BaseBallPlayer.class);
		System.out.println("컨테이너 객체 호출:"+bp01);
		bp01.score();

/*[1단계:확인] 5. constructor를 활용해서 가상 컨테이너안에서 BaseBallTeam를(팀명, 승,무,패) 선언하세요 */
		BaseBallTeam bt01 = ctx.getBean("bt01",BaseBallTeam.class);
		System.out.println("컨테이너 객체 호출:"+bt01);
		System.out.println(bt01.getTname());
		System.out.println(bt01.getWin());
		System.out.println(bt01.getEq());
		System.out.println(bt01.getDef());
	
/*[1단계:확인] 6. BaseBallPlayer에 소속 팀 객체를 선언하여 1:1로 할당하고, 해당 선수와 소속팀 정보를 출력 메서드를 선언하세요. */
		BaseBallPlayer bp02 = ctx.getBean("bp02",BaseBallPlayer.class);
		bp02.score();
		
		/*소속이 없는 선수*/
		BaseBallPlayer bp03 = ctx.getBean("bp03",BaseBallPlayer.class);
		bp03.score();
		
		
		
		//컨테이너 객체 호출 처리
		
		
		
		//di10.xml
		//<bean id="obj" class="java.lang.Object"/>
		
		System.out.println("종료");
		ctx.close();
	}

}
