import java.io.IOException;
import java.util.Arrays;

public class Menu {

	private AmpliarRegistro ampliar = new AmpliarRegistro();
	private Traductor traductor = new Traductor();
	private GuardarTxt txt = new GuardarTxt();
	private String[] registro;
	private String[] registroHumano;
	private int addExtra = 0;
	private int addHumano = 0;

	/***
	 * Gives the initial size of the records that will contain the extraterrestrial
	 * and human data.
	 * 
	 * @param cantidad (value defining the amount of array space)
	 * @param tipo     (define whether it will be human or extraterrestrial record)
	 */
	public void inicializarRegistro(int cantidad, int tipo) {

		int maxRegistro = cantidad;

		if (tipo == 0) {
			this.registro = new String[maxRegistro];

		} else if (tipo == 1) {
			this.registroHumano = new String[maxRegistro];
		}

	}

	/***
	 * Convert data from a txt file to a String vector
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
	 * It offers the option of introducing a new alien per console.
	 * 
	 * @Precondicion Data must be entered in human language.
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
	 * Modify the data of an extraterrestrial, you must enter the "Universal ID"
	 * which must be unique for each extraterrestrial. which must be unique for each
	 * extraterrestrial.
	 * 
	 * @param iUniversal
	 * @pre The extraterrestrial must already be registered beforehand
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
	 * Gives the option to enter a new human by console.
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
	 * Modify the data of a human, if you want to change the data of the list of
	 * planets as the last data you must enter "-1" if you want to add a data, "-2"
	 * if you want to delete a data or enter the position of the planet to modify
	 * it.
	 * 
	 * @pre The human must already be registered in advance
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
	 * Display by console the humans belonging to the entered nationality
	 * 
	 * @param nacionalidad
	 * @param porcentaje   (Enter 0 if you do not want to show the percentage or 1
	 *                     if you want to show the percentage.)
	 * 
	 * @pre Nationality must exist
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
	 * Entering the "Universal ID" searches for the alien and deletes it.
	 * 
	 * @param iUniversar
	 * @param admin      (Class Menu)
	 * 
	 * @pre The extraterrestrial must exist in the records
	 * @post The alien is removed from the records and if the alien is not found the
	 *       records do not change.
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
	 * When entering the "Universal ID" the human is searched for and eliminated.
	 * 
	 * @param identificacion
	 * @param admin          (Class Menu)
	 * 
	 * @pre The human must exist in the records
	 * @post The human is removed from the records and if the human is not found the
	 *       records do not change.
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
	 * Receives the "Universar Identifier" and displays the alien's data.
	 * 
	 * @param iUniversal
	 * @pre The extraterrestrial must exist in the records
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
	 * You must pass the identifier of the planet or the name of the planet and it
	 * shows by console the percentage of extraterrestrials that exist on that
	 * planet compared to the rest in the database.
	 * 
	 * @pre The planet must be registered
	 */
	public void mostrarPorPlaneta(String planeta) {

		double cantExtraterrestres = 0;
		boolean existe = true;
		System.out.println("###############################");
		System.out.println("Buscando seres en el planeta: " + planeta);
		System.out.println("###############################");
		for (String s : registro) {
			String[] datos = s.split(",");
			if (datos[3].equals(planeta)) {
				existe = false;
				cantExtraterrestres++;
				System.out.println("Especie: " + datos[0]);
				System.out.println("Nombre: " + datos[1]);
				System.out.println("Identificacion Universal: " + datos[2]);
				System.out.println("Planeta de Origen: " + datos[3]);
				System.out.println("Edad (conversion a humano): " + datos[4]);
				System.out.println("Altura: " + datos[5] + " [m]");
				System.out.println("Peso: " + datos[6] + " [kg]");
				System.out.println("Tipo: " + datos[7]);
				System.out.println("##################################");
			}

		}

		int cantHumanos = 0;

		for (String s : registroHumano) {
			String[] datos = s.split(",");
			String[] planetas = datos[8].split("/");
			for (String sPlaneta : planetas) {
				if (sPlaneta.equals(planeta)) {
					cantHumanos++;
					break;
				}
			}
		}

		if (existe) {
			System.out.println("Planeta: " + planeta + " NO existe en los registros!!");
		} else {
			System.out.println(" ");
			System.out.println("Total de extraterrestre en el planeta " + planeta + ": " + (int) cantExtraterrestres);
			System.out.println("Hay un " + ((100 * cantExtraterrestres) / registro.length)
					+ "% en comparacion al resto de planetas");
			System.out.println("Humanos trabajado en el palenta " + planeta + ": " + (int) cantHumanos);
		}
	}

	/***
	 * Shows by console the types of extraterrestrials that exist separated by their
	 * structure.
	 * 
	 * @post V = Vertebrates, I = Invertebrates y F = Flexible
	 */
	public void mostrarCantidadExtraterrestres() {

		int cantVertebrados = 0;
		int cantInvertebrados = 0;
		int cantFlexibles = 0;
		int totalExtraterrestre = registro.length;

		for (String s : registro) {
			String[] datos = s.split(",");
			if (datos[7].equals("V")) {
				cantVertebrados++;
			} else if (datos[7].equals("I")) {
				cantInvertebrados++;
			} else if (datos[7].equals("F")) {
				cantFlexibles++;
			}
		}
		System.out.println("########################################");
		System.out.println("Total de extraterrestres: " + totalExtraterrestre);
		System.out.println("########################################");
		System.out.println("Vertebrados | Invertebrados | Flexible");
		System.out.println(
				"     " + cantVertebrados + "      |       " + cantInvertebrados + "       |    " + cantFlexibles);
		System.out.println("########################################");
		System.out.println("Porcentajes ");
		System.out.println("########################################");
		System.out.println("Vertebrados: " + ((double) cantVertebrados * 100 / totalExtraterrestre) + "%");
		System.out.println("Invertebrados: " + ((double) cantInvertebrados * 100 / totalExtraterrestre) + "%");
		System.out.println("Flexibles: " + ((double) cantFlexibles * 100 / totalExtraterrestre) + "%");

	}

	public void guardarArchivos() throws IOException {
		txt.guardarArch(registro, registroHumano);
	}

	/***
	 * Checks whether or not the item to be searched for exists.
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
