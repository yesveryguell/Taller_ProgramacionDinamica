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
}
