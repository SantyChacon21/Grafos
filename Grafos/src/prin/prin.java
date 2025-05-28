package prin;

import api.GrafoTDA;
import imp.GrafoMA;

public class prin {	
	public static void main(String[] args) {
		GrafoTDA a = new GrafoMA();
		a.inicializarGrafo();
		a.agregarVertice(3);
		a.agregarVertice(1);
		a.agregarVertice(5);
		a.agregarVertice(7);
		a.agregarArista(1, 3, 2);
		a.agregarArista(1, 5, 1);
		a.agregarArista(1, 7, 3);
		a.agregarArista(3, 1, 7);
		a.agregarArista(3, 7, 1);
		a.agregarArista(5, 1, 7);
		a.agregarArista(5, 7, 2);
		a.agregarArista(7, 1, 5);
		a.agregarArista(7, 3, 3);
	
		a.eliminarVertice(1);

		a.imprimirMatrizAdyacencia();

	}

}
