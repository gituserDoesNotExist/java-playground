package model;

public class BooleanUtil {

	public static boolean vergleicheFelder(int feld1, int feld2, int feld3, int spieler) {
		return feld1 == feld2 && feld1 == feld3 && feld1 == spieler;
	}

}
