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

		int decision = 0;

		do {
			vista.mostrar("Bienvenido al programa de algoritmos de programación dinámica, esocoja una opción: ");
			String dec = vista
					.escritura("[1] Algoritmo Floyd\n[2] Problema del viajero\n[3] Multipliación de matrices\n"
							+ "[4] Problema de asignación de tareas\n[5] Coeficientes binomial\n" + "[6] Salir");
			try {
				if (vista.exceptionNumber(dec)) {
					decision = Integer.parseInt(dec);
				}

				switch (decision) {
				case 1:
					String t = vista.escritura("Ingrese el tamaño de la matriz:\n");
					try {
						if (vista.exceptionNumber(t)) {
							int tamanio = Integer.parseInt(t);
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

						}
					} catch (Exception e1) {
						vista.mostrar("Señor Usuario, escriba bien los números\n");
					}

					break;

				case 2:
					break;

				case 3:

					String t3 = vista.escritura("Ingrese el tamaño del arreglo:");
					try {
						if (vista.exceptionNumber(t3)) {
							int tamanio3 = Integer.parseInt(t3);
							int[] arreglo = new int[tamanio3];

							vista.mostrar("Ingrese los datos:");
							for (int i = 0; i < tamanio3; i++) {
								arreglo[i] = Integer.parseInt(vista.escritura(""));
							}
							int prueba = algo.MatrixChainOrder(arreglo, tamanio3);
							vista.mostrar("" + prueba);

						}
					} catch (Exception e) {
						vista.mostrar("Señor Usuario, escriba bien los números\n");
					}

					break;

				case 4:

					String d = vista.escritura("Ingrese el número de días:");
					try {
						if (vista.exceptionNumber(d)) {
							int dias = Integer.parseInt(d);
							int[] high = new int[dias];
							int[] low = new int[dias];
							vista.mostrar("Ingrese el número máximo de trabajos:");
							for (int i = 0; i < high.length; i++) {
								high[i] = Integer.parseInt(vista.escritura(""));
							}

							vista.mostrar("Se han guardado el máximo de trabajos.\n");

							vista.mostrar("Ingrese el número mínimo de trabajos:");
							for (int j = 0; j < low.length; j++) {
								low[j] = Integer.parseInt(vista.escritura(""));
							}
							vista.mostrar("Se han guardado el mínimo de trabajos.\n");

							int tareas = algo.maxTasks(high, low, dias);

							vista.mostrar("La cantidad de tareas asignadas son: " + tareas);
						}
					} catch (Exception e) {
						vista.mostrar("Señor Usuario, escriba bien los números\n");
					}

					break;

				case 5:

					String c1 = vista.escritura("Ingrese el tamaño para el coeficiente numero 1:");
					String c2 = vista.escritura("Ingrese el tamaño para el coeficiente numero 2:");

					try {
						if (vista.exceptionNumber(c1) && vista.exceptionNumber(c2)) {
							int n = Integer.parseInt(c1);
							int k = Integer.parseInt(c2);
							int resultado = algo.binomialCoeff(n, k);

							vista.mostrar("" + resultado);
						}
					} catch (Exception e) {
						vista.mostrar("Señor Usuario, escriba bien los números\n");
					}

					break;
				case 6:
					System.exit(0);
					break;

				}
			} catch (Exception e1) {
				vista.mostrar("Señor Usuario, escriba bien los números\n");
			}

		} while (decision != 6);

	}
}
