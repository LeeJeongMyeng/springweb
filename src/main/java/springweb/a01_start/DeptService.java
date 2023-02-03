package springweb.a01_start;

import org.springframework.stereotype.Service;

import springweb.a13_database.A06_PareparedDao;
import z01_vo.Dept;
import z01_vo.MemberVO;


@Service
public class DeptService {
	A06_PareparedDao dao = new A06_PareparedDao();
	
	
	 public int insertDept(Dept dept) { return dao.insertDept(dept); }
	 
	
	public String Login(String id, String pass) {
		return dao.login(id, pass);
	}
	
	public int InsertMember(MemberVO mem) {
		return dao.insertMember(mem);
	}
	
	
	
}
