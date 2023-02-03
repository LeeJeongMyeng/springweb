package a01_diexp;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.mybatis2.dao.A01_Dao;
import springweb.z01_vo.EmpDept;
import springweb.z01_vo.EmpSalgrade;

public class DIExp92_2 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      // 컨테이너 객체 호출 처리
      String path = "a01_diexp\\di92_2.xml";
      AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
      // DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
      // A01_EmpDao
      A01_Dao obj = ctx.getBean("a01_Dao", A01_Dao.class);
      System.out.println("컨테이너의 객체호출:"+obj.exp1());
      System.out.println("사원의수:"+obj.exp2());
      System.out.println("최대급여:"+obj.exp3());
      System.out.println("사원이름:"+obj.exp4());
      System.out.println(obj.exp5());
	  System.out.println(obj.emp6());
	  System.out.println(obj.emp7());
	  System.out.println(obj.emp8());
	  System.out.println(obj.emp9());
	  System.out.println("10번:"+obj.emp10());

	  List<EmpDept> ed = obj.getEmpDeptList();
	  
	  System.out.println("#사원부서정보 다중열:"+ed.size());
	  for(EmpDept eds:ed) {
		  System.out.print(eds.getEname());
		  System.out.println(eds.getDname());
	  }
	  
	  List<EmpSalgrade> es = obj.getEmpSalgradeList();
	  System.out.println("#등급표 열:"+es.size());
	  for(EmpSalgrade ess:es) {
		  System.out.print(ess.getEname());
		  System.out.println(ess.getGrade());
	  }
	  
      System.out.println("종료");
      
      
      ctx.close();
      // di10.xml
      // <bean id="obj" class="java.lang.Object" />

      
      
   }

}