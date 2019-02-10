package org.fancy.model;

public class Application {
	public static void main(String[] args) {
		// überall dort wo die Basisklasse steht kann man dies durch die
		// Kindklasse ersetzen, d.h. man kann jede Instanz der Elternklasse
		// durch eine Instanz der Kindklasse ersetzen
		Parent parent = new Parent();
		Parent child = new Child();

		// man kann nicht überall dort wo die Kindklasse ist die Elternklasse
		// einsetzen, d.h. man kann nicht jede Instanz der Kindklasse durch eine
		// Instanz der Elternklasse ersetzen
		Child child2 = new Child();
		// Child as = new Parent();

		if (child instanceof Parent) {
			System.out.println("child is instance of parent");// out
		} else {
			System.out.println("child is not instance of parent");// is not the
																	// case
		}
		if (parent instanceof Child) {
			System.out.println("parent is instance of child");// is not the case
		} else {
			System.out.println("parent is not instance of child");// out
		}
	}

}
