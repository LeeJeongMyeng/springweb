package springweb.a03_ajax;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import springweb.a13_database.A02_EmpDao;
import springweb.a13_database.A06_PareparedDao;
import springweb.z01_vo.Emp;
import z01_vo.Dept;

@RestController
public class A01_ReustController {
	A02_EmpDao dao = new A02_EmpDao();
	A06_PareparedDao Ddao = new A06_PareparedDao();
	// http://localhost:8084/springweb/callRest01.do
	@GetMapping("/callRest01.do")
	public String callRest01() {
		return "hello";
	}
	
	// http://localhost:8084/springweb/callRest02.do
	@GetMapping(value="/callRest02.do",produces="text/plain;charset=UTF-8")
	public String callRest02() {
		return "안녕하세요";
	}
	@GetMapping(value="/callRest03.do", produces="text/plain;charset=UTF-8")
	public String callRest03() {
		return "안녕하세요";
	}
	
	@GetMapping(value="/callRest04.do", produces="text/plain;charset=UTF-8")
	public String callRest04() {
		//{"empno":7780,"ename":"홍길동","sal":4000}
		return "{\"empno\":7780,\"ename\":\"홍길동\",\"sal\":4000}";
	}
	
	@GetMapping(value="/callRest05.do", produces="text/plain;charset=UTF-8")
	public String callRest05() {
		Gson g = new Gson();
		
		return g.toJson(new Dept(10,"인사","서울"));
	}
	
	@RequestMapping(value="/callRest06.do", produces="text/plain;charset=UTF-8")
	public String callRest06(Emp sch) {
		Gson g = new Gson();
		if(sch.getEname()==null)sch.setEname("");
		if(sch.getJob()==null)sch.setJob("");
		if(sch.getToSal()==0)sch.setToSal(9999);
		return g.toJson(dao.getEmpSch(sch));
	}
	
	@RequestMapping(value="/callRest07.do", produces="text/plain;charset=UTF-8")
	public String callRest07(Dept dsch) {
		Gson g = new Gson();
		if(dsch.getDname()==null) dsch.setDname("");
		if(dsch.getLoc()==null) dsch.setLoc("");
		;
		return g.toJson(Ddao.getDeptList(dsch));
	}
}
