package prin;

import api.ConjuntoTDA;
import api.GrafoTDA;
import imp.GrafoMA;

public class prin {

	public static int contarVertices(GrafoTDA g) {
		int cant = 0;
		int x;
		ConjuntoTDA c = g.vertices();
		while(!c.conjuntoVacío()) {
			x = c.elegir();
			c.sacar(x);
			cant++;
		}
		return cant;
	}
		
	public static void mostrarGrafo(GrafoTDA g) {
		String cadena = "";
		ConjuntoTDA v = g.vertices();
		int cantidad = contarVertices(g);
		int[] vertices = new int[cantidad];
		cadena = cadena + "    ";
		int inx = 0;
		while(!v.conjuntoVacío()) {
			int x = v.elegir();
			v.sacar(x);
			vertices[inx] = x;
			cadena = cadena + x + "   ";
			inx++;
		}
		System.out.println(cadena);
		for (int i = 0; i < cantidad; i++) {
			cadena = "";
			cadena = cadena + vertices[i] + "   ";
			for (int j = 0; j < cantidad; j++) 
				if(g.existeArista(vertices[i], vertices[j]))
					cadena = cadena + g.pesoArista(vertices[i], vertices[j]) + "   ";
				else
					cadena = cadena + "0   ";
			System.out.println(cadena);
		}
	}
	
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
		mostrarGrafo(a);
		a.eliminarVertice(1);
		mostrarGrafo(a);
	}

}
