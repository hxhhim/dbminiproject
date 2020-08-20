package util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


import java.util.Scanner;

import vo.Product;
import vo.Stock;
import vo.Store;
import DAO.purcahse_listDAO;

public class consoleUtil {
	purcahse_listDAO listDAO = new purcahse_listDAO();
	Scanner sc = new Scanner(System.in);
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
		 System.out.println("결제방법선택");
		 System.out.println("1.현금결제");
		 System.out.println("2.카드결제");
		 String payway = null;
		 int menu = Integer.parseInt(sc.nextLine());
		 if(menu==1) {
			 payway="현금";
		 }else if(menu==2) {
			 payway="카드";
		 }
		 
		 return payway;
	 }
	 public int memberNo() {
		 System.out.println("회원이십니까?(y/n)");
		 String member = sc.nextLine();
		 int num=1;
		 if(member.equals("y")) {
			 System.out.println("회원번호를 입력하세요:");
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
			System.out.println("등록할 제품의 정보를 입력하세요.");
			System.out.print("제품번호 : ");
			String pno = scanner.nextLine();
			
			System.out.print("카테고리 : ");
			String category = scanner.nextLine();
			
			System.out.print("제품회사 : ");
			String comp = scanner.nextLine();
			
			System.out.print("제품명 : ");
			String pname = scanner.nextLine();
			
			System.out.print("가격 : ");
			int price = Integer.parseInt(scanner.nextLine());
			
			System.out.println("유통기한 : (YYYY-MM-DD)");
			String shelflife = scanner.nextLine();
			
			System.out.println("이벤트 여부 : (1: O / 2: X)");
			int event = Integer.parseInt(scanner.nextLine());
			
			return new Product(pno, category, comp, pname, price, shelflife, event);
		}
		
		public String updatePno(Scanner scanner)
		{
			System.out.println("수정을 원하는 제품번호를 입력하세요 : ");
			String updatePno = scanner.nextLine();
			
			return updatePno;
		}
		
		public Product getUpdateProduct(Scanner scanner)
		{
			System.out.println("수정할 제품의 정보를 입력하세요.");
			
			System.out.print("카테고리 : ");
			String category = scanner.nextLine();
			
			System.out.print("제품회사 : ");
			String comp = scanner.nextLine();
			
			System.out.print("제품명 : ");
			String pname = scanner.nextLine();
			
			System.out.print("가격 : ");
			int price = Integer.parseInt(scanner.nextLine());
			
			System.out.print("유통기한 : (YYYY-MM-DD)");
			String shelflife = scanner.nextLine();
			
			System.out.println("이벤트 여부 : (1: O / 2: X)");
			int event = Integer.parseInt(scanner.nextLine());
			
			return new Product(category, comp, pname, price, shelflife, event);
		}
		
		public Store getNewStore(Scanner scanner)
		{
			System.out.println("등록할 지점의 정보를 입력하세요.");
			
			System.out.print("편의점 코드 : ");
			String sno = scanner.nextLine();
			
			System.out.print("지점명 : ");
			String sname = scanner.nextLine();
			
			System.out.print("주소 : ");
			String address = scanner.nextLine();
			
			System.out.println("관리자 : ");
			String admin = scanner.nextLine();
			
			return new Store(sno, sname, address, admin);
		}
		
		public String updateSno(Scanner scanner)
		{
			System.out.println("수정을 원하는 편의점 코드를 입력하세요 : ");
			String updateSno = scanner.nextLine();
			
			return updateSno;
		}
		
		public Store getUpdateStore(Scanner scanner)
		{
			System.out.println("수정할 편의점의 정보를 입력하세요.");
			
			System.out.print("지점명 : ");
			String sname = scanner.nextLine();
			
			System.out.print("주소 : ");
			String address = scanner.nextLine();
			
			System.out.print("관리자 : ");
			String admin = scanner.nextLine();
			
			return new Store(sname, address, admin);
		}
		
		public Stock getNewStock(Scanner scanner)
		{
			System.out.println("편의점에 추가할 제품의 재고를 입력하세요.");
			
			System.out.print("편의점 코드 : ");
			String sno = scanner.nextLine();
			
			System.out.print("제품번호 : ");
			String pno = scanner.nextLine();
			
			System.out.print("재고 수량 : ");
			int stock = Integer.parseInt(scanner.nextLine());
			
			return new Stock(sno, pno, stock);
		}
		
		public Stock getUpdateStock(Scanner scanner)
		{
			System.out.println("수정할 편의점의 제품 재고를 입력하세요");
			
			System.out.print("제품번호 : ");
			String pno = scanner.nextLine();
			
			System.out.print("재고 수량 : ");
			int stock = Integer.parseInt(scanner.nextLine());
			
			return new Stock(pno, stock);
		}
}



	

