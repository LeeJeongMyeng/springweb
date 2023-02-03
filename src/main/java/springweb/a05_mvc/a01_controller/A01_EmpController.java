package springweb.a05_mvc.a01_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a05_mvc.a02_service.A01_EmpService;
import springweb.z01_vo.Code;
import springweb.z01_vo.Dept;
import springweb.z01_vo.Emp;

@Controller("empCtrl")
public class A01_EmpController {

	@Autowired
	private A01_EmpService service;
	
	@ModelAttribute("DeptCombo")
	public List<Dept> getDeptCombo(){
		return service.getDeptCombo();
	}
	@ModelAttribute("MgrCombo")
	public List<Code> getMgrCombo(){
		return service.getMgrCombo();
	}
	@ModelAttribute("JobCombo")
	public List<String> getJobCombo(){
		return service.getJobCombo();
	}
	@RequestMapping("empListMy.do")
	public String empList(@ModelAttribute("sch") Emp sch,Model d) {
		
		d.addAttribute("empList",service.getEmpList(sch));
		return "\\WEB-INF\\views\\a05_mvc\\a01_empList.jsp";
	}
	
	
	
	
	
}
