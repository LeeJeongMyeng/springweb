package springweb.homework;

import java.util.List;

import org.springframework.stereotype.Service;

import springweb.a13_database.A06_PareparedDao;
import z01_vo.Dept;
import z01_vo.MemberVO;

@Service
public class A0118_Service {
	
	A06_PareparedDao dao = new A06_PareparedDao();
	public List<MemberVO> getMemList(MemberVO mv) {
		return dao.getMemberList(mv);
	}
	
	public List<Dept> getdeptList(Dept dept) {
		return dao.getDeptList(dept);
	}
	
	public Dept getDeptInfo() {
		return new Dept(10,"회계","서울");
	}
	
}
