package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.Register;

/**
 * Servlet implementation class CustomerRegisterServlet
 */
@WebServlet("/CustomerRegisterServlet")
public class CustomerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	// 顧客登録画面を表示させる
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/Register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// 登録画面で入力された値を取得
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String user_id = request.getParameter("user_id");

		//バリデーションの追加
		//メールアドレスのバリデーション
		String errorMsgmail = "";
		if(email.length() == 0){
			errorMsgmail += "メールアドレスが入力されていません<br>";
		}else if(!email.matches("^[a-zA-Z0-9]+$")){
			errorMsgmail += "半角英数字で入力してください<br>";
		}else if(!email.matches("@")){
			errorMsgmail += "正しいメールアドレスを入力してください<br>";
		}
		//パスワードのバリデーション 
		String errorMsgpass = "";
		if(password.length() == 0) {
			errorMsgmail += "パスワードが入力されていません<br>";
		}else if(!password.matches("[0-9]{4}")){
			errorMsgpass += "パスワードは数字4文字で入力してください<br>";
		}
		//ユーザーIDのバリデーション
		String errorMsguser_id = "";
		if(user_id.length() == 0) {
			errorMsguser_id += "ユーザーIDが入力されていません<br>";
		}
		//JSP側に値を処理する
		request.setAttribute("errorMsgmail", errorMsgmail);
		request.setAttribute("errorMsgpass", errorMsgpass);
		request.setAttribute("errorMsguser_id", errorMsguser_id);

		//登録日を処理するコード
		java.sql.Date created_at = new java.sql.Date(System.currentTimeMillis());
		Register register = new Register();
		register.check(email,password,user_id,created_at);

		//登録完了したら再度登録画面に戻る
		System.out.println("登録成功");
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/Register.jsp");
		dispatcher.forward(request, response);
	} 
}
