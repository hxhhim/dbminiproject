package svc;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;
import java.util.Scanner;
import DAO.purcahse_listDAO;

public class PurchaseListService {
	Connection con = getConnection();
	purcahse_listDAO pdao = new purcahse_listDAO(con);
	
	public void phistoryid(int pid) {
		pdao.purchasehistoryid(con,pid);
	}
}
