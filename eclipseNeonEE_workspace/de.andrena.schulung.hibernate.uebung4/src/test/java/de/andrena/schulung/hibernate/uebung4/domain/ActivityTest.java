package de.andrena.schulung.hibernate.uebung4.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import de.andrena.schulung.hibernate.uebung4.dao.domain.Activity;

public class ActivityTest {

	@Test
	public void testAgeForKindergarten() {
		assertThat(Activity.KINDERGARTEN.isAgeOk(-1), is(false));
		assertThat(Activity.KINDERGARTEN.isAgeOk(0), is(true));
		assertThat(Activity.KINDERGARTEN.isAgeOk(7), is(true));
		assertThat(Activity.KINDERGARTEN.isAgeOk(8), is(false));
	}
	
	@Test
	public void testAgeForSchule() {
		assertThat(Activity.SCHULE.isAgeOk(4), is(false));
		assertThat(Activity.SCHULE.isAgeOk(5), is(true));
		assertThat(Activity.SCHULE.isAgeOk(22), is(true));
		assertThat(Activity.SCHULE.isAgeOk(23), is(false));
	}
	
	@Test
	public void testAgeForAusbildung() {
		assertThat(Activity.AUSBILDUNG.isAgeOk(12), is(false));
		assertThat(Activity.AUSBILDUNG.isAgeOk(13), is(true));
		assertThat(Activity.AUSBILDUNG.isAgeOk(35), is(true));
		assertThat(Activity.AUSBILDUNG.isAgeOk(36), is(false));
	}
	
	@Test
	public void testAgeForBerufsleben() {
		assertThat(Activity.IM_BERUFSLEBEN.isAgeOk(15), is(false));
		assertThat(Activity.IM_BERUFSLEBEN.isAgeOk(16), is(true));
		assertThat(Activity.IM_BERUFSLEBEN.isAgeOk(67), is(true));
		assertThat(Activity.IM_BERUFSLEBEN.isAgeOk(68), is(false));
	}
	
}
