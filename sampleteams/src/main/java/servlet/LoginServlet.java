package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Admin;
import sql.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	//ログイン画面を表示させる
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	// ログイン処理の実装
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// ログイン画面で入力された値を取得
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// ログイン画面で入力された値をもとに
		// データベースに登録された管理者の値を取得
		// 入力された情報でデータベースから値が取得できない場合
		// ログイン失敗
		Login login = new Login();
		Admin admin = login.check(email, password);

		if(admin.isLogin_flag()) {
			// ログイン成功 → 次の画面へ遷移
			System.out.println("ログイン成功");
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("WEB-INF/jsp/customer_list.jsp");
			dispatcher.forward(request, response);
		} else {
			// ログイン失敗 → ログイン画面へ遷移
			System.out.println("ログイン失敗");
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
	}
}