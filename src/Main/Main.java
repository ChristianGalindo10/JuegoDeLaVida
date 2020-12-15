package Main;

import Controlador.Controlador;
import Interfaces.Interfaz_Iniciar;
import Modelo.Modelo;
import Vista.TheGameOfLife;

public class Main implements Interfaz_Iniciar{

	public static void main(String[] args) {
		Main main = new Main();
                main.iniciar();
	}

    @Override
    public void iniciar() {
        TheGameOfLife vista = new TheGameOfLife();
		Modelo modelo = new Modelo(25,45);
		Controlador ctrl = new Controlador(vista,modelo);
		ctrl.iniciar();
    }
}
