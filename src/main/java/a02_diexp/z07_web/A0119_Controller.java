package a02_diexp.z07_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import z01_vo.Emp;





@Controller
public class A0119_Controller {
	// 실제 내용은 url로 호출하여 해당 요청값을 처리..
	@Autowired
	private A0119_Service service;
	
	
	public void getEmpSch(Emp sch){
		
			for(Emp e: service.getEmpSch(sch)) {
				System.out.print(e.getEname()+"\t");
			}
		
	}
}
