package a01_diexp;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



import a01_diexp.mybatis.dao.A01_EmpDao;
import a01_diexp.mybatis.dao2.A02_ExpDao;
import springweb.z01_vo.Emp;
import springweb.z01_vo.MemberVO;

public class DIExp22 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      // 컨테이너 객체 호출 처리
      String path = "a01_diexp\\di22.xml";
      AbstractApplicationContext 
      ctx = new GenericXmlApplicationContext(path);
      // DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
      // A01_EmpDao
      A01_EmpDao obj = ctx.getBean("a01_EmpDao", A01_EmpDao.class);
      System.out.println("컨테이너의 객체호출:"+obj.getEmpList(new Emp("","")).size());
      System.out.println("사원의수:"+obj.empCount());
      System.out.println("최대급여:"+obj.EmpMaxSal());
      System.out.println("사원이름:"+obj.empGetEname());
      System.out.println(obj.empMaxSal20Deptno());
	  System.out.println(obj.empMaxMgr());
	  System.out.println(obj.empGetJob());
	  System.out.println(obj.getEmpByEmpno().getDeptno());
	  System.out.println(obj.getEmpByEname().getEmpno());
      System.out.println("종료");
      
      
      A02_ExpDao obj2 = ctx.getBean("a02_ExpDao", A02_ExpDao.class);
      List<MemberVO> mvList = obj2.getMemberList();
      System.out.println("호출된 사이즈:"+mvList.size());
      for(MemberVO mv:mvList) {
    	  System.out.print(mv.getName()+"\t");
    	  System.out.print(mv.getAuthority()+"\t");
    	  System.out.print(mv.getId()+"\t");
    	  System.out.print(mv.getPass()+"\t");
    	  System.out.println(mv.getPoint());
      }
      
      ctx.close();
      // di10.xml
      // <bean id="obj" class="java.lang.Object" />

      
      
   }

}