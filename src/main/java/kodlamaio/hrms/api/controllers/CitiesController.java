package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
	
	private CityService cityService;
	
	@Autowired
	public CitiesController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
	
	@GetMapping("getById")
	public DataResult<City> getById(@RequestParam int id){
		return cityService.getById(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody City city) {
		
		return this.cityService.add(city);
	}
	
	
	
	
	
	
	
	
}
