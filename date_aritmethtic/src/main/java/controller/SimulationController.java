package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Result;
import domain.SimulationForm;
import service.CalculationService;

@Controller
@RequestMapping
public class SimulationController {
	@Autowired
	private CalculationService service;
	
	@GetMapping
	public String index(@ModelAttribute SimulationForm form) {
		return "simulation";
	}
	
	@PostMapping
	public String simulation(@ModelAttribute @Validated SimulationForm form, Model model) {
		SimulationForm resultForm = new SimulationForm(form.getBaseDate(), service.search());
		List<Result> results = resultForm.getResults();
		
		results.stream().forEach(e -> e.setCalculated(service.calculate(form.getBaseDate(), e.getArithmetic())));
		
		model.addAttribute("results", results);
		return "simulation";
	}
	
	@PostMapping(value = "/{dateId}")
	public String delete(@PathVariable String dateId, Model model) {
		service.delete(dateId);
		model.addAttribute("simulationForm", new SimulationForm());
		return "simulation";
	}
	
}
