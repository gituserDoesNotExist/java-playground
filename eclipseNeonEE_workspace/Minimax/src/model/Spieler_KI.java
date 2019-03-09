package model;

import java.awt.Point;
import java.util.List;

public class Spieler_KI {

	SpielBrett spielOriginal = SpielBrett.getInstance();
	private Point compMove;

	public Point testmethod() {
		SpielBrett spielCopy = spielOriginal.getCopy();
		System.out.println("so sehe ich das Feld");
		spielCopy.zeigeSpielFeld();
		lastMinimax(0, SpielConstants.MAXIMIZING_PLAYER, spielCopy);
		return compMove;
	}

	private int lastMinimax(int depth, int player, SpielBrett spielCopy) {
		if (spielCopy.hatSpielerGewonnen(SpielConstants.MAXIMIZING_PLAYER)) {
			// System.out.println("ich hab gewonnen du pisser");
			// zeigeSpielFeld();
			return SpielConstants.WERT_SIEG_MAXIMIZING_PLAYER;
		}
		if (spielCopy.hatSpielerGewonnen(SpielConstants.MINIMIZING_PLAYER)) {
			// System.out.println("ich hab verloren");
			// zeigeSpielFeld();
			return SpielConstants.WERT_SIEG_MINIMIZING_PLAYER;
		}

		List<Point> emptyFields = spielCopy.ermittleFreieFelder();
		if (emptyFields.isEmpty()) {
			return 0;
		}

		if (player == SpielConstants.MAXIMIZING_PLAYER) {
			int bestValue = Integer.MIN_VALUE;
			for (Point point : emptyFields) {
				spielCopy.besetzeFeldFallsLeer(point, SpielConstants.MAXIMIZING_PLAYER);
				// System.out.println("maximizing player --- depth=" + depth + "-- point=" + point);
				// zeigeSpielFeld();
				int currentValue = lastMinimax(depth + 1, SpielConstants.MINIMIZING_PLAYER,
						spielCopy);
				bestValue = Math.max(bestValue, currentValue);
				if (depth == 0) {
					System.out.println("computer score for point " + point + ":" + currentValue);
				}

				if (depth == 0 && currentValue >= bestValue) {
					compMove = point;
				}

				// System.out.println("nach minimax" + "--bewertung=" + bestValue);
				spielCopy.besetzeFeld(point, SpielConstants.LEERESFELD);
				// zeigeSpielFeld();
			}
			return bestValue;
		}

		if (player == SpielConstants.MINIMIZING_PLAYER) {
			int bestValue = Integer.MAX_VALUE;
			for (Point point : emptyFields) {
				spielCopy.besetzeFeldFallsLeer(point, SpielConstants.MINIMIZING_PLAYER);
				// System.out.println("minimizing player --- depth=" + depth + "-- point=" + point);
				// zeigeSpielFeld();
				int currentValue = lastMinimax(depth + 1, SpielConstants.MAXIMIZING_PLAYER,
						spielCopy);
				bestValue = Math.min(bestValue, currentValue);
				// System.out.println("nach minimax" + "--bewertung=" + v);
				spielCopy.besetzeFeld(point, SpielConstants.LEERESFELD);
				// zeigeSpielFeld();
			}
			return bestValue;
		}
		return 100;
	}
}
