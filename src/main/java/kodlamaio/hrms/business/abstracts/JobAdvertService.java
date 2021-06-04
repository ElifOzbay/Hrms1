package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	
	
	Result add(JobAdvert jobAdvert);
	
	Result update(JobAdvert jobAdvert);
	
	Result deleteAdvert(int id);
	
	DataResult<JobAdvert> getById(int id);
		
	DataResult<JobAdvert> getByJobAdvertName(String jobAdvertName);
	
	DataResult<JobAdvert> getByJobAdvertNameAndJobPosition(String jobAdvertName, int jobPositionId);
	
	DataResult<List<JobAdvert>> getByJobAdvertNameAndCity(String jobAdvertName, int cityId);
	
	DataResult<List<JobAdvert>> getAllActiveAdverts();
	
	DataResult<List<JobAdvert>> getAllByReleaseDate();
	
	
	
	
	
	
	
	
}
