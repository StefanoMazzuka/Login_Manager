package Controller;

import java.util.ArrayList;

public class Application {

	private String name;
	private ArrayList<User> users;
	private String URL;
	
	/* Constructor */
	
	public Application() {
		this.users = new ArrayList<User>();
	}
	
	/* Getters and Setters */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUser(User user) {
		this.users.add(user);
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
}