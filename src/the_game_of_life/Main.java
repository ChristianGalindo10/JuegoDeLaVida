package the_game_of_life;

public class Main {

	public static void main(String[] args) {
		TheGameOfLife vista = new TheGameOfLife();
		Modelo modelo = new Modelo(25,45);
		Controlador ctrl = new Controlador(vista,modelo);
		ctrl.iniciar();
	}
}
