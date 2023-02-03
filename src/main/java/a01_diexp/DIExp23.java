package a01_diexp;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.mybatis2.dao.A02_ExpDao;
import springweb.z01_vo.Dept;
import springweb.z01_vo.Emp;
import springweb.z01_vo.Salgrade;

public class DIExp23 {

	public static void main(String[] args) {

		//컨테이너 객체 호출 처리
		String path="a01_diexp\\di92_2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		//DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
		A02_ExpDao obj = ctx.getBean("a02_ExpDao",A02_ExpDao.class);
		System.out.println("컨테이너 객체 호출:"+obj);
		List<Emp> emList = obj.getEmpData();
		System.out.println("데이터 건수:"+emList.size());
		for(Emp e:emList) {
			System.out.print(e.getEmpno()+"\t");
			System.out.print(e.getEname()+"\t");
			System.out.println(e.getSal());
		}
		
		List<Salgrade> gradeList = obj.getSalgrade();
		System.out.println("데이터건수:"+gradeList.size());
		for(Salgrade sal:gradeList) {
			System.out.print("등급:"+sal.getGrade()+"\t");
			System.out.print("시작연봉:"+sal.getLosal()+"\t");
			System.out.println("끝연봉:"+sal.getHisal());
		}
		
		List<Emp> emHomework = obj.getEmphomework();
		System.out.println("데이터 건수:"+emHomework.size());
		for(Emp emp:emHomework) {
			System.out.print(emp.getEname());
			System.out.print(emp.getMgr());
			System.out.println(emp.getSal());
		}
		List<Dept> emHomework2 = obj.getDepthomework();
		System.out.println("데이터 건수:"+emHomework2.size());
		for(Dept dept:emHomework2) {
			System.out.print(dept.getDeptno());
			System.out.print(dept.getDname());
			System.out.println(dept.getLoc());
		}
		
		
		
		System.out.println("종료");
		ctx.close();
		//di10.xml
		//<bean id="obj" class="java.lang.Object"/>
	}

}
