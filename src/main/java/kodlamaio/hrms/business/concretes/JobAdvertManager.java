package kodlamaio.hrms.business.concretes;

import java.awt.print.Pageable;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Advert added.");
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Advert updated.");
	}

	@Override
	public DataResult<JobAdvert> getById(int id) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.findById(id).get());
	}

	@Override
	public Result deleteAdvert(int id) {
		if (getById(id) == null) {
			return new ErrorResult("There is no such job ad.");
		}
		if (getById(id).getData().isActive() == false) {
			return new ErrorResult("This ad is inactive.");
		}
		JobAdvert deleteAdvert = getById(id).getData();

		deleteAdvert.setActive(false);

		add(deleteAdvert);

		return new SuccessResult("The job ad has been deactivated.");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllActiveAdverts() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getAllActiveAdverts()," Active advertisement listed.");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByReleaseDate() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getAllByReleaseDate()," Advertisement listed by date.");
	}

	

	@Override
	public DataResult<JobAdvert> getByJobAdvertName(String jobAdvertName) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getByJobAdvertName(jobAdvertName));
	}

	@Override
	public DataResult<JobAdvert> getByJobAdvertNameAndJobPosition(String jobAdvertName, int jobPositionId) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getByJobAdvertNameAndJobPosition_Id(jobAdvertName, jobPositionId));
		}

	@Override
	public DataResult<List<JobAdvert>> getByJobAdvertNameAndCity(String jobAdvertName, int cityId) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByJobAdvertNameAndCity_Id(jobAdvertName, cityId));
	}


	

	

	

}
