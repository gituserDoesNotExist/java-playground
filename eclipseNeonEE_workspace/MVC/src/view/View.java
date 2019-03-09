package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class View {

    private JFrame jFrame = new JFrame();
    private JPanel jPanel = new JPanel();
    private JTextField jTextField = new JTextField("3");
    private JButton jButton = new JButton("compute square");

    public View() {
	initForm();
    }

    private void initForm() {
	jPanel.add(jButton);
	jPanel.add(jTextField);
	jFrame.add(jPanel);
	jFrame.setSize(400, 400);
	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void showView() {
	jFrame.setVisible(true);
    }

    public String getEingabe() {
	return jTextField.getText();
    }

    public void setButtonListener(ActionListener al) {
	this.jButton.addActionListener(al);
    }

    public void setButtonText(String text) {
	jButton.setText(text);
    }

}
