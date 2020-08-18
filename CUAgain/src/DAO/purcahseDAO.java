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
			System.out.println(pname+" "+"����:"+orderCount+" "+paySum+"��");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("���հ�:"+totalpay);
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
//			barcode//���������ڵ�(VARCHAR2(20))
//			totalpay//���ջ�(number)
//			posno//pos��ȣ(VARCHAR2(10))
//			paytime//�����ð�(DATE)
//			buyloc//��������(VARCHAR2(10))
//			payway//��������(VARCHAR2(10))
//			mno//ȸ����ȣ(number)
			
			
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	}

