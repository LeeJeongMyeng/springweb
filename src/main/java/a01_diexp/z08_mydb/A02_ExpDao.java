package a01_diexp.z08_mydb;

import java.util.List;

import a01_diexp.z08_mydb.vo.DeptSalgrade;
import a01_diexp.z08_mydb.vo.Emp;
import a01_diexp.z08_mydb.vo.EmpDeptCom;
import a01_diexp.z08_mydb.vo.Salgrade;



public interface A02_ExpDao {
	public List<Salgrade> getSalgrade();
	
	public List<Emp> getEmpExp01();
	
	public List<EmpDeptCom> getEmpDeptList();
	
	public List<DeptSalgrade> getDeptSalgrade();
	
	public Emp getEmp(int empno);
	
	public int insertEmp(Emp sch);
	public int insertEmp2(Emp sch);
	
	public int deleteEmp(int empno);
	
}
