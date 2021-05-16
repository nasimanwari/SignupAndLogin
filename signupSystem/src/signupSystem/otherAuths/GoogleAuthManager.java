package signupSystem.otherAuths;

import signupSystem.business.abstracts.AuthService;

public class GoogleAuthManager implements AuthService {

	@Override
	public void register(int id, String firstName, String lastName, String email, String password) {
		System.out.println("Account created by gmail: "+email);
		
	}

	@Override
	public void login(String email, String password) {
		System.out.println("Logged in by gmail: "+email);
		
	}
	
}
