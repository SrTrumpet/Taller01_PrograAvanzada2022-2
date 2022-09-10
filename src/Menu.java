import java.util.Arrays;

public class Menu {

	private AmpliarRegistro ampliar = new AmpliarRegistro();
	private Traductor traductor = new Traductor();
	private String[] registro;
	private String[] registroHumano;
	private int addExtra = 0;
	private int addHumano = 0;

	/***
	 * Da el tamaño inicial de los registros que contendran los datos de los
	 * extraterrestres y humanos
	 * 
	 * @param cantidad (valor que define la cantidad de espacio del arreglo)
	 * @param tipo     (define si sera registro humano o extraterrestre)
	 */
	public void inicializarRegistro(int cantidad, int tipo) {

		int maxRegistro = 0;

		if (tipo == 0) {
			if (cantidad == 0) {
				maxRegistro = 1;
			} else {
				maxRegistro = cantidad;
			}
			this.registro = new String[maxRegistro];

		} else if (tipo == 1) {
			if (cantidad == 0) {
				maxRegistro = 1;
			} else {
				maxRegistro = cantidad;
			}
			this.registroHumano = new String[maxRegistro];
		}

	}

	/***
	 * Convierte los datos de un archivo txt a un arreglo de String
	 * 
	 * @param linea
	 * @param ex
	 */

	public void crearRegistro(String linea, int ex) {
		if (ex == 0) {
			String registroString = traductor.traductorExtraterrestreHumano(linea);
			registro[addExtra] = registroString;
			addExtra++;
		} else if (ex == 1) {
			String registroString = traductor.cambiarMedidasHumanas(linea);
			registroHumano[addHumano] = registroString;
			addHumano++;
		}

	}

	/***
	 * 
	 * Da la opcion de ingresar a un nuevo extraterrestre por consola.
	 * 
	 * @Precondicion Se deben de ingresar los datos en el lenguaje humano
	 * 
	 * @param nombreEspecie
	 * @param nombre
	 * @param iUniversal
	 * @param planeta
	 * @param edad
	 * @param altura
	 * @param peso
	 * @param tipo
	 */
	public void ingresarExtraterrestre(String nombreEspecie, String nombre, String iUniversal, String planeta,
			String edad, String altura, String peso, String tipo) {

		String datos = nombreEspecie + "," + nombre + "," + iUniversal + "," + planeta + "," + edad + "," + altura + ","
				+ peso + "," + tipo;

		this.registro = ampliar.add(datos, this.registro);

	}

	/***
	 * Modifica los datos de un extraterrestre, se debe ingresar la "Identificacion
	 * Universal" la cual debe ser unica para cada extraterrestre
	 * 
	 * @param iUniversal
	 * @pre El extraterrestre ya debe estar registrado con anterioridad
	 */
	public void modificarExtraterrestre(String iUniversal, int datoACambiar, String nuevoDato, Menu admin) {

		int posicionExtraterrestreRegistro = admin.buscar(iUniversal, registro);

		if (posicionExtraterrestreRegistro == registro.length) {
			System.out.println(" ");
			System.out.println("#######################################");
			System.out.println("Extraterrestre no encontrado");
			System.out.println("#######################################");
		} else {
			System.out.println("#############################################");
			System.out.println(
					"Datos actuales del extraterrestre(Recordar que ya estan traducidos sus datos y medidas): ");
			System.out.println("#############################################");
			String[] datos = registro[posicionExtraterrestreRegistro].split(",");

			System.out.println("Especie: " + datos[0]);
			System.out.println("Nombre: " + datos[1]);
			System.out.println("Planeta de origen: " + datos[3]);
			System.out.println("Edad: " + datos[4]);
			System.out.println("Altura: " + datos[5] + " [m]");
			System.out.println("Peso: " + datos[6] + " [kg]");
			System.out.println("Tipo: " + datos[7]);

			datos[datoACambiar - 1] = nuevoDato;

			System.out.println("#############################################");
			System.out.println("Nuevos datos del extraterrestre");
			System.out.println("#############################################");

			System.out.println("Especie: " + datos[0]);
			System.out.println("Nombre: " + datos[1]);
			System.out.println("Planeta de origen: " + datos[3]);
			System.out.println("Edad: " + datos[4]);
			System.out.println("Altura: " + datos[5] + " [m]");
			System.out.println("Peso: " + datos[6] + " [kg]");
			System.out.println("Tipo: " + datos[7]);

			String cambioRegistro = datos[0] + "," + datos[1] + "," + datos[2] + "," + datos[3] + "," + datos[4] + ","
					+ datos[5] + "," + datos[6] + "," + datos[7] + ",";

			registro[posicionExtraterrestreRegistro] = cambioRegistro;
			System.out.println(" ");
			System.out.println("Se realizo la modificacion Correctamente!");

		}

	}

	/***
	 * Da la opcion de ingresar a un nuevo humano por consola
	 * 
	 * @param nacionalidad
	 * @param nombre
	 * @param identificacion
	 * @param region
	 * @param ciudad
	 * @param edad
	 * @param altura
	 * @param peso
	 * @param planetasDeTrabajo
	 */
	public void ingresarHumano(String nacionalidad, String nombre, String identificacion, String region, String ciudad,
			String edad, int altura, int peso, String[] planetasDeTrabajo) {

		double nuevaAltura = (double) altura / 100;
		int nuevoPeso = peso / 1000;

		String datosPlaneta = "";
		int tam = 1;

		for (String s : planetasDeTrabajo) {

			if (tam != planetasDeTrabajo.length) {
				datosPlaneta += (s + "/");
			} else {
				datosPlaneta += (s);
			}
			tam++;
		}

		String addRegistro = nacionalidad + "," + nombre + "," + identificacion + "," + region + "," + ciudad + ","
				+ edad + "," + nuevaAltura + "," + nuevoPeso + "," + datosPlaneta;

		registroHumano = ampliar.add(addRegistro, registroHumano);

	}

	/***
	 * Modifica los datos de un humano, si se quiere cambiar los datos de la lista
	 * de los planetas como ultimo dato se debe ingresar "-1" si se quiere añadir un
	 * dato, "-2" si se quiere eliminar un dato o se ingresa la posicion del planeta
	 * para modificarlo
	 * 
	 * @pre El humano ya debe estar registrado con anterioridad
	 * 
	 * @param iUniversal
	 * @param datoACambiar
	 * @param nuevoDato
	 * @param admin
	 */
	public void modificarHumano(String identificacion, int datoACambiar, String nuevoDato, Menu admin, int planeta) {

		int posicionHumanoRegistro = admin.buscar(identificacion, registroHumano);

		if (posicionHumanoRegistro == registroHumano.length) {
			System.out.println(" ");
			System.out.println("#######################################");
			System.out.println("Humano no encontrado");
			System.out.println("#######################################");
		} else {
			System.out.println("#############################################");
			System.out.println("Datos actuales del Humano: ");
			System.out.println("#############################################");
			String[] datos = registroHumano[posicionHumanoRegistro].split(",");

			System.out.println("Nacionalidad: " + datos[0]);
			System.out.println("Nombre: " + datos[1]);
			System.out.println("Identificacion: " + datos[2]);
			System.out.println("Region: " + datos[3]);
			System.out.println("Ciudad: " + datos[4]);
			System.out.println("Edad: " + datos[5]);
			System.out.println("Altura: " + datos[6] + " [m]");
			System.out.println("Peso: " + datos[7] + " [kg]");
			System.out.println("Planetas de trabajo: " + datos[8]);

			if (datoACambiar == 9) {
				String datoNuevoPlaneta = "";

				if (planeta == -1) {
					String planetas[] = datos[8].split("/");
					planetas = ampliar.add(nuevoDato, planetas);
					for (String s : planetas) {
						datoNuevoPlaneta += (s + "/");
					}

				} else if (planeta == -2) {
					String planetas[] = datos[8].split("/");
					planetas = ampliar.deletePlanet(nuevoDato, planetas);
					for (String s : planetas) {
						datoNuevoPlaneta += (s + "/");
					}

				} else {
					String planetas[] = datos[8].split("/");
					planetas[planeta] = nuevoDato;
					for (String s : planetas) {
						datoNuevoPlaneta += (s + "/");
					}
				}

				datos[datoACambiar - 1] = datoNuevoPlaneta;

			} else {
				datos[datoACambiar - 1] = nuevoDato;
			}

			System.out.println("#############################################");
			System.out.println("Nuevos datos del Humano: ");
			System.out.println("#############################################");

			System.out.println("Nacionalidad: " + datos[0]);
			System.out.println("Nombre: " + datos[1]);
			System.out.println("Identificacion: " + datos[2]);
			System.out.println("Region: " + datos[3]);
			System.out.println("Ciudad: " + datos[4]);
			System.out.println("Edad: " + datos[5]);
			System.out.println("Altura: " + datos[6] + " [m]");
			System.out.println("Peso: " + datos[7] + " [kg]");
			System.out.println("Planetas de trabajo: " + datos[8]);

			String cambioRegistro = datos[0] + "," + datos[1] + "," + datos[2] + "," + datos[3] + "," + datos[4] + ","
					+ datos[5] + "," + datos[6] + "," + datos[7] + "," + datos[8];

			registroHumano[posicionHumanoRegistro] = cambioRegistro;
		}

	}

	/***
	 * Muestra por consola los humanos que perteneces a la nacionalidad ingresada,
	 * 
	 * @param nacionalidad
	 * @param porcentaje   (Se ingresa 0 si no quiere mostar el porcentaje o 1 si se
	 *                     quiere mostrar el porcentaje)
	 * 
	 * @pre La nacionalidad debe de existir
	 */
	public void mostrarPorNacionalidad(String nacionalidad, int porcentaje) {

		int porcentajeHumanos = 0;

		System.out.println("Datos de los humanos en la nacionalidad de: " + nacionalidad);
		System.out.println(" ");

		for (String s : registroHumano) {
			String[] datos = s.split(",");
			if (datos[0].equals(nacionalidad)) {
				System.out.println("#####################################");
				System.out.println(" ");
				System.out.println("Nacionalidad: " + datos[0]);
				System.out.println("Nombre: " + datos[1]);
				System.out.println("Identificacion: " + datos[2]);
				System.out.println("Region: " + datos[3]);
				System.out.println("Ciudad: " + datos[4]);
				System.out.println("Edad: " + datos[5]);
				System.out.println("Altura: " + datos[6] + " [m]");
				System.out.println("Peso: " + datos[7] + " [kg]");
				System.out.println("Planetas de trabajo: " + datos[8]);
				System.out.println(" ");

				porcentajeHumanos++;
			}
		}

		if (porcentaje == 1) {
			double porcentajeTotal = (100 * (int) porcentajeHumanos) / registroHumano.length;

			System.out.println("#####################################");
			System.out.println(" ");
			System.out.println("Porcentaje de humanos en la nacion de " + nacionalidad + ": " + porcentajeTotal + "%");
		}

	}

	/***
	 * Al ingresar la "Identificacion universar" se busca al extraterrestre y se
	 * elimina
	 * 
	 * @param iUniversar
	 * @param admin      (Class Menu)
	 * 
	 * @pre El extraterrestre debe existir en los registros
	 * @post Se elimina el extraterrestre de los registros y sino se encuentra al
	 *       extraterrestre los registros no cambian
	 */
	public void eliminarExtraterrestre(String iUniversal, Menu admin) {

		int posicion = admin.buscar(iUniversal, registro);

		if (posicion == registro.length) {
			System.out.println("###################");
			System.out.println("Extraterrestre no esta en el registro!");
			System.out.println("###################");
		} else {
			registro = ampliar.delete(iUniversal, registro);
			System.out.println("Registro eliminado");
		}

	}

	/***
	 * /*** Al ingresar la "Identificacion universar" se busca al humano y se
	 * elimina
	 * 
	 * @param identificacion
	 * @param admin          (Class Menu)
	 * 
	 * @pre El humano debe existir en los registros
	 * @post Se elimina el humano de los registros y sino se encuentra al humano los
	 *       registros no cambian
	 */
	public void eliminarHumano(String identificacion, Menu admin) {

		int posicion = admin.buscar(identificacion, registroHumano);

		if (posicion == registroHumano.length) {
			System.out.println("###################");
			System.out.println("Humano no esta en el registro!");
			System.out.println("###################");
		} else {
			registroHumano = ampliar.delete(identificacion, registroHumano);
			System.out.println("Registro eliminado");
		}

	}

	/***
	 * Recibe el "Identificador Universar" y muestra los datos del extraterrestre
	 * 
	 * @param iUniversal
	 * @pre El extraterrestre debe existir en los registros
	 */
	public void buscarPorIdentificadorUniversar(String iUniversal, Menu menu) {

		int posicion = menu.buscar(iUniversal, registro);

		if (posicion == registro.length) {
			System.out.println("Extraterrestre no encontrado en los registros");
		} else {
			String[] datos = registro[posicion].split(",");
			System.out.println("Especie: " + datos[0]);
			System.out.println("Nombre: " + datos[1]);
			System.out.println("Identificacion Universal: " + datos[2]);
			System.out.println("Planeta de Origen: " + datos[3]);
			System.out.println("Edad (conversion a humano): " + datos[4]);
			System.out.println("Altura: " + datos[5] + " [m]");
			System.out.println("Peso: " + datos[6] + " [kg]");
			System.out.println("Tipo: " + datos[7]);
		}
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
	 * @post V = Vertebrados, I = Invertebrados y F = Flexible
	 */
	public void mostrarCantidadExtraterrestres() {

	}

	/***
	 * Verifica si es que existe o no el elemento a buscar
	 * 
	 * @param iUniversal
	 * @return
	 */
	private int buscar(String iUniversal, String[] listaBuscar) {

		int posicion = 0;

		for (String s : listaBuscar) {
			String[] datos = s.split(",");
			if (datos[2].equals(iUniversal)) {
				break;
			}
			posicion++;
		}
		return posicion;

	}

	public void mostrarDatosPrueba() {
		System.out.println(Arrays.toString(registro));
		System.out.println(Arrays.toString(registroHumano));
	}

}
