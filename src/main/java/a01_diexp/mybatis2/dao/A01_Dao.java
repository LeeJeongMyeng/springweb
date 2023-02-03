package a01_diexp.mybatis2.dao;

import java.util.List;

import springweb.z01_vo.Dept;
import springweb.z01_vo.Emp;
import springweb.z01_vo.EmpDept;
import springweb.z01_vo.EmpSalgrade;


public interface A01_Dao {
	
	/*2023-01-20
	[1단계:개념] 1. mybatis 설정의 위해 container에서 설정할 내용을 기술하세요.
					<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
           				<property name="dataSource" ref="dataSource"></property>
           			<property name="configLocation" value="classpath:resource/mybatis.Spring.xml"></property>
        			</bean>
        			
        			1. 해당 클래스의 xml파일과 연결
        			
	[1단계:개념] 2. mybatis 설정의 위해 mybatis.Spring.xml에서 설정할 내용을 기술하세요
					// 생성자를 위한 VO파일을 연결하고 alias를 통해 변수명설정
					<typeAliases>
						<typeAlias alias="emp" type="z01_vo.Emp"/>
					</typeAliases>
					
					// Mapper에서 sql로 데이터를 얻기위해 Mapper.xml과 연결
					<!-- 2. 사용 XXXMapper.xml을 추가  a01_diexp\mybatis\resource\A01_EmpMapper.xml -->
					<mappers>
						<mapper resource="a01_diexp/mybatis/resource/A01_EmpMapper.xml"/>		
					</mappers>
					
					
					
	[1단계:개념] 3. dao와 XXXMapper.xml의 연동 규칙을 기술하세요.
				
				<select id="empMaxSal20Deptno" resultType="int">
				select max(sal) msal from emp100 where deptno=20
				</select>
				1. id는 dao에서 처리할 메서드 변수명와 동일해야한다.
				2. dao에서 처리할 데이터 타입이 동일해야한다.
				
				
	[1단계:확인] 4. 단일 리턴값 처리 연습(아래와 같은 sql을 처리하는 dao와 mapper.xml을 구현하고  main()에서 호출하세요.*/
	      //1) 최고 관리자 번호
	public int exp1();
	     // 2) 40번 부서의 최근 입사자의 입사일
	public String exp2();
	     // 3) 직책이 SALESMAN의 최저 급여
	public double exp3();
	     // 4) 연봉이 2000~4000 구간의 사원의 수
	public int exp4();
	     // 5) 1/4분기에 입사한 사원의 수
	public int exp5();      
	      
	      
	//[1단계:확인] 4. 단일 객체 처리 연습(아래와 같은 sql을 처리하는 dao와 mapper.xml을 구현하고  main()에서 호출하세요.
	     // 1) 직책이 MANAGER인 사원의 최고 급여자
	public Emp emp6();
	      //2) 부서번호가 10인 부서정보 (Dept alias 등록 필요 - dept - 공통 mybatis에)
	public Dept emp7();
	// 3) 사원명이 TURNER인 사원의 정보
	public Emp emp8();
	// 4) 최초 입사자의 사원 정보 
	public Emp emp9();
	// 5) 2/4분기 최고 급여자의 정보*/
	public Emp emp10();
	
	public List<EmpDept> getEmpDeptList();
	
	public List<EmpSalgrade> getEmpSalgradeList();
}
