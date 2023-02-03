package springweb.homework.a0130;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import springweb.z01_vo.Member111;


@Service
public class A0130_Service {
	
	@Autowired(required=false)
	private A0130_Dao dao;
	
	public int insertMem(Member111 ins) {
		
		return dao.insertMem(ins);
	}
	
}
