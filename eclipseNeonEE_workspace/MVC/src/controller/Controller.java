package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import view.View;

public class Controller {

    private Model model;
    private View view;

    public Controller() {
	view = new View();
	model = new Model();
	addListener();
    }

    public void showView() {
	view.showView();
    }

    private void addListener() {
	view.setButtonListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		int eingabe = Integer.valueOf(view.getEingabe());
		model.square(eingabe);
		view.setButtonText("summe = " + model.getZahl());
	    }
	});
    }

}
