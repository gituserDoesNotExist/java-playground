package friday.thirteen.count;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CountFridays {

	private List<Friday> fridays = new ArrayList<>();

	public List<Friday> getFridaysOfYear(int year) {

		LocalDate localDate = LocalDate.of(year, 1, 1);

		for (int i = 0; i < computeDaysOfYear(year, localDate); i++) {
			LocalDate newDate = localDate.plusDays(i);
			if (checkIfFriday(newDate)) {
				fridays.add(new Friday(newDate.getDayOfMonth()));
			}
		}
		return fridays;
	}

	private long computeDaysOfYear(int year, LocalDate localDate) {
		return Duration.between(localDate.atStartOfDay(), LocalDate.of(year + 1, 1, 1).atStartOfDay()).toDays();
	}

	private boolean checkIfFriday(LocalDate newDate) {
		return newDate.getDayOfWeek().getValue() == DayOfWeek.FRIDAY.getValue();
	}

}
