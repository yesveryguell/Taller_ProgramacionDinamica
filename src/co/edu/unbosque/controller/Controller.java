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
			int[][] matriz2 = new int[tamanio][tamanio];
			int inf=9999;

			vista.mostrar("Ingrese los datos:\n");
			for (int i = 0; i < tamanio; i++) {
				for (int j = 0; j < tamanio; j++) {
					matriz[i][j] = Integer.parseInt(vista.escritura(""));
				}
			}
			
			matriz2 = algo.floydWarshall(matriz, tamanio);

			for (int i = 0; i < tamanio; i++) {
				for (int j = 0; j < tamanio; j++) {
					 if (matriz2[i][j] == 99)
				          System.out.print("INF ");
				        else
					System.out.print(matriz2[i][j]+" ");
				}
			    System.out.println("\n");
			}

			break;

		case 2:
			break;

		case 3:
			break;

		case 4:
			break;

		case 5:
			break;

		}
	}
}
