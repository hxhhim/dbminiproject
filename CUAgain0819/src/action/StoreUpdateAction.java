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
			System.out.println(updateStore.getSname() + " ì§?? ?˜ ? •ë³? ?ˆ˜? • ?„±ê³?");
		}
		
		else
		{
			System.out.println(updateStore.getSname() + " ì§?? ?˜ ? •ë³? ?ˆ˜? • ?‹¤?Œ¨");
		}
	}
}
