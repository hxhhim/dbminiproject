package svc;

import static db.jdbcUtil.commit;
import static db.jdbcUtil.getConnection;
import static db.jdbcUtil.rollback;

import java.sql.Connection;

import DAO.StockDAO;
import vo.Stock;

public class StockAddService
{
	public boolean addStock(Stock newStock)
	{
		boolean isInsertSuccess = false;
		Connection con = getConnection();
		StockDAO stockDAO = new StockDAO(con);
		
		int insertCount = stockDAO.insertNewStock(newStock);
		
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
