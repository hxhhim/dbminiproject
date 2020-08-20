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
			System.out.println(updateProduct.getPname() + " ��ǰ�� ���� ���� ����");
		}
		
		else
		{
			System.out.println(updateProduct.getPname() + " ��ǰ�� ���� ���� ����");
		}
	}	
}
