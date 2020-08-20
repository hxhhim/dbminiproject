package svc;

import java.sql.Connection;

import static db.jdbcUtil.*;
import DAO.storeDAO;
import vo.Store;

public class StoreUpdateService
{
	public boolean upStore(Store updateStore, String sno)
	{
		boolean isUpdateSuccess = false;
		Connection con = getConnection();
		storeDAO storeDAO = new storeDAO(con);
		
		int updateCount = storeDAO.updateStore(updateStore, sno);
		
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
