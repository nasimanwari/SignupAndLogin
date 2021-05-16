package signupSystem.core.verifications;

import signupSystem.entities.concretes.UserInfo;

public interface VerificationService {
	boolean verification(UserInfo user);
}
