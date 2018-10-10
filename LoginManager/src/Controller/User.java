package Controller;

public class User {

	private String user;
	private String pass;
	private String extra;
	
	/* Constructor */

	public User() {}
	
	/* Getters and Setters */

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	
	/* ToString */
	
	@Override
	public String toString() {
		return "USUARIO:" + '\t' + user + '\n' + "CLAVE:" + '\t' + pass + '\n' + "INFORMACIÓN EXTRA:" + '\n' + extra + '\n' + '\n';
	}
}