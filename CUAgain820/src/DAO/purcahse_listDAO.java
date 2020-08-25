package DAO;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class purcahse_listDAO {
	Connection con = getConnection();
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
	
}
