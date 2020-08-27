package DAO;

import static db.jdbcUtil.close;
import static db.jdbcUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Product;

public class ProductDAO {
	 static ArrayList<String[]> menu = new ArrayList<>();
	 Connection con;
		public ProductDAO() {
			
		}
		public ProductDAO(Connection con)
		{
			this.con = con;
		}
		
		public int insertNewProduct(Product newProduct)
		{
			int insertCount = 0;
			PreparedStatement pstmt = null;
			
			String sql = "INSERT INTO product "
					+ "(pno, category, comp, pname, price, shelflife, event) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			try
			{
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, newProduct.getPno());
				pstmt.setString(2, newProduct.getCategory());
				pstmt.setString(3, newProduct.getComp());
				pstmt.setString(4, newProduct.getPname());
				pstmt.setInt(5, newProduct.getPrice());
				pstmt.setString(6, newProduct.getShelflife());
				pstmt.setInt(7, newProduct.getEvent());
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
		
		public int updateProduct(Product updateProduct, String pno)
		{
			int updateCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
//			String sql1 = "SELECT * FROM product WHERE pno = ?";
			
			String sql2 = "UPDATE product SET category=?, comp=?,"
					+ " pname=?, price=?, shelflife=?, event=? WHERE pno=? ";
		
			try
			{
//				pstmt = con.prepareStatement(sql1);
//				pstmt.setString(1, pno);
//				rs = pstmt.executeQuery();
//				
//				while(rs.next())
//				{
//					System.out.println("pno : " + rs.getString(1) + ", category : " + rs.getString(2)
//							+ ", comp : " + rs.getString(3) + ", pname : " + rs.getString(4)
//							+ ", price : " + rs.getInt(5) + ", shelflife : " + rs.getString(6)
//							+ ", event : " + rs.getInt(7));
//				}
				
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, updateProduct.getCategory());
				pstmt.setString(2, updateProduct.getComp());
				pstmt.setString(3, updateProduct.getPname());
				pstmt.setInt(4, updateProduct.getPrice());
				pstmt.setString(5, updateProduct.getShelflife());
				pstmt.setInt(6, updateProduct.getEvent());
				pstmt.setString(7, pno);
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
	public ArrayList menulist(String category) {
		Connection con = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		menu.clear();
				
		String sql ="SELECT pno,pname FROM product WHERE category=? ";
		
		try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, category);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			String category1[]= new String[2];
			String pno = rs.getString(1);
			String pname = rs.getString(2);
			category1[0]= pno;
			category1[1]= pname;
//			category1=null;
			menu.add(category1);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//pno,pname을 입력한 카테고리로 db에서 받아와서 메뉴 배열에 저장
		//String category[] = new String[2];
		
	//	menu = category;// menu에 category배열 저장
		
	return menu;
	}
	public void shelflifeProduct(Connection con,String scode) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="select pname ,shelflife, stock from product p, stock s where p.pno=s.pno and 2>(shelflife-sysdate)and sno=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, scode);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				String pname = rs.getString(1);
				String shelflife = rs.getString(2);
				int stock = rs.getInt(3);
				System.out.println("제품명: "+pname+" 유통기한: "+shelflife+" 재고수량: "+stock);
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
