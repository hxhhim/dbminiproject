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
		System.out.println("=======�� ��  ��=======");
		System.out.println("======1.�����ϱ�======");
		System.out.println("======2.ȯ     �� ======");
		System.out.println("======3.ȸ������======");
		System.out.println("======4.��      ��======");
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
			System.out.println("���α׷��� �����մϴ�.");
			break;
		default:
			System.out.println("�ٽ� �Է��ϼ���.");
			break;
		}
		}while(!isStop);
	 }
	public void sub_buy() {
		boolean isStop = false;
		
		System.out.println("======1.����Ļ�======");
		System.out.println("======2.�Ｎ�丮======");
		System.out.println("======3.��  �� ��======");
		System.out.println("======4.���̽�ũ��=====");
		System.out.println("======5.��      ǰ======");
		System.out.println("======6.��      ��======");
		System.out.println("======7.��Ȱ��ǰ======");
		System.out.println("======8.�����޴�======");
		System.out.println("======9.��      ��======");
		
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
			System.out.println("���α׷��� �����մϴ�.");
			break;
		default:
			System.out.println("�ٽ� �Է��ϼ���.");
			break;
		}
		}
	public void cmeal() {
		ArrayList <String[]>cmeal = new ArrayList<>();
		String category ="����Ļ�";
		
		cmeal = pdao.menulist(category);
//		pdao.menulist(category);
//		ProductDAO.menu;
		int i=0;
				
		for(i=0;i<cmeal.size();i++) {
			System.out.println("======"+(i+1)+"."+cmeal.get(i)[1]+"======");
		}
		System.out.println("======"+(i+2)+".�����޴�"+"======");
		System.out.println("======"+(i+3)+".��                 ��======");
		System.out.println("�޴��� �����ϼ���:");
		int menu = Integer.parseInt(sc.nextLine());
		
		order[0]=cmeal.get(menu)[0];
		System.out.println("��� �����Ͻðڽ��ϱ�?");
		int orderCount = Integer.parseInt(sc.nextLine());
		order[1] = Integer.toString(orderCount);
		basket.add(order);
		
		if(menu==i+2) {
			sub_buy();
		}else if(menu==i+3) {
			System.out.println("���α׷��� �����մϴ�.");
		}else {
			System.exit(0);
		}
					
	}
	public void instant() {
		ArrayList <String[]>instant = new ArrayList<>();
		String category ="�Ｎ�丮";
		
		instant = pdao.menulist(category);
		int i=0;
				
		for(i=0;i<instant.size();i++) {
			System.out.println("======"+(i+1)+"."+instant.get(i)[1]+"======");
		}
		System.out.println("======"+(i+2)+".�����޴�"+"======");
		System.out.println("======"+(i+3)+".��                 ��======");
		System.out.println("�޴��� �����ϼ���:");
		int menu = Integer.parseInt(sc.nextLine());
		
		order[0]=instant.get(menu)[0];
		System.out.println("��� �����Ͻðڽ��ϱ�?");
		int orderCount = Integer.parseInt(sc.nextLine());
		order[1] = Integer.toString(orderCount);
		basket.add(order);
		if(menu==i+2) {
			sub_buy();
		}else if(menu==i+3) {
			System.out.println("���α׷��� �����մϴ�.");
		}else {
			System.exit(0);
		}
	}
	public void snack() {
		ArrayList <String[]>snack = new ArrayList<>();
		String category ="���ڷ�";
		
		snack = pdao.menulist(category);
		int i=0;
				
		for(i=0;i<snack.size();i++) {
			System.out.println("======"+(i+1)+"."+snack.get(i)[1]+"======");
		}
		System.out.println("======"+(i+2)+".�����޴�"+"======");
		System.out.println("======"+(i+3)+".��                 ��======");
		System.out.println("�޴��� �����ϼ���:");
		int menu = Integer.parseInt(sc.nextLine());
		
		order[0]=snack.get(menu)[0];
		System.out.println("��� �����Ͻðڽ��ϱ�?");
		int orderCount = Integer.parseInt(sc.nextLine());
		order[1] = Integer.toString(orderCount);
		basket.add(order);
		if(menu==i+2) {
			sub_buy();
		}else if(menu==i+3) {
			System.out.println("���α׷��� �����մϴ�.");
		}else {
			System.exit(0);
		}
	}
	public void icecream() {
		ArrayList <String[]>icecream = new ArrayList<>();
		String category ="���̽�ũ��";
		
		icecream = pdao.menulist(category);
		int i=0;
				
		for(i=0;i<icecream.size();i++) {
			System.out.println("======"+(i+1)+"."+icecream.get(i)[1]+"======");
		}
		System.out.println("======"+(i+2)+".�����޴�"+"======");
		System.out.println("======"+(i+3)+".��                 ��======");
		System.out.println("�޴��� �����ϼ���:");
		int menu = Integer.parseInt(sc.nextLine());
		
		order[0]=icecream.get(menu)[0];
		System.out.println("��� �����Ͻðڽ��ϱ�?");
		int orderCount = Integer.parseInt(sc.nextLine());
		order[1] = Integer.toString(orderCount);
		basket.add(order);
		if(menu==i+2) {
			sub_buy();
		}else if(menu==i+3) {
			System.out.println("���α׷��� �����մϴ�.");
		}else {
			System.exit(0);
		}
	}
	public void food() {
		ArrayList <String[]>food = new ArrayList<>();
		String category ="��ǰ";
		
		food = pdao.menulist(category);
		int i=0;
				
		for(i=0;i<food.size();i++) {
			System.out.println("======"+(i+1)+"."+food.get(i)[1]+"======");
		}
		System.out.println("======"+(i+2)+".�����޴�"+"======");
		System.out.println("======"+(i+3)+".��                 ��======");
		System.out.println("�޴��� �����ϼ���:");
		int menu = Integer.parseInt(sc.nextLine());
		
		order[0]=food.get(menu)[0];
		System.out.println("��� �����Ͻðڽ��ϱ�?");
		int orderCount = Integer.parseInt(sc.nextLine());
		order[1] = Integer.toString(orderCount);
		basket.add(order);
		if(menu==i+2) {
			sub_buy();
		}else if(menu==i+3) {
			System.out.println("���α׷��� �����մϴ�.");
		}else {
			System.exit(0);
		}
	}
	public void drink() {
		ArrayList <String[]>drink = new ArrayList<>();
		String category ="����";
		
		drink = pdao.menulist(category);
		int i=0;
				
		for(i=0;i<drink.size();i++) {
			System.out.println("======"+(i+1)+"."+drink.get(i)[1]+"======");
		}
		System.out.println("======"+(i+2)+".�����޴�"+"======");
		System.out.println("======"+(i+3)+".��                 ��======");
		System.out.println("�޴��� �����ϼ���:");
		int menu = Integer.parseInt(sc.nextLine());
		
		order[0]=drink.get(menu)[0];
		System.out.println("��� �����Ͻðڽ��ϱ�?");
		int orderCount = Integer.parseInt(sc.nextLine());
		order[1] = Integer.toString(orderCount);
		basket.add(order);
		if(menu==i+2) {
			sub_buy();
		}else if(menu==i+3) {
			System.out.println("���α׷��� �����մϴ�.");
		}else {
			System.exit(0);
		}
	}
	public void housegoods() {
		ArrayList <String[]>housegoods = new ArrayList<>();
		String category ="����";
		
		housegoods = pdao.menulist(category);
		int i=0;
				
		for(i=0;i<housegoods.size();i++) {
			System.out.println("======"+(i+1)+"."+housegoods.get(i)[1]+"======");
		}
		System.out.println("======"+(i+2)+".�����޴�"+"======");
		System.out.println("======"+(i+3)+".��                 ��======");
		System.out.println("�޴��� �����ϼ���:");
		int menu = Integer.parseInt(sc.nextLine());
		
		order[0]=housegoods.get(menu)[0];
		System.out.println("��� �����Ͻðڽ��ϱ�?");
		int orderCount = Integer.parseInt(sc.nextLine());
		order[1] = Integer.toString(orderCount);
		basket.add(order);
		if(menu==i+2) {
			sub_buy();
		}else if(menu==i+3) {
			System.out.println("���α׷��� �����մϴ�.");
		}else {
			System.exit(0);
		}
	}
	
	
	
}
