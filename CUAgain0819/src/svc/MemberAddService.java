package svc;

import java.sql.Connection;

import DAO.MemberDAO;
import vo.Member;
import static db.jdbcUtil.*;

public class MemberAddService {
	public boolean addMember(Member newMember) {
		boolean isInsertSuccess = false;
		Connection con = getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		
		int insertCount = memberDAO.insertNewMember(newMember);
		
		if(insertCount>0) {
			commit(con);
			isInsertSuccess= true;
		}else {
			rollback(con);
		}
		return isInsertSuccess;
	}
}
