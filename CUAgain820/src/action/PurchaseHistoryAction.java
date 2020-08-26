package action;

import java.util.Scanner;

import svc.PurchaseListService;
import util.consoleUtil;

public class PurchaseHistoryAction implements Action{

	@Override
	public void execute(Scanner sc) throws Exception {
		consoleUtil cu = new consoleUtil();
		
		PurchaseListService plistService = new PurchaseListService();
		plistService.phistoryid(cu.purchaselistID(sc));
		//메뉴에서 호출하면끝
	}

}
