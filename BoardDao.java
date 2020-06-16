package board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	List list = new ArrayList();

	

	public BoardDao() { // 생성자를 통해서 호출할떄마다 DB연결까지)

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();

		} catch (Exception e) {
			System.out.println("db연결실패 " + e);
		}

	}

	// insert 메소드
	public void boardInsert(BoardBean board) throws Exception {
		try {
			String sql = "";

			// sql 문장
			sql = "insert into mvcboard (subject,content,writer) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("boardInset 메소드 예외" + e);
			e.printStackTrace();
			;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		}
	}// board insert 끝
		// getBoardList

	public List<BoardBean> getBoardList() throws Exception {
		try {
			String sql = "";

			// sql 문장
			sql = "select * from mvcboard";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardBean board = new BoardBean();
				board.setBno(rs.getInt("bno"));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				board.setReg_date(rs.getString("reg_date"));
				list.add(board);

			}
			return list;

		} catch (Exception e) {
			System.out.println("boardInset 메소드 예외" + e);
			e.printStackTrace();
			;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		}
		return null; // 여기다 return list하고 싶은데 그러면 finally 에서 닫히니까 null값이 return 된다고 함 그래서 편법으로 위에서 한번
						// return 해주고 여기서는 null로 해줌.
	}

	public BoardBean getContentBoard(int bno) throws Exception {
		try {
			String sql = "";
			BoardBean board = new BoardBean();

			// sql 문장
			sql = "select subject ,content,writer,reg_date from mvcboard where  bno=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);

			rs = pstmt.executeQuery();
			if (rs.next()) {

				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setReg_date(rs.getString("reg_date"));

				return board;
			}

		} catch (Exception e) {
			System.out.println("boardInset 메소드 예외" + e);
			e.printStackTrace();
			;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		}
		return null;
	}

	public void boardUpdate(BoardBean board) throws Exception {
		try {
			String sql = "";
			BoardBean bb = board;
			// sql 문장
			sql = "update  mvcboard set subject=?,content=? where bno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bb.getSubject());
			pstmt.setString(2, bb.getContent());
			pstmt.setInt(3, bb.getBno());
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("boardInset 메소드 예외" + e);
			e.printStackTrace();
			;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		}
	}

	public int boardDelete(int num) throws Exception {
		  int result =0;
		try {
			String sql = "";
		
			sql = "Delete from mvcboard where bno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
		result=	pstmt.executeUpdate();  // 반환타입 result set인데 그냥 int하나로만 해도되나?
			System.out.println("num은"+num);
			return result;
		} catch (Exception e) {
			System.out.println("boardInset 메소드 예외" + e);
			e.printStackTrace();
			
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		}
       return result;
	}
}
