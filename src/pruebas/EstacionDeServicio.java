package pruebas;

import java.util.Scanner;

public class EstacionDeServicio {

	public static void main(String[] args) { //se podr�an crear vectores String para tipo de comb y nombredeestacion
		

		int combustibles = 3; // cuantos tipos de combustible hay?
		int estaciones = 3;
		float matriz[][] = new float[combustibles][estaciones];
		float litros;
		int tipo;
		float total = 0; // variable temporal
		int estacion;
		int i;
		int j;
		float totalxEst[] = new float[estaciones]; // o, = { 0, 0, 0 };
		float totalxTipo[] = new float[combustibles];
		float mayor = 0;
		float masVendida;
		int indiceMasVendido = 0;
		String nombresEst[] = {"Estacion A", "Estacion B", "Estacion C"}; //usar para mostrar totales, falta por hacer
		String naftas[] = {"Nafta Super", "Nafta Premium", "Gasoil"};

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

			System.out.println("Ingrese el n�mero del tipo de nafta:");
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

			System.out.println("Ingrese el nro de estaci�n:");
			System.out.println("(0 = Estaci�n A, 1 = Estaci�n B, 2 = Estaci�n C)");
			estacion = scan.nextInt();
			
			matriz[tipo][estacion] += total;
			totalxTipo[tipo] += total;
			totalxEst[estacion] += total;
			
			System.out.println("Cantidad de litros: ");
			System.out.println("(0 = finalizar programa)");
			litros = scan.nextFloat();

		}

		for (i = 0; i < totalxTipo.length; i++) {
				if ( totalxTipo[i] > mayor ) {
					mayor = totalxTipo[i];
					indiceMasVendido = i;
			}

		masVendida = totalxTipo[indiceMasVendido];

		System.out.println("Total vendido por estaci�n:");
		System.out.println("Estaci�n A: " + totalxEst[0]);
		System.out.println("Estaci�n B: " + totalxEst[1]);
		System.out.println("Estaci�n C: " + totalxEst[2]+'\n');

		System.out.println("La nafta m�s vendida es: " + naftas[indiceMasVendido] + ": " + masVendida);

		scan.close();
	}
}
}
