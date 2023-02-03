package springweb.a03_ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import springweb.a05_mvc.a02_service.A01_EmpService;
import springweb.z01_vo.Dept;
import springweb.z01_vo.Emp;
import z01_vo.Person;

@Controller
public class A03_JsonViewCallCtrl {

	
	@GetMapping("callJson.do")
	public String calljson01(Model d) {
		
		d.addAttribute("json01",new Dept(10,"인사","서울"));
		return "pageJsonReport";
		//컨테이너에있는 bean id와일치하면 해당 내용에맞게 반환
	}
	
	//ex) callJson02.do Person객체를 json데이터로 출력

	 
	@GetMapping("callJson2.do")
	public String calljson02(Model d) {
		d.addAttribute("json02",new Person("이정명",25,"서울"));
		return "pageJsonReport";
	}
	@Autowired(required=false)
	private A01_EmpService service;
	
	@GetMapping("callJson3.do")
	public String calljson03(Model d) {
		d.addAttribute("json03",service.getEmpList(new Emp()));
		return "pageJsonReport";
	}
}
