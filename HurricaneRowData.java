

public class HurricaneRowData {
	
	// instance vars
	private int year;
	private int ace;
	private int tropicalStorms;
	private int hurricanes;
	private int majorHurricanes;
	
	// constructor
	public HurricaneRowData(int year,int ace,int tropicalStorms,int hurricanes,int majorHurricanes) {
		this.year = year;
		this.ace = ace;
		this.tropicalStorms = tropicalStorms;
		this.hurricanes = hurricanes;
		this.majorHurricanes = majorHurricanes;
	}
	
	// tostring
	@Override
	public String toString() {
		return "Year: " + year + ", Ace Index: " + ace + ", Number of Tropical Storms: " + tropicalStorms + ", Number of Hurricanes: " + hurricanes + ", Number of Major Huricanes: " + majorHurricanes;
	}
	
	// getters and setters
	
	public int getACE() {
		return ace;
	}
	public int getYear() {
		return year;
	}
	
	
}