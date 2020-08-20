package DAO;

import static db.jdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
				+ "VALUES (?, ?, ?, ?)";
		
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
		
		String sql = "UPDATE stock SET (pno, stock) "
				+ "pno = ?, stock = ? WHERE sno = ?";
		
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updateStock.getPno());
			pstmt.setInt(2, updateStock.getStock());
			pstmt.setString(3, updateStock.getSno());
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
}
