package springweb.a13_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import z01_vo.SalGrade;



public class A04_salgrade {
	
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	static A04_salgrade SDao = new A04_salgrade();
	
	public List<SalGrade> getGradeSch(SalGrade sch){
		List<SalGrade> list = new ArrayList<SalGrade>();
		// 1. DB 연결
		try {
			con = DB.con();
//		   2. 대화
			String sql = "SELECT * \r\n"
					+ "FROM salgrade\r\n"
					+ "WHERE grade BETWEEN "+sch.getLowsal()+" AND "+sch.getHisal();
					
			// ORA-00920: invalid relational operator 이 에러가
			// 나는 분들은 아래와 같이 출력해보시면 sql 구문의 에러를 보일 겁니다.
			// 적당하게 위 sql 문자열에 띄워쓰기가 필요한 겁니다.
			System.out.println(sql);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			//select empno, ename, job, mgr, hiredate, sal, comm, deptno
			while(rs.next()) {
				SalGrade e = new SalGrade(
							rs.getInt(1),
							rs.getInt(2),
							rs.getInt(3)

						);
				list.add(e);
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
	
	
	
	
	public List<SalGrade> getGradeSch(){
		List<SalGrade> list = new ArrayList<SalGrade>();
		// 1. DB 연결
		try {
			con = DB.con();
//		   2. 대화
			String sql = "SELECT * \r\n"
					+ "FROM salgrade\r\n";
					
			// ORA-00920: invalid relational operator 이 에러가
			// 나는 분들은 아래와 같이 출력해보시면 sql 구문의 에러를 보일 겁니다.
			// 적당하게 위 sql 문자열에 띄워쓰기가 필요한 겁니다.
			System.out.println(sql);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			//select empno, ename, job, mgr, hiredate, sal, comm, deptno
			while(rs.next()) {
				SalGrade e = new SalGrade(
							rs.getInt(1),
							rs.getInt(2),
							rs.getInt(3)

						);
				list.add(e);
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
	
	public void insertGrade(SalGrade s) {
		String sql = "INSERT INTO SALGRADE VALUES(?,?,?)";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s.getGrade());
			pstmt.setInt(2, s.getLowsal());
			pstmt.setInt(3, s.getHisal());
			System.out.println("등록건수:"+pstmt.executeUpdate());
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
 
	
	public static void main(String[] args) {
		List<SalGrade> salList = SDao.getGradeSch(new SalGrade());
		// 외부에서 불러와서 검색된 내용
		for(SalGrade s:salList) {
			System.out.print(s.getGrade()+"\t");
			System.out.print(s.getLowsal()+"\t");
			System.out.print(s.getHisal()+"\n");

		}
	}

}
