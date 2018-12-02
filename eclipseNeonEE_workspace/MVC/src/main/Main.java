package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.Controller;

public class Main {

    public static void main(String[] args) {
	JButton test = new JButton();
	test.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	    }
	});
	Controller controller = new Controller();

	controller.showView();

    }

}
