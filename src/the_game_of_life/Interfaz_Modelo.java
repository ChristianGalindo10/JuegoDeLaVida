
package the_game_of_life;

public interface Interfaz_Modelo {
    
    public void nextGen();

    public boolean[][] getArea();

    public void setArea(boolean[][] area);

    public void clearArea();

    public boolean[][] copyArea();

}
