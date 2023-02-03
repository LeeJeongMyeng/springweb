package springweb.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A0118_Controller {
	@Autowired
	private A0118_Service service;
	
	@GetMapping("/showA0118.do")
	public String showA0118() {
		return "WEB-INF\\homework\\a09_0118.jsp";
	}
	
	@GetMapping("/deptinfo01.do")
	public String dept(Model d) {
		d.addAttribute("dept",service.getDeptInfo());
		return "homework\\0118.jsp";
	}
}
