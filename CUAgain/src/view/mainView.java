package view;

import java.util.Scanner;

public class mainView {
	Scanner sc = new Scanner(System.in);
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
			sub_refund();
			break;
		case 3:
			sub_signup();
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
		boolean isStop = false;
		
		System.out.println("======1.��§ �Ұ��  ����======");
		System.out.println("======2.����   �쵷   ����======");
		System.out.println("======3.����ƹ���������======");
		System.out.println("======4.��    ��    ��    ��======");
		System.out.println("======5.��                  ��======");
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
			System.out.println("���α׷��� �����մϴ�.");
			break;
		default:
			System.out.println("�ٽ� �Է��ϼ���.");
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
		System.out.println("��� �����Ͻðڽ��ϱ�?");
		int stock = Integer.parseInt(sc.nextLine());
		return stock;
	}
	
}
