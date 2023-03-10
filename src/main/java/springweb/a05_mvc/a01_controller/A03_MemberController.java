package springweb.a05_mvc.a01_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a05_mvc.a02_service.A03_MemberService;
import springweb.z01_vo.Member111;

@Controller
public class A03_MemberController {
	@Autowired(required = false)
	private A03_MemberService service;

	@ModelAttribute("authCom")
	public List<String> getAuthCom(){
		return service.getAuthCom();
	}
	@RequestMapping("/memberListMy.do")
	public String memberList(@ModelAttribute("sch") Member111 sch,
				Model d) {
		d.addAttribute("mlist",service.getMemberList(sch));
		return "WEB-INF\\views\\a05_mvc\\a03_memberList.jsp";
	}
	// memberMy.do
	@GetMapping("/memberMy.do")
	public String getMember(@RequestParam("id") String id, 
							Model d) {
		d.addAttribute("mem", service.getMember(id));
		d.addAttribute("mlist",service.getMemberList(new Member111()));
		return "WEB-INF\\views\\a05_mvc\\a03_memberList.jsp";
	}
	// /memberUpt.do /memberDel.do
	@RequestMapping("/memberUpt")
	public String memberUpt(Member111 upt, Model d) {
		service.uptMember(upt);
		d.addAttribute("mem", service.getMember(upt.getMid()));
		d.addAttribute("mlist",service.getMemberList(new Member111()));
		return "WEB-INF\\views\\a05_mvc\\a03_memberList.jsp";
	} 
	@RequestMapping("/memberDel")
	public String memberUpt(@RequestParam("id") String id) {
		service.delMember(id);
		return "WEB-INF\\views\\a05_mvc\\a03_memberList.jsp";
	}	
	
	@GetMapping("memberMyAjax.do")
	public String memberMyAjax(@RequestParam("mid")String mid,Model d) {
		d.addAttribute("mem",service.getMember(mid));
		return "pageJsonReport";
	}
	
}
