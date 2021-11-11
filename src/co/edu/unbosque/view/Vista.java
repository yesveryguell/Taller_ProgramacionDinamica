/**
 * Paquete donde se encuentra la clase.
 */
package co.edu.unbosque.view;

import java.util.Scanner;

/**
 * Clase de Vista, donde podremos realizar los m�todos para escritutra e
 * impresi�n de datos.
 * 
 * @authors Santiago Porras Sep�lveda, Juan Felipe Rojas Rodr�guez
 *
 */
public class Vista {
	/**
	 * sc de tipo Scanner, donde inicializamos la clase para la escritura.
	 */
	Scanner sc = new Scanner(System.in);

	/**
	 * Constructor vac�o para llamar los m�todos de la clase.
	 */
	public Vista() {

	}

	/**
	 * M�todo para escribir lo que el usuario necesite.
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
	 * M�todo de tipo void para imprimir el mensaje generado.
	 * 
	 * @param mensaje de tipo String para mostrar el mensaje antes de la escritura.
	 *                mensaje != null.
	 */
	public void mostrar(String mensaje) {
		System.out.println(mensaje);
	}

	/**
	 * M�todo para verificar si los datos ingresados por el usuario son solomante
	 * n�meros que escrito el usuario.
	 * 
	 * @param pNumber es de tipo String y son los datos del usuario. pNumber !=
	 *                null.
	 * @return un valor booleano para verificar si son n�meros ingresados o no.
	 */
	public boolean soloNumeros(String pNumber) {

		boolean ver = true;

		if (!pNumber.trim().matches("[0-9]")) {
			ver = false;
		}
		return ver;
	}

	/**
	 * M�todo que verifica y genera una excepci�n sobre, si el texto tiene n�meros o
	 * no.
	 * 
	 * @param pNumber es de tipo String y son los datos del usuario. pNumber !=
	 *                null.
	 * @return un valor booleano para verificar si son n�meros ingresados o no.
	 * @throws Exception
	 */
	public boolean exceptionNumber(String pNumber) throws Exception {
		boolean ver;

		if (soloNumeros(pNumber)) {
			ver = true;
		} else {
			throw new Exception("Error, solo escriba n�meros");
		}
		return ver;
	}
}
