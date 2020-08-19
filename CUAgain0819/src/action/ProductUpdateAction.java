package action;

import java.util.Scanner;

import svc.ProductUpdateService;
import util.consoleUtil;
import vo.Product;

public class ProductUpdateAction implements Action
{
	@Override
	public void execute(Scanner scanner) throws Exception
	{
		consoleUtil cu = new consoleUtil();
		String pno = cu.updatePno(scanner);
		Product updateProduct = cu.getUpdateProduct(scanner);
		
		ProductUpdateService productUpdateService = new ProductUpdateService();
		
		boolean isUpdateSuccess = productUpdateService.upProduct(updateProduct, pno);
		
		if(isUpdateSuccess)
		{
			System.out.println(updateProduct.getPname() + " 제품의 정보 수정 성공");
		}
		
		else
		{
			System.out.println(updateProduct.getPname() + " 제품의 정보 수정 실패");
		}
	}	
}
