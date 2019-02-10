package de.andrena.schulung.hibernate.uebung4.dao.domain;

public enum Activity {
	
	KINDERGARTEN(0, 7), SCHULE(5, 22), AUSBILDUNG(13, 35), IM_BERUFSLEBEN(16, 67);
	
	
	private int minAge;
	private int maxAge;


	private Activity() {
	}

	private Activity(int minAlter, int maxAlter) {
		this.minAge = minAlter;
		this.maxAge = maxAlter;
		
	}

	
	public boolean isAgeOk(int age){
		return age >= minAge && age <= maxAge;
	}

}
