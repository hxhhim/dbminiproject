package DAO;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
	 static ArrayList<String[]> menu = new ArrayList<>();
	 
	public ArrayList menulist(String category) {
		Connection con = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String category1[]= new String[2];
		
		String sql ="SELECT pno,pname FROM product WHERE category=? ";
		
		try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, category);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			String pno = rs.getString(1);
			String pname = rs.getString(2);
			System.out.println(pno);
			System.out.println(pname);
			category1[0]= pno;
			category1[1]= pname;
			menu.add(category1);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//pno,pname�� �Է��� ī�װ��� db���� �޾ƿͼ� �޴� �迭�� ����
		//String category[] = new String[2];
		
	//	menu = category;// menu�� category�迭 ����
		
	return menu;
	}
	
}
