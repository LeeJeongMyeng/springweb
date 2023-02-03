package a01_diexp.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import a01_diexp.z03_vo.MemberVO;
import z01_vo.Dept;

@Service("a02service")
public class A02_Service {
	@Autowired
	private A03_Dao dao;
	
	public List<Dept> getDeptList(Dept sch){
		if(sch.getDname()==null) sch.setDname("");
		if(sch.getLoc()==null) sch.setLoc("");
		return dao.getDeptList(sch);
	}
	public List<MemberVO> getMemberList(MemberVO sch){
		if(sch.getName()==null) sch.setName("");
		if(sch.getAuthority()==null) sch.setAuthority("");
		return dao.getMemberList(sch);
	}
	public MemberVO login(MemberVO m) {
		if(m.getId()==null) m.setId("");
		if(m.getPass()==null) m.setPass("");
		return dao.login(m);
	}
}
