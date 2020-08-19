package svc;

import static db.jdbcUtil.getConnection;

import java.sql.Connection;

import DAO.MemberDAO;

public class MemberListService {
	Connection con = getConnection();
	MemberDAO memberDAO = new MemberDAO(con);
	
	public void list() {
		memberDAO.listMember(con);
	}
}
