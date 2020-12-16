package Main;

import Controlador.Naturaleza;
import Interfaces.Interfaz_Iniciar;
import Modelo.Vivarium;
import Vista.TheGameOfLife;

public class Vida implements Interfaz_Iniciar{

	public static void main(String[] args) {
		Vida main = new Vida();
                main.iniciar();
	}

    @Override
    public void iniciar() {
                TheGameOfLife vista = new TheGameOfLife();
		Vivarium modelo = new Vivarium(25,45);
		Naturaleza ctrl = new Naturaleza(vista,modelo);
		ctrl.iniciar();
    }
}
