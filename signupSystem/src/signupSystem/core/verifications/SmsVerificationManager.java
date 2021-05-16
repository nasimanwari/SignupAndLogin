package signupSystem.core.verifications;

import java.util.Random;
import java.util.Scanner;

import signupSystem.entities.concretes.UserInfo;

public class SmsVerificationManager implements VerificationService {

	@Override
	public boolean verification(UserInfo user) {
		Scanner scanner = new Scanner(System.in);
		char isDecision = 'h';
		System.out.println(
				user.getName() + " adli kisinin telefonuna gelen do�rulama kodunu girmek istiyor musunuz? (E/H)");
		isDecision = scanner.next().charAt(0);

		if (isDecision == 'e' || isDecision == 'E') {
			Random random = new Random();
			int randomInteger, iAmNotARobot, count = 0;

			do {
				randomInteger = random.nextInt(999999 - 100000 + 1) + 100000;

				System.out.println(
						"Hesab�n�z do�rulamak i�in telefona gelen 6 haneli say�y� giriniz:\n--> " + randomInteger);
				iAmNotARobot = scanner.nextInt();
				count++;
				if (count == 4) {
					System.out.println(
							"Bir �ok yanl�� denemenizden kaynakl� hesab�n�z� �uanda do�rulayam�yoruz.\nL�tfen daha sonra tekrar deneyiniz.");
					scanner.close();
					return false;
				}
			} while (!(iAmNotARobot == randomInteger) && count < 4);
			System.out.println("Tebrikler hesab�n�z do�ruland�.");
			user.setVerified(true);
			scanner.close();
			return true;

		}
		scanner.close();
		return false;
	}
}