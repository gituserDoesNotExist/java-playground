package superclass.created.when.child.created.same.instance;

public class Main {

	public static void main(String[] args) {
		// Die Klasse ChildClass1 erbt von Superclass. Das sieht dann so aus wie wenn alle Felder aus Superclass auch in ChildClass1 stehen.
		// Wenn man also eine Instanz von ChildClass1 erstellt, dann werden auch die Membervariablen aus Superclass neu initialisiert.

		// new Superclass();
		new ChildClass1();

		AttributeClass attributeClass = new AttributeClass();
		ChildClass1 child1 = new ChildClass1();
		ChildClass1 child1Second = new ChildClass1();
		ChildClass2 child2 = new ChildClass2();
		Superclass superClass = new Superclass();

		System.out.println("child1 equals child1: " + child1.equals(child1));
		System.out.println("child1 equals child2: " + child1.equals(child2));
		System.out.println("child1.getAttributeClass equals child2.getAttributeClass: "
				+ child1.getAttributeClass().equals(child2.getAttributeClass()));
		System.out.println("child1.getAttributeClass equals superClass.getAttributeClass: "
				+ child1.getAttributeClass().equals(superClass.getAttributeClass()));
		System.out.println("child1.getAttributeClass equals child1Second.getAttributeClass: "
				+ child1.getAttributeClass().equals(child1Second.getAttributeClass()));

		System.out.println("child1.getAttributeClass: " + child1.getAttributeClass());
		System.out.println("child2.getAttributeClass: " + child2.getAttributeClass());
		System.out.println("attributeClassInstance: " + attributeClass);
		System.out.println("superClass.getAttributeClass: " + superClass.getAttributeClass());
	}

}
