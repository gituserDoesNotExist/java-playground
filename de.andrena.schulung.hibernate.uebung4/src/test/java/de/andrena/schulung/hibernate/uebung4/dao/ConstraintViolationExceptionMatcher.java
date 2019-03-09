package de.andrena.schulung.hibernate.uebung4.dao;

import java.util.Arrays;

import javax.validation.ConstraintViolationException;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public final class ConstraintViolationExceptionMatcher extends TypeSafeMatcher<ConstraintViolationException> {

	private String[] expectedMessages;

	public static ConstraintViolationExceptionMatcher containsMessages(String... expectedMessages) {
		return new ConstraintViolationExceptionMatcher(expectedMessages);
	}

	private ConstraintViolationExceptionMatcher(String... expectedMessages) {
		this.expectedMessages = expectedMessages;
	}

	@Override
	public void describeTo(Description description) {
		Arrays.asList(expectedMessages).stream().forEach(expectedMessage -> description.appendValue(expectedMessage));
	}

	@Override
	protected boolean matchesSafely(ConstraintViolationException exception) {
		return numberOfMessagesAreCorrect(exception) && allMessagesAreContained(exception);
	}

	private boolean allMessagesAreContained(ConstraintViolationException exception) {
		return Arrays.asList(expectedMessages).stream()
				.allMatch(expectedMessage -> isMessageContained(expectedMessage, exception));
	}

	private boolean isMessageContained(String expectedMessage, ConstraintViolationException exception) {
		return exception.getConstraintViolations().stream()
				.anyMatch(violation -> violation.getMessage().contains(expectedMessage));
	}

	private boolean numberOfMessagesAreCorrect(ConstraintViolationException exception) {
		return exception.getConstraintViolations().size() == expectedMessages.length;
	}

}
