package signupSystem.business.concretes;

import java.util.List;

import signupSystem.business.abstracts.UserService;
import signupSystem.dataAccess.abstracts.UserDao;
import signupSystem.entities.concretes.UserInfo;

public class UserManager implements UserService{

	UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public void add(UserInfo user) {
		userDao.add(user);
		System.out.println("Kullanıcı başarılı bir şekilde oluşturulmuştur.");
		
	}

	@Override
	public void update(UserInfo user) {
		userDao.update(user);
		System.out.println("Kullanıcı bilgileri güncellendi.");
		
	}

	@Override
	public void delete(UserInfo user) {
		userDao.delete(user);
		System.out.println("Kullanıcı silindi.");
	}

	@Override
	public UserInfo getById(int id) {
		return userDao.getById(id);
	}

	@Override
	public UserInfo getByMail(String email) {
		return userDao.getByMail(email);
	}

	@Override
	public UserInfo getByEmailAndPass(String email, String password) {
		return userDao.getByEmailAndPass(email, password);
	}

	@Override
	public List<UserInfo> getAll() {
		return userDao.getAll();

	}
}
