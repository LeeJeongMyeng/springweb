package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import z01_vo.Dept;
import z01_vo.Person;



//springweb.a01_start.A04_RequestVO
@Controller
public class A04_RequestVO {
	DeptService deptservice = new DeptService();
	// http://localhost:8084/springweb/person.do
	// ?name=홍길동&age=&loc=서울
	// 문자열은 없어도 괜찮은데 int형은 없으면 에러가나서 뒤의구문(loc)부터 먹히지 않는다.
	
	@RequestMapping("/person.do")
	public String callPerson(Person person) {
		// 요청값이 없더라도 해당 메서드가 호출되고,
		// type에 맞게 호출하면 해당 요청값을 Person객체에 할당된다.
		System.out.println("요청값:"+person.getName());
		System.out.println("요청값:"+person.getAge());
		System.out.println("요청값:"+person.getLoc());
		return "WEB-INF\\views\\a01_start\\a14_InsertPerson.jsp";
	}
	
	
	@RequestMapping("/deptIns.do")
	public String DeptInsert(Dept dept,Model d) {
		if(dept.getDname()!=null && dept.getDname()!="") {
		d.addAttribute("result",deptservice.insertDept(dept));
		}
		return "WEB-INF\\views\\a01_start\\a15_InsertDept.jsp";
	}
	
	
}
