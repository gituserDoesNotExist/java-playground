package friday.thirteen.count;

public class FridayCount {

	private Friday friday;
	private int count;

	public FridayCount(int dayOfMonth, int count) {
		this.friday = new Friday(dayOfMonth);
		this.count = count;
	}

	public Friday getFriday() {
		return friday;
	}

	public void setFriday(Friday friday) {
		this.friday = friday;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
