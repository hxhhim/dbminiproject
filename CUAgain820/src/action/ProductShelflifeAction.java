package action;

import java.util.Scanner;

import svc.ProductShelflifeService;
import util.consoleUtil;

public class ProductShelflifeAction implements Action{

	@Override
	public void execute(Scanner sc) throws Exception {
		consoleUtil cu = new consoleUtil();
		ProductShelflifeService pss = new ProductShelflifeService();
		
		pss.pshelflifelist(cu.storeCode(sc));
		
	}

}
