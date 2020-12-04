/**
 * The game of life
 *
 * @author Marc Oliveras Galvez <admin@oligalma.com> 
 * @link http://www.oligalma.com
 * @copyright 2017 Oligalma
 * @license GPL License v3
 */

package the_game_of_life;

import java.awt.*;

import javax.swing.*;

public class TheGameOfLife extends JApplet {
	private static final long serialVersionUID = 1L;
	private static final int ROWS_NUMBER = 25;
	private static final int COLS_NUMBER = 45;
	private JLabel[][] area = new JLabel[25][45];
	private JPanel jPanel1 = new JPanel();
	private JPanel jPanel2 = new JPanel();
	private JPanel jPanel3 = new JPanel();
	private JPanel jPanel4 = new JPanel();
	private GridLayout gridLayout1 = new GridLayout();
	private JButton nextgenButton = new JButton();
	private JButton eraseButton = new JButton();
	private JCheckBox ballCheckbox = new JCheckBox();

	// Initialize the applet
	@Override
	public void init() {
		try {
			this.setSize(new Dimension(420, 320));
			jPanel1.setLayout(null);
			jPanel2.setBackground(Color.black);
			jPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
			jPanel2.setBounds(new Rectangle(16, 11, 362, 227));
			jPanel2.setLayout(gridLayout1);
			gridLayout1.setColumns(COLS_NUMBER);
			gridLayout1.setHgap(0);
			gridLayout1.setRows(ROWS_NUMBER);
			gridLayout1.setVgap(0);
			jPanel3.setBorder(BorderFactory.createRaisedBevelBorder());
			jPanel3.setBounds(new Rectangle(19, 268, 384, 39));
			jPanel3.setLayout(null);
			nextgenButton.setBounds(new Rectangle(182, 6, 83, 26));
			nextgenButton.setMargin(new Insets(2, 1, 2, 1));
			nextgenButton.setText("Next");

			eraseButton.setText("Clear");
			eraseButton.setMargin(new Insets(2, 1, 2, 1));
			eraseButton.setBounds(new Rectangle(86, 6, 83, 26));

			jPanel4.setBackground(new Color(192, 255, 192));
			jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
			jPanel4.setBounds(new Rectangle(14, 8, 392, 250));
			jPanel4.setLayout(null);
			jPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
			this.getContentPane().add(jPanel1, BorderLayout.CENTER);
			jPanel3.add(ballCheckbox, null);
			jPanel3.add(eraseButton, null);
			jPanel3.add(nextgenButton, null);
			jPanel1.add(jPanel4, null);
			jPanel4.add(jPanel2, null);
			jPanel1.add(jPanel3, null);
			
			for (int i = 0; i < area.length; i++)
			{
				for (int j = 0; j < area[0].length; j++) {
					area[i][j] = new JLabel();
					area[i][j].setBackground(Color.white);
					area[i][j].setOpaque(true);
					area[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
					jPanel2.add(area[i][j]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JButton getNextGenButton() {
		return this.nextgenButton;
	}
	
	public JButton getEraseButton() {
		return this.eraseButton;
	}
	
	public JLabel getArea(int i, int j){
		return area[i][j];
	}
	
	public void setArea(boolean[][] area2) {
		for (int i = 0; i < area2.length; i++)
		{
			for (int j = 0; j < area2[0].length; j++) {
				if (area2[i][j] == true)
					area[i][j].setBackground(Color.red);
				else
					area[i][j].setBackground(Color.white);
			}
		}		
	}
}