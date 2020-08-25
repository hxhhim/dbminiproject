package action;

import java.util.Scanner;

import svc.MemberAddService;
import util.consoleUtil;
import vo.Member;

public class MemberAddAction implements Action{
	public void execute(Scanner sc) throws Exception {
		//System.out.println("ȸ�����");
		consoleUtil cu = new consoleUtil();
		Member newMember = cu.getNewMember(sc);
	
		MemberAddService memberAddService = new MemberAddService();
		
		boolean isAddSuccess=memberAddService.addMember(newMember);
		if(isAddSuccess) {
			System.out.println(newMember.getName()+"ȸ������ �߰� ����");
			
		}else {
			System.out.println(newMember.getName()+"ȸ������ �߰� ����");
		}
		
	}
}
