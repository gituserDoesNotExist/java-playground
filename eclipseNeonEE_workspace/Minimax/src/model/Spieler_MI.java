package model;

import java.awt.Point;
import java.util.Scanner;

public class Spieler_MI extends Spieler {

	@Override
	public Point naechsterZug() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter point:");
		Point point = new Point(scanner.nextInt(), scanner.nextInt());
		scanner.close();
		return point;
	}

}
