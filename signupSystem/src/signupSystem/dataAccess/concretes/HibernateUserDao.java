package signupSystem.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import signupSystem.dataAccess.abstracts.UserDao;
import signupSystem.entities.concretes.UserInfo;

public class HibernateUserDao implements UserDao{

	List<UserInfo> users = new ArrayList<UserInfo>();
	
	@Override
	public void add(UserInfo user) {
		users.add(user);
		System.out.println("Hibarnate ile eklendi " + user.getName());
		
	}

	@Override
	public void update(UserInfo user) {
		UserInfo userToUpdate = getById(user.getId());
		userToUpdate.setName(user.getName());
		userToUpdate.setLastName(user.getLastName());
	}

	@Override
	public void delete(UserInfo user) {
		users.removeIf(usr -> usr.getId() == user.getId());
		
	}

	@Override
	public UserInfo getById(int id) {
		for (UserInfo user : users) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	@Override
	public UserInfo getByMail(String email) {
		for (UserInfo user : users) {
			if (user.getEmail() == email)
				return user;
		}
		return null;
	}

	@Override
	public UserInfo getByEmailAndPass(String email, String password) {
		for (UserInfo user : users) {
			if (user.getEmail() == email && user.getPassWord() == password)
				return user;
		}
		return null;
	}

	@Override
	public List<UserInfo> getAll() {
		return users;
	}

}
