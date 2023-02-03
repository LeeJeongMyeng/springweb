package springweb.a05_mvc.a01_controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a05_mvc.a02_service.A01_EmpService;
import springweb.z01_vo.Dept;

@Controller
public class A02_DeptController {
	//컨테이너에 해당 객체가 null이더라도 에러가 발생하지 않게 해주는 옵션
	@Autowired(required=false)
	private A01_EmpService service;
	
	
	
	@RequestMapping("MyDeptList.do")
	public String MyDeptList(@ModelAttribute("sch") Dept sch,Model d) {
		
		d.addAttribute("deptList",service.getDeptList(sch));
		return "WEB-INF\\views\\a05_mvc\\a02_deptList.jsp";
	}
	
	@RequestMapping("MyinserDept.do")
	public String MyinserDept(Dept ins) {
		
		   return "redirect:MyDeptList.do";
	}
	
	@GetMapping("deptAjaxInit.do")
	public String deptAjaxInitG() {
		return "WEB-INF\\views\\a05_mvc\\a04_ajaxList.jsp";
	}
	@PostMapping("deptAjaxInit2.do")
	public String deptAjaxInitP(Dept sch,Model d) {
		d.addAttribute("dlist",service.getDeptList(sch));
		return "pageJsonReport";
	}
	@RequestMapping("DeptAjAX.do")
	public String DeptAjAXP(@RequestParam("deptno") int deptno,Model d) {
		d.addAttribute("DeptAjax",service.DeptAjAXP(deptno));
		return "pageJsonReport";
	}
	@RequestMapping("updateDept")
	public String updateDept(Dept del) {
		service.updateDept(del);
		return "";
	}
	@RequestMapping("deleteDept")
	public String deleteDept(@RequestParam("deptno") int deptno) {
		service.deleteDept(deptno);
		return "";
	}
}
