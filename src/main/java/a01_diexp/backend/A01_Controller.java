package a01_diexp.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import a01_diexp.z03_vo.MemberVO;
import z01_vo.Dept;



@Controller
public class A01_Controller {
	// 실제 내용은 url로 호출하여 해당 요청값을 처리..
	@Autowired
	private A02_Service service;
	
	public void getDeptList(Dept sch){
		List<Dept> dlist = service.getDeptList(sch);
		if(dlist!=null && dlist.size()>0) {
			for(Dept d: service.getDeptList(sch)) {
				System.out.print(d.getDeptno()+"\t");
				System.out.print(d.getDname()+"\t");
				System.out.print(d.getLoc()+"\n");
			}
		}else {
			System.out.println("검색된 부서정보가 없습니다.");
		}
	}
	public void getMemberList(MemberVO sch){
		for(MemberVO m: service.getMemberList(sch)) {
			System.out.print(m.getId()+"\t");
			System.out.print(m.getName()+"\t");
			System.out.print(m.getAuthority()+"\t");
			System.out.print(m.getPoint()+"\n");
		}
	}
	public MemberVO login(MemberVO m) {
		return service.login(m);
	}	
}
