package kodlamaio.hrms.core.utilities.adapters.concretes;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisValidationService;
import kodlamaio.hrms.entities.concretes.Candidate;

@Component
public class FakeMernisValidationAdapter implements MernisValidationService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		return true;
	}
	
	
}
