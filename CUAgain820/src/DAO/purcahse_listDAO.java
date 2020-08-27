package DAO;

import static db.jdbcUtil.getConnection;
import static db.jdbcUtil.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import util.consoleUtil;

public class purcahse_listDAO {
	Connection con ;
	consoleUtil cs = new consoleUtil();
	
	public purcahse_listDAO(Connection con) {
		this.con = con;
	}
	
	public int getBarcode(String barcode) {
	      PreparedStatement pstmt = null;
	      String sql = "SELECT barcode FROM purchase_list"
	            + "WHERE barcode=?";
	      int duBarcode = 0;
	      try {
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1,barcode);
	         duBarcode = pstmt.executeUpdate();
	         return ++duBarcode;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return duBarcode;
	   }
	public void purchasehistoryid(Connection con,int pid) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*),SUM(totalpay) FROM PURCHASE_LIST WHERE MNO=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pid);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				int count = rs.getInt(1);
				int sum = rs.getInt(2);
				System.out.println("회원번호: "+pid+" 구매건수: "+count+" 총구매금액: "+sum);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) {
					close(rs);
				}if(pstmt !=null) {
					close(pstmt);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public void purchaseHistoryDate(Connection con,String[] pdate) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*),sum(totalpay) from purchase_list where paytime like ? and ploc=?";

		String ploc = pdate[0];
		String paytime = pdate[1];
		String paytime1 = pdate[1]+"%";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, paytime1);
			pstmt.setString(2, ploc);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				int count = rs.getInt(1);
				int sum = rs.getInt(2);
				System.out.println("지점: "+ploc+"기간: "+paytime+"구매건수: "+count+"총구매금액: "+sum);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) {
					close(rs);
				}if(pstmt !=null) {
					close(pstmt);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
