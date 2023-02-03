package springweb.a02_dao1;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a13_database.A02_EmpDao;
import springweb.a13_database.A06_PareparedDao;
import springweb.z01_vo.Code;
import springweb.z01_vo.Emp;
import z01_vo.Dept;


//springweb.a02_dao1.A01_EmpController

@Controller
public class A01_EmpController {
   private A02_EmpDao dao = new A02_EmpDao();
   private A06_PareparedDao ddao =new A06_PareparedDao();
   public A01_EmpController() {
		
   }
   
   
   @ModelAttribute("mgrCode")
	public List<Code> getMgrInfo(){
		return dao.getMgrInfo();
	}
   
   @ModelAttribute("deptCode")
   public List<Code> getdeptInfo(){
	   return ddao.getDeptInfo();
   }
   @ModelAttribute("salGradeCode")
   public List<Code> getsalGradeInfo(){
	   return dao.getSGradeInfo();
   }
   
   
   
   // http://localhost:7080/springweb/empList.do
   //@ModelAttribute("sch") 모델값을 지정
   @RequestMapping("/empList.do")
   public String empList(@ModelAttribute("sch") Emp sch, Model d) {
      if(sch.getEname()==null) sch.setEname("");
      if(sch.getJob()==null) sch.setJob("");
      if(sch.getToSal()==0) sch.setToSal(9999);
      
      d.addAttribute("empList", dao.getEmpSch(sch));
      return "WEB-INF\\views\\a02_dao1\\a01_empList.jsp";
   }
   
   @RequestMapping("/empInsert.do")
   public String insertDept(Emp ins,Model d) {
	   int cnt =dao.insertEmp(ins);
	   //등록 후, 조회 컨트롤러를 다시 호출해야한다.
	   // 1)redirect 2)forward
	   // 데이터없이 전체 호줄되도록하기 위해서 redirect로 한다.
	   
	   return "redirect:/empList.do";
   }
   
   @RequestMapping("/deptList.do")
   public String deptList(Dept dsch, Model d) {
	   
	   if(dsch.getDname()==null) dsch.setDname("");
	   if(dsch.getLoc()==null) dsch.setLoc("");
	   
	   d.addAttribute("deptList", ddao.getDeptList(dsch));
	   return "WEB-INF\\views\\a02_dao1\\a02_deptList.jsp";
   }
   
   @RequestMapping("/deptInsert.do")
   public String insertDept(Dept ins,Model d) {
	   int success = ddao.insertDept(ins);
	   String check ="등록실패";
	   if(success==1) {check="등록완료";}
	   
	   d.addAttribute(check);
	   return "redirect:/deptList.do";
   }
  
}