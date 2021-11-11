/**
 * Paquete donde se encuentra la clase.
 */
package co.edu.unbosque.view;

import java.util.Scanner;

/**
 * Clase de Vista, donde podremos realizar los métodos para escritutra e
 * impresión de datos.
 * 
 * @authors Santiago Porras Sepúlveda, Juan Felipe Rojas Rodríguez
 *
 */
public class Vista {
	/**
	 * sc de tipo Scanner, donde inicializamos la clase para la escritura.
	 */
	Scanner sc = new Scanner(System.in);

	/**
	 * Constructor vacío para llamar los métodos de la clase.
	 */
	public Vista() {

	}

	/**
	 * Método para escribir lo que el usuario necesite.
	 * 
	 * @param mensaje de tipo String para mostrar el mensaje antes de la escritura.
	 *                mensaje != null.
	 * @return la variable escrito que es lo escrito por el usuario.
	 */
	public String escritura(String mensaje) {
		System.out.println(mensaje);
		String escrito = sc.nextLine();
		return escrito;
	}

	/**
	 * Método de tipo void para imprimir el mensaje generado.
	 * 
	 * @param mensaje de tipo String para mostrar el mensaje antes de la escritura.
	 *                mensaje != null.
	 */
	public void mostrar(String mensaje) {
		System.out.println(mensaje);
	}

	/**
	 * Método para verificar si los datos ingresados por el usuario son solomante
	 * números que escrito el usuario.
	 * 
	 * @param pNumber es de tipo String y son los datos del usuario. pNumber !=
	 *                null.
	 * @return un valor booleano para verificar si son números ingresados o no.
	 */
	public boolean soloNumeros(String pNumber) {

		boolean ver = true;

		if (!pNumber.trim().matches("[0-9]")) {
			ver = false;
		}
		return ver;
	}

	/**
	 * Método que verifica y genera una excepción sobre, si el texto tiene números o
	 * no.
	 * 
	 * @param pNumber es de tipo String y son los datos del usuario. pNumber !=
	 *                null.
	 * @return un valor booleano para verificar si son números ingresados o no.
	 * @throws Exception
	 */
	public boolean exceptionNumber(String pNumber) throws Exception {
		boolean ver;

		if (soloNumeros(pNumber)) {
			ver = true;
		} else {
			throw new Exception("Error, solo escriba números");
		}
		return ver;
	}
}
