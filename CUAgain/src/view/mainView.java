package view;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.ProductDAO;

public class mainView {
	Scanner sc = new Scanner(System.in);
	String order[] = new String[2];
	public static ArrayList <String[]>basket = new ArrayList<>();
	ProductDAO pdao = new ProductDAO();
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
//			sub_refund();
			break;
		case 3:
//			sub_signup();
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
		ArrayList <String[]>cmeal = new ArrayList<>();
		String category ="간편식사";
		
		cmeal = pdao.menulist(category);
//		pdao.menulist(category);
//		ProductDAO.menu;
		int i=0;
				
		for(i=0;i<cmeal.size();i++) {
			System.out.println("======"+(i+1)+"."+cmeal.get(i)[1]+"======");
		}
		System.out.println("======"+(i+2)+".이전메뉴"+"======");
		System.out.println("======"+(i+3)+".종                 료======");
		System.out.println("메뉴를 선택하세요:");
		int menu = Integer.parseInt(sc.nextLine());
		
		order[0]=cmeal.get(menu)[0];
		System.out.println("몇개를 구입하시겠습니까?");
		int orderCount = Integer.parseInt(sc.nextLine());
		order[1] = Integer.toString(orderCount);
		basket.add(order);
		
		if(menu==i+2) {
			sub_buy();
		}else if(menu==i+3) {
			System.out.println("프로그램을 종료합니다.");
		}else {
			System.exit(0);
		}
					
	}
	public void instant() {
		ArrayList <String[]>instant = new ArrayList<>();
		String category ="즉석요리";
		
		instant = pdao.menulist(category);
		int i=0;
				
		for(i=0;i<instant.size();i++) {
			System.out.println("======"+(i+1)+"."+instant.get(i)[1]+"======");
		}
		System.out.println("======"+(i+2)+".이전메뉴"+"======");
		System.out.println("======"+(i+3)+".종                 료======");
		System.out.println("메뉴를 선택하세요:");
		int menu = Integer.parseInt(sc.nextLine());
		
		order[0]=instant.get(menu)[0];
		System.out.println("몇개를 구입하시겠습니까?");
		int orderCount = Integer.parseInt(sc.nextLine());
		order[1] = Integer.toString(orderCount);
		basket.add(order);
		if(menu==i+2) {
			sub_buy();
		}else if(menu==i+3) {
			System.out.println("프로그램을 종료합니다.");
		}else {
			System.exit(0);
		}
	}
	public void snack() {
		ArrayList <String[]>snack = new ArrayList<>();
		String category ="과자류";
		
		snack = pdao.menulist(category);
		int i=0;
				
		for(i=0;i<snack.size();i++) {
			System.out.println("======"+(i+1)+"."+snack.get(i)[1]+"======");
		}
		System.out.println("======"+(i+2)+".이전메뉴"+"======");
		System.out.println("======"+(i+3)+".종                 료======");
		System.out.println("메뉴를 선택하세요:");
		int menu = Integer.parseInt(sc.nextLine());
		
		order[0]=snack.get(menu)[0];
		System.out.println("몇개를 구입하시겠습니까?");
		int orderCount = Integer.parseInt(sc.nextLine());
		order[1] = Integer.toString(orderCount);
		basket.add(order);
		if(menu==i+2) {
			sub_buy();
		}else if(menu==i+3) {
			System.out.println("프로그램을 종료합니다.");
		}else {
			System.exit(0);
		}
	}
	public void icecream() {
		ArrayList <String[]>icecream = new ArrayList<>();
		String category ="아이스크림";
		
		icecream = pdao.menulist(category);
		int i=0;
				
		for(i=0;i<icecream.size();i++) {
			System.out.println("======"+(i+1)+"."+icecream.get(i)[1]+"======");
		}
		System.out.println("======"+(i+2)+".이전메뉴"+"======");
		System.out.println("======"+(i+3)+".종                 료======");
		System.out.println("메뉴를 선택하세요:");
		int menu = Integer.parseInt(sc.nextLine());
		
		order[0]=icecream.get(menu)[0];
		System.out.println("몇개를 구입하시겠습니까?");
		int orderCount = Integer.parseInt(sc.nextLine());
		order[1] = Integer.toString(orderCount);
		basket.add(order);
		if(menu==i+2) {
			sub_buy();
		}else if(menu==i+3) {
			System.out.println("프로그램을 종료합니다.");
		}else {
			System.exit(0);
		}
	}
	public void food() {
		ArrayList <String[]>food = new ArrayList<>();
		String category ="식품";
		
		food = pdao.menulist(category);
		int i=0;
				
		for(i=0;i<food.size();i++) {
			System.out.println("======"+(i+1)+"."+food.get(i)[1]+"======");
		}
		System.out.println("======"+(i+2)+".이전메뉴"+"======");
		System.out.println("======"+(i+3)+".종                 료======");
		System.out.println("메뉴를 선택하세요:");
		int menu = Integer.parseInt(sc.nextLine());
		
		order[0]=food.get(menu)[0];
		System.out.println("몇개를 구입하시겠습니까?");
		int orderCount = Integer.parseInt(sc.nextLine());
		order[1] = Integer.toString(orderCount);
		basket.add(order);
		if(menu==i+2) {
			sub_buy();
		}else if(menu==i+3) {
			System.out.println("프로그램을 종료합니다.");
		}else {
			System.exit(0);
		}
	}
	public void drink() {
		ArrayList <String[]>drink = new ArrayList<>();
		String category ="음료";
		
		drink = pdao.menulist(category);
		int i=0;
				
		for(i=0;i<drink.size();i++) {
			System.out.println("======"+(i+1)+"."+drink.get(i)[1]+"======");
		}
		System.out.println("======"+(i+2)+".이전메뉴"+"======");
		System.out.println("======"+(i+3)+".종                 료======");
		System.out.println("메뉴를 선택하세요:");
		int menu = Integer.parseInt(sc.nextLine());
		
		order[0]=drink.get(menu)[0];
		System.out.println("몇개를 구입하시겠습니까?");
		int orderCount = Integer.parseInt(sc.nextLine());
		order[1] = Integer.toString(orderCount);
		basket.add(order);
		if(menu==i+2) {
			sub_buy();
		}else if(menu==i+3) {
			System.out.println("프로그램을 종료합니다.");
		}else {
			System.exit(0);
		}
	}
	public void housegoods() {
		ArrayList <String[]>housegoods = new ArrayList<>();
		String category ="음료";
		
		housegoods = pdao.menulist(category);
		int i=0;
				
		for(i=0;i<housegoods.size();i++) {
			System.out.println("======"+(i+1)+"."+housegoods.get(i)[1]+"======");
		}
		System.out.println("======"+(i+2)+".이전메뉴"+"======");
		System.out.println("======"+(i+3)+".종                 료======");
		System.out.println("메뉴를 선택하세요:");
		int menu = Integer.parseInt(sc.nextLine());
		
		order[0]=housegoods.get(menu)[0];
		System.out.println("몇개를 구입하시겠습니까?");
		int orderCount = Integer.parseInt(sc.nextLine());
		order[1] = Integer.toString(orderCount);
		basket.add(order);
		if(menu==i+2) {
			sub_buy();
		}else if(menu==i+3) {
			System.out.println("프로그램을 종료합니다.");
		}else {
			System.exit(0);
		}
	}
	
	
	
}
