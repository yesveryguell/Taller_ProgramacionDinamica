/**
 * Paquete donde se encuentra la clase.
 */
package co.edu.unbosque.model;

/**
 * Clase de Algoritmos, en esta clase están los diferentes métodos que se
 * pidieron para realizar el programa.
 * 
 * @authors Santiago Porras Sepúlveda, Juan Felipe Rojas Rodríguez
 *
 */
public class Algoritmos {
	/**
	 * variable estática INF de tipo int.
	 */
	private final static int INF = 9999;

	/**
	 * Constructor vacío de la clase Algoritmos, para hacer uso de los métodos que
	 * hay en la clase.
	 */
	public Algoritmos() {

	}

	/**
	 * Método de tipo int que aloja una matriz, este es el algortimo de Floyd, donde
	 * le pasan una matriz y un tamaño para esa matriz.
	 * 
	 * @param graph es de tipo int que aloja matriz. graph != 0.
	 * @param v     es el tamaño de la matriz de tipo entero. v != 0.
	 * @return una matriz con los valores generados dentro del método, con una
	 *         solución realizada.
	 */
	public int[][] floydWarshall(int graph[][], int v) {
		int matrix[][] = new int[v][v];
		int i, j, k;
		for (i = 0; i < v; i++) {
			for (j = 0; j < v; j++) {
				matrix[i][j] = graph[i][j];
			}
		}

		for (k = 0; k < v; k++) {
			for (i = 0; i < v; i++) {
				for (j = 0; j < v; j++) {
					if (matrix[i][k] + matrix[k][j] < matrix[i][j])
						matrix[i][j] = matrix[i][k] + matrix[k][j];
				}
			}
		}
		return matrix;
	}

	/**
	 * Método de tipo int, este es el algoritmo para la multiplicación de matrices,
	 * donde se pasan dos parámetros, un arreglo con los datos para realizar la
	 * multiplicación y la vaiable del tamaño.
	 * 
	 * @param p es de tipo entero que tiene un arreglo. p != 0.
	 * @param n es el tamaño del arregllo de tipo int. n != 0.
	 * @return El valor de la multiplicación que se realizó en las matrices.
	 */
	public int MatrixChainOrder(int p[], int n) {

		int m[][] = new int[n][n];

		for (int i = 1; i < n; i++) {
			m[i][i] = 0;
		}

		for (int L = 2; L < n; L++) {
			for (int i = 1; i < n - L + 1; i++) {
				int j = i + L - 1;
				if (j == n) {
					continue;
				}
				m[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++) {

					int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (q < m[i][j]) {
						m[i][j] = q;
					}
				}
			}
		}

		return m[1][n - 1];
	}

	/**
	 * Método de tipo int, este método es el algoritmo de asiganción de tareas que
	 * realiza los procedimientos con los parámetros que recibe, las tareas mayores
	 * y las menores, juento con ello el tamaño del arreglo.
	 * 
	 * @param high es de tipo int siendo un arreglo. high != 0.
	 * @param low  es de tipo int siendo un arreglo. low != 0.
	 * @param n    es el tamaño del arreglo para realizar el arreglo de la tarea. n
	 *             != 0.
	 * @return El valor total de las tareas realizadas.
	 */
	public int maxTasks(int[] high, int[] low, int n) {

		int[] task_dp = new int[n + 1];

		task_dp[0] = 0;

		task_dp[1] = high[0];

		for (int i = 2; i <= n; i++) {
			task_dp[i] = Math.max(high[i - 1] + task_dp[i - 2], low[i - 1] + task_dp[i - 1]);
		}
		return task_dp[n];
	}

	/**
	 * Método de tipo int, este es el algoritmo de coeficiente binomial, este pasa
	 * dos parámetros, los cuales son para la fórmula a realizar.
	 * 
	 * @param n es de tipo int que es el primer coeficiente.
	 * @param k es de tipo int que es el segundo coeficiente.
	 * @return El valor de la operación realizada.
	 */
	public int binomialCoeff(int n, int k) {
		int C[][] = new int[n + 1][k + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= min(i, k); j++) {
				if (j == 0 || j == i) {
					C[i][j] = 1;
				} else {
					C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
				}
			}
		}

		return C[n][k];
	}

	/**
	 * Método para obtener el mínimo número de dos valores.
	 * 
	 * @param a es de tipo int.
	 * @param b es de tipo int.
	 * @return El valor mínimo entre los dos números.
	 */
	public int min(int a, int b) {
		return (a < b) ? a : b;
	}

	/**
	 * Método de tipo int, este es el algoritmo del problema del viajero, eel cuál
	 * recibe la cantidad de ciudades, la cantidad de tour que se realiza, desde
	 * donde empieza y el tamaño que tendrá la matriz.
	 * 
	 * @param c matriz de tipo int el cuál será la cantidad de ciudades. c != 0.
	 * @param tour es un arreglo de tipo int.
	 * @param start es una variable de tipo int. start != 0.
	 * @param n es el tamaño del arreglo de tipo int. n != 0.
	 * @return El valor del cálculo realizado del viajero.
	 */
	public int tspdp(int c[][], int tour[], int start, int n) {

		int mintour[] = new int[10], temp[] = new int[10], mincost = 999, ccost, i, j, k;

		if (start == n - 1) {

			return (c[tour[n - 1]][tour[n]] + c[tour[n]][1]);

		}

		for (i = start + 1; i <= n; i++) {

			for (j = 1; j <= n; j++) {

				temp[j] = tour[j];
			}

			temp[start + 1] = tour[i];

			temp[i] = tour[start + 1];

			if ((c[tour[start]][tour[i]] + (ccost = tspdp(c, temp, start + 1, n))) < mincost) {

				mincost = c[tour[start]][tour[i]] + ccost;

				for (k = 1; k <= n; k++) {

					mintour[k] = temp[k];
				}

			}

		}

		for (i = 1; i <= n; i++) {

			tour[i] = mintour[i];
		}

		return mincost;

	}

}
