import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class GuardarTxt {

	private File archExtra = new File("x.txt");
	private File archHuman = new File("h.txt");
	private Traductor traductor = new Traductor();

	public void guardarArch(String[] registro, String[] registroHumano) throws IOException {

		GuardarTxt admin = new GuardarTxt();

		String rutaArchExtra = archExtra.getAbsolutePath();
		String rutaArchHumano = archHuman.getAbsolutePath();

		registro = admin.cambioDatos(registro);
		registroHumano = admin.cambioDatosHumanos(registroHumano);

		// Guarda archivo de extraterrestres
		FileWriter nuevoArchExtre = new FileWriter(rutaArchExtra);

		int ultimaLinea = registro.length - 1;

		for (int i = 0; i < registro.length; i++) {
			if (ultimaLinea == i) {
				nuevoArchExtre.write(registro[i]);
			} else {
				nuevoArchExtre.write(registro[i] + "\n");
			}
		}

		nuevoArchExtre.close();

		// Guardar Humanos
		FileWriter nuevoArchHumano = new FileWriter(rutaArchHumano);

		ultimaLinea = registroHumano.length - 1;

		for (int i = 0; i < registroHumano.length; i++) {
			if (ultimaLinea == i) {
				nuevoArchHumano.write(registroHumano[i]);
			} else {
				nuevoArchHumano.write(registroHumano[i] + "\n");
			}
		}
		nuevoArchHumano.close();

	}

	/***
	 * Cambio de datos para los registros de extraterrestre
	 * 
	 * @param registro
	 * @return
	 */
	private String[] cambioDatos(String[] registro) {

		String[] nuevosDatos = registro;

		for (int i = 0; i < nuevosDatos.length; i++) {
			String linea = nuevosDatos[i];
			linea = traductor.rebertirMedidas(linea);
			nuevosDatos[i] = linea;
		}
		return nuevosDatos;

	}

	/***
	 * 
	 */
	private String[] cambioDatosHumanos(String[] registro) {

		String[] nuevosDatos = registro;

		for (int i = 0; i < nuevosDatos.length; i++) {
			String linea = nuevosDatos[i];
			linea = traductor.rebertirMedidasHumanas(linea);
			nuevosDatos[i] = linea;
		}
		return nuevosDatos;

	}

}
