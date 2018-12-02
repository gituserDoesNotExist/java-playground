package model;

import java.awt.Point;

public class SpielController {

    private final static View view = new View();
    SpielBrett tictactoe = SpielBrett.getInstance();
    Spieler_KI ki = new Spieler_KI();

    public void start() {

	view.erzeugeGUI();

    }

    public void firstStep() {
	tictactoe.besetzeFeld(ki.testmethod(), SpielConstants.MAXIMIZING_PLAYER);
	view.updateSpielfeld(tictactoe.getSpielFeld());
    }

    public void nextStep(Point point) {
	System.out.println(point);
	tictactoe.besetzeFeld(point, SpielConstants.MINIMIZING_PLAYER);
	view.updateSpielfeld(tictactoe.getSpielFeld());
	if (tictactoe.istSpielVorbei()) {
	    System.out.println("ende");
	    return;
	}
	tictactoe.besetzeFeld(ki.testmethod(), SpielConstants.MAXIMIZING_PLAYER);
	view.updateSpielfeld(tictactoe.getSpielFeld());
	if (tictactoe.istSpielVorbei()) {
	    System.out.println("ende");
	    return;
	}
    }
}
