package util;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


import java.util.Scanner;

import vo.Member;
import vo.Product;
import vo.Stock;
import vo.Store;
import DAO.MemberDAO;
import DAO.purcahse_listDAO;

public class consoleUtil {
	purcahse_listDAO listDAO = new purcahse_listDAO();
	Scanner sc = new Scanner(System.in);
	Connection con = getConnection();
	MemberDAO memberDAO = new MemberDAO(con);
	
	public String barcode() {
	      SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMddHHmmss");
	            
	      Date time = new Date();
	            
	      String time1 = format1.format(time);
	      return time1;
	   }
	 public  String time() {
	       SimpleDateFormat time = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");
	       Date time2 = new Date();
	       String time1=time.format(time2);
	       
	       return time1;
	   }

	 public String payway() {
		 System.out.println("�����������");
		 System.out.println("1.���ݰ���");
		 System.out.println("2.ī�����");
		 String payway = null;
		 int menu = Integer.parseInt(sc.nextLine());
		 if(menu==1) {
			 payway="����";
		 }else if(menu==2) {
			 payway="ī��";
		 }
		 
		 return payway;
	 }
	 public int memberNo() {
		 System.out.println("ȸ���̽ʴϱ�?(y/n)");
		 String member = sc.nextLine();
		 int num=1;
		 if(member.equals("y")) {
			 System.out.println("ȸ����ȣ�� �Է��ϼ���:");
			 num=Integer.parseInt(sc.nextLine());
		 }
		 
		 return num;	 
	 }
	 public String posno() {
			LocalDateTime now = LocalDateTime.now();
			int nowtime = now.getHour();
			String posno = null;
			if(nowtime%2!=0) {
				posno="POS-01";
			}else {
				posno="POS-02";
			}
			return posno;
		}
	 public Product getNewProduct(Scanner scanner)
		{
			System.out.println("����� ��ǰ�� ������ �Է��ϼ���.");
			System.out.print("��ǰ��ȣ : ");
			String pno = scanner.nextLine();
			
			System.out.print("ī�װ� : ");
			String category = scanner.nextLine();
			
			System.out.print("��ǰȸ�� : ");
			String comp = scanner.nextLine();
			
			System.out.print("��ǰ�� : ");
			String pname = scanner.nextLine();
			
			System.out.print("���� : ");
			int price = Integer.parseInt(scanner.nextLine());
			
			System.out.println("������� : (YYYY-MM-DD)");
			String shelflife = scanner.nextLine();
			
			System.out.println("�̺�Ʈ ���� : (1: O / 2: X)");
			int event = Integer.parseInt(scanner.nextLine());
			
			return new Product(pno, category, comp, pname, price, shelflife, event);
		}
		
		public String updatePno(Scanner scanner)
		{
			System.out.println("������ ���ϴ� ��ǰ��ȣ�� �Է��ϼ��� : ");
			String updatePno = scanner.nextLine();
			
			return updatePno;
		}
		
		public Product getUpdateProduct(Scanner scanner)
		{
			System.out.println("������ ��ǰ�� ������ �Է��ϼ���.");
			
			System.out.print("ī�װ� : ");
			String category = scanner.nextLine();
			
			System.out.print("��ǰȸ�� : ");
			String comp = scanner.nextLine();
			
			System.out.print("��ǰ�� : ");
			String pname = scanner.nextLine();
			
			System.out.print("���� : ");
			int price = Integer.parseInt(scanner.nextLine());
			
			System.out.print("������� : (YYYY-MM-DD)");
			String shelflife = scanner.nextLine();
			
			System.out.println("�̺�Ʈ ���� : (1: O / 2: X)");
			int event = Integer.parseInt(scanner.nextLine());
			
			return new Product(category, comp, pname, price, shelflife, event);
		}
		
		public Store getNewStore(Scanner scanner)
		{
			System.out.println("����� ������ ������ �Է��ϼ���.");
			
			System.out.print("������ �ڵ� : ");
			String sno = scanner.nextLine();
			
			System.out.print("������ : ");
			String sname = scanner.nextLine();
			
			System.out.print("�ּ� : ");
			String address = scanner.nextLine();
			
			System.out.println("������ : ");
			String admin = scanner.nextLine();
			
			return new Store(sno, sname, address, admin);
		}
		
		public String updateSno(Scanner scanner)
		{
			System.out.println("������ ���ϴ� ������ �ڵ带 �Է��ϼ��� : ");
			String updateSno = scanner.nextLine();
			
			return updateSno;
		}
		
		public Store getUpdateStore(Scanner scanner)
		{
			System.out.println("������ �������� ������ �Է��ϼ���.");
			
			System.out.print("������ : ");
			String sname = scanner.nextLine();
			
			System.out.print("�ּ� : ");
			String address = scanner.nextLine();
			
			System.out.print("������ : ");
			String admin = scanner.nextLine();
			
			return new Store(sname, address, admin);
		}
		
		public Stock getNewStock(Scanner scanner)
		{
			System.out.println("�������� �߰��� ��ǰ�� ��� �Է��ϼ���.");
			
			System.out.print("������ �ڵ� : ");
			String sno = scanner.nextLine();
			
			System.out.print("��ǰ��ȣ : ");
			String pno = scanner.nextLine();
			
			System.out.print("��� ���� : ");
			int stock = Integer.parseInt(scanner.nextLine());
			
			return new Stock(sno, pno, stock);
		}
		
		public Stock getUpdateStock(Scanner scanner)
		{
			System.out.println("������ �������� ��ǰ ��� �Է��ϼ���");
			
			System.out.print("��ǰ��ȣ : ");
			String pno = scanner.nextLine();
			
			System.out.print("��� ���� : ");
			int stock = Integer.parseInt(scanner.nextLine());
			
			return new Stock(pno, stock);
		}
		public Member getNewMember(Scanner sc) {
			System.out.println("����� ȸ�� ������ �Է��ϼ���");
			System.out.print("�̸�: ");
			String name = sc.nextLine();
			
			System.out.print("��ȭ��ȣ: ");
			String phone = sc.nextLine();
			
			int mno = member_mno_seq();
			return new Member(name,phone,mno);
		}
		
		public int member_mno_seq(){
			int mno = 1;
			int preMno = memberDAO.mno(con);
			if(preMno == 0) {
				return mno;
			}
			else {
				return ++preMno;
			}
		}
		
//		public int getDeleteId(Scanner sc) {
//			System.out.println("������ȸ���� �̸��� �Է����ּ���: ");
//			String name = sc.nextLine();
//			int demno = memberDAO.getMno(name);
//			return demno;
//		}
		   
		public Member getupMember(Scanner sc) {
			System.out.println("������ ȸ�� ������ �Է��ϼ���");
			System.out.print("�̸�: ");
			String name = sc.nextLine();
			
			System.out.print("��ȭ��ȣ: ");
			String phone = sc.nextLine();
			int mno = updateId(name);
			return new Member(name,phone,mno);
		}
		
		public int updateId(String name) {
//			System.out.println("������ ȸ����  �̸��� �Է����ּ���: ");
//			String name = sc.nextLine();
			int updateMno = memberDAO.getMno(name);
			return updateMno;
		}
}



	

