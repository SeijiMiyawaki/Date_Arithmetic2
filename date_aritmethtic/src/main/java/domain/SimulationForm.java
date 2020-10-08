package domain;

import java.util.ArrayList;
import java.util.List;

public class SimulationForm {
	private String baseDate;
	
	private List<Result> results;
	
	public SimulationForm() {
		
	}
	
	public SimulationForm(String baseDate, List<DateArithmetic> results) {
		this.baseDate = baseDate;
		this.results = new ArrayList<>();
		results.stream().forEach(r -> this.results.add(convertToResult(r)));
		
	}
	
	public String getBaseDate() {
		return baseDate;
	}
	
	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}
	
	public List<Result> getResults(){
		return results;
	}
	
	public Result convertToResult(DateArithmetic arithmetic) {
		return new Result(arithmetic);
	}
}
