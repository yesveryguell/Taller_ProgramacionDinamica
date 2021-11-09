package co.edu.unbosque.model;

public class Algoritmos {

	private final static int INF = 9999;

	public Algoritmos() {

	}

	// Coeficiente binomial
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

	public int min(int a, int b) {
		return (a < b) ? a : b;
	}

	// Multiplicación de matrices
	static int MatrixChainOrder(int p[], int n) {

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
	
	//Algoritmo de Floyd
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

}
