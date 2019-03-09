package friday.thirteen.count;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FridayCountWrapper {

	private List<FridayCount> fridayCounts = new ArrayList<>();

	public FridayCountWrapper() {
		initializeFridayCounts();
	}

	public void addCount(int dayOfWeek, int count) {
		FridayCount friday = fridayCounts.get(dayOfWeek - 1);
		friday.setCount(friday.getCount() + count);
		fridayCounts.set(dayOfWeek - 1, friday);
	}

	private void initializeFridayCounts() {
		IntStream.range(1, 32).boxed().map(value -> fridayCounts.add(new FridayCount(value, 0))).collect(Collectors.toList());
	}

	public List<FridayCount> getFridayCounts() {
		return fridayCounts;
	}

}
