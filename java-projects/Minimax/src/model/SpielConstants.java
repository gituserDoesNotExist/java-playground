package model;

import java.io.File;

public interface SpielConstants {
	int MAXIMIZING_PLAYER = 1;
	int MINIMIZING_PLAYER = 2;
	int LEERESFELD = 0;
	String STRING_MAXIMIZING_PLAYER = "X";
	String STRING_MINIMIZING_PLAYER = "O";
	String STRING_LEERESFELD = "?";
	int GROESSE_SPIELFELD_ROWS = 3;
	int GROESSE_SPIELFELD_COLS = 3;
	int STARTWERT_MINIMAX = 0;
	int MAXIMUMDEPTH = 3;
	int WERT_SIEG_MAXIMIZING_PLAYER = 1;
	int WERT_SIEG_MINIMIZING_PLAYER = -1;
	File FILE = new File("C:\\Users\\Manfred\\JavaShit", "obj.ser");
}
