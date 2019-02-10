package superclass.created.when.child.created.same.instance;

public class Superclass {

	private AttributeClass attributeClass = new AttributeClass();

	public Superclass() {
		System.out.println("Superclass was called");
	}

	public AttributeClass getAttributeClass() {
		return attributeClass;
	}

	public void setAttributeClass(AttributeClass attributeClass) {
		this.attributeClass = attributeClass;
	}

}
