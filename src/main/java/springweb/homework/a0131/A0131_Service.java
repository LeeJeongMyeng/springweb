package springweb.homework.a0131;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.z01_vo.Emp;
import springweb.z01_vo.Member111;
import springweb.z01_vo.Salgrade;


@Service
public class A0131_Service {
	
	@Autowired(required=false)
	private A0131_Dao dao;
	
	public List<Emp> getEmpList(Emp sch){
		if(sch.getEname()==null) sch.setEname("");
	return dao.getEmpList(sch);
}
	public List<Salgrade> exp0131_3P() {
		return dao.exp0131_3P();
	}
	
	public Salgrade exp0131_33P(int grade) {
		
		return dao.exp0131_33P(grade);
	}
	
}
