package svc;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;

import DAO.ProductDAO;

public class ProductShelflifeService {
	Connection con = getConnection();
	ProductDAO productDAO = new ProductDAO(con);
	
	public void pshelflifelist(String scode) {
		productDAO.shelflifeProduct(con, scode);
	}
}
