package signupSystem.core.concretes;

import java.util.regex.Pattern;

import signupSystem.core.abstracts.UserVaidationService;
import signupSystem.entities.concretes.UserInfo;

public class UserValidationManager implements UserVaidationService{
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public UserValidationManager() {

	}

	@Override
	public boolean registerValidate(UserInfo user) {
		boolean result = isFirstNameLengthValid(user.getName()) && isLastNameLengthValid(user.getLastName())
				&& isEmailFormatValid(user.getEmail()) && isPasswordLengthValid(user.getPassWord())
				&& isAllFieldsFilled(user);

		return result;
	}

	@Override
	public boolean loginValidate(String email, String password) {
		boolean result = isEmailFormatValid(email) && isPasswordLengthValid(password);

		return result;
	}
	private boolean isFirstNameLengthValid(String firstName) {
		return firstName.length() > 1;
	}

	private boolean isLastNameLengthValid(String lastName) {
		return lastName.length() > 1;
	}

	private boolean isEmailFormatValid(String email) {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
	}

	private boolean isPasswordLengthValid(String password) {
		return password.length() > 5;
	}

	private boolean isAllFieldsFilled(UserInfo user) {
		if (user.getName().length() <= 0 || user.getLastName().length() <= 0 || user.getEmail().length() <= 0
				|| user.getPassWord().length() <= 0) {
			return false;
		}
		return true;
	}

}
