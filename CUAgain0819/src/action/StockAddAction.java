package action;

import java.util.Scanner;

import svc.StockAddService;
import util.consoleUtil;
import vo.Stock;

public class StockAddAction implements Action
{
	@Override
	public void execute(Scanner scanner) throws Exception
	{
		consoleUtil cu = new consoleUtil();
		Stock newStock = cu.getNewStock(scanner);
		StockAddService stockAddService = new StockAddService();
		
		boolean isAddSuccess = stockAddService.addStock(newStock);
		
		if(isAddSuccess)
		{
			System.out.println(newStock.getSno() + " μ§?? ? " + newStock.getPno() + " ? ? ? κ³? μΆκ? ?±κ³?");
		}
		
		else
		{
			System.out.println(newStock.getSno() + " μ§?? ? " + newStock.getPno() + " ? ? ? κ³? μΆκ? ?€?¨");
		}
	}
}
