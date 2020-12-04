/**
 * The game of life
 *
 * @author Marc Oliveras Galvez <admin@oligalma.com> 
 * @link http://www.oligalma.com
 * @copyright 2017 Oligalma
 * @license GPL License v3
 */

package the_game_of_life;

public class Modelo
{
	// Attributes.
	private boolean[][] area;
	private int rowsNumber, colsNumber;

	// Constructor.
	public Modelo(int rowsNumber, int colsNumber) {
		this.rowsNumber = rowsNumber;
		this.colsNumber = colsNumber;
		this.area = new boolean[rowsNumber][colsNumber];
	}

	// Method to calculate next generations
	public void nextGen() {
		int cell = 0, row, col;

		// Copy area matrix.
		boolean[][] areaCopy = this.copyArea();

		for (row = 0; row < rowsNumber; row++) {
			for (col = 0; col < colsNumber; col++) {
				if (row == 0 && col == 0) {
					if (areaCopy[row][col + 1])
						cell++;
					if (areaCopy[row + 1][col])
						cell++;
					if (areaCopy[row + 1][col + 1])
						cell++;
				} else if (row == 0 && col == colsNumber - 1) {
					if (areaCopy[row][col - 1])
						cell++;
					if (areaCopy[row + 1][col - 1])
						cell++;
					if (areaCopy[row + 1][col])
						cell++;
				} else if (row == rowsNumber - 1 && col == 0) {
					if (areaCopy[row - 1][col])
						cell++;
					if (areaCopy[row - 1][col + 1])
						cell++;
					if (areaCopy[row][col + 1])
						cell++;
				} else if (row == rowsNumber - 1 && col == colsNumber - 1) {
					if (areaCopy[row - 1][col - 1])
						cell++;
					if (areaCopy[row - 1][col])
						cell++;
					if (areaCopy[row][col - 1])
						cell++;
				} else if (row == 0 && col != colsNumber - 1 && col != 0) {
					if (areaCopy[row][col - 1])
						cell++;
					if (areaCopy[row][col + 1])
						cell++;
					if (areaCopy[row + 1][col - 1])
						cell++;
					if (areaCopy[row + 1][col])
						cell++;
					if (areaCopy[row + 1][col + 1])
						cell++;
				} else if (row == rowsNumber - 1 && col != colsNumber - 1 && col != 0) {
					if (areaCopy[row - 1][col - 1])
						cell++;
					if (areaCopy[row - 1][col])
						cell++;
					if (areaCopy[row - 1][col + 1])
						cell++;
					if (areaCopy[row][col - 1])
						cell++;
					if (areaCopy[row][col + 1])
						cell++;
				} else if (row != rowsNumber - 1 && row != 0 && col == 0) {
					if (areaCopy[row - 1][col])
						cell++;
					if (areaCopy[row - 1][col + 1])
						cell++;
					if (areaCopy[row][col + 1])
						cell++;
					if (areaCopy[row + 1][col])
						cell++;
					if (areaCopy[row + 1][col + 1])
						cell++;
				} else if (row != rowsNumber - 1 && row != 0 && col == colsNumber - 1) {
					if (areaCopy[row - 1][col - 1])
						cell++;
					if (areaCopy[row - 1][col])
						cell++;
					if (areaCopy[row][col - 1])
						cell++;
					if (areaCopy[row + 1][col - 1])
						cell++;
					if (areaCopy[row + 1][col])
						cell++;
				} else { 
					if (areaCopy[row - 1][col - 1])
						cell++;
					if (areaCopy[row - 1][col])
						cell++;
					if (areaCopy[row - 1][col + 1])
						cell++;
					if (areaCopy[row][col - 1])
						cell++;
					if (areaCopy[row][col + 1])
						cell++;
					if (areaCopy[row + 1][col - 1])
						cell++;
					if (areaCopy[row + 1][col])
						cell++;
					if (areaCopy[row + 1][col + 1])
						cell++;
				}
				if (areaCopy[row][col]) {
					if (cell == 0 || cell == 1 || cell >= 4)
						area[row][col] = false;
				} else {
					if (cell == 3)
						area[row][col] = true;
				}
				cell = 0;
			}
		}
	}


	public boolean[][] getArea()
	{
		return area;
	}
	
	public void setArea(boolean[][] area)
	{
		this.area = area;
	}

	public void clearArea()
	{
		for (int i = 0; i < area.length; i++)
			for (int j = 0; j < area[0].length; j++)
				area[i][j] = false;	
	}
	
	private boolean[][] copyArea()
	{
		boolean[][] areaCopy = new boolean[rowsNumber][colsNumber];
		
		for (int row = 0; row < rowsNumber; row++)
			for (int col = 0; col < colsNumber; col++)
				areaCopy[row][col] = area[row][col];
		
		return areaCopy;
	}
	
}
