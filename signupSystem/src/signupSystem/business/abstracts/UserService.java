package signupSystem.business.abstracts;

import java.util.List;

import signupSystem.entities.concretes.UserInfo;

public interface UserService {
	void add(UserInfo user);
	void update(UserInfo user);
	void delete(UserInfo user);
	UserInfo getById(int id);
	UserInfo getByMail(String email);
	UserInfo getByEmailAndPass(String email, String password);
	List<UserInfo> getAll();
	
}
