import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args) throws IOException {
		App app = new App();
		Menu menu = new Menu();
		
		app.ejecutor(app,menu);
		menu.mostrarDatosPrueba();
		
		
	}
	
	
	public void ejecutor(App app,Menu menu) throws IOException {
		Traductor traductor = new Traductor();
		app.leerArchivos(traductor,menu);
		
		
		
	}
	
	public void leerArchivos(Traductor traductor,Menu menu) throws IOException {

		int totalDatos = 0;
		Scanner contador = new Scanner(new File("x.txt"));
		while(contador.hasNextLine()){
			String linea = contador.nextLine();
			totalDatos++;
		}
		
		menu.inicializarRegistro(totalDatos);
		
		Scanner leerArchExtraterrestre = new Scanner(new File("x.txt"));
		while(leerArchExtraterrestre.hasNextLine()) {
			String linea = leerArchExtraterrestre.nextLine();
			menu.crearRegistro(linea);
		}
		
		Scanner leerHumano = new Scanner(new File("h.txt"));
		while(leerHumano.hasNextLine()) {
			String linea = leerHumano.nextLine();
		}
		
	}
	
	

}
