package DAO;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static db.jdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import vo.Store;

public class storeDAO {
	static ArrayList<String> store = new ArrayList<>();
	
	public ArrayList storelist() {
		Connection con = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		store.clear();
		
		String sql = "SELECT sname FROM store";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String sname = rs.getString(1);
				store.add(sname);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return store;		
	}
	Connection con;
	public storeDAO() {
		
	}
	public storeDAO(Connection con)
	{
		this.con = con;
	}
	
	public int insertNewStore(Store newStore)
	{
		int insertCount = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO store "
				+ "VALUES (?, ?, ?, ?)";
		
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newStore.getSno());
			pstmt.setString(2, newStore.getSname());
			pstmt.setString(3, newStore.getAddress());
			pstmt.setString(4, newStore.getAdmin());
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
	
	public int updateStore(Store updateStore, String sno)
	{
		int updateCount = 0;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE store SET sname = ?, address = ?, admin = ? WHERE sno = ?";
		
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updateStore.getSname());
			pstmt.setString(2, updateStore.getAddress());
			pstmt.setString(3, updateStore.getAdmin());
			pstmt.setString(4, sno);
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




	


