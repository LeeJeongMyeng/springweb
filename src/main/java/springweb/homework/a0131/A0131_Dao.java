package springweb.homework.a0131;

import java.util.List;

import springweb.z01_vo.Emp;
import springweb.z01_vo.Salgrade;

public interface A0131_Dao {
	public List<Emp> getEmpList(Emp sch);
	public List<Salgrade> exp0131_3P();
	public Salgrade exp0131_33P(int grade);
}
