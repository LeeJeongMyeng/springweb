package springweb.a04_di_last;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A03_Controller {
	@Autowired
	private A04_Service service;
	
	
	@GetMapping("/diCall02")
	public String diCall02(Model d) {
		
		d.addAttribute("show",service.getCheck2());
		return "WEB-INF\\\\views\\\\a01_start\\\\a20_autowireshow.jsp";
	}
	
	
}
