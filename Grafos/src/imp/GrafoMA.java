package imp;

import api.GrafoTDA;

public class GrafoMA implements GrafoTDA {

	int[][] mAdy;
	int[] etiquetas;
	int [] verticeIndice; //creamos una lista paralela a etiquetas
	int cantidad;
	int mx = 55;
	
	@Override
	public void inicializarGrafo() { // O(n)
		mAdy = new int[mx][mx];
		etiquetas = new int[mx];
		verticeIndice= new int[mx];

		cantidad = 0;

		for(int i=0;i<mx;i++){
			mAdy[i][cantidad] = 0;
			mAdy[cantidad][i] = 0;
			verticeIndice[i]=-1;

		}
	}

	@Override
	public void agregarVertice(int v) {// O(cte)
		etiquetas[cantidad] = v;
		verticeIndice[v]= cantidad; 
		cantidad++;
	}

	@Override
	public void eliminarVertice(int v) { // O(n)
		int inx = verticeIndice[v];
		cantidad--;

		etiquetas[inx] = etiquetas[cantidad];
		verticeIndice[etiquetas[cantidad]]=inx;
		verticeIndice[v]=-1;


		for(int i=0; i<cantidad; i++){
			mAdy[inx][i]=mAdy[cantidad][i];
			mAdy[i][inx]=mAdy[i][cantidad];
		}

	}


	@Override
	public void agregarArista(int origen, int destino, int peso) { // O(cte)
		int o = verticeIndice[origen];
		int d = verticeIndice[destino];
		mAdy[o][d] = peso;
	}

	@Override
	public void eliminarArista(int origen, int destino) { // O(cte)
		int o = verticeIndice[origen];
		int d = verticeIndice[destino];
		mAdy[o][d] = 0;
	}

	@Override
	public boolean existeArista(int origen, int destino) { // O(cte)
		int o = verticeIndice[origen];
		int d = verticeIndice[destino];
		return (mAdy[o][d] != 0);
	}

	@Override
	public int pesoArista(int origen, int destino) { // O(cte)
		int o = verticeIndice[origen];
		int d = verticeIndice[destino];
		return mAdy[o][d];
	}

	//funcion de prueba para imprimir matriz
	public void imprimirMatrizAdyacencia() { // O(n**2)
    System.out.print("     ");
		for (int i = 0; i < cantidad; i++) {
			System.out.printf("%4d", etiquetas[i]);
		}
		System.out.println();
		System.out.println("    " + "----".repeat(cantidad));

		for (int i = 0; i < cantidad; i++) {
			System.out.printf("%4d|", etiquetas[i]);
			for (int j = 0; j < cantidad; j++) {
				if (mAdy[i][j] == 0) {
					System.out.print("   -");
				} else {
					System.out.printf("%4d", mAdy[i][j]);
				}
			}
			System.out.println();
		}
}



}
