package DAO;

import static db.jdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Stock;

public class StockDAO
{
	Connection con;
	
	public StockDAO(Connection con)
	{
		this.con = con;
	}
	
	public int insertNewStock(Stock newStock)
	{
		int insertCount = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO stock "
				+ "VALUES (?, ?, ?)";
		
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newStock.getSno());
			pstmt.setString(2, newStock.getPno());
			pstmt.setInt(3, newStock.getStock());
			insertCount = pstmt.executeUpdate();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(pstmt != null)
				{
					close(pstmt);
				}
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return insertCount;
	}
	
	public int updateStock(Stock updateStock, String sno)
	{
		int updateCount = 0;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE stock SET stock = ? WHERE sno = ? AND pno = ?";
		
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, updateStock.getStock());
			pstmt.setString(2, sno);
			pstmt.setString(3, updateStock.getPno());
			updateCount = pstmt.executeUpdate();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(pstmt != null)
				{
					close(pstmt);
				}
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return updateCount;
	}
	public void stocklist(Connection con, String scode) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select pname,stock,sno from product,stock where product.pno=stock.pno and sno=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, scode);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				String pname = rs.getString(1);
				int stock = rs.getInt(2);
				String sno = rs.getString(3);
				System.out.println("지점: "+sno+" 제품명: "+pname+" 재고수량: "+stock);
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





















