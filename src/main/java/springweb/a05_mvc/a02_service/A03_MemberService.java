package springweb.a05_mvc.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.a05_mvc.a03_dao.A03_MemberDao;

import springweb.z01_vo.Member111;

@Service
public class A03_MemberService {
	@Autowired(required=false)
	private A03_MemberDao dao;
	public List<String> getAuthCom(){
		return dao.getAuthCom();
	}
	public List<Member111> getMemberList(Member111 sch){
		if(sch.getMid()==null) sch.setMid("");
		if(sch.getName()==null) sch.setName("");
		if(sch.getAuth()==null) sch.setAuth("");
		return dao.getMemberList(sch);
	}	
	public Member111 getMember(String mid) {
		return dao.getMember(mid);
	}
	public void uptMember(Member111 upt) {
		dao.uptMember(upt);
	}	
	public void delMember(String id) {
		dao.delMember(id);
	}
	
}
