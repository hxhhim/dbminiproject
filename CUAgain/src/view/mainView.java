package view;

import java.util.Scanner;

public class mainView {
	Scanner sc = new Scanner(System.in);
	public void mainview() {
		boolean isStop = false;
		
		do {
		System.out.println("=======편 의  점=======");
		System.out.println("======1.구매하기======");
		System.out.println("======2.환     불 ======");
		System.out.println("======3.회원가입======");
		System.out.println("======4.종      료======");
		int menu = Integer.parseInt(sc.nextLine());
		
		switch (menu) {
		case 1:
			sub_buy();
			break;
		case 2:
			sub_refund();
			break;
		case 3:
			sub_signup();
			break;
		case 4:
			isStop = true;
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("다시 입력하세요.");
			break;
		}
		}while(!isStop);
	 }
	public void sub_buy() {
		boolean isStop = false;
		
		System.out.println("======1.간편식사======");
		System.out.println("======2.즉석요리======");
		System.out.println("======3.과  자 류======");
		System.out.println("======4.아이스크림=====");
		System.out.println("======5.식      품======");
		System.out.println("======6.음      료======");
		System.out.println("======7.생활용품======");
		System.out.println("======8.이전메뉴======");
		System.out.println("======9.종      료======");
		
		int menu = Integer.parseInt(sc.nextLine());
		
		switch (menu) {
		case 1:
			cmeal();
			break;
		case 2:
			instant();
			break;
		case 3:
			snack();
			break;
		case 4:
			icecream();
			break;
		case 5:
			food();
			break;
		case 6:
			drink();
			break;
		case 7:
			housegoods();
			break;
		case 8:
			mainview();
			break;
		case 9:
			isStop = true;
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("다시 입력하세요.");
			break;
		}
		}
	public void cmeal() {
		boolean isStop = false;
		
		System.out.println("======1.단짠 불고기  버거======");
		System.out.println("======2.보성   녹돈   정식======");
		System.out.println("======3.쿼노아바질샐러드======");
		System.out.println("======4.이    전    메    뉴======");
		System.out.println("======5.종                  료======");
		int menu = Integer.parseInt(sc.nextLine());
		switch (menu) {
		case 1:
			cmeal();
			break;
		case 2:
			instant();
			break;
		case 3:
			snack();
			break;
		case 4:
			sub_buy();
		case 5:
			isStop = true;
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("다시 입력하세요.");
			break;
		}
			
			
	}
	public void instant() {
		
	}
	public void snack() {
		
	}
	public void icecream() {
		
	}
	public void food() {
		
	}
	public void drink() {
		
	}
	public void housegoods() {
		
	}
	public int addproduct(int pno) {
		System.out.println("몇개를 구입하시겠습니까?");
		int stock = Integer.parseInt(sc.nextLine());
		return stock;
	}
	
}
