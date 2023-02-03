package springweb.a04_di_last;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A01_DIController {
	@Autowired
	private A02_DIService service;
	// 컨테이너에(dispatcher-servlet.xml)에 있는 해당 서비스 객체를 로딩해준다.
	// new A02_DIService() 필요없음
	
	
	@GetMapping("/diCall01.do")
	public String diCall01(Model d) {
		d.addAttribute("show",service.getCheck());
		return "WEB-INF\\views\\a01_start\\a20_autowireshow.jsp"; //index.jsp호출
	}
	
	
	
}
