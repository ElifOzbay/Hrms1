package kodlamaio.hrms.core.utilities.adapters.concretes;

import java.rmi.RemoteException;


import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisValidationService;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;


@Service
public class MernisValidationAdapter implements MernisValidationService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean result = false;
		try {
			result = client.TCKimlikNoDogrula(Long.valueOf(candidate.getNationalIdentity()),
					candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(),
					candidate.getYearofBirth());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return result;
	}

}
