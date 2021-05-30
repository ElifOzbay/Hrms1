package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;



public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	boolean existsbyMail (String email);
	boolean existsByNationalIdentity(String nationalIdentity);
	Candidate findbyNationalIdentity(String nationalIdentity);
}
