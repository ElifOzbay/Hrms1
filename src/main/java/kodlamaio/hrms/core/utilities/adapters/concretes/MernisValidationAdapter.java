package kodlamaio.hrms.core.utilities.adapters.concretes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisValidationService;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;


@Service
public class MernisValidationAdapter implements MernisValidationService {

	@Autowired
	private KPSPublicSoapProxy  client;
	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		
		boolean result = false;
		try {
			result =this.client.TCKimlikNoDogrula(Long.valueOf(candidate.getNationalIdentity()),
					candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(),
					candidate.getYearofBirth());
			
		} catch (Exception e) {

            System.out.println("Not a valid person");
        }

		return result;
	}

}
