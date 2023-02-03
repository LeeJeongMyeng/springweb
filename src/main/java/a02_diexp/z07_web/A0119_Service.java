package a02_diexp.z07_web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.z01_vo.Member111;
import z01_vo.Emp;

@Service("a02service")
public class A0119_Service {
	@Autowired
	private A0119_Dao dao;
	
	public List<Emp> getEmpSch(Emp sch){
		if(sch.getEname()==null) sch.setEname("");
		if(sch.getJob()==null) sch.setJob("");
		if(sch.getToSal()==0) sch.setToSal(9999);
		return dao.getEmpSch(sch);
	}
	
}
