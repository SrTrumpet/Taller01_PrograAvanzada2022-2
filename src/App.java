import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/***
 * 
 * @author Elias M. Olivares
 *
 */
public class App {

	public static void main(String[] args) throws IOException {
		App app = new App();
		Menu menu = new Menu();
		Scanner leer = new Scanner(System.in);

		app.ejecutor(app, menu);
		//menu.mostrarDatosPrueba();
		app.menuInicio(leer, menu);

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

	public void menuInicio(Scanner leer, Menu menu) throws IOException {

		int opcion = -1;
		while (opcion != 12) {
			System.out.println(" ");
			System.out.println("#######################################");
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
				System.out.println("#############################################");
				System.out.println("Recuerde Ingresar los datos como Humano!!");
				System.out.println("#############################################");
				System.out.println(" ");

				System.out.println("Ingrese Nombre de especie: ");
				String especie = leer.nextLine();

				System.out.println("Ingrese nombre del extraterrestre: ");
				String nombre = leer.nextLine();

				System.out.println("Ingrese identificacion universal: ");
				String iUniversal = leer.nextLine().toUpperCase();

				System.out.println("Ingrese planeta de origen: ");
				String planeta = leer.nextLine();

				System.out.println("Ingrese edad(Edad en humano): ");
				String edad = leer.nextLine();
				int edadExtra = Integer.parseInt(edad);
				edad = String.valueOf(edadExtra);

				System.out.println("Ingrese altura (En Metros) : ");
				String altura = leer.nextLine();
				double alturaExt = Double.parseDouble(altura);
				altura = String.valueOf(alturaExt);

				System.out.println("Ingrese peso (En Kilogramos): ");
				String peso = leer.nextLine();
				double pesoExt = Double.parseDouble(peso);
				peso = String.valueOf(pesoExt);

				System.out.println("Ingrese tipo (V, I o F): ");
				String tipo = leer.nextLine().toUpperCase();

				menu.ingresarExtraterrestre(especie, nombre, iUniversal, planeta, edad, altura, peso, tipo);
				
				//menu.mostrarDatosPrueba();

				break;
			}
			case 2: {

				System.out.println("Ingrese la Identificacion Universal: ");
				String iUniversal = leer.nextLine();
				System.out.println("Que dato cambiara? (Recuerde Ingresar los datos como Humano): ");
				System.out.print("""
						1. Nombre de Especie
						2. Nombre
						3. Identificacion Universal
						4. Planeta de origen
						5. Edad
						6. Altura
						7. Peso
						8. Tipo
						>> """);
				int datoCambiar = Integer.parseInt(leer.nextLine());
				System.out.println("Ingrese el nuevo dato: ");
				String nuevoDato = leer.nextLine();

				menu.modificarExtraterrestre(iUniversal, datoCambiar, nuevoDato, menu);

				break;
			}
			case 3: {

				System.out.println("Ingrese los datos para registrar a un humano: ");
				System.out.println(" ");
				System.out.println("Ingrese nacionalidad: ");
				String nacionalidad = leer.nextLine();

				System.out.println("Ingrese nombre: ");
				String nombre = leer.nextLine();

				System.out.println("Ingrese identificacion: ");
				String identificacion = leer.nextLine();

				System.out.println("Ingrese region: ");
				String region = leer.nextLine();

				System.out.println("Ingrese ciudad: ");
				String ciudad = leer.nextLine();

				System.out.println("Ingrese edad: ");
				String edad = leer.nextLine();

				System.out.println("Ingrese altura (en cm): ");
				int altura = Integer.parseInt(leer.nextLine());

				System.out.println("Ingrese peso (en gramos): ");
				int peso = Integer.parseInt(leer.nextLine());

				System.out.println("En cuantos planetas trbaja?: ");
				int cantPlanetas = Integer.parseInt(leer.nextLine());

				String[] planetas = new String[cantPlanetas];

				for (int i = 0; i < cantPlanetas; i++) {
					System.out.println("Ingrese nombre del planeta " + (i + 1) + " :");
					String nomPlaneta = leer.nextLine();
					planetas[i] = nomPlaneta;
				}

				menu.ingresarHumano(nacionalidad, nombre, identificacion, region, ciudad, edad, altura, peso, planetas);
				
				//menu.mostrarDatosPrueba();
				break;
			}
			case 4: {

				//////////////////////////////////////////////////////////// FALTA COMPLETAR
				System.out.println("Ingrese la Identificacion : ");
				String identificacion = leer.nextLine();
				System.out.println("Que dato cambiara?: ");
				System.out.print("""
						1. Nacionalidad
						2. Nombre
						3. Identificacion
						4. Region
						5. Ciudad
						6. Edad
						7. Altura [metro]
						8. Peso [kilogramos]
						9. Planetas
						>> """);
				int datoCambiar = Integer.parseInt(leer.nextLine());

				if (datoCambiar == 9) {
					System.out.println(
							"Quiere añadir o eliminar un planeta del registro? añadir = 1; eliminar = 2; modificar = 3: ");
					int datoAddDelete = Integer.parseInt(leer.nextLine());
					if (datoAddDelete == 1) {
						System.out.println("Ingrese el nombre del planeta: ");
						String planetaNuevo = leer.nextLine();

						menu.modificarHumano(identificacion, datoCambiar, planetaNuevo, menu, -1);

					} else if (datoAddDelete == 2) {
						System.out.println("Ingrese el nombre del planeta: ");
						String planetaEliminar = leer.nextLine();

						menu.modificarHumano(identificacion, datoCambiar, planetaEliminar, menu, -2);

					} else if (datoAddDelete == 3) {
						System.out.println("Posicion del planeta a cambiar: ");
						int dato = Integer.parseInt(leer.nextLine());
						System.out.println("Ingrese el nombre del planeta");
						String planetaNuevo = leer.nextLine();

						menu.modificarHumano(identificacion, datoCambiar, planetaNuevo, menu, dato);

					} else {
						System.out.println("Dato no permitido!");
					}

				} else {
					System.out.println("Recuerde ingresar las medidas en [kg] o [m] segun corresponda: ");
					System.out.println("Ingrese el nuevo dato: ");
					String nuevoDato = leer.nextLine();

					menu.modificarHumano(identificacion, datoCambiar, nuevoDato, menu, 0);
				}

				break;
			}
			case 5: {

				System.out.println("Ingrese la nacionalidad a buscar: ");
				String nacionalidad = leer.nextLine();

				menu.mostrarPorNacionalidad(nacionalidad, 0);

				break;
			}
			case 6: {
				System.out.println("Ingrese la Identificacion Universal: ");
				String iUniversal = leer.nextLine();

				menu.eliminarExtraterrestre(iUniversal, menu);
				//menu.mostrarDatosPrueba();

				break;
			}
			case 7: {
				System.out.println("Ingrese la Identificacion: ");
				String identificacion = leer.nextLine();

				menu.eliminarHumano(identificacion, menu);
				//menu.mostrarDatosPrueba();
				break;
			}
			case 8: {

				System.out.println("Ingrese la identificacion universal: ");
				String iUniversal = leer.nextLine();

				menu.buscarPorIdentificadorUniversar(iUniversal, menu);

				break;
			}
			case 9: {
				System.out.println("Ingrese el planeta a buscar: ");
				String planeta = leer.nextLine();
				
				menu.mostrarPorPlaneta(planeta);
				
				break;
			}
			case 10: {

				System.out.println("Ingrese la nacionalidad a buscar: ");
				String nacionalidad = leer.nextLine();

				menu.mostrarPorNacionalidad(nacionalidad, 1);

				break;
			}
			case 11: {
				menu.mostrarCantidadExtraterrestres();
				break;
			}
			case 12: {
				
				break;
			}
			default:
				throw new IllegalArgumentException("Valor ingresado no permitido:  " + opcion);
			}
		}
		
		
		///Guardar los nuevos datos
		menu.guardarArchivos();
		

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
