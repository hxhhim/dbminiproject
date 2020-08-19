package svc;

import static db.jdbcUtil.*;
import java.sql.Connection;

import DAO.ProductDAO;
import vo.Product;

public class ProductAddService
{
	public boolean addProduct(Product newProduct)
	{
		boolean isInsertSuccess = false;
		Connection con = getConnection();
		ProductDAO productDAO = new ProductDAO(con);
		
		int insertCount = productDAO.insertNewProduct(newProduct);
		
		if(insertCount > 0)
		{
			commit(con);
			isInsertSuccess = true;
		}
		
		else
		{
			rollback(con);
		}
		
		return isInsertSuccess;
	}
}
