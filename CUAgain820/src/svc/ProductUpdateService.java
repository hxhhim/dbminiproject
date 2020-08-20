package svc;

import static db.jdbcUtil.*;

import java.sql.Connection;

import DAO.ProductDAO;
import vo.Product;

public class ProductUpdateService
{
	public boolean upProduct(Product updateProduct, String pno)
	{
		boolean isUpdateSuccess = false;
		Connection con = getConnection();
		ProductDAO productDAO = new ProductDAO(con);
		
		int updateCount = productDAO.updateProduct(updateProduct, pno);
		
		if(updateCount > 0)
		{
			commit(con);
			isUpdateSuccess = true;
		}
		
		else
		{
			rollback(con);
		}
		
		return isUpdateSuccess;
	}
}
