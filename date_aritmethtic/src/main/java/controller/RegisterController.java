package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.DateArithmetic;
import domain.SimulationForm;
import service.CalculationService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private CalculationService service;
	
	@GetMapping
	public String index(@ModelAttribute DateArithmetic form) {
		return "register";
	}
	
	@PostMapping
	public String register(@ModelAttribute @Validated DateArithmetic form, Model model) {
		service.register(form);
		model.addAttribute("simulationForm", new SimulationForm());
		return "simulation";
	}
}
