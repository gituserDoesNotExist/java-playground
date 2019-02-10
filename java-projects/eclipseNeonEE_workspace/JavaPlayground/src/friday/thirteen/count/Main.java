package friday.thirteen.count;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		FridayCountWrapper wrapper = new FridayCountWrapper();

		for (int year = 0; year <= 4000; year++) {
			List<Friday> fridays = new CountFridays().getFridaysOfYear(year);
			System.out.println(year);
			for (int day = 1; day <= 31; day++) {
				wrapper.addCount(day, countFriday(fridays, day));
			}
		}
		wrapper.getFridayCounts().stream().forEach(fridayCount -> logResult(fridayCount));
		wrapper.getFridayCounts().stream().forEach(fridayCount -> System.out.println(fridayCount.getFriday().getDayOfMonth()));
	}

	private static void logResult(FridayCount fridayCount) {
		System.out.println("Day of month: " + fridayCount.getFriday().getDayOfMonth() + " count: " + fridayCount.getCount());
	}

	private static int countFriday(List<Friday> fridays, int day) {
		return Collections.frequency(convertToListOfNumbers(fridays), day);
	}

	private static List<Integer> convertToListOfNumbers(List<Friday> fridays) {
		return fridays.stream().map(Friday::getDayOfMonth).collect(Collectors.toList());
	}

}
