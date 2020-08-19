package action;

import java.util.Scanner;

import svc.StockUpdateService;
import util.consoleUtil;
import vo.Stock;

public class StockUpdateAction implements Action
{

	@Override
	public void execute(Scanner scanner) throws Exception
	{
		consoleUtil cu = new consoleUtil();
		String sno = cu.updateSno(scanner);
		Stock updateStock = cu.getUpdateStock(scanner);
		
		StockUpdateService stockUpdateService = new StockUpdateService();
		
		boolean isUpdateSuccess = stockUpdateService.upStock(updateStock, sno);
		
		if(isUpdateSuccess)
		{
			System.out.println(updateStock.getSno() + " �??��?�� ?���? ?��?�� ?���?");
		}
		
		else
		{
			System.out.println(updateStock.getSno() + " �??��?�� ?���? ?��?�� ?��?��");
		}
	}
	
}
