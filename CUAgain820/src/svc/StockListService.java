package svc;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;

import DAO.StockDAO;

public class StockListService {
	Connection con = getConnection();
	StockDAO sdao = new StockDAO(con);
	
	public void stockList(String scode) {
		sdao.stocklist(con,scode);
	}
}
