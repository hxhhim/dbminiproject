package view;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import DAO.ProductDAO;
import DAO.purcahseDAO;
import DAO.storeDAO;
import action.Action;
import action.MemberAddAction;
import action.ProductAddAction;
import action.ProductUpdateAction;
import action.StockAddAction;
import action.StockUpdateAction;
import action.StoreAddAction;
import action.StoreUpdateAction;
import controller.MemberController;

public class mainView {
	Scanner sc = new Scanner(System.in);
	String order[] = new String[2];
	public static ArrayList <String[]>basket = new ArrayList<>();
	ProductDAO pdao = new ProductDAO();
	storeDAO sdao = new storeDAO();
	purcahseDAO pudao = new purcahseDAO();
	public static String selsname=null;
	public static String posno=null;
	MemberController memberController = new MemberController();
	
	
	public void mainview() {
		
		boolean isStop = false;
		Action action = null;
		storemenu();
		do {
		System.out.println("=======편 의  점=======");
		System.out.println("1.구매하기");
//		System.out.println("2.환     불 ");
		System.out.println("2.회원가입");
		System.out.println("3.종      료");
		int menu = Integer.parseInt(sc.nextLine());
		
		switch (menu) {
		case 1:
			sub_buy();
			break;
		case 2:
			action = new MemberAddAction();
			if(action !=null) {
				memberController.processorRequest(action, sc);
			}
			break;
		case 3:
			isStop = true;
			System.out.println("프로그램을 종료합니다.");
			break;
		case 999:
			adminMenu();
			break;
			
					
		default:
			System.out.println("다시 입력하세요.");
			break;
		}
		}while(!isStop);
	 }
	public void storemenu() {
		ArrayList <String> sm = new ArrayList<>();
		sm = sdao.storelist();
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println("=======편 의  점=======");
		int i=0;
		for(i=0;i<sm.size();i++) {
			System.out.println(""+(i+1)+"."+sm.get(i)+"");
		}
		System.out.println(""+(i+1)+".종         료");
		
		int menu = Integer.parseInt(sc.nextLine());
		
		selsname=sm.get(menu-1);
		
		int nowtime = now.getHour();
		if(nowtime%2!=0) {
			posno="POS-01";
		}else {
			posno="POS-02";
		}
				
		if(menu==i+1) {
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		}else {
			
		}
		
	}
	public void sub_buy() {
		boolean isStop = false;
		
		System.out.println("1.간편식사");
		System.out.println("2.즉석요리");
		System.out.println("3.과  자 류");
		System.out.println("4.아이스크림");
		System.out.println("5.식      품");
		System.out.println("6.음      료");
		System.out.println("7.생활용품");
		System.out.println("8.이전메뉴");
		System.out.println("9.종      료");
//		System.out.println(selsname+posno);
		int menu = Integer.parseInt(sc.nextLine());
		
		switch (menu) {
		case 1:
			productsel("간편식사");
			break;
		case 2:
			productsel("즉석요리");
			break;
		case 3:
			productsel("과자류");
			break;
		case 4:
			productsel("아이스크림");
			break;
		case 5:
			productsel("식품");
			break;
		case 6:
			productsel("음료");
			break;
		case 7:
			productsel("생활용품");
			break;
		case 8:
			mainview();
			break;
		case 9:
			
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			break;
		default:
			System.out.println("다시 입력하세요.");
			break;
		}
		}
	public void productsel(String productsel) {
		ArrayList <String[]> cg = new ArrayList<>();
		String[] suborder = new String[2];
		cg = pdao.menulist(productsel);
//		pdao.menulist(category);
//		ProductDAO.menu;
		int i=0;
				
		for(i=0;i<cg.size();i++) {
			System.out.println(""+(i+1)+"."+cg.get(i)[1]+"");
		}
		System.out.println(""+(i+1)+".이전메뉴"+"");
		System.out.println(""+(i+2)+".종               료");
		System.out.println("메뉴를 선택하세요:");
		int menu = Integer.parseInt(sc.nextLine());
		
		if(menu==i+1) {
			sub_buy();
		}else if(menu==i+2) {
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		}
		
		suborder[0]=cg.get(menu-1)[0];
		System.out.println("몇개를 구입하시겠습니까?");
		int orderCount = Integer.parseInt(sc.nextLine());
		suborder[1] = Integer.toString(orderCount);
		order=suborder;
		basket.add(order);
//		order=null;
		
		System.out.println("1.계속구매하기");
		System.out.println("2.장  바  구  니");
		menu = Integer.parseInt(sc.nextLine());
		
		if(menu==1) {
			sub_buy();
		}else if(menu==2){
			pudao.pbasket();
		}
						
	}
	public void adminMenu() {
		Action action = null;
		
		System.out.println("관리자메뉴입니다");
		System.out.println("1.제품추가");
		System.out.println("2.제품정보수정");
		System.out.println("3.재고추가");
		System.out.println("4.재고수정");
		System.out.println("5.지점추가");
		System.out.println("6.지점수정");
		System.out.println("7.이전메뉴");
		System.out.println("8.종      료");
		
		int menu = Integer.parseInt(sc.nextLine());
		
		switch(menu) {
			case 1:
				action = new ProductAddAction();
				if(action !=null) {
					memberController.processorRequest(action, sc);
				}
				break;
			case 2:
				action = new ProductUpdateAction();
				if(action !=null) {
					memberController.processorRequest(action, sc);
				}
				break;
			case 3:
				action = new StockAddAction();
				if(action !=null) {
					memberController.processorRequest(action, sc);
				}
				break;
			case 4:
				action = new StockUpdateAction();
				if(action !=null) {
					memberController.processorRequest(action, sc);
				}
				break;
			case 5:
				action = new StoreAddAction();
				if(action !=null) {
					memberController.processorRequest(action, sc);
				}
				break;
			case 6:
				action = new StoreUpdateAction();
				if(action !=null) {
					memberController.processorRequest(action, sc);
				}
				break;
			case 7:
				storemenu();
			case 8:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("다시 입력하세요.");
				break;
				
				
	}
		
		
	}
	
	
	
	
	
}
