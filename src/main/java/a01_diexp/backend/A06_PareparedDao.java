package a01_diexp.backend;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import springweb.z01_vo.Code;
import z01_vo.Dept;
import z01_vo.MemberVO;






@Repository

public class A06_PareparedDao implements A03_Dao {
	// 전역변수 선언
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	// 조회 처리
	public List<Dept> getDeptList(Dept sch){
		List<Dept> dlist = new ArrayList<Dept>();
		String sql = "SELECT *\r\n"
				+ "FROM dept100\r\n"
				+ "WHERE dname LIKE '%'||?||'%'\r\n"
				+ "AND loc LIKE '%'||?||'%'";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			// 위 sql의 ?에 해당하는 문자열을 mapping해서 데이터를 전달
			// 1. 위 형태로 ?로 설정하는 해당 데이터 형태만 입력이 되지,
			// sql injection이 처리되지 않는다.
			// 2. ?로 같은 유형을 sql을 먼저 서버에 전달되기에 한번 컴파일된 이후로는
			//    빠르게 수행될 수 있다.
			// pstmt.setString(1번부터 ?에 해당하는 순서, 데이터 );
			pstmt.setString(1, sch.getDname()); //
			pstmt.setString(2, sch.getLoc());
			rs = pstmt.executeQuery(); // sql를 넣지 않는다.!!(주의)
			// select * ==> deptno, dname, loc
			while(rs.next()) {
				// select에 해당 컬럼에 맞는 컬럼명, 데이터유형에
				// 맞게 rs.get타입("컬럼명") 지정하여야 한다.
				dlist.add(new Dept(rs.getInt("deptno"),
								   rs.getString("dname"),
								   rs.getString("loc"))
						 );
			}
			System.out.println("데이터 건수:"+dlist.size());
			
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		
		return dlist;
	}
	
	public List<Code> getDeptInfo(){
		List<Code> list = new ArrayList<Code>();
		// 1. DB 연결
		try {
			con = DB.con();
//		   2. 대화
			String sql = "SELECT deptno code, dname val \r\n"
					+ "FROM dept100\r\n"
					+ "ORDER BY code";
			// ORA-00920: invalid relational operator 이 에러가
			// 나는 분들은 아래와 같이 출력해보시면 sql 구문의 에러를 보일 겁니다.
			// 적당하게 위 sql 문자열에 띄워쓰기가 필요한 겁니다.
			System.out.println(sql);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			//select empno, ename, job, mgr, hiredate, sal, comm, deptno
			while(rs.next()) {
				list.add(new Code(
							rs.getString(1),
							rs.getString(2)));
			}
			System.out.println("데이터 건수:"+list.size());
			
		} catch (SQLException e) {
			System.out.println("DB관련예외:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("기본 예외:"+e.getMessage());
		}finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}	
	
	
	
	// transaction 에러로 제대로 등록/수정/삭제되지 않을 때.
	// 다시 eclipse 재부팅해서 DB도 확인하고, 다시 실행한다.
	public int insertDept(Dept d) {
		int success = 0;
		String sql = "INSERT INTO dept100 values(?,?,?)";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, d.getDeptno());
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getLoc());
			success= pstmt.executeUpdate();
			System.out.println("등록성공:"+success);
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("rollback 에러:"+e1.getMessage());
			}
		} catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		return  success;
	}
	public int insertMember(MemberVO m) {
		int success = 0;
		String sql = "INSERT INTO member values(?,?,?,?,?)";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,m.getId() );
			pstmt.setString(2,m.getAuthority() );
			pstmt.setString(3,m.getName() );
			pstmt.setString(4,m.getPass() );
			pstmt.setInt(5,m.getPoint() );
			success= pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("rollback 에러:"+e1.getMessage());
			}
		} catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		return  success;
	}
	// 10 ==> 55, 인사, 부산
	public void updateDept(int deptno,Dept upt) {
		String sql = "UPDATE dept100\r\n"
				+ "   SET deptno = ?,\r\n"
				+ "       dname = ?,\r\n"
				+ "       loc = ?\r\n"
				+ "   WHERE deptno = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, upt.getDeptno());
			pstmt.setString(2, upt.getDname());
			pstmt.setString(3, upt.getLoc());
			pstmt.setInt(4, deptno);
			System.out.println("수정건수:"+pstmt.executeUpdate());
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("rollback 에러:"+e1.getMessage());
			}
		} catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
	}
	public void deleteDept(int deptno) {
		String sql = "DELETE FROM dept100\r\n"
				+ "WHERE deptno = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			System.out.println("삭제건수:"+pstmt.executeUpdate());
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("rollback 에러:"+e1.getMessage());
			}
		} catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	
	// 조회 처리
	 public List<MemberVO>  getMemberList(MemberVO sch){
	      List<MemberVO> Mlist = new ArrayList<MemberVO>();
	      String sql = "SELECT * FROM MEMBER\r\n"
	      		+ "WHERE name LIKE '%'||?||'%'\r\n"
	      		+ "and authority LIKE '%'||?||'%'";
	      try {
	         con = DB.con();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, sch.getName());
	         pstmt.setString(2, sch.getAuthority());
	         rs = pstmt.executeQuery(); // sql를 넣지 않는다.!!(주의)
	         while(rs.next()) {
	            Mlist.add(new MemberVO(
	                              rs.getString("id"),
	                              rs.getString("authority"),
	                              rs.getString("name"),
	                              rs.getString("pass"),
	                              rs.getInt("point")                  
	                               )
	                   );
	         }
	         System.out.println("데이터 건수:"+Mlist.size());
	         
	      } catch (SQLException e) {
	         System.out.println("DB에러:"+e.getMessage());
	      } catch(Exception e) {
	         System.out.println("일반 에러:"+e.getMessage());
	      }finally {
	         DB.close(rs, pstmt, con);
	      }
	      
	      return Mlist;
	   }
	
	 public boolean login2 (String id, String pass){
		 	boolean isSuccess=false;
	     
	      String sql = "SELECT * FROM MEMBER\r\n"
	      		+ "WHERE id=? and pass=?";
	      try {
	         con = DB.con();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, id);
	         pstmt.setString(2, pass);
	         rs = pstmt.executeQuery(); // sql를 넣지 않는다.!!(주의)
	         isSuccess=rs.next(); //해당 id,pass로 조회될땜만 true 그 외, false
	         
	         System.out.println("에이작슼ㅋ:"+isSuccess);
	         
	      } catch (SQLException e) {
	         System.out.println("DB에러:"+e.getMessage());
	      } catch(Exception e) {
	         System.out.println("일반 에러:"+e.getMessage());
	      }finally {
	         DB.close(rs, pstmt, con);
	      }
	      
	      return isSuccess;
	   }
	 public String login (String id, String pass){
		 String isSuccess="";
		 
		 String sql = "SELECT * FROM MEMBER\r\n"
				 + "WHERE id=? and pass=?";
		 try {
			 con = DB.con();
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1, id);
			 pstmt.setString(2, pass);
			 rs = pstmt.executeQuery(); // sql를 넣지 않는다.!!(주의)
			 if(rs.next()) {
				 isSuccess="성공";
			 }else {
				 isSuccess="실패";
			 }
			 
			 System.out.println("에이작슼ㅋ:"+isSuccess);
			 
		 } catch (SQLException e) {
			 System.out.println("DB에러:"+e.getMessage());
		 } catch(Exception e) {
			 System.out.println("일반 에러:"+e.getMessage());
		 }finally {
			 DB.close(rs, pstmt, con);
		 }
		 
		 return isSuccess;
	 }
	 
	 public boolean Dept (int deptno, String dname){
		 	boolean isSuccess=false;
	      List<Dept> Mlist = new ArrayList<Dept>();
	      String sql = "SELECT * FROM dept100\r\n"
	      		+ "WHERE deptno=?\r\n"
	      		+ "AND dname=?";
	      try {
	         con = DB.con();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setInt(1, deptno);
	         pstmt.setString(2, dname);
	         rs = pstmt.executeQuery(); // sql를 넣지 않는다.!!(주의)
	         isSuccess=rs.next(); //해당 id,pass로 조회될땜만 true 그 외, false
	         
	         System.out.println("데이터 건수:"+Mlist.size());
	         
	      } catch (SQLException e) {
	         System.out.println("DB에러:"+e.getMessage());
	      } catch(Exception e) {
	         System.out.println("일반 에러:"+e.getMessage());
	      }finally {
	         DB.close(rs, pstmt, con);
	      }
	      
	      return isSuccess;
	   }
		 
	 
	 public boolean checkId (String id){
		 	boolean isSuccess=false;
	      List<MemberVO> Mlist = new ArrayList<MemberVO>();
	      String sql = "SELECT * FROM MEMBER\r\n"
	      		+ "WHERE id=?";
	      try {
	         con = DB.con();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery(); // sql를 넣지 않는다.!!(주의)
	         isSuccess=rs.next(); //해당 id,pass로 조회될땜만 true 그 외, false
	         
	         //System.out.println("데이터 건수:"+Mlist.size());
	         
	      } catch (SQLException e) {
	         System.out.println("DB에러:"+e.getMessage());
	      } catch(Exception e) {
	         System.out.println("일반 에러:"+e.getMessage());
	      }finally {
	         DB.close(rs, pstmt, con);
	      }
	      
	      return isSuccess;
	   }
	 
	 
	 public MemberVO login(MemberVO m){
	      MemberVO mem=null;
	        // boolean isSuccess = false;
	         String sql = "SELECT *\r\n"
	               + "FROM MEMBER100\r\n"
	               + "WHERE id=? and pass=?";
	         try {
	            con = DB.con();
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, m.getId()); //
	            pstmt.setString(2, m.getPass());
	            rs = pstmt.executeQuery();
	            /*
	        (String id, String pass, String name, String grade, int point, String rday)
	             */
	            if(rs.next()) {
	               mem= new MemberVO(                     
	                     rs.getString(1),
	                     rs.getString(2),
	                     rs.getString(3),
	                     rs.getString(4),
	                     rs.getInt(5)                   
	                     );
	              
	            }
	            // 해당 id, pass로 조회 될 때만 true, 그 외는 false
	            
	         } catch (SQLException e) {
	            System.out.println("DB에러:"+e.getMessage());
	         } catch(Exception e) {
	            System.out.println("일반 에러:"+e.getMessage());
	         }finally {
	            DB.close(rs, pstmt, con);
	         }
	         
	         return mem;
	      }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		A06_PareparedDao dao = new A06_PareparedDao();

		// 12:15~
		//dao.insertDept(new Dept(11,"총무","부산"));
		// // 10 ==> 55, 인사, 부산
//		dao.updateDept(10, new Dept(55, "인사","부산"));
//		dao.deleteDept(55);
//		for(Dept d: dao.getDeptList(new Dept("",""))) {
//			System.out.print(d.getDeptno()+"\t");
//			System.out.print(d.getDname()+"\t");
//			System.out.print(d.getLoc()+"\n");
//		}
	}

	@Override
	public List<a01_diexp.z03_vo.MemberVO> getMemberList(a01_diexp.z03_vo.MemberVO sch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public a01_diexp.z03_vo.MemberVO login(a01_diexp.z03_vo.MemberVO m) {
		// TODO Auto-generated method stub
		return null;
	}
}
// ex) 부서등록 처리(PreparedStatement)

