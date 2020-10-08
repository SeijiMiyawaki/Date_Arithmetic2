package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.DateArithmetic;
import domain.Result;
import domain.SimulationForm;
import service.CalculationService;

@RestController
@RequestMapping("/api")
public class SimulationRestApiController {
	
	@Autowired
	private CalculationService service;
	
	@GetMapping
	public List<DateArithmetic> getDateArithmeticList() {
		return service.search();
	}
	
	@GetMapping(value = "{dateId}")
	public DateArithmetic getDateArithmetic(@PathVariable("dateId") String dateId) {
		return service.search(dateId);
	}
	
	@PostMapping(value = "{baseDate}")
	public List<Result> simulation(@PathVariable("baseDate") String baseDate) {
		SimulationForm resultForm = new SimulationForm(baseDate, service.search());
		List<Result> results = resultForm.getResults();
		
		results.stream().forEach(e -> e.setCalculated(service.calculate(baseDate, e.getArithmetic())));
		return results;
	}
	
}
