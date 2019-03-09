package model;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class View {

	SpielController controller = new SpielController();

	private List<JButton> buttonList = new ArrayList<>(
			SpielConstants.GROESSE_SPIELFELD_ROWS * SpielConstants.GROESSE_SPIELFELD_COLS);

	private Map<Integer, String> myMap;

	public View() {
		myMap = new HashMap<Integer, String>();
		myMap.put(SpielConstants.LEERESFELD, SpielConstants.STRING_LEERESFELD);
		myMap.put(SpielConstants.MINIMIZING_PLAYER, SpielConstants.STRING_MINIMIZING_PLAYER);
		myMap.put(SpielConstants.MAXIMIZING_PLAYER, SpielConstants.STRING_MAXIMIZING_PLAYER);
	}

	public void updateSpielfeld(int[][] spielFeld) {
		System.out.println("update");
		for (int row = 0; row < SpielConstants.GROESSE_SPIELFELD_ROWS; row++) {
			for (int col = 0; col < SpielConstants.GROESSE_SPIELFELD_COLS; col++) {
				int index = col + row * SpielConstants.GROESSE_SPIELFELD_ROWS;
				System.out.println(index);
				JButton jButton = buttonList.get(index);
				String newLabel = myMap.get(spielFeld[row][col]);
				jButton.setText(newLabel);
			}
		}
	}

	private JPanel erzeugeSpielFeld() {
		JPanel jPanel = new JPanel(new GridLayout(SpielConstants.GROESSE_SPIELFELD_ROWS,
				SpielConstants.GROESSE_SPIELFELD_COLS));
		for (int row = 0; row < SpielConstants.GROESSE_SPIELFELD_ROWS; row++) {
			for (int col = 0; col < SpielConstants.GROESSE_SPIELFELD_COLS; col++) {
				JButton jButton = new JButton("?");
				jButton.setFont(new Font("Arial", 1, 40));
				Point point = new Point(row, col);
				jButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						controller.nextStep(point);
					}
				});
				buttonList.add(jButton);
				jPanel.add(jButton);
			}
		}
		System.out.println(buttonList);
		return jPanel;
	}

	private JMenuBar erzeugeMenuBar() {
		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenu = new JMenu("Spiel");
		JMenuItem jMenuItem = new JMenuItem("Start");
		jMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.firstStep();
			}
		});
		jMenu.add(jMenuItem);
		jMenuBar.add(jMenu);

		return jMenuBar;
	}

	protected void erzeugeGUI() {
		JFrame jFrame = new JFrame();
		jFrame.setJMenuBar(erzeugeMenuBar());
		jFrame.add(erzeugeSpielFeld());
		jFrame.setSize(400, 400);
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}

}
