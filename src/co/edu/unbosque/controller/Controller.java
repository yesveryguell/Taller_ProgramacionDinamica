package co.edu.unbosque.controller;

import co.edu.unbosque.model.Algoritmos;
import co.edu.unbosque.view.Vista;

public class Controller {

	private Vista vista;
	private Algoritmos algo;

	public Controller() {
		algo = new Algoritmos();
		vista = new Vista();

		ejecutar();
	}

	public void ejecutar() {

		vista.mostrar("Bienvenido al programa de algoritmos de programación dinámica, esocoja una opción: ");
		String dec = vista.escritura("[1] Algoritmo Floyd\n[2] Problema del viajero\n[3] Multipliación de matrices\n"
				+ "[4] Problema de asignación de tareas\n[5] Coeficientes binomial\n");

		int decision = Integer.parseInt(dec);

		switch (decision) {
		case 1:
			int tamanio = Integer.parseInt(vista.escritura("Ingrese el tamaño de la matriz:\n"));
			int[][] matriz = new int[tamanio][tamanio];
			int[][] m = new int[tamanio][tamanio];
			int inf = 9999;

			vista.mostrar("Ingrese los datos:");
			for (int i = 0; i < tamanio; i++) {
				for (int j = 0; j < tamanio; j++) {
					matriz[i][j] = Integer.parseInt(vista.escritura(""));
				}
			}

			m = algo.floydWarshall(matriz, tamanio);

			for (int i = 0; i < tamanio; i++) {
				for (int j = 0; j < tamanio; j++) {
					if (m[i][j] == 99)
						System.out.print("INF ");
					else
						System.out.print(m[i][j] + " ");
				}
				System.out.println("\n");
			}

			break;

		case 2:
			break;

		case 3:

			int tamanio3 = Integer.parseInt(vista.escritura("Ingrese el tamaño del arreglo:"));
			int[] arreglo = new int[tamanio3];

			vista.mostrar("Ingrese los datos:");
			for (int i = 0; i < tamanio3; i++) {
				arreglo[i] = Integer.parseInt(vista.escritura(""));
			}
			int prueba = algo.MatrixChainOrder(arreglo, tamanio3);
			vista.mostrar("" + prueba);

			break;

		case 4:

			int dias = Integer.parseInt(vista.escritura("Ingrese el número de días:"));
			int[] high = new int[dias];
			int[] low = new int[dias];
			vista.mostrar("Ingrese el número highs:");
			for (int i = 0; i < high.length; i++) {
				high[i] = Integer.parseInt(vista.escritura(""));
			}

			vista.mostrar("Finalizó el highs");

			vista.mostrar("Ingrese el número lows:");
			for (int j = 0; j < low.length; j++) {
				low[j] = Integer.parseInt(vista.escritura(""));
			}
			vista.mostrar("Finalizó el highs");

			int tareas = algo.maxTasks(high, low, dias);

			vista.mostrar("" + tareas);

			break;

		case 5:

			int n = Integer.parseInt(vista.escritura("Ingrese el tamaño para el coeficiente numero 1:"));
			int k = Integer.parseInt(vista.escritura("Ingrese el tamaño para el coeficiente numero 2:"));

			int resultado = algo.binomialCoeff(n, k);

			vista.mostrar("" + resultado);

			break;

		}
	}
}
