package a01_diexp.backend;

import java.util.List;

import a01_diexp.z03_vo.MemberVO;
import z01_vo.Dept;


// public class A06_PreparedDao implements A03_Dao{
public interface A03_Dao {
	public List<Dept> getDeptList(Dept sch);
	public List<MemberVO> getMemberList(MemberVO sch);
	public MemberVO login(MemberVO m);
}
