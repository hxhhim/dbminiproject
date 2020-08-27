package action;

import java.util.Scanner;

import svc.StockListService;
import util.consoleUtil;

public class StockListAction implements Action{

	@Override
	public void execute(Scanner sc) throws Exception {
		consoleUtil cu = new consoleUtil();
		StockListService sls = new StockListService();
		sls.stockList(cu.storeCode(sc));
	}

}
