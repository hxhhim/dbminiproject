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
			System.out.println(newStock.getSno() + " Ïß??†ê?óê " + newStock.getPno() + " ?†ú?íà ?†úÍ≥? Ï∂îÍ? ?Ñ±Í≥?");
		}
		
		else
		{
			System.out.println(newStock.getSno() + " Ïß??†ê?óê " + newStock.getPno() + " ?†ú?íà ?†úÍ≥? Ï∂îÍ? ?ã§?å®");
		}
	}
}
