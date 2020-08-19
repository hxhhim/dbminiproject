package action;

import java.util.Scanner;

import vo.Member;
import util.ConsolUtil;
import svc.MemberAddService;

public class MemberAddAction {
	public void execute(Scanner sc) throws Exception {
		//System.out.println("ȸ�����");
		ConsolUtil cu = new ConsolUtil();
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
