import java.util.Arrays;

public class Menu {
	
	private Traductor traductor = new Traductor();
	private String[] registro; 
	private int add = 0;
	
	
	public void inicializarRegistro(int cantidad) {
		int maxRegistro = 0;
		if(cantidad == 0) {
			maxRegistro = 1;
		}else {
			maxRegistro = cantidad;
		}
		this.registro = new String[maxRegistro];
	}
	
	public void crearRegistro(String linea) {
		String registroString = traductor.traductorExtraterrestreHumano(linea);
		registro[add] = registroString;
		add++;
		

	}

	/***
	 * Da la opcion de ingresar a un nuevo extraterrestre por consola
	 * 
	 */
	public void ingresarExtraterrestre() {

	}

	/***
	 * Modifica los datos de un extraterrestre
	 * 
	 * @pre El extraterrestre ya debe estar registrado con anterioridad
	 */
	public void modificarExtraterrestre() {

	}

	/***
	 * Da la opcion de ingresar a un nuevo humano por consola
	 */
	public void ingresarHumano() {

	}

	/***
	 * Modifica los datos de un humano
	 * 
	 * @pre El humano ya debe estar registrado con anterioridad
	 */
	public void modificarHumano() {

	}

	/***
	 * Muestra por consola los humanos que perteneces a la nacionalidad ingresada
	 * 
	 * @param nacionalidad
	 * 
	 * @pre La nacionalidad debe de existir
	 */
	public void mostrarPorNacionalidad(String nacionalidad) {

	}

	/***
	 * Al ingresar la "Identificacion universar" se busca al extraterrestre y se
	 * elimina
	 * 
	 * @param iUniversar
	 * 
	 * @pre El extraterrestre debe existir en los registros
	 * @post Se elimina el extraterrestre de los registros y sino se encuentra al
	 *       extraterrestre los registros no cambian
	 */
	public void eliminarExtraterrestre() {

	}

	/***
	 * /*** Al ingresar la "Identificacion universar" se busca al humano y se
	 * elimina
	 * 
	 * @param iUniversal
	 * 
	 * @pre El humano debe existir en los registros
	 * @post Se elimina el humano de los registros y sino se encuentra al humano los
	 *       registros no cambian
	 */
	public void eliminarHumano() {

	}

	/***
	 * Recibe el "Identificador Universar" y muestra los datos del extraterrestre
	 * 
	 * @param iUniversal
	 * @pre El extraterrestre debe existir en los registros
	 */
	public void buscarPorIdentificadorUniversar() {

	}

	/***
	 * Se debe pasar el identificador del el planeta o el nombre del mismo y muestra
	 * por consola el porcentaje de extraterrestres que existen en ese planeta en
	 * comparacion al resto existentes en la base de datos
	 * 
	 * @pre El planeta debe estar registrado
	 */
	public void mostrarPorPlaneta() {

	}

	/***
	 * Se ingresa la nacionalidad y muestra por consola los datos de los humanos, y
	 * el porcentaje de humanos que hay en esa nacionalidad con respecto al resto de
	 * naciones
	 */
	public void mostrarPorNacionalidadDatosHumanos() {

	}

	/***
	 * Muestra por consola los tipos de extraterrestres que existen separados por su
	 * estructura
	 * 
	 *  @post V = Vertebrados, I = Invertebrados y F = Flexible
	 */
	public void mostrarCantidadExtraterrestres() {

	}
	
	public void mostrarDatosPrueba() {
		System.out.println(Arrays.toString(registro));
	}
	
	
}
