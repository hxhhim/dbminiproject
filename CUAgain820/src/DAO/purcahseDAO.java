package DAO;

import static db.jdbcUtil.commit;
import static db.jdbcUtil.getConnection;
import static db.jdbcUtil.rollback;
import static view.mainView.basket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import util.consoleUtil;
		

public class purcahseDAO {
		consoleUtil cu = new consoleUtil();
		int j=0;
		Scanner sc = new Scanner(System.in);
		String[] plist2 = new String[6];
		ArrayList <String[]> list = new ArrayList<>();
		
	public void pbasket() {
		Connection con = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int totalpay=0;
		try {
		
		for(int i=0;i<basket.size();i++) {
			String sql = "SELECT pname,price,stock,event FROM product,stock WHERE product.pno=stock.pno and product.pno=?";
			//String sql = "SELECT pname,price,stock,event FROM product WHERE pno=?";
			String pno = basket.get(i)[0];
			String orderCount = basket.get(i)[1];
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pno);
			rs= pstmt.executeQuery();
			
			while(rs.next()){
			String pname =rs.getString(1);
			int price =rs.getInt(2);
			int stock =rs.getInt(3);
			int event =rs.getInt(4);
			int paySum = price*Integer.parseInt(orderCount);
			totalpay += paySum;
			
			System.out.println((j=j+1)+"."+pname+"  "+"����:"+orderCount+" "+paySum+"��");// "\t"���� �߰��ٿ��� �ȵ�
			
			}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("\t"+"���հ�:"+totalpay);
		
		System.out.println((j+1)+"."+"��ٱ��Ϻκл���");
		System.out.println((j+2)+"."+"��ٱ�����ü����");
		System.out.println((j+3)+"."+"�����ϱ�");
		
		int menu = Integer.parseInt(sc.nextLine());
		if(menu==(j+1)) {
			System.out.println("������ ǰ���ȣ�� �Է�:");
			int del = Integer.parseInt(sc.nextLine());
			basket.remove(del-1);
			j=0;
			pbasket();
		}else if(menu==(j+2)) {
			basket.clear();
			j=0;
		}else if(menu==(j+3)) {
			j=0;
			payment();
		}else {
			j=0;
			pbasket();
		}
	}
	public void payment() {
		
		Connection con = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int totalpay=0;
		
		
		try {
		
		for(int i=0;i<basket.size();i++) {
			String[] plist = new String[7];
			String sql = "SELECT pname,price,stock,event FROM product,stock WHERE product.pno=stock.pno and product.pno=?";
		//	String sql = "SELECT pname,price,stock,event FROM product WHERE pno=?";
			String pno = basket.get(i)[0];
			String orderCount = basket.get(i)[1];
			plist[0]=pno;
			plist[1]=orderCount;
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pno);
			rs= pstmt.executeQuery();
			
			while(rs.next()){
			String pname =rs.getString(1);
			int price =rs.getInt(2);
			int stock =rs.getInt(3);
			int event =rs.getInt(4);
			if(event==1) {
				stock = stock*2;
			}
			int paySum = price*Integer.parseInt(orderCount);
			
			totalpay += paySum;
			plist[2]=pname;
			plist[3]=Integer.toString(price);
			plist[4]=Integer.toString(stock);
			plist[5]=Integer.toString(event);
			plist[6]=Integer.toString(paySum);
			list.add(plist);
			
			System.out.println((j=j+1)+"."+pname+"  "+"����:"+orderCount+" "+paySum+"��");// "\t"���� �߰��ٿ��� �ȵ�
			if(event==1) {
				System.out.println((j=j+1)+"."+pname+"  "+"����:"+orderCount+" "+0+"��"+"�������ǰ");//
			}
			}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("\t"+"���հ�:"+totalpay);
		String pway=cu.payway();
		int mno = cu.memberNo();
		int paymoney= 0;
		int change = 0;
		if(pway=="����") {
			System.out.println("�����ϽǱݾ��� �Է��ϼ���:");
			 paymoney= Integer.parseInt(sc.nextLine());
			 change = paymoney-totalpay;
			System.out.println("�Ž������� "+change+"�Դϴ�.");
			System.out.println("�ȳ��� ������.");
		}else if(pway=="ī��") {
			System.out.println("ī��� ������ �帱�Կ�.");
			System.out.println("�����մϴ�. �ȳ��� ������.");
		}
		String paytime= cu.time();
		String barcode= cu.barcode();
		String posno = cu.posno();
		plist2[0] = paytime;
		plist2[1] = barcode;
		plist2[2] = posno;
		plist2[3] = Integer.toString(mno);
		plist2[4] = Integer.toString(totalpay);
		plist2[5] = pway;
		
		
		System.out.println(paytime);
		System.out.println(barcode);
		System.out.println(posno);
		System.out.println(mno);
		System.out.println(totalpay);
		System.out.println(pway);
		
		for(String[] s:list) {
			System.out.println(s);	
		}
		purchaselistup();
		buylistup();
		stockup();
		
		
		
		
	}
	public int purchaselistup() {
		Connection con = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int insertCount = 0;
		
		try {
			String sql = "INSERT INTO purchase_list(paytime,barcode,pos_num,mno,totalpay,payway) VALUES(?,?,?,?,?,?) ";
					
			
			String paytime = plist2[0];
			String barcode = plist2[1];
			String posno = plist2[2];
			int mno = Integer.parseInt(plist2[3]);
			int totalpay = Integer.parseInt(plist2[4]);
			String pway = plist2[5];
						
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, paytime);
			pstmt.setString(2, barcode);
			pstmt.setString(3, posno);
			pstmt.setInt(4, mno);
			pstmt.setInt(5, totalpay);
			pstmt.setString(6, pway);
			
			insertCount = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(insertCount>0) {
			commit(con);
		}else {
			rollback(con);
		}
		return insertCount;
	  }
	public int buylistup() {
		Connection con = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int insertCount = 0;
		
		try {
			for(int i=0;i<list.size();i++) {
			String sql = "INSERT INTO buy(productname,paysum,orderCount,barcode) "
					 + "VALUES(?,?,?,?)";
			
			String productname = list.get(i)[2];
			int paysum = Integer.parseInt(list.get(i)[6]);
			int orderCount = Integer.parseInt(list.get(i)[1]);
			String barcode = plist2[1];
			
						
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, productname);
			pstmt.setInt(2, paysum);
			pstmt.setInt(3, orderCount);
			pstmt.setString(4, barcode);
						
			insertCount = pstmt.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(insertCount>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return insertCount;
	  }
		public int stockup() {
			Connection con = getConnection();
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			int insertCount = 0;
			
			try {
				for(int i=0;i<list.size();i++) {
				String sql = "UPDATE stock SET stock=? WHERE pno=? AND sno=?";
						 
	//			UPDATE member SET id=?,name=?,addr=?,nation=?,email=?,age=? WHERE id=?"
				String pno = list.get(i)[0];
				int stock = Integer.parseInt(list.get(i)[4]);
				stock = stock-(Integer.parseInt(list.get(i)[1]));
				String sno= "CU01";			
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, stock);
				pstmt.setString(2, pno);
				pstmt.setString(3, sno);
											
				insertCount = pstmt.executeUpdate();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			if(insertCount>0) {
				commit(con);
			}else {
				rollback(con);
			}
			
			return insertCount;
		}
	
	}

