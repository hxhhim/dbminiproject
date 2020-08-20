package view;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import DAO.ProductDAO;
import DAO.purcahseDAO;
import DAO.storeDAO;

public class mainView {
	Scanner sc = new Scanner(System.in);
	String order[] = new String[2];
	public static ArrayList <String[]>basket = new ArrayList<>();
	ProductDAO pdao = new ProductDAO();
	storeDAO sdao = new storeDAO();
	purcahseDAO pudao = new purcahseDAO();
	public static String selsname=null;
	public static String posno=null;
	
	public void mainview() {
		boolean isStop = false;
	//	storemenu();
		do {
		System.out.println("=======�� ��  ��=======");
		System.out.println("1.�����ϱ�");
//		System.out.println("2.ȯ     �� ");
//		System.out.println("3.ȸ������");
		System.out.println("2.��      ��");
		int menu = Integer.parseInt(sc.nextLine());
		
		switch (menu) {
		case 1:
			sub_buy();
			break;
		case 2:
			isStop = true;
			System.out.println("���α׷��� �����մϴ�.");
			break;
		default:
			System.out.println("�ٽ� �Է��ϼ���.");
			break;
		}
		}while(!isStop);
	 }
	public void storemenu() {
		ArrayList <String[]> sm = new ArrayList<>();
		sm = sdao.storelist();
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println("=======�� ��  ��=======");
		int i=0;
		for(i=0;i<sm.size();i++) {
			System.out.println(""+(i+1)+"."+sm.get(i)[1]+"");
		}
		System.out.println(""+(i+1)+".��                 ��");
		
		int menu = Integer.parseInt(sc.nextLine());
		selsname=sm.get(menu-1)[0];
		
		int nowtime = now.getHour();
		if(nowtime%2!=0) {
			posno="POS-01";
		}else {
			posno="POS-02";
		}
				
		if(menu==i+1) {
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
		}else {
			
		}
		
	}
	public void sub_buy() {
		boolean isStop = false;
		
		System.out.println("1.����Ļ�");
		System.out.println("2.�Ｎ�丮");
		System.out.println("3.��  �� ��");
		System.out.println("4.���̽�ũ��");
		System.out.println("5.��      ǰ");
		System.out.println("6.��      ��");
		System.out.println("7.��Ȱ��ǰ");
		System.out.println("8.�����޴�");
		System.out.println("9.��      ��");
//		System.out.println(selsname+posno);
		int menu = Integer.parseInt(sc.nextLine());
		
		switch (menu) {
		case 1:
			productsel("����Ļ�");
			break;
		case 2:
			productsel("�Ｎ�丮");
			break;
		case 3:
			productsel("���ڷ�");
			break;
		case 4:
			productsel("���̽�ũ��");
			break;
		case 5:
			productsel("��ǰ");
			break;
		case 6:
			productsel("����");
			break;
		case 7:
			productsel("��Ȱ��ǰ");
			break;
		case 8:
			mainview();
			break;
		case 9:
			isStop = true;
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
			break;
		default:
			System.out.println("�ٽ� �Է��ϼ���.");
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
		System.out.println(""+(i+1)+".�����޴�"+"");
		System.out.println(""+(i+2)+".��               ��");
		System.out.println("�޴��� �����ϼ���:");
		int menu = Integer.parseInt(sc.nextLine());
		
		if(menu==i+1) {
			sub_buy();
		}else if(menu==i+2) {
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
		}
		
		suborder[0]=cg.get(menu-1)[0];
		System.out.println("��� �����Ͻðڽ��ϱ�?");
		int orderCount = Integer.parseInt(sc.nextLine());
		suborder[1] = Integer.toString(orderCount);
		order=suborder;
		basket.add(order);
//		order=null;
		
		System.out.println("1.��ӱ����ϱ�");
		System.out.println("2.��  ��  ��  ��");
		menu = Integer.parseInt(sc.nextLine());
		
		if(menu==1) {
			sub_buy();
		}else if(menu==2){
			pudao.pbasket();
		}
						
	}
	
	
	
	
	
}
