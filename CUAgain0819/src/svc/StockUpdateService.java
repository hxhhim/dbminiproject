package svc;

import static db.jdbcUtil.*;
import java.sql.Connection;

import DAO.StockDAO;
import vo.Stock;

public class StockUpdateService
{
	public boolean upStock(Stock updateStock, String sno)
	{
		boolean isUpdateSuccess = false;
		Connection con = getConnection();
		StockDAO stockDAO = new StockDAO(con);
		
		int updateCount = stockDAO.updateStock(updateStock, sno);
		
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
