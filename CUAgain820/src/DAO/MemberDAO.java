package DAO;

import static db.jdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Member;

public class MemberDAO {
	Connection con;

	public MemberDAO(Connection con) {
		this.con = con;
	}

	public int insertNewMember(Member newMember) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member VALUES(?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, newMember.getMno());
			pstmt.setString(2, newMember.getName());
			pstmt.setString(3, newMember.getPhone());
			pstmt.setInt(4, newMember.getReserve());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return insertCount;
	}

	public int getMno(String name) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT mno FROM member WHERE name=?";
		int mno = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				mno = rs.getInt(1);
			}
			return mno;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mno;
	}

//	public int deleteMember(int demno) {
//		int delCount = 0;
//		PreparedStatement pstmt = null;
//
//		String sql = "DELETE FROM member WHERE mno=?";
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(5, demno);
//			delCount = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (pstmt != null)
//					close(pstmt);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return delCount;
//	}

	public void listMember(Connection con) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String sql = "SELECT name,phone,reserves,mno,rank,mileage "
				+ "FROM grade,member WHERE reserves BETWEEN LOWERVALUE AND UPPERVALUE";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// String grade = rs.getString(1);
				String name = rs.getString(1);
				String phone = rs.getString(2);
				int reserve = rs.getInt(3);
				int mno = rs.getInt(4);
				String grade = rs.getString(5);
				int mileage = rs.getInt(6);
				Member newMember = new Member(name, phone, reserve, mno);
				newMember.setGrade(grade);
				newMember.setMileage(mileage);
				System.out.println(newMember + "[등급=" + grade + " 적립금=" + mileage + "]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int mno(Connection con) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM member";
		int numMno=0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				numMno++;
			}
			return numMno;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return numMno;
	}

	public int updateMember(Member newMember) {
		int updateCount = 0;
		PreparedStatement pstmt = null;

		String sql = "UPDATE member SET name=?,phone=? WHERE mno=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newMember.getName());
			pstmt.setString(2, newMember.getPhone());
			// pstmt.setInt(3, newMember.getReserve());
			pstmt.setInt(3, newMember.getMno());
			// pstmt.setInt(6, newMember.getMno());
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return updateCount;
	}

//	public int updateGrade(String grade, int upMno) {
//		int updateCount = 0;
//		PreparedStatement pstmt = null;
//
//		String sql = "UPDATE member SET grade=? WHERE mno=?";
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1,grade);
//			pstmt.setInt(2,upMno );
//			updateCount = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (pstmt != null)
//					close(pstmt);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return updateCount;
//	}
}
