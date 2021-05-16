package signupSystem.core.abstracts;

import signupSystem.entities.concretes.UserInfo;

public interface UserVaidationService {
	boolean registerValidate(UserInfo user);
	boolean loginValidate(String email, String password);
}
