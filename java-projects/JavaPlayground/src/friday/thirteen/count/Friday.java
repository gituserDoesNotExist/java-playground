package friday.thirteen.count;

public class Friday {

	public static String VALUE = "Friday";

	private int dayOfMonth;

	public Friday(int dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	public int getDayOfMonth() {
		return dayOfMonth;
	}

	public void setDayOfMonth(int dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	@Override
	public String toString() {
		return "Friday_" + getDayOfMonth();
	}

}
