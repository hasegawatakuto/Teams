package object;

import java.sql.Date;

public class Admin {

	private int id;
	private String name;
	private String password;
	private Date at;
	private boolean login_flag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getAt() {
		return at;
	}

	public void setAt(Date at) {
		this.at = at;
	}

	public boolean isLogin_flag() {
		return login_flag;
	}

	public void setLogin_flag(boolean login_flag) {
		this.login_flag = login_flag;
	}
}