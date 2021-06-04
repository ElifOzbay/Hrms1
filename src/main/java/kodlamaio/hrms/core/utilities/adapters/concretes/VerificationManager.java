package kodlamaio.hrms.core.utilities.adapters.concretes;

import java.util.UUID;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapters.abstracts.VerificationService;

@Service
public class VerificationManager implements VerificationService {

	@Override
	public boolean sendVerificationCode(String email) {
		 UUID uuid = UUID.randomUUID();
		    String code= uuid.toString();
			System.out.println(email +" Verification code sent to e-mail address. Verification code:" + code );
			return true;
	}

}
