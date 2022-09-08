import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException {
		App app = new App();
		Menu menu = new Menu();
		Scanner leer = new Scanner(System.in);

		app.ejecutor(app, menu);
		menu.mostrarDatosPrueba();
		System.out.println("##################");
		app.menuInicio(leer,menu);

	}

	/***
	 * Administra los pasos a seguir para transformar los datos de un archivo .txt a
	 * un arreglo de String
	 * 
	 * @param app
	 * @param menu
	 * @throws IOException
	 */
	public void ejecutor(App app, Menu menu) throws IOException {
		Traductor traductor = new Traductor();
		app.leerArchivos(traductor, menu);

	}

	public void menuInicio(Scanner leer, Menu menu) {

		int opcion = -1;
		while (opcion != 12) {
			System.out.println("""
					1: Ingresar extraterrestre
					2: Modificar un extraterrestre
					3: Ingresar humano
					4: Modificar un humano
					5: Mostrar por nacionalidad
					6: Eliminar extraterrestre
					7: Eliminar humano
					8: Buscar por identificación universal
					9: Mostrar por planeta
					10: Mostrar por nacionalidad
					11: Mostrar tabla con la cantidad de extraterrestres
					12: Salir
					""");
			System.out.println("Ingrese una opcion: ");
			opcion = Integer.parseInt(leer.nextLine());
			
			switch (opcion) {
			case 1: {
				System.out.println("Ingrese Nombre de especie: ");
				String especie = leer.nextLine();
				System.out.println("Ingrese nombre del extraterrestre: ");
				String nombre = leer.nextLine();
				System.out.println("Ingrese identificacion universal: ");
				String iUniversal = leer.nextLine().toUpperCase();
				System.out.println("Ingrese planeta de origen: ");
				String planeta = leer.nextLine();
				System.out.println("Ingrese edad: ");
				String edad = leer.nextLine();
				System.out.println("Ingrese altura: ");
				String altura = leer.nextLine();
				System.out.println("Ingrese peso: ");
				String peso = leer.nextLine();
				System.out.println("Ingrese tipo: ");
				String tipo = leer.nextLine().toUpperCase();
				
				menu.ingresarExtraterrestre(especie, nombre, iUniversal, planeta, edad, altura, peso, tipo);
				menu.mostrarDatosPrueba();
				break;
			}
			case 2: {

				break;
			}
			case 3: {

				break;
			}
			case 4: {

				break;
			}
			
			
			default:
				throw new IllegalArgumentException("Valor ingresado no permitido:  " + opcion);
			}
		}

	}

	public void leerArchivos(Traductor traductor, Menu menu) throws IOException {

		int totalDatos = 0;
		Scanner contador = new Scanner(new File("x.txt"));
		while (contador.hasNextLine()) {
			String linea = contador.nextLine();
			totalDatos++;
		}

		menu.inicializarRegistro(totalDatos, 0);

		Scanner leerArchExtraterrestre = new Scanner(new File("x.txt"));
		while (leerArchExtraterrestre.hasNextLine()) {
			String linea = leerArchExtraterrestre.nextLine();
			menu.crearRegistro(linea, 0);
		}

		int totalDatosHumano = 0;
		Scanner contadorHumano = new Scanner(new File("h.txt"));
		while (contadorHumano.hasNextLine()) {
			String linea = contadorHumano.nextLine();
			totalDatosHumano++;
		}

		menu.inicializarRegistro(totalDatosHumano, 1);

		Scanner leerHumano = new Scanner(new File("h.txt"));
		while (leerHumano.hasNextLine()) {
			String linea = leerHumano.nextLine();
			menu.crearRegistro(linea, 1);
		}

	}

}
