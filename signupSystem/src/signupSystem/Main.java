package signupSystem;

import signupSystem.business.abstracts.AuthService;
import signupSystem.business.abstracts.UserService;
import signupSystem.business.concretes.AuthManager;
import signupSystem.business.concretes.UserManager;
import signupSystem.core.concretes.UserValidationManager;
import signupSystem.core.verifications.EmailVerificationManager;
import signupSystem.dataAccess.concretes.HibernateUserDao;
import signupSystem.otherAuths.GoogleAuthManager;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new HibernateUserDao());

		AuthService authService = new AuthManager(userService, new UserValidationManager(),
				new EmailVerificationManager());

		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓REGİSTER↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
		authService.register(1, "Nasim", "Anwari", "nanwari001@gmail.com", "123456"); // BAŞARILI
		System.out.println("\n###########################################################\n");
		authService.register(2, "Nasim", "Anwari", "anwari", "123456"); // Başarısız E-POSTA
		System.out.println("\n###########################################################\n");
		authService.register(3, "Nasim", "Anwari", "nanwari001@gmail.com", "1234"); // Başarısız Şifre
		System.out.println("\n###########################################################\n");
		authService.register(4, "N", "A", "nanwari001@gmail.com", "1234"); // Başarısız Şifre
		System.out.println("\n###########################################################\n");
		authService.register(5, "Nasim", "Anwari", "nanwari001@gmail.com", "123456"); // E-Posta MEVCUT

		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓LOGİN↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
		authService.login("nanwari001@gmail.com", "123456");// Başarılı
		System.out.println("\n###########################################################\n");
		authService.login("nasimawnari@gmail.com", "1234567"); // Kullanıcı Mevcut Değil
		System.out.println("\n###########################################################\n");
		authService.login("", ""); // Başarısız e-posta ve parola zorunlu

		AuthService googleAuthService = new GoogleAuthManager();
		googleAuthService.register(6, "Nasim", "Anwari", "nanwari001@gmail.com", "123456"); // BAŞARILI
		System.out.println("\n###########################################################\n");
		googleAuthService.login("nanwari001@gmail.com", "123456");

	}

}
