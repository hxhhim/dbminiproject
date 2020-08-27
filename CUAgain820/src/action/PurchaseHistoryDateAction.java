package action;

import java.util.Scanner;

import svc.PurchaseListService;
import util.consoleUtil;

public class PurchaseHistoryDateAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
consoleUtil cu = new consoleUtil();
		
		PurchaseListService plistService = new PurchaseListService();
		plistService.purchaseHistoryDate(cu.phistorydate(sc));
	}
	

}
