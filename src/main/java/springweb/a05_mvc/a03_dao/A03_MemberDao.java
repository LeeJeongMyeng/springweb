package springweb.a05_mvc.a03_dao;

import java.util.List;


import springweb.z01_vo.Member111;
// springweb.a05_mvc.a03_dao.A03_MemberDao
public interface A03_MemberDao {
	public List<String> getAuthCom();	
	public List<Member111> getMemberList(Member111 sch);	
	public Member111 getMember(String id);	
	public void uptMember(Member111 upt);	
	public void delMember(String id);

}
