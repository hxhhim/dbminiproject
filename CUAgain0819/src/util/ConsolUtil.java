package util;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;
import java.util.Scanner;

import DAO.MemberDAO;
import vo.Member;
public class ConsolUtil {
	Connection con = getConnection();
	MemberDAO memberDAO = new MemberDAO(con);
	
	
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
	
//	public int getDeleteId(Scanner sc) {
//		System.out.println("������ȸ���� �̸��� �Է����ּ���: ");
//		String name = sc.nextLine();
//		int demno = memberDAO.getMno(name);
//		return demno;
//	}
	   
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
//		System.out.println("������ ȸ����  �̸��� �Է����ּ���: ");
//		String name = sc.nextLine();
		int updateMno = memberDAO.getMno(name);
		return updateMno;
	}
}