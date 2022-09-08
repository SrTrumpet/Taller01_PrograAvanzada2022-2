import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException {
		App app = new App();
		Menu menu = new Menu();

		app.ejecutor(app, menu);
		menu.mostrarDatosPrueba();

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
