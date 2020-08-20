package action;

import java.util.Scanner;

import vo.Member;
import util.ConsolUtil;
import svc.MemberAddService;

public class MemberAddAction {
	public void execute(Scanner sc) throws Exception {
		//System.out.println("회원등록");
		ConsolUtil cu = new ConsolUtil();
		Member newMember = cu.getNewMember(sc);
	
		MemberAddService memberAddService = new MemberAddService();
		
		boolean isAddSuccess=memberAddService.addMember(newMember);
		if(isAddSuccess) {
			System.out.println(newMember.getName()+"회원정보 추가 성공");
			
		}else {
			System.out.println(newMember.getName()+"회원정보 추가 실패");
		}
		
	}
}
