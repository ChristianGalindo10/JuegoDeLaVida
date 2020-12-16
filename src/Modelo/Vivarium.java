package Modelo;

import Interfaces.Interfaz_Area;

/**
 * The game of life
 *
 * @author Marc Oliveras Galvez <admin@oligalma.com>
 * @link http://www.oligalma.com
 * @copyright 2017 Oligalma
 * @license GPL License v3
 */



public class Vivarium implements Interfaz_Area {
    // Attributes.

    private boolean[][] celulas;
    private int rowsNumber, colsNumber;

    // Constructor.
    public Vivarium(int rowsNumber, int colsNumber) {
        this.rowsNumber = rowsNumber + 2;
        this.colsNumber = colsNumber + 2;
        this.celulas = new boolean[rowsNumber][colsNumber];
    }

    // Method to calculate next generations
    public void nextGen() {
        int cell = 0, row, col;

        // Copy area matrix.
        boolean[][] areaCopy = this.copyArea();
	// Attributes.
        for (row = 0; row < rowsNumber; row++) {
            for (col = 0; col < colsNumber; col++) {
                if (row != 0 && row != rowsNumber - 1 && col != 0 && col != colsNumber - 1) {
                    if (areaCopy[row - 1][col - 1]) {
                        cell++;
                    }
                    if (areaCopy[row - 1][col]) {
                        cell++;
                    }
                    if (areaCopy[row - 1][col + 1]) {
                        cell++;
                    }
                    if (areaCopy[row][col - 1]) {
                        cell++;
                    }
                    if (areaCopy[row][col + 1]) {
                        cell++;
                    }
                    if (areaCopy[row + 1][col - 1]) {
                        cell++;
                    }
                    if (areaCopy[row + 1][col]) {
                        cell++;
                    }
                    if (areaCopy[row + 1][col + 1]) {
                        cell++;
                    }
                    if (areaCopy[row][col]) {
                        if (cell == 0 || cell == 1 || cell >= 4) {
                            celulas[row-1][col-1] = false;
                        }
                    } else {
                        if (cell == 3) {
                            celulas[row-1][col-1] = true;
                        }
                    }
                    cell = 0;
                }
            }
        }
    }

    @Override
    public boolean[][] getArea() {
        return celulas;
    }

    @Override
    public void setArea(boolean[][] area) {
        this.celulas = area;
    }

    @Override
    public void clearArea() {
        for (int i = 0; i < celulas.length; i++) {
            for (int j = 0; j < celulas[0].length; j++) {
                celulas[i][j] = false;
            }
        }
    }

    private boolean[][] copyArea() {
        boolean[][] areaCopy = new boolean[rowsNumber][colsNumber];

        for (int row = 0; row < rowsNumber; row++) {
            for (int col = 0; col < colsNumber; col++) {
                if (row == 0 || row == rowsNumber - 1 || col == 0 || col == colsNumber - 1) {
                    areaCopy[row][col] = false;
                } else {
                    areaCopy[row][col] = celulas[row-1][col-1];
                }
            }
        }
        return areaCopy;
    }
}
