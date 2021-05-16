package signupSystem.business.concretes;

import signupSystem.business.abstracts.AuthService;
import signupSystem.business.abstracts.UserService;
import signupSystem.core.abstracts.UserVaidationService;
import signupSystem.core.concretes.UserValidationManager;
import signupSystem.core.verifications.VerificationService;
import signupSystem.entities.concretes.UserInfo;

public class AuthManager implements AuthService {

	UserService userService;
	UserVaidationService userValidationService;
	VerificationService verificationService;

	public AuthManager() {

	}

	public AuthManager(UserService userService, UserVaidationService userValidationService,
			VerificationService verificationService) {
		super();
		this.userService = userService;
		this.userValidationService = userValidationService;
		this.verificationService = verificationService;
	}
	
	@Override
	public void register(int id, String firstName, String lastName, String email, String password) {
		UserInfo userToRegister = new UserInfo(id, firstName, lastName, email, password, false);

		if (!this.userValidationService.registerValidate(userToRegister)) {
			System.out.println("Kullanıcı bilgilerinizi kontrol ediniz!");
			return;
		}

		if (!checkIfUserExists(email)) {
			System.out.println("Kayıt olma işlemi başarsız. Bu email ile bir başka üye mevcut.");
			return;
		}

		if (!this.verificationService.verification(userToRegister)) {
			System.out.println("Doğrulama işlemi iptal edildi.");
		}

		userService.add(userToRegister);
	}

	@Override
	public void login(String email, String password) {
		if (!this.userValidationService.loginValidate(email, password)) {
			System.out.println("Kullanıcı bilgilerinizi kontrol ediniz!");
			return;
		}

		UserInfo userToLogin = userService.getByEmailAndPass(email, password);

		if (userToLogin == null) {
			System.out.println("Girii başarısız. E-Posta veya şifre bilginiz yanlış.");
			return;
		}

		if (!checkIfUserVerified(userToLogin)) {
			System.out.println("Giriş başarısız. Üyeliğinizi doğrulamadınız.");
			return;
		}

		System.out
				.println("Giriş başarılı. Hoşgeldiniz " + userToLogin.getName() + " " + userToLogin.getLastName());

	}
	
	private boolean checkIfUserExists(String email) {
		return this.userService.getByMail(email) == null;
	}

	private boolean checkIfUserVerified(UserInfo user) {
		return user.isVerified();
	}
	
}
