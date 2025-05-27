package imp;

import api.ConjuntoTDA;
import api.GrafoTDA;

public class GrafoMA implements GrafoTDA {

	int[][] mAdy;
	int[] etiquetas;
	int [] verticeIndice; //creamos una lista paralela a etiquetas
	int cantidad;
	int mx = 55;
	int mx_etiquetas = 500; //le damos un maximo a la lista
	
	@Override
	public void inicializarGrafo() {
		mAdy = new int[mx][mx];
		etiquetas = new int[mx];
		verticeIndice= new int[mx_etiquetas];

		cantidad = 0;

		//para marcar que no existe usamos -1
		for(int i=0;i<mx_etiquetas;i++){

			verticeIndice[i]=-1;

		}
	}

	@Override
	public void agregarVertice(int v) {
		etiquetas[cantidad] = v;
		verticeIndice[v]= cantidad; //guardamos el indice del vertice guardado
		for (int i = 0; i <= cantidad; i++) {
			mAdy[i][cantidad] = 0;
			mAdy[cantidad][i] = 0;
		}
		cantidad++;
	}

	@Override
	public void eliminarVertice(int v) {
		int inx = verticeIndice[v];
		cantidad--;

		//actualizar la lista
		etiquetas[inx] = etiquetas[cantidad];
		verticeIndice[etiquetas[cantidad]]=inx;
		verticeIndice[v]=-1;


		//reordenar la matriz

		for(int i=0; i<cantidad; i++){
			mAdy[inx][i]=mAdy[cantidad][i];
			mAdy[i][inx]=mAdy[i][cantidad];
		}

	}

	@Override
	public ConjuntoTDA vertices() {
		ConjuntoTDA v = new ConjuntoLD();
		v.inicializarConjunto();
		for (int i = 0; i < cantidad; i++)
			v.agregar(etiquetas[i]);
		return v;
	}

	@Override
	public void agregarArista(int origen, int destino, int peso) {
		int o = verticeIndice[origen];
		int d = verticeIndice[destino];
		mAdy[o][d] = peso;
	}

	@Override
	public void eliminarArista(int origen, int destino) {
		int o = verticeIndice[origen];
		int d = verticeIndice[destino];
		mAdy[o][d] = 0;
	}

	@Override
	public boolean existeArista(int origen, int destino) {
		int o = verticeIndice[origen];
		int d = verticeIndice[destino];
		return (mAdy[o][d] != 0);
	}

	@Override
	public int pesoArista(int origen, int destino) {
		int o = verticeIndice[origen];
		int d = verticeIndice[destino];
		return mAdy[o][d];
	}

}
