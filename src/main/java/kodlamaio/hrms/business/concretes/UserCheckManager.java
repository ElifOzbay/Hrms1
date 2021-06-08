package kodlamaio.hrms.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserCheckService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisValidationService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserCheckManager implements UserCheckService {
	
	private MernisValidationService mernisValidationService;
	private UserDao userDao;
	private CandidateDao candidateDao;
	
	
	@Autowired
	public UserCheckManager(MernisValidationService mernisValidationService, UserDao userDao, CandidateDao candidateDao) {
		this.mernisValidationService = mernisValidationService;
		this.userDao = userDao;
		this.candidateDao = candidateDao;
	}


	@Override
	public boolean isValidEMail(String email) {
		Pattern validMailPattern = Pattern.compile("^(.+)@(.+)$");
		Matcher validMailMatcher = validMailPattern.matcher(email);
		return validMailMatcher.matches();
	}

	@Override
	public boolean isEmailExist(String email) {
//		boolean isExist = false;		
//		for (User user : userDao.findAll()) {
//			if (user.getEmail() == email) {
//				isExist = true;
//			}
//		}		
		return this.userDao.existsByEmail(email);
	}

	@Override
	public boolean isFirstNameOk(String firstName) {
		Pattern validNamePattern = Pattern.compile("[A-Z][a-z]*");
		Matcher validNameMatcher = validNamePattern.matcher(firstName);
		if(firstName.length()>=2&&validNameMatcher.matches())
		return true;
		
		return false;
		
	}

	@Override
	public boolean isLastNameOk(String lastName) {
		Pattern validLastNamePattern = Pattern.compile("[A-Z]+([ '-][a-zA-Z]+)*");
		Matcher validLastNameMatcher = validLastNamePattern.matcher(lastName);
		if(lastName.length()>=2&&validLastNameMatcher.matches())
			return true;
			
			return false;
	}

	@Override
	public boolean isPasswordOk(String password) {
		Pattern validPasswordPattern = Pattern.compile("^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,16}$");
		Matcher validPasswordMatcher = validPasswordPattern.matcher(password);
		return true;
	}

	@Override
	public boolean isNationalIdentityUnique(String nationalIdentity) {
		boolean isExist = false;
		for (Candidate candidate : candidateDao.findAll()) {
			if (candidate.getNationalIdentity() == nationalIdentity) {
				isExist = true;				
			}
		}		
		return true;
	}


	@Override
	public boolean isRealPerson(Candidate candidate) {
		return this.mernisValidationService.checkIfRealPerson(candidate);
	}
	
}
