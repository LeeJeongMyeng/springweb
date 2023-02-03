package springweb.a13_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import z01_vo.Dept;
import z01_vo.GameVO;

public class GameDao {
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	
	public List<GameVO> getScoreList(){
		List<GameVO> dlist = new ArrayList<GameVO>();
		String sql = "SELECT name,score,\r\n"
				+ "TO_CHAR(registdate,'YYYY/MM/DD - HH24\"시\"MI\"분\"')\r\n"
				+ "FROM gamescore\r\n"
				+ "ORDER BY score desc";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			// 위 sql의 ?에 해당하는 문자열을 mapping해서 데이터를 전달
			// 1. 위 형태로 ?로 설정하는 해당 데이터 형태만 입력이 되지,
			// sql injection이 처리되지 않는다.
			// 2. ?로 같은 유형을 sql을 먼저 서버에 전달되기에 한번 컴파일된 이후로는
			//    빠르게 수행될 수 있다.
			// pstmt.setString(1번부터 ?에 해당하는 순서, 데이터 );
			rs = pstmt.executeQuery(); // sql를 넣지 않는다.!!(주의)
			// select * ==> deptno, dname, loc
			while(rs.next()) {
				// select에 해당 컬럼에 맞는 컬럼명, 데이터유형에
				// 맞게 rs.get타입("컬럼명") 지정하여야 한다.
				dlist.add(new GameVO(rs.getString(1),
								   rs.getInt(2),
								   rs.getString(3))
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
	
	public int insertScore(GameVO d) {
		int success = 0;
		String sql = "INSERT INTO gamescore values(?,?,sysdate)";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, d.getName());
			pstmt.setInt(2, d.getScore());
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
	
	
	public boolean CheckGameUser (GameVO d){ // 기존 유저가있는지 호가인
	 	boolean isSuccess=false;
     
      String sql = "SELECT name FROM gamescore WHERE name=?";
      try {
         con = DB.con();
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1,d.getName() );
         
         rs = pstmt.executeQuery(); // sql를 넣지 않는다.!!(주의)
         isSuccess=rs.next(); //해당 id,pass로 조회될땜만 true 그 외, false
         
      } catch (SQLException e) {
         System.out.println("DB에러:"+e.getMessage());
      } catch(Exception e) {
         System.out.println("일반 에러:"+e.getMessage());
      }finally {
         DB.close(rs, pstmt, con);
      }
      
      return isSuccess;
   }
	
	public void updateScore(GameVO d) {
		String sql = "UPDATE GAMESCORE \r\n"
				+ "SET score=?,registdate=SYSDATE\r\n"
				+ "WHERE name=?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,d.getScore());
			pstmt.setString(2, d.getName());
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
