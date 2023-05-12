package test;

import dao.AccountsDAO;
import model.Account;
import model.Login;

public class AccountsDAOTest {
	public static void main(String[] args) {
		testFindByLoginOK();
		testFindByLoginNG();
	}
	public static void testFindByLoginOK() {
		Login login = new Login("yusuke.minato@miyabilink.jp","1234");
		AccountsDAO dao = new AccountsDAO();
		Account result = dao.findByLogin(login);
		if(result != null &&
				result.getUseId().equals("minato") &&
				result.getPass().equals("1234") &&
				result.getMail().equals("yusuke.minato@miyabilink.jp") &&
				result.getName().equals("湊 雄輔") ) {
			System.out.println("testfindOK成功");
		}else {
			System.out.println("restfindOK失敗");
		}
	}public static void testFindByLoginNG() {
		Login login = new Login("yusuke.minato@miyabilink.jp","12345");
		AccountsDAO dao = new AccountsDAO();
		Account result = dao.findByLogin(login);
		if(result == null) {
			System.out.println("testNG成功");
		}else {
			System.out.println("testNG失敗");
		}
	}
}
