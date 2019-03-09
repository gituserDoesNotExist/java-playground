package returnit.without.value;

public class ReturnTest {

	public void callIt() {
		mymethod();
		mymethodReturningSomething();

	}

	private void mymethod() {
		int variable = 2;
		if (variable == 2) {
			return;
		}
		System.out.println("variable was not 2");
	}

	private String mymethodReturningSomething() {
		int variable = 2;
		if (variable == 2) {
			return null;
		}
		return "something";
	}

}
