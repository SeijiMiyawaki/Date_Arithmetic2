package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.DateArithmeticRepository;
import domain.DateArithmetic;

@Service
public class CalculationService {
	
	@Autowired
	private DateArithmeticRepository repository;
	
	public List<DateArithmetic> search() {
		return repository.select();
	}
	
	public DateArithmetic search(String dateId) {
		return repository.selectPK(dateId);
	}
	
	@Transactional
	public void register(DateArithmetic arithmetic) {
		repository.insert(arithmetic);
	}
	
	@Transactional
	public void update(DateArithmetic arithmetic) {
		repository.update(arithmetic);
	}
	
	@Transactional
	public void delete(String dateId) {
		repository.deletePK(dateId);
	}
	
	public String calculate(String baseDate, DateArithmetic arithmetic) {
		LocalDate date = LocalDate.parse(baseDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		LocalDate calculatedDate = date.plusYears(arithmetic.getAdjustmentYear()).plusMonths(arithmetic.getAdjustmentMonth()).plusDays(arithmetic.getAdjustmentDay());
		return calculatedDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	}
}
