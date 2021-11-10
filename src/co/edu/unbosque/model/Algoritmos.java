package co.edu.unbosque.model;

public class Algoritmos {

	private final static int INF = 9999;

	public Algoritmos() {

	}

	// Algoritmo de Floyd
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

	// Multiplicación de matrices
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

	// Asignación de tareas
	public int maxTasks(int[] high, int[] low, int n) {

		int[] task_dp = new int[n + 1];

		task_dp[0] = 0;

		task_dp[1] = high[0];

		for (int i = 2; i <= n; i++) {
			task_dp[i] = Math.max(high[i - 1] + task_dp[i - 2], low[i - 1] + task_dp[i - 1]);
		}
		return task_dp[n];
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
	
	//Viajero
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
