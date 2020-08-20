package svc;
import static db.jdbcUtil.commit;
import static db.jdbcUtil.getConnection;
import static db.jdbcUtil.rollback;

import java.sql.*;

import DAO.storeDAO;
import vo.Store;

public class StoreAddService
{
	public boolean addStore(Store newStore)
	{
		boolean isInsertSuccess = false;
		Connection con = getConnection();
		storeDAO storeDAO = new storeDAO(con);
		
		int insertCount = storeDAO.insertNewStore(newStore);
		
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
