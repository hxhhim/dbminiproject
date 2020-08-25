package action;

import java.util.Scanner;

import svc.ProductAddService;
import util.consoleUtil;
import vo.Product;

public class ProductAddAction implements Action
{

	@Override
	public void execute(Scanner scanner) throws Exception
	{
		consoleUtil cu = new consoleUtil();
		Product newProduct = cu.getNewProduct(scanner);
		ProductAddService productAddService = new ProductAddService();
		
		boolean isAddSuccess = productAddService.addProduct(newProduct);
		
		if(isAddSuccess)
		{
			System.out.println(newProduct.getPname() + "제품정보 추가 성공");
		}
		
		else
		{
			System.out.println(newProduct.getPname() + "제품정보 추가 성공");
		}
	}
	
}
