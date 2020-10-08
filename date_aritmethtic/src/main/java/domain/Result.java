package domain;

import java.util.Arrays;
import java.util.StringJoiner;

public class Result {
	
	/* 日付計算式 */
	private DateArithmetic arithmetic;
	
	/* 計算結果 */
	private String calculated;
	
	public Result(DateArithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}
	
	public String getDateId() {
		return arithmetic.getDateId();
	}
	
	public String getDateName() {
		return arithmetic.getDateName();
	}
	
	public DateArithmetic getArithmetic() {
		return arithmetic;
	}
	
	public String getCalculated() {
		return calculated;
	}
	
	public void setCalculated(String calculated) {
		this.calculated = calculated;
	}
	
	public String getYmdArithmetic() {
		int[] ymdArithmetic = {arithmetic.getAdjustmentYear(), arithmetic.getAdjustmentMonth(), arithmetic.getAdjustmentDay()};
		StringJoiner joiner = new StringJoiner(" / ");
		Arrays.stream(ymdArithmetic).forEach(i -> joiner.add(String.valueOf(i)));
		return joiner.toString();
	}
}
