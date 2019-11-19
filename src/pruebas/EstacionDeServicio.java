package pruebas;

import java.util.Scanner;

public class EstacionDeServicio {

	public static void main(String[] args) {

		int combustibles = 3; // cuantos tipos de combustible hay?
		int estaciones = 3;
		float matriz[][] = new float[combustibles][estaciones];
		float litros;
		int tipo;
		float total = 0; // variable temporal
		int estacion;
		int i;
		int j;
		float totalxEst[] = new float[estaciones];
		float totalxTipo[] = new float[combustibles];
		float mayor = 0;
		String masVendida;

		for (i = 0; i < 3; i++) {
			totalxEst[i] = 0;
		}

		for (i = 0; i < 3; i++) {
			totalxTipo[i] = 0;
		}

		for (i = 0; i < 3; i++) { // recorre de izq a der
			for (j = 0; j < 3; j++) { // esto inicializa todos los valores de la matriz
				matriz[i][j] = 0;
			}
		}

		Scanner scan = new Scanner(System.in);
		System.out.println("VENTA DE NAFTA:");
		System.out.println("===============");
		System.out.println("Cantidad de litros: ");
		System.out.println("(0 = finalizar programa)");
		litros = scan.nextFloat();
		while (litros != 0) {

			System.out.println("Ingrese el número del tipo de nafta:");
			System.out.println("0 = Nafta Super, 1 = Nafta Premium, 2 = gasoil");
			tipo = scan.nextInt();
			switch (tipo) {
			case 0:
				total = litros * 20;
				break;

			case 1:
				total = litros * 40;
				break;

			case 2:
				total = litros * 10;
				break;
			}
			totalxTipo[tipo] += total;

			System.out.println("Ingrese el nro de estación:");
			System.out.println("(0 = Estación A, 1 = Estación B, 2 = Estación C)");
			estacion = scan.nextInt();
			totalxEst[estacion] += total;
			System.out.println("Cantidad de litros: ");
			System.out.println("(0 = finalizar programa)");
			litros = scan.nextFloat();

		}

		for (i = 0; i < 3; i++) {
			for (j = 1; j < 3; j++) {
				if (totalxTipo[i] > totalxTipo[j]) {
					mayor = totalxTipo[i];
				}
				mayor = totalxTipo[j];
			}
		}

		// hay alguna forma mas eficiente de unir la posicion del array con el tipo
		// de nafta? un switch case serviria pero no se puede hacer switch con var float
		// si fuera un array mas grande?

		if (mayor == totalxTipo[0]) {
			masVendida = "Super";
		} else if (mayor == totalxTipo[1]) {
			masVendida = "Premium";
		} else {
			masVendida = "gasoil";
		}

		System.out.println("Total vendido por estación:");
		System.out.println("Estación A: " + totalxEst[0]);
		System.out.println("Estación B: " + totalxEst[1]);
		System.out.println("Estación C: " + totalxEst[2]);

		System.out.println("La nafta más vendida es: " + masVendida);

		scan.close();
	}
}
