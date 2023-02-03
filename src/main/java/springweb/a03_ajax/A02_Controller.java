package springweb.a03_ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import springweb.homework.A0118_Service;

@Controller
public class A02_Controller {


	@GetMapping("/empForAjax.do")
	public String empFroAjax() {
		return"a01_jquery\\a17_ajax.html";
	}
	
	@GetMapping("/deptForAjax.do")
	public String deptForAjax() {
		return "a01_jquery\\a18_deptajax.html";
	}
		
	
	
	}

