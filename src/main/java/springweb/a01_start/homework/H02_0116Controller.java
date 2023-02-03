package springweb.a01_start.homework;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a13_database.A02_EmpDao;
import springweb.z01_vo.Emp;



@Controller
public class H02_0116Controller {
	A02_EmpDao dao = new A02_EmpDao();
	
	
	@RequestMapping("/a0116_exp.do")
	public String callPerson(@ModelAttribute("sch") Emp sch,Model d) {
			
		  if(sch.getEname()==null) sch.setEname("");
	      if(sch.getJob()==null) sch.setJob("");
	      if(sch.getToSal()==0) sch.setToSal(9999);
			
			d.addAttribute("empList",dao.getEmpSch(sch));
		return "WEB-INF\\homework\\a05_0116.jsp";
	}
	
}
