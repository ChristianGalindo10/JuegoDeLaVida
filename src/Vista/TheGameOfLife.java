/**
 * The game of life
 *
 * @author Marc Oliveras Galvez <admin@oligalma.com>
 * @link http://www.oligalma.com
 * @copyright 2017 Oligalma
 * @license GPL License v3
 */
package Vista;

import Interfaces.Interfaz_Area;
import Interfaces.Interfaz_Iniciar;
import java.awt.*;

import javax.swing.*;
import Services.ObjetosGraficos;
import static javax.swing.BorderFactory.*;

public class TheGameOfLife extends JApplet implements Interfaz_Iniciar, Interfaz_Area {

    private static final long serialVersionUID = 1L;
    private static final int ROWS_NUMBER = 25;
    private static final int COLS_NUMBER = 45;
    private JLabel[][] celulas = new JLabel[25][45];
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private GridLayout gridLayout1;
    private JButton nextgenButton;
    private JButton eraseButton;
    private ObjetosGraficos sObjGraficos;

    public TheGameOfLife() {
        iniciar();
    }

    public void crearJPanels() {
        jPanel1 = sObjGraficos.construirPanel(0, 0, 420, 320, null, createLineBorder(Color.black));
        this.getContentPane().add(jPanel1);

        jPanel2 = sObjGraficos.construirPanel(16, 11, 362, 227, Color.black, createLineBorder(Color.black));

        jPanel3 = sObjGraficos.construirPanel(19, 268, 384, 39, null, createRaisedBevelBorder());

        jPanel4 = sObjGraficos.construirPanel(14, 8, 392, 250, new Color(192, 255, 192), createLoweredBevelBorder());

        jPanel1.add(jPanel4);
        jPanel4.add(jPanel2);
        jPanel1.add(jPanel3);

    }

    public void crearJLabels() {
        for (int i = 0; i < celulas.length; i++) {
            for (int j = 0; j < celulas[0].length; j++) {
                celulas[i][j] = sObjGraficos.construirJLabel(null, 0, 0, 0, 0, null, null, null, Color.white, null, createLineBorder(Color.black));
                celulas[i][j].setOpaque(true);
                jPanel2.add(celulas[i][j]);
            }
        }

    }

    public void crearJButtons() {
        nextgenButton = sObjGraficos.construirJButton("next", 182, 6, 83, 26, null, null, null);
        nextgenButton.setMargin(new Insets(2, 1, 2, 1));
        nextgenButton.setText("Next");
        jPanel3.add(nextgenButton);

        eraseButton = sObjGraficos.construirJButton("Clear", 86, 6, 83, 26, null, null, null);
        eraseButton.setMargin(new Insets(2, 1, 2, 1));
        jPanel3.add(eraseButton);

    }

    public void crearGridLayouts() {
        gridLayout1 = sObjGraficos.construirGridLayout(COLS_NUMBER, 0, ROWS_NUMBER, 0);
        jPanel2.setLayout(gridLayout1);
    }

    // Initialize the applet
    public JButton getNextGenButton() {
        return this.nextgenButton;
    }

    public JButton getEraseButton() {
        return this.eraseButton;
    }

    public JLabel getArea(int i, int j) {
        return celulas[i][j];
    }

    @Override
    public void setArea(boolean[][] area2) {
        for (int i = 0; i < area2.length; i++) {
            for (int j = 0; j < area2[0].length; j++) {
                if (area2[i][j] == true) {
                    celulas[i][j].setBackground(Color.red);
                } else {
                    celulas[i][j].setBackground(Color.white);
                }
            }
        }
    }

    @Override
    public boolean[][] getArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void iniciar() {
        sObjGraficos = ObjetosGraficos.getServicio();
        crearJPanels();
        crearJLabels();
        crearJButtons();
        crearGridLayouts();
        setSize(new Dimension(420, 320));
    }

}
