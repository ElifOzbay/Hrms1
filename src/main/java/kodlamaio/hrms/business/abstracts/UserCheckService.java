package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface UserCheckService {
	
	boolean isValidEMail(String email);
	boolean isEmailExist(String email);
	boolean isFirstNameOk(String firstName);
	boolean isLastNameOk(String lastName);
	boolean isPasswordOk(String password);
	boolean isNationalIdentityUnique(String nationalIdentity);
	boolean isRealPerson(Candidate candidate);
}
