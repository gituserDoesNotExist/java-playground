package superclass.created.when.child.created.same.instance;

public class ChildClass1 extends Superclass {

	private String attributeChild1;

	public ChildClass1() {
		System.out.println("ChildClass1 was called");
	}

	public String getAttributeChild1() {
		return attributeChild1;
	}

	public void setAttributeChild1(String attributeChild1) {
		this.attributeChild1 = attributeChild1;
	}

}
