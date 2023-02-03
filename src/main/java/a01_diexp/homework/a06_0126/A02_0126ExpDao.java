package a01_diexp.homework.a06_0126;

import java.util.List;

import a01_diexp.homework.a06_0126.vo.Buyinfo111;
import a01_diexp.z08_mydb.vo.BuyProduct;
import a01_diexp.z08_mydb.vo.Dept;
import a01_diexp.z08_mydb.vo.DeptSalgrade;
import a01_diexp.z08_mydb.vo.Emp;
import a01_diexp.z08_mydb.vo.EmpDeptCom;
import a01_diexp.z08_mydb.vo.MemberVO;
import a01_diexp.z08_mydb.vo.Salgrade;



public interface A02_0126ExpDao {
	public List<MemberVO> getmember();
	
	public Dept getDept(int deptno);
	
	public int insertDept(Dept dept);
	
	public int deleteMember(String id);
	
	public List<Buyinfo111> getBuyResult();
	
}
