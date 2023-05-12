package loginservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic;

@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  //ログイン画面を表示させる
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//33,34のコードを入れることで文字化けを防ぐ。
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("jsp/login.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		
		//ログイン処理の実行
		Login login = new Login(mail, pass);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		System.out.println();
		//ログイン処理の可否によって処理を分岐
		if (result) {
			//セクションスコープにメールを保存
			HttpSession session = request.getSession();
			session.setAttribute("mail",mail);
			
			//フォワード
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("jsp/top.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("LoginServlet");
		}
	}
}
