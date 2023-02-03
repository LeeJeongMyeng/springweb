package springweb.homework.a0127;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.z01_vo.Code;
import springweb.z01_vo.Emp;
import springweb.z01_vo.Member111;


@Service
public class A0127_Service {
	
	@Autowired(required=false)
	private A0127_Dao dao;
	
	public List<Emp> getEmpList(Emp sch){
			if(sch.getEname()==null) sch.setEname("");
		return dao.getEmpList(sch);
	}
	public List<Member111> getMemberList(Member111 sch){
		if(sch.getMid()==null) sch.setMid("");
		if(sch.getName()==null) sch.setName("");
		if(sch.getAuth()==null) sch.setAuth("");
		return dao.getMemberList(sch);
	}
	
	public void updateMem(Member111 upt) {
		dao.updateMem(upt);
	}
	public void deleteMem(Member111 del) {
		dao.deleteMem(del);
	}
	
	public List<String> getAuthInfo(){
		return dao.getAuthInfo();
	}
	
}
