package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserCheckService userCheckService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserCheckService userCheckService) {
		this.candidateDao = candidateDao;
		this.userCheckService = userCheckService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), " Candidate listed.");
	}

	@Override
	public Result add(Candidate candidate) {

		if (this.userCheckService.isEmailExist(candidate.getEmail())) {
			return new ErrorResult("Email kullanımda!");

		}
		if (!this.userCheckService.isFirstNameOk(candidate.getFirstName())) {
			return new ErrorResult("İsminizi benim canım nasıl isterse öyle gireceksin taaaammı!");
		}
		if (!this.userCheckService.isLastNameOk(candidate.getLastName())) {
			return new ErrorResult("Soyadınız benim canım nasıl isterse öyle gireceksin taaaammı!");

		}
		if (!this.userCheckService.isNationalIdentityUnique(candidate.getNationalIdentity())) {
			return new ErrorResult("Tc kimlik numaranızı doğru girmelisiniz!");
		}
		if (!this.userCheckService.isPasswordOk(candidate.getPassword())) {
			return new ErrorResult("Şifre benim canım nasıl isterse öyle gireceksin taaaammı!");
		}
		if (!this.userCheckService.isRealPerson(candidate)) {
			return new ErrorResult("Sen aslında yoğğsun!");
		}

		this.candidateDao.save(candidate);
		return new SuccessResult(" Candidate added.");

	}

	@Override
	public DataResult<Candidate> findCandidateByNationalIdentity(String nationalIdentity) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findAllByNationalIdentity(nationalIdentity));
	}

}
