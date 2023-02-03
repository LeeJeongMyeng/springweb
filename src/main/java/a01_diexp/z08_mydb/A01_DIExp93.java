package a01_diexp.z08_mydb;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z08_mydb.vo.DeptSalgrade;
import a01_diexp.z08_mydb.vo.Emp;
import a01_diexp.z08_mydb.vo.EmpDeptCom;
import a01_diexp.z08_mydb.vo.Salgrade;

public class A01_DIExp93 {

	public static void main(String[] args) {

		//컨테이너 객체 호출 처리
		String path="a01_diexp\\z08_mydb\\a01_di93.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		//DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
		A02_ExpDao obj = ctx.getBean("a02_ExpDao",A02_ExpDao.class);
		System.out.println(obj);
		List<Salgrade> sgd = obj.getSalgrade();
		
		System.out.println("호출수:"+sgd.size());
		for(Salgrade sg:sgd) {
			System.out.print(sg.getGrade()+"\t");
			System.out.print(sg.getLosal()+"\t");
			System.out.println(sg.getHisal());
		}
		List<Emp> emps = obj.getEmpExp01();
		for(Emp emp:emps) {
			System.out.print(emp.getEname()+"\t");
			System.out.print(emp.getMgr()+"\t");
			System.out.println(emp.getSal());
		}
		
		System.out.println("#건수:"+obj.getEmpDeptList().size());	
		for(EmpDeptCom edc:obj.getEmpDeptList()) {
			System.out.println(edc.getEmp().getEname());
			System.out.println(edc.getDept().getDname());
		}
		
		System.out.println("#건수:"+obj.getDeptSalgrade().size());
		for(DeptSalgrade ds:obj.getDeptSalgrade()) {
			System.out.println(ds.getDept().getDname());
			System.out.println(ds.getSalgrade().getGrade());
		}
		
		Emp emp2= obj.getEmp(7369);
		System.out.println(emp2.getEmpno());
		
		int a = obj.insertEmp(new Emp("황길동","대리",7369,8888,1000,20));
		int c = obj.insertEmp2(new Emp("황길독","대리",7369,8888,1000,20));

		System.out.println(a+c);
		
		int b = obj.deleteEmp(7878);
		System.out.println(b);
		
		System.out.println("종료");
		ctx.close();
		//di10.xml
		//<bean id="obj" class="java.lang.Object"/>
	}

}
