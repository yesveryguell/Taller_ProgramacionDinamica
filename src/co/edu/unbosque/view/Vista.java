package co.edu.unbosque.view;

import java.util.Scanner;

public class Vista {
	Scanner sc = new Scanner(System.in);

	public Vista() {

	}

	public String escritura(String mensaje) {
		System.out.println(mensaje);
		String escrito = sc.nextLine();
		return escrito;
	}

	public void mostrar(String mensaje) {
		System.out.println(mensaje);
	}

	public boolean soloNumeros(String pNumber) {

		boolean ver = true;

		if (!pNumber.trim().matches("[0-9]")) {
			ver = false;
		}
		return ver;
	}

	public boolean exceptionNumber(String pNumber) throws Exception {
		boolean ver;

		if (soloNumeros(pNumber)) {
			ver = true;
		} else {
			throw new Exception("Age not valid, try again (age cannot be greater than 100)");
		}
		return ver;
	}
}
