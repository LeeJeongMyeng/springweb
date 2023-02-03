package a01_diexp.homework.a06_0126;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.homework.a06_0126.vo.Buyinfo111;
import a01_diexp.z08_mydb.vo.BuyProduct;
import a01_diexp.z08_mydb.vo.Dept;
import a01_diexp.z08_mydb.vo.DeptSalgrade;
import a01_diexp.z08_mydb.vo.Emp;
import a01_diexp.z08_mydb.vo.EmpDeptCom;
import a01_diexp.z08_mydb.vo.MemberVO;
import a01_diexp.z08_mydb.vo.Salgrade;

public class A01_0126DiExp {

	public static void main(String[] args) {
		String path="a01_diexp\\homework\\a06_0126\\a01_di0126.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		//DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
		A02_0126ExpDao obj = ctx.getBean("a02_0126ExpDao",A02_0126ExpDao.class);
		System.out.println(obj);
		/*
		  2023-01-26
[1단계:개념] 1. resultMap을 사용하는 경우와 설정형식을 기술하세요
			resultMap은 1:1혹은 1:다 관계에서 vo의 property와 컬럼의 명이 다를때 사용한다.
			
			*vo하나
			<resultMap type="mybatis의 vo alias명" id="변수명">
				<result column="name" property="ename"/>
			</resultMap>
			*2개이상의 vo연결시
			<resultMap type="mybatis의 vo alias명" id="변수명">
				<association property="emp" javatype="emp">
					<result column="empno" property="empno"/>
				</association>
			</resultMap>
			
[1단계:확인] 2. select id user, pass password99,
 			authority auth  from member sql을 resultmap을 이용해서  DB 처리를하세요*/
 			List<MemberVO> mvs = obj.getmember();
		
		for(MemberVO mv:mvs) {
			System.out.print(mv.getId());
			System.out.print(mv.getPass());
			System.out.println(mv.getAuthority());
		}
 			
 			
//[1단계:확인] 3. 부서번호로 조회와 부서정보를 등록하는 처리를 parameterType 속성을 이용하여 처리하세요
			Dept dept = obj.getDept(20);
			System.out.print(dept.getDeptno());
			System.out.print(dept.getDname());
			System.out.println(dept.getLoc());
			
			int check= obj.insertDept(new Dept(67,"간호","창원"));
			String checkval="실패";
			if(check==1) {checkval="성공";}
			System.out.println(checkval);
			
//[1단계:확인] 4. 회원정보(member)를 삭제하는 처리를 하세요
			System.out.println(obj.deleteMember("aaaa"));
			
			
			
//[3단계:확인] 5. product, member, buyinfo 테이블의 조인관계를 설정하여  BuyProduct VO에 Product, Member 객체를 포함하여 resultMap을 활용한 DB처리를 하세요
			
			for(Buyinfo111 bp:obj.getBuyResult()) {
				System.out.println(bp.getMember111().getName());
				System.out.println(bp.getProduct111().getName());
			}
		
		
		
		
		
	}

}
