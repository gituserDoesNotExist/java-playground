package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		SpielController controller = new SpielController();
		controller.start();

	}

	public static Point compMove;

	/*
	 * static int[][] spielFeld = new int[][] { { SpielConstants.MINIMIZING_PLAYER, SpielConstants.MINIMIZING_PLAYER,
	 * SpielConstants.MAXIMIZING_PLAYER }, { SpielConstants.LEERESFELD, SpielConstants.LEERESFELD,
	 * SpielConstants.LEERESFELD }, { SpielConstants.MAXIMIZING_PLAYER, SpielConstants.MINIMIZING_PLAYER,
	 * SpielConstants.MINIMIZING_PLAYER } };
	 */
	static int[][] spielFeld = new int[][] {
			{ SpielConstants.LEERESFELD, SpielConstants.LEERESFELD, SpielConstants.LEERESFELD },
			{ SpielConstants.LEERESFELD, SpielConstants.LEERESFELD, SpielConstants.LEERESFELD },
			{ SpielConstants.LEERESFELD, SpielConstants.LEERESFELD, SpielConstants.LEERESFELD } };

	public static boolean istSpielVorbei() {
		return hatSpielerGewonnen(SpielConstants.MAXIMIZING_PLAYER)
				|| hatSpielerGewonnen(SpielConstants.MINIMIZING_PLAYER)
				|| leereFelder().size() == 0;
	}

	public static List<Point> leereFelder() {
		List<Point> list = new ArrayList<>();
		for (int row = 0; row < SpielConstants.GROESSE_SPIELFELD_ROWS; row++) {
			for (int col = 0; col < SpielConstants.GROESSE_SPIELFELD_COLS; col++) {
				if (spielFeld[row][col] == SpielConstants.LEERESFELD) {
					list.add(new Point(row, col));
				}
			}
		}
		return list;
	}

	public static boolean frageUndBesetzeFeld(Point point, int spieler) {
		if (spielFeld[point.x][point.y] != SpielConstants.LEERESFELD) {
			return false;
		}
		spielFeld[point.x][point.y] = spieler;
		return true;
	}

	public static void besetzeFeld(Point point, int spieler) {
		spielFeld[point.x][point.y] = spieler;
	}

	public static void zeigeSpielFeld() {
		System.out.println("spielfeld:");
		for (int row = 0; row < SpielConstants.GROESSE_SPIELFELD_ROWS; row++) {
			for (int col = 0; col < SpielConstants.GROESSE_SPIELFELD_COLS; col++) {
				System.out.print(spielFeld[row][col] + " ");
			}
			System.out.print("\n");
		}
	}

	public static boolean hatSpielerGewonnen(int spieler) {
		if (BooleanUtil.vergleicheFelder(spielFeld[0][0], spielFeld[1][1], spielFeld[2][2],
				spieler)) {
			return true;
		}
		if (BooleanUtil.vergleicheFelder(spielFeld[2][0], spielFeld[1][1], spielFeld[0][2],
				spieler)) {
			return true;
		}
		boolean result = false;
		for (int index = 0; index < SpielConstants.GROESSE_SPIELFELD_ROWS; index++) {
			boolean waagrecht = BooleanUtil.vergleicheFelder(spielFeld[0][index],
					spielFeld[1][index], spielFeld[2][index], spieler);
			boolean senkrecht = BooleanUtil.vergleicheFelder(spielFeld[index][0],
					spielFeld[index][1], spielFeld[index][2], spieler);
			if (waagrecht || senkrecht) {
				result = waagrecht || senkrecht;
				break;
			}
		}
		return result;
	}

	public static boolean hatSpielerGewonnen2(int spieler) {
		if (BooleanUtil.vergleicheFelder(spielFeld[0][0], spielFeld[1][0], spielFeld[2][0],
				spieler))
			return true;
		if (BooleanUtil.vergleicheFelder(spielFeld[0][1], spielFeld[1][1], spielFeld[2][1],
				spieler))
			return true;
		return false;
	}

	public static int lastMinimax(int depth, int player) {

		if (hatSpielerGewonnen(SpielConstants.MAXIMIZING_PLAYER)) {
			// System.out.println("ich hab gewonnen du pisser");
			// zeigeSpielFeld();
			return SpielConstants.WERT_SIEG_MAXIMIZING_PLAYER;
		}
		if (hatSpielerGewonnen(SpielConstants.MINIMIZING_PLAYER)) {
			// System.out.println("ich hab verloren");
			// zeigeSpielFeld();
			return SpielConstants.WERT_SIEG_MINIMIZING_PLAYER;
		}

		List<Point> emptyFields = leereFelder();
		if (emptyFields.isEmpty()) {
			return 0;
		}

		if (player == SpielConstants.MAXIMIZING_PLAYER) {
			int bestValue = Integer.MIN_VALUE;
			for (Point point : emptyFields) {
				frageUndBesetzeFeld(point, SpielConstants.MAXIMIZING_PLAYER);
				// System.out.println("maximizing player --- depth=" + depth + "-- point=" + point);
				// zeigeSpielFeld();
				int v = lastMinimax(depth + 1, SpielConstants.MINIMIZING_PLAYER);
				bestValue = Math.max(bestValue, v);
				if (depth == 0) {
					System.out.println("computer score for point " + point + ":" + v);
				}

				if (depth == 0 && v >= bestValue) {
					compMove = point;
				}

				// System.out.println("nach minimax" + "--bewertung=" + bestValue);
				spielFeld[point.x][point.y] = SpielConstants.LEERESFELD;
				// zeigeSpielFeld();
			}
			return bestValue;
		}

		if (player == SpielConstants.MINIMIZING_PLAYER) {
			int bestValue = Integer.MAX_VALUE;
			for (Point point : emptyFields) {
				frageUndBesetzeFeld(point, SpielConstants.MINIMIZING_PLAYER);
				// System.out.println("minimizing player --- depth=" + depth + "-- point=" + point);
				// zeigeSpielFeld();
				int v = lastMinimax(depth + 1, SpielConstants.MAXIMIZING_PLAYER);
				bestValue = Math.min(bestValue, v);
				// System.out.println("nach minimax" + "--bewertung=" + v);
				spielFeld[point.x][point.y] = SpielConstants.LEERESFELD;
				// zeigeSpielFeld();
			}
			return bestValue;
		}
		return 100;
	}

	enum Test {
		CLASSIC(100), SOCIAL(200);

		private int number;

		private Test(int number) {
			this.number = number;
		}

		public int getNumber() {
			return number;
		}
	}

	enum Test3 {
		CLASSIC3(new Point(1, 1)), SOCIAL3(new Point(5, 4));

		private Point point;

		private Test3(Point point) {
			this.point = point;
		}

		public Point getPoint() {
			return point;
		}
	}

	enum Test2 {
		CLASSIC2 {
			public Point getPoint() {
				return new Point(1, 1);
			}
		},
		SOCIAL2 {
			public Point getPoint() {
				return new Point(5, 4);
			}
		};
		abstract Point getPoint();
	}

}
