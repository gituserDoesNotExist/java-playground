package model;

import java.awt.Point;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SpielBrett implements Serializable {

	private static final long serialVersionUID = 2050501729717993344L;
	private static SpielBrett instance = null;

	private SpielBrett() {
	};

	static SpielBrett getInstance() {
		if (SpielBrett.instance == null) {
			SpielBrett.instance = new SpielBrett();
		}
		return SpielBrett.instance;
	}

	public SpielBrett getCopy() {
		SpielBrett copy = null;
		try {
			ObjectOutputStream objectOutputStream = ObjectStreamFactory
					.getObjectOutputStream(SpielConstants.FILE);
			objectOutputStream.writeObject(SpielBrett.getInstance());
			objectOutputStream.close();
			ObjectInputStream objectInputStream = ObjectStreamFactory
					.getObjectInputStream(SpielConstants.FILE);
			copy = (SpielBrett) objectInputStream.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return copy;
	}

	public int[][] spielFeld = new int[][] {
			{ SpielConstants.LEERESFELD, SpielConstants.LEERESFELD, SpielConstants.LEERESFELD },
			{ SpielConstants.LEERESFELD, SpielConstants.LEERESFELD, SpielConstants.LEERESFELD },
			{ SpielConstants.LEERESFELD, SpielConstants.LEERESFELD, SpielConstants.LEERESFELD } };

	public boolean hatSpielerGewonnen(int spieler) {
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

	public boolean istSpielVorbei() {
		return hatSpielerGewonnen(SpielConstants.MAXIMIZING_PLAYER)
				|| hatSpielerGewonnen(SpielConstants.MINIMIZING_PLAYER)
				|| ermittleFreieFelder().size() == 0;
	}

	public int[][] getSpielFeld() {
		return spielFeld;
	}

	public List<Point> ermittleFreieFelder() {
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

	public boolean besetzeFeldFallsLeer(Point point, int spieler) {
		if (spielFeld[point.x][point.y] != SpielConstants.LEERESFELD) {
			return false;
		}
		spielFeld[point.x][point.y] = spieler;
		return true;
	}

	public void besetzeFeld(Point point, int spieler) {
		spielFeld[point.x][point.y] = spieler;
	}

	public void zeigeSpielFeld() {
		System.out.println("spielfeld:");
		for (int row = 0; row < SpielConstants.GROESSE_SPIELFELD_ROWS; row++) {
			for (int col = 0; col < SpielConstants.GROESSE_SPIELFELD_COLS; col++) {
				System.out.print(spielFeld[row][col] + " ");
			}
			System.out.print("\n");
		}
	}
}
