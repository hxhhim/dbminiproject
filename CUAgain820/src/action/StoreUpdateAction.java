package action;

import java.util.Scanner;

import svc.StoreUpdateService;
import util.consoleUtil;
import vo.Store;

public class StoreUpdateAction implements Action
{
	@Override
	public void execute(Scanner scanner) throws Exception
	{
		consoleUtil cu = new consoleUtil();
		String sno = cu.updateSno(scanner);
		Store updateStore = cu.getUpdateStore(scanner);
		
		StoreUpdateService storeUpdateService = new StoreUpdateService();
		
		boolean isUpdateSuccess = storeUpdateService.upStore(updateStore, sno);
		
		if(isUpdateSuccess)
		{
			System.out.println(updateStore.getSname() + "지점 정보 수정 성공");
		}
		
		else
		{
			System.out.println(updateStore.getSname() + "지점 정보 수정 실패");
		}
	}
}
