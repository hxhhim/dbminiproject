package action;

import java.util.Scanner;

import svc.StoreAddService;
import util.consoleUtil;
import vo.Store;

public class StoreAddAction implements Action
{
	@Override
	public void execute(Scanner scanner) throws Exception
	{
		consoleUtil cu = new consoleUtil();
		Store newStore = cu.getNewStore(scanner);
		StoreAddService storeAddService = new StoreAddService();
		
		boolean isAddSuccess = storeAddService.addStore(newStore);
		
		if(isAddSuccess)
		{
			System.out.println(newStore.getSname() + "지점정보 추가 성공");
		}
		
		else
		{
			System.out.println(newStore.getSname() + "지점정보 추가 실패");
		}
	}
}
