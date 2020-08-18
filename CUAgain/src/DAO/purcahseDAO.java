package DAO;

import static db.jdbcUtil.getConnection;
import static view.mainView.basket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class purcahseDAO {
	public void purchase() {
		Connection con = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int totalpay=0;
		try {
		
		for(int i=0;i<basket.size();i++) {
			String sql = "SELECT pname,price,stock,event FROM product WHERE pno=?";
			String pno = basket.get(i)[0];
			String orderCount = basket.get(i)[1];
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pno);
			rs= pstmt.executeQuery();
			String pname =rs.getString(1);
			int price =rs.getInt(2);
			int stock =rs.getInt(3);
			int event =rs.getInt(4);
			int paySum = price*Integer.parseInt(orderCount);
			totalpay =+ paySum;
			System.out.println(pname+" "+"수량:"+orderCount+" "+paySum+"원");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("총합계:"+totalpay);
	}
	public void purchaselist() {
		Connection con = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int totalpay=0;
		try {
		
		for(int i=0;i<basket.size();i++) {
			String sql = "SELECT pname,price,stock,event FROM product WHERE pno=?";
			String pno = basket.get(i)[0];
			String orderCount = basket.get(i)[1];
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pno);
			rs= pstmt.executeQuery();
			String pname =rs.getString(1);
			int price =rs.getInt(2);
			int stock =rs.getInt(3);
			int event =rs.getInt(4);
			int paySum = price*Integer.parseInt(orderCount);
			totalpay =+ paySum;
			String sql1 = "INSERT INTO purchase_list VALUES(?,?,?,?,?,?,?)";
//			barcode//영수증바코드(VARCHAR2(20))
//			totalpay//총합산(number)
//			posno//pos번호(VARCHAR2(10))
//			paytime//결제시간(DATE)
//			buyloc//구매지점(VARCHAR2(10))
//			payway//결제수단(VARCHAR2(10))
//			mno//회원번호(number)
			
			
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	}

