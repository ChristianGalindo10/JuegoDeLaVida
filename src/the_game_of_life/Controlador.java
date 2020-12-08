package the_game_of_life;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Controlador implements ActionListener,MouseListener{
	
	private Modelo modelo;
	private TheGameOfLife vista;
	private boolean leftButtonPressed;
	private boolean click = false;
	
	public Controlador(TheGameOfLife vista, Modelo modelo) {
		this.vista = vista;
		vista.init();
		this.modelo = modelo;
		this.vista.getNextGenButton().addActionListener(this);
		this.vista.getEraseButton().addActionListener(this);
		
		for (int i = 0; i < 25; i++)
		{
			for (int j = 0; j < 45; j++) {
				vista.getArea(i,j).addMouseListener(this);
			}
		}
	}
	
	public void iniciar(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(3);
		frame.setTitle("The game of life");
		frame.getContentPane().add(vista, BorderLayout.CENTER);
		//applet.init();
		vista.start();
		frame.setSize(425, 350);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if(e.getActionCommand().equals("Next")){
			modelo.nextGen();
			vista.setArea(modelo.getArea());
		}else {
			modelo.clearArea();
			vista.setArea(modelo.getArea());
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if (click) {
			Object o = e.getSource();
			if (leftButtonPressed)
				((JLabel) o).setBackground(Color.red);
			else
				((JLabel) o).setBackground(Color.white);
		}
		
		boolean[][] area2 = new boolean[25][45];		
		for (int i = 0; i < area2.length; i++)
		{
			for (int j = 0; j < area2[0].length; j++) {
				if (vista.getArea(i, j).getBackground().equals(Color.red))
					area2[i][j] = true;
				else
					area2[i][j] = false;
			}
		}
		
		modelo.setArea(area2);
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mousePressed(MouseEvent e) {
		click = true;
		Object o = e.getSource();
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftButtonPressed = true;
			((JLabel) o).setBackground(Color.red);
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			leftButtonPressed = false;
			((JLabel) o).setBackground(Color.white);
		}	
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		click = false;
	}
}
