package a01_diexp.mybatis.dao;

import java.util.List;

import springweb.z01_vo.Emp;

public interface A01_EmpDao {
	
	  public List<Emp> getEmpList(Emp sch);
	  
	  public int empCount();
	  
	  public double EmpMaxSal();
	  
	  public String empGetEname();
	  
	  public int empMaxSal20Deptno();
	  
	  public int empMaxMgr();
	  
	  public String empGetJob();
	  
	  public Emp getEmpByEmpno();
	  
	  public Emp getEmpByEname();
	 
	  
	  
}
