package a01_diexp.homework.a02_0116;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Car;
import homework_vo.BaseBallTeam;
import homework_vo.Poket;

public class A02_0116 {

	public static void main(String[] args) {
		String path="a01_diexp\\homework\\a02_0116\\a02_0116.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		/*
		 2023-01-16
			[1단계:개념] 1. DI로 설정한 Collections 객체들의 기본 컨테이너 선언 방법을 기술하세요.
						<bean id = "prod01" class="@@@@.Product"/>
							<bean id = "prod02" class="@@@@.Product"/>
							<bean id = "prod03" class="@@@@.Product"/>
							<bean id = "mt01" class="@@@.Mart">
								<property name="plist">
									<list>
										<ref bean="prod01"/>
										<ref bean="prod02"/>
										<ref bean="prod03"/>
									</list>
								</property>
							</bean>
			[1단계:확인] 4. 호주머니 클래스를 선언하고 여기담긴 구슬을 Set로 할당하고, 호출하는 클래스와 di를 설정하고 호출하세요*/
						Poket pk01 = ctx.getBean("pk01",Poket.class);
					System.out.println("컨테이너 객체 호출:"+pk01);
					System.out.println(pk01.getBall());
			
			/*[1단계:확인] 4. Car클래스에 Tire클래스(제조사,가격)을 List로 추가하여 1:다로 처리되는 di를 선언하고 호출하세요.*/
					Car c01 = ctx.getBean("carinfo01",Car.class);
					c01.carInfo();
					
			/*[1단계:확인] 4. Map/Properties의 차이점을 기술하고, BaseTeam클래스에 타석 순서별 선수명를 Map으로,
			 *  수비역할별 선수명을 Properties로 DI로 할당하여 출력 처리하세요
			 *  - Map : key나 value로 문자열 및 다른 타입의 객체도 사용 가능
			  	<map>
				 <entry>
				  <key>
				   <value>키1</value>
				  </key>
				  <value>값1</value>
				 </entry>
				 <entry key="키2">
				  <ref bean="값2의id"/>
				 </entry>
				 <entry key="키3" value="값3" />
				 <entry key="키4" value-ref="값4의id" />
				</map>
			 		
				- Properties : Map의 일종이지만, key나 value로 문자열을 다룰 때 주로 사용
					<props>
					 <prop key="키1">값1</prop>
					 <prop key="키2">값2</prop>
					 ...
					</props>
			 */
					BaseBallTeam bt01 = ctx.getBean("bt01",BaseBallTeam.class);
					bt01.Teaminfo();

					
			/*[1단계:개념] 4. di에서 namespace처리를 위한 ddl 선언과 선언형식을 기술하세요*/
					// xmlns:p="http://www.springframework.org/schema/p"
					// xmlns:c="http://www.springframework.org/schema/c"
					
					// xmlns ==> xml namespace의 약자			
					//c: => constructor
					//p: => property
					
					 //<bean id="tire01" class="homework_vo.Tire" c:_0="한국타이어" c:_1="10000"/>
					 //<bean id="tire02" class="homework_vo.Tire" c:company="넥센타이어" c:price="20000"/>
					 //<bean id="tire03" class="homework_vo.Tire" p:company="동네타이어" p:price="30000"/>
					
			/*[1단계:확인] 5. callback메서드를 이용하여, 등록회원확인하기 누를때, 등록된 회원리스트나오고, alert(조회완료), 다시 등록회원닫기 누를때,
			      닫아지면 등록회원확인 완료 alert()이 로딩되게 하세요. */
					
					
		 
		
		
		System.out.println("종료");
		ctx.close();
	}

}
