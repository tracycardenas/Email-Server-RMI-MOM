package ec.ups.edu.common;

import java.io.Serializable;
import java.util.Date;

public class User  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String username;
	private String password;
	
	
	
	public User(String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
