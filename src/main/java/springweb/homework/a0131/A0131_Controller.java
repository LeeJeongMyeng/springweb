package springweb.homework.a0131;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.z01_vo.Emp;

@Controller
public class A0131_Controller {

	@Autowired(required=false)
	private A0131_Service service2;

	//2번문제 기본페이지 호출
	@GetMapping("exp0131.do")
	public String exp0131_2G() {
		return "WEB-INF\\homework\\a11_0131.jsp";
	}
	//2번문제 검색호출
	@PostMapping("exp01312.do")
	public String exp0131_2P(Emp sch,Model d) {
		d.addAttribute("empList0131",service2.getEmpList(sch));
		return "pageJsonReport";
	}
	@PostMapping("exp01313.do")
	public String exp0131_3P(Model d) {
		d.addAttribute("gradeList",service2.exp0131_3P());
		return "pageJsonReport";
	}
	
	@PostMapping("exp013133.do")
	public String exp0131_33P(@RequestParam("grade") int grade,Model d) {
		d.addAttribute("gradeInfo",service2.exp0131_33P(grade));
		return "pageJsonReport";
	}
	

}
