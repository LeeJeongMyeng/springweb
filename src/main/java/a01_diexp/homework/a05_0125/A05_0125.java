package a01_diexp.homework.a05_0125;

import java.util.List;

import springweb.z01_vo.Dept;
import springweb.z01_vo.Emp;

public class A05_0125 {
/*
	2023-01-25
	[1단계:개념] 1. 새로운 dao패키지, 새로운 dao와 새로운 mapper를 추가했을 때, 새로운 vo를 mybatis에 추가할 때, 처리할 내용을 기술하세요.
			 	1. dao추가시, 객체화를 위해 관리 xml (dispatcher-servlet.xml / di00.xml) 파일에
			 		해당 dao가 소속되어잇는 패키지 위치 주소를 추가한다.
			 		* 만일 기존이 존재하고 추가가 되었을 경우에는 ,(콤마)구분자로 추가한다.
			 		<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
				      <property name="basePackage" value="a01_diexp.mybatis.dao,a01_diexp.mybatis.dao2"/>
				   </bean> 
				   
				 2. 새로운 mapper추가시에는
				 	mapper를 관리하는 xml(mybatis.spring.xml 등) 파일에서 mapperse안에
				 	<mapper resource="추가된 mapper.xml파일 위치"/>를 추가한다.
				
				 3. 새로운 vo를 추가할경우 역시 mapper를 관리하는 xml파일의 <typeAliases>안에
				  <typeAlias alias="vo변수명" type="vo위치">를 추가한다.
				   
	[1단계:확인] 2. salgrade활용하여 select * from salgrade를 처리할려고 한다. 처리순서를 기술하세요. 
					
					1. vo생성
					
					2. * 패키지를 새로만들지 않고 넘어간다고 가정,
						mapper를 관리하는 xml파일(mybatis.spring.xml)파일에
						 <typeAlias alias="salgrade" type="springweb.z01_vo.Salgrade"/> 추가
					   * dao패키지를 새로 생성한다는 가정,
					    최우선 xml파일(dispatcher-servlet,di00.xml)파일에서 새로 생성한 dao mybatis에서 사용할수있도록
					    선언해줌
				  <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		           <property name="basePackage" value="springweb.a05_mvc.a03_dao"></property>
		          </bean>
					    
					3. mapper.xml파일에 선언
					 <select id="interface Dao파일에서 선언할 메서드이름과 동일하게 선언" resultType="salgrade">
					 
					4. interface Dao파일에 mapper.xml에서 선언한  
						select id=""네이밍과 동일하게 호출
					 
	[1단계:확인] 3. a01_diexp.mybatis하위에 dao3패키지를 만들어 회원테이블을 조회할려고 한다. 처리순서와 내용 코드를 기술하세요.
						1. dao3패키지를 새로 생성했기 때문에 객체화를 위해서 최우선 xml파일에 아래와같이 선언
						*아래 구문이 기존에 존재했다면 value=""에 ,(콤마)구분자로 추가하면됨
							<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
					           <property name="basePackage" value="dao3위치"></property>
					        </bean>
					    
					    2. 같은 최우선 xml파일에 아래와 같이 선언하여 mybatis와 연동
					    	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
					           <property name="dataSource" ref="dataSource"></property>
					           <property name="configLocation" value="classpath:'mapper관리 xml파일 위치 선언'"></property>
					        </bean>
					    
					    3-1. vo사용을 위해  mybatis.xml에 vo연동
					    <typeAliases>
							<typeAlias alias="emp" type="springweb.z01_vo.Emp"/>
							<typeAlias alias="dept" type="springweb.z01_vo.Dept"/>
							<typeAlias alias="empdept" type="springweb.z01_vo.EmpDept"/>
							<typeAlias alias="membervo" type="springweb.z01_vo.MemberVO"/>
						</typeAliases>
					    	
					    3-2.	mybatis.spring.xml 파일에 mapper.xml파일 연동
					    	<mappers>
								<mapper resource="a01_diexp/mybatis/resource/A01_EmpMapper.xml"/>
								<mapper resource="a01_diexp/mybatis/resource/A02_EmpMapper.xml"/>				
							</mappers>
					    
					    4. mapper.xml파일에 아래와 같이 선언
					    	* id는 interface dao에 호출할 메서드명과 동일해야함
					    	* resultType은 mapper관리 xml파일에서 선언한 alias네임과 동일해야함
					    	mapper namespace="a01_diexp.mybatis.dao2.A02_ExpDao">	
								<select id="getMemberList" resultType="membervo">
									select * from member100
								</select>								
							</mapper>	
						
						5. interface dao에서 mapper select id와 동일한 메서드명으로 호출
						
						6. main에서 호출
						
	[1단계:개념] 4. resultType을 쓰는 경우와 resultMap을 쓰는 경우의 차이점을 기술하세요. 
			1) 컬럼명과 property 동일한 경우 
		        resultType
		    2) 컬럼명과 proprty 다르게 설정해야하는 경우 
		        resultMap 활용 
	 
	[1단계:확인] 5. 1대 다 resultMap 활용
	      1. select ename name, mgr manager, sal salaray from emp로 sql을 처리하여 mybatis에서 처리할려고 한다.vo를 변경하지 않고 처리하세요.
	      			
	      			<!--여기는 숙제! ename name, mgr manager, sal salaray -->
	      			
	      			*mapper
				    <resultMap type="emp" id="emphomework">
						<result column="name" property="ename"/>
						<result column="manager" property="mgr"/>
						<result column="salaray" property="sal"/>
					</resultMap>
					
					<select id="getEmphomework" resultMap="emphomework">
				    SELECT ename name, mgr manager, sal salaray 
					FROM emp100
					</select>
	      			
	      			*dao
	      			public List<Emp> getEmphomework();
	      			
	      			*DIExp.java
	      			List<Emp> emHomework = obj.getEmphomework();
					System.out.println("데이터 건수:"+emHomework.size());
					for(Emp emp:emHomework) {
						System.out.print(emp.getEname());
						System.out.print(emp.getMgr());
						System.out.println(emp.getSal());
					}
	      2. select deptno no, dname departname, loc location from dept sql 처리
	      		*mapper
	      		<resultMap type="dept" id="depthomework">
					<result column="no" property="deptno"/>
					<result column="departname" property="dname"/>
					<result column="location" property="loc"/>
				</resultMap>
				<select id="getDepthomework" resultMap="depthomework">
				select deptno no, dname departname, loc location from dept
				</select>
	      
	      		*dao
	      		public List<Dept> getDepthomework();
	      
	      		*DIExp.java
	      		List<Dept> emHomework2 = obj.getDepthomework();
				System.out.println("데이터 건수:"+emHomework2.size());
				for(Dept dept:emHomework2) {
					System.out.print(dept.getDeptno());
					System.out.print(dept.getDname());
					System.out.println(dept.getLoc());
				}
*/
}
