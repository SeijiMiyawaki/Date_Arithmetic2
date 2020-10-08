package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.DateArithmetic;
import service.CalculationService;

@Controller
@RequestMapping("/update/{dateId}")
public class UpdateController {
	@Autowired
	private CalculationService service;
	
	@GetMapping
	public String index(@PathVariable String dateId, Model model) {
		model.addAttribute("dateArithmetic", service.search(dateId));
		return "update";
	}
	
	@PostMapping
	public String update(@ModelAttribute @Validated DateArithmetic form, Model model) {
		return "update";
	}
	
}
