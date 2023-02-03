package springweb.a05_mvc.a03_dao;

import java.util.List;

import springweb.z01_vo.Emp;
import springweb.z01_vo.Code;
import springweb.z01_vo.Dept;

public interface A01_EmpDao {
	public List<Emp> getEmpList(Emp sch);
	public List<Dept> getDeptList(Dept sch);
	
	public List<Dept> getDeptCombo();
	public List<Code> getMgrCombo();
	public List<String> getJobCombo();
	public Dept DeptAjAXP(int deptno);
	public void updateDept(Dept del);
	public void deleteDept(int deptno);
	
}
