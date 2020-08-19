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
			System.out.println(newStore.getSname() + " Ïß??†ê?ùò ?†ïÎ≥? Ï∂îÍ? ?Ñ±Í≥?");
		}
		
		else
		{
			System.out.println(newStore.getSname() + " Ïß??†ê?ùò ?†ïÎ≥? Ï∂îÍ? ?ã§?å®");
		}
	}
}
