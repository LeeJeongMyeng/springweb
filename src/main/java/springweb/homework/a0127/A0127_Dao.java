package springweb.homework.a0127;

import java.util.List;

import springweb.z01_vo.Code;
import springweb.z01_vo.Emp;
import springweb.z01_vo.Member111;



public interface A0127_Dao {
	public List<Emp> getEmpList(Emp sch);
	public List<Member111> getMemberList(Member111 sch); 
	public void updateMem(Member111 upt);
	public void deleteMem(Member111 del);
	public List<String> getAuthInfo();
}
