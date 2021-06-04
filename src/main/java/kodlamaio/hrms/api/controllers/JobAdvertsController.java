package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {
	
	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobAdvert jobAdvert) {
		
		return this.jobAdvertService.update(jobAdvert);
	}
	
	@PostMapping("/deleteAdvert")
	public Result deleteAdvert(@RequestParam int id) {
		
		return this.jobAdvertService.deleteAdvert(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobAdvert> getById(@RequestParam int id) {
		
		return this.jobAdvertService.getById(id);
	}
	
	@GetMapping("/getAllActiveAdverts")
	public DataResult<List<JobAdvert>> getAllActiveAdverts() {
		
		return this.jobAdvertService.getAllActiveAdverts();
	}
	
	@GetMapping("/getAllByReleaseDate")
	public DataResult<List<JobAdvert>> getAllByReleaseDate() {
		
		return this.jobAdvertService.getAllByReleaseDate();
	}
	
	@GetMapping("/getByJobAdvertName")
	public DataResult<JobAdvert> getByJobAdvertName(@RequestParam String jobAdvertName){
		return this.jobAdvertService.getByJobAdvertName(jobAdvertName);
	}
	
	@GetMapping("/getByJobAdvertNameandJobPosition")
	public DataResult<JobAdvert> getByJobAdvertNameAndJobPosition(@RequestParam String jobAdvertName, int jobPositionId){
		return this.jobAdvertService.getByJobAdvertNameAndJobPosition(jobAdvertName, jobPositionId);
	}
	
	@GetMapping("/getByJobAdvertNameandCity")
	public DataResult<List<JobAdvert>> getByJobAdvertNameAndCity(@RequestParam String jobAdvertName, int cityId){
		return this.jobAdvertService.getByJobAdvertNameAndCity(jobAdvertName, cityId);
	}
	
	
	
	
	
	
	
}
