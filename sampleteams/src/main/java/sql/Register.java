package sql;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import object.Admin;

public class Register {

	public Admin check(String email, String password,String user_id,Date created_at) throws FileNotFoundException {

		// データベースへの接続情報をプロパティファイルから取得
		//DBconfig db_info = new DBconfig();
		String url = "jdbc:postgresql://localhost:5432/hofs";//db_info.getDBinfo().get("url");
		String user = "postgres";//db_info.getDBinfo().get("user");
		String pass = "takuto1206";//db_info.getDBinfo().get("password");

		// 実行SQL
		String register_sql = "insert into users"
				+ "(email,password,user_id,created_at) values(?,?,?,?)";
		Admin admin = new Admin();
		// データベースへの接続
		// try〜catch〜resources構文を使用
		try(Connection conn = DriverManager.getConnection(url,user,pass)) {

			// オートコミット機能を無効化
			conn.setAutoCommit(false);

			try(PreparedStatement stmt = conn.prepareStatement(register_sql)){

				// 変数login_sqlの一番目の?に引数のuser_idをセット
				stmt.setString(1, email);
				// 変数login_sqlの二番目の?に引数のpasswordをセット
				stmt.setString(2, password);

				stmt.setString(3, user_id);

				stmt.setDate(4, created_at);

				stmt.executeUpdate();

				// コミット
				conn.commit();
				System.out.println("コミット処理を行いました");
			} catch (SQLException e) {
				conn.rollback();
				System.out.println("ロールバック処理を行いました");
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return admin;
	}
}






