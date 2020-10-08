package domain;

public class DateArithmetic {
	
	/*　日付ID　*/
	private String dateId;
	
	/*　日付名　*/
	private String dateName;
	
	/*　加減年　*/
	private int adjustmentYear;
	
	/*　加減月　*/
	private int adjustmentMonth;
	
	/*　加減日　*/
	private int adjustmentDay;
	
	/*　日付IDの取得　*/
	public String getDateId() {
		return dateId;
	}
	
	/*　日付IDの設定　*/
	public void setDateId(String dateId) {
		this.dateId = dateId;
	}
	
	/*　日付名の取得　*/
	public String getDateName() {
		return dateName;
	}
	
	/*　日付名の設定　*/
	public void setDateName(String dateName) {
		this.dateName = dateName;
	}
	
	/*　加減年の取得　*/
	public int getAdjustmentYear() {
		return adjustmentYear;
	}
	
	/*　加減年の設定　*/
	public void setAdjustmentYear(int adjustmentYear) {
		this.adjustmentYear = adjustmentYear;
	}
	
	/*　加減月の取得　*/
	public int getAdjustmentMonth() {
		return adjustmentMonth;
	}
	
	/*　加減月の設定　*/
	public void setAdjustmentMonth(int adjustmentMonth) {
		this.adjustmentMonth = adjustmentMonth;
	}
	
	/*　加減日の取得　*/
	public int getAdjustmentDay() {
		return adjustmentDay;
	}
	
	/*　加減日の設定　*/
	public void setAdjustmentDay(int adjustmentDay) {
		this.adjustmentDay = adjustmentDay;
	}
}
