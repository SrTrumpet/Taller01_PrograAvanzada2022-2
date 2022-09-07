import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args) throws IOException {
		App app = new App();
		app.ejecutor(app);
		
		
	}
	
	
	public void ejecutor(App app) throws IOException {
		Traductor traductor = new Traductor();
		app.leerArchivoExtraterrestre(traductor);
		
		
		
	}
	
	public void leerArchivoExtraterrestre(Traductor traductor) throws IOException {
		
		Scanner leerArchExtraterrestre = new Scanner(new File("x.txt"));
		while(leerArchExtraterrestre.hasNextLine()) {
			String linea = leerArchExtraterrestre.nextLine();
			
		}
		
		Scanner leerHumano = new Scanner(new File("h.txt"));
		while(leerHumano.hasNextLine()) {
			String linea = leerHumano.nextLine();
		}
		
	}
	
	

}
