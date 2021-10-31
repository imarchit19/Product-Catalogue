/**
 * 
 */
package com.architgupta.product.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author architgupta
 *
 */
public class LoginForm {

	@NotBlank
	@Size(min = 3, max = 60)
	private String username;

	@NotBlank
	@Size(min = 6, max = 100)
	private String password;

	public LoginForm(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
