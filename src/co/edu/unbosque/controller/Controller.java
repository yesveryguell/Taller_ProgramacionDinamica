/**
 * Paquete donde se encuentra la clase.
 */
package co.edu.unbosque.controller;

import co.edu.unbosque.model.Algoritmos;
import co.edu.unbosque.view.Vista;

/**
 * Clase de Controller, donde unimos la vista con los m�todos que hay en el
 * modelo, en este caso los algoritmos a realizar.
 * 
 * @authors Santiago Porras Sep�lveda, Juan Felipe Rojas Rodr�guez
 *
 */
public class Controller {

	/**
	 * vista de tipo Vista.
	 */
	private Vista vista;
	/**
	 * algo de tipo Algoritmos.
	 */
	private Algoritmos algo;

	/**
	 * Constructor de la clase Controller en donde se inicializan las clases que
	 * tenemos como atributos.
	 */
	public Controller() {
		algo = new Algoritmos();
		vista = new Vista();

		ejecutar();
	}

	/**
	 * M�todo para ejecutar los m�todos que hay en el modelo con la vista.
	 */
	public void ejecutar() {

		int decision = 0;
		String dec = "";
		do {
			vista.mostrar("Bienvenido al programa de algoritmos de programaci�n din�mica, esocoja una opci�n: ");
			dec = vista.escritura("[1] Algoritmo Floyd\n[2] Problema del viajero\n[3] Multipliaci�n de matrices\n"
					+ "[4] Problema de asignaci�n de tareas\n[5] Coeficientes binomial\n" + "[6] Salir");
			try {
				if (vista.exceptionNumber(dec)) {
				}
			} catch (Exception e1) {
				vista.mostrar("Se�or Usuario, escriba bien los n�meros\n");

			}

			switch (dec) {
			case "1":
				String t = vista.escritura("Ingrese el tama�o de la matriz:\n");
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
					vista.mostrar("Se�or Usuario, escriba bien los n�meros\n");
				}

				break;

			case "2":

				String n1 = vista.escritura("Escriba el n�mero de las ciudades: ");
				try {
					if (vista.exceptionNumber(n1)) {
						int n = Integer.parseInt(n1);
						int[][] c = new int[n][n];
						int[] tour = new int[10];

						vista.mostrar("Escriba el costo de las ciudades: ");
						for (int i = 0; i < n; i++) {
							for (int j = 0; j < n; j++) {
								c[i][j] = Integer.parseInt(vista.escritura(""));
							}
						}
						for (int i = 0; i < n; i++) {
							tour[i] = i;
						}

						int result = algo.tspdp(c, tour, 1, n);

						vista.mostrar("El tour m�s optimo es: ");
						for (int i = 1; i <= n; i++) {

							System.out.print(tour[i] + " -> ");
						}

						vista.mostrar("1");

						vista.mostrar("El costo m�nimo es: " + result + "\n");
					}

				} catch (Exception e) {
					vista.mostrar("Se�or Usuario, escriba bien los n�meros\n");
				}

				break;

			case "3":

				String t3 = vista.escritura("Ingrese el tama�o del arreglo:");
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
					vista.mostrar("Se�or Usuario, escriba bien los n�meros\n");
				}

				break;

			case "4":

				String d = vista.escritura("Ingrese el n�mero de d�as:");
				try {
					if (vista.exceptionNumber(d)) {
						int dias = Integer.parseInt(d);
						int[] high = new int[dias];
						int[] low = new int[dias];
						vista.mostrar("Ingrese el n�mero m�ximo de trabajos:");
						for (int i = 0; i < high.length; i++) {
							high[i] = Integer.parseInt(vista.escritura(""));
						}

						vista.mostrar("Se han guardado el m�ximo de trabajos.\n");

						vista.mostrar("Ingrese el n�mero m�nimo de trabajos:");
						for (int j = 0; j < low.length; j++) {
							low[j] = Integer.parseInt(vista.escritura(""));
						}
						vista.mostrar("Se han guardado el m�nimo de trabajos.\n");

						int tareas = algo.maxTasks(high, low, dias);

						vista.mostrar("La cantidad de tareas asignadas son: " + tareas);
					}
				} catch (Exception e) {
					vista.mostrar("Se�or Usuario, escriba bien los n�meros\n");
				}

				break;

			case "5":

				String c1 = vista.escritura("Ingrese el tama�o para el coeficiente numero 1:");
				String c2 = vista.escritura("Ingrese el tama�o para el coeficiente numero 2:");

				try {
					if (vista.exceptionNumber(c1) && vista.exceptionNumber(c2)) {
						int n = Integer.parseInt(c1);
						int k = Integer.parseInt(c2);
						int resultado = algo.binomialCoeff(n, k);

						vista.mostrar("" + resultado);
					}
				} catch (Exception e) {
					vista.mostrar("Se�or Usuario, escriba bien los n�meros\n");
				}

				break;
			case "6":
				break;
			default:
				vista.mostrar("Decisi�n incorrecta");
			}

		} while (!dec.equals("6"));

	}
}
