package kodlamaio.hrms.business.abstracts;

public interface UserCheckService {
	
	boolean isValidEMail(String email);
	boolean isEMailExist(String email);
	boolean isFirstNameOk(String firstName);
	boolean isLastNameOk(String lastName);
	boolean isPasswordOk(String password);
	boolean isNationalityIdUnique(String nationalityId);
}
