package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	
	JobAdvert getByJobAdvertName(String jobAdvertName);
	
	JobAdvert getByJobAdvertNameAndJobPosition_Id(String jobAdvertName, int jobPositionId);
	
	List<JobAdvert> getByJobAdvertNameAndCity_Id(String jobAdvertName, int cityId);
	
	@Query("From JobAdvert where jobAdvertName=:jobAdvertName and city.id=:cityId")
	List<JobAdvert> getByJobAdvertNameAndCity(String jobAdvertName, int cityId);
	
	@Query("From JobAdvert where isActive=true")
	List<JobAdvert> getAllActiveAdverts();
	
	@Query("From JobAdvert where isActive = true Order By releaseDate")
	List<JobAdvert> getAllByReleaseDate();
	
	
	
	
	
}
