package a01_diexp.mybatis2.dao;

import java.util.List;

import springweb.z01_vo.Dept;
import springweb.z01_vo.Emp;
import springweb.z01_vo.Salgrade;

public interface A02_ExpDao {
	public List<Emp> getEmpData();
	
	public List<Salgrade> getSalgrade();
	
	public List<Emp> getEmphomework();
	public List<Dept> getDepthomework();
}
