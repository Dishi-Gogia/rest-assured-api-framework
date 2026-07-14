package builders;

import models.AuthRequest;

public class AuthBuilder {
	
	public static AuthRequest createAuth() {
		
		AuthRequest auth=new AuthRequest();
		
		auth.setUsername("admin");
		auth.setPassword("password123");
		
		return auth;
	}

}
