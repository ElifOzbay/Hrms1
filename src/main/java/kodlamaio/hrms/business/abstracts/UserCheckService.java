package kodlamaio.hrms.business.abstracts;

public interface UserCheckService {
	
	boolean isValidEMail(String email);
	boolean isEmailExist(String email);
	boolean isFirstNameOk(String firstName);
	boolean isLastNameOk(String lastName);
	boolean isPasswordOk(String password);
	boolean isNationalIdentityUnique(String nationalIdentity);
}
