package springweb.a05_mvc.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a05_mvc.a03_dao.A01_EmpDao;
import springweb.z01_vo.Code;
import springweb.z01_vo.Dept;
import springweb.z01_vo.Emp;
import springweb.z01_vo.EmpDept;

@Service
public class A01_EmpService {
	
	@Autowired(required=false)
	private A01_EmpDao dao;
	
	public List<Emp> getEmpList(Emp sch){
		if(sch.getEname()==null) sch.setEname("");
		if(sch.getJob()==null) sch.setJob("");
		return dao.getEmpList(sch);
	}
	
	public List<Dept> getDeptList(Dept sch){
		if(sch.getDname()==null) sch.setDname("");
		if(sch.getLoc()==null) sch.setLoc("");
		return dao.getDeptList(sch);
	}
		
	public List<Dept> getDeptCombo(){
		return dao.getDeptCombo();
	}
	public List<Code> getMgrCombo(){
		return dao.getMgrCombo();
	}
	public List<String> getJobCombo(){
		return dao.getJobCombo();
	}
	
	public Dept DeptAjAXP(int deptno) {
		return dao.DeptAjAXP(deptno);
	}

	public void updateDept(Dept del) {
		dao.updateDept(del);
	}
	public void deleteDept(int deptno) {
		dao.deleteDept(deptno);
	}
}
