package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import controllers.DBManager;
import controllers.HashManager;

@Entity
public class User extends Model {

	private static final long serialVersionUID = 5854422586239724109L;
	
	@Id
	private String email;
	
	private String password;

	public User(String email, String password) {
		this.email = email;
		this.password = HashManager.getInstance().codeString(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = HashManager.getInstance().codeString(password);
	}

	public static Finder<String, User> find = new Finder<String, User>(String.class, User.class);
	
	public static User authenticate(String email, String password) {
		return DBManager.getInstance().getUser(email, password);
	}
}