
public class AmpliarRegistro {

	/***
	 * Recibe la lista a la que se le quiere añadir un nuevo dato, y el dato que se
	 * añadirá
	 * 
	 * @param datos
	 * @param listaAnterior
	 * @return nuevaLista
	 */
	public String[] add(String datos, String[] listaAnterior) {

		int size = listaAnterior.length + 1; // Se crea una nueva lista con un espacion mayor que la lista anterior
		String[] nuevaLista = new String[size];

		int add = 0;

		for (String s : listaAnterior) {
			nuevaLista[add] = s;
			add++;
		}
		nuevaLista[size - 1] = datos; // Se añade el nuevo dato alfinal de la lista
		return nuevaLista;
	}

	/***
	 * Se ingresa el dato clave para encontrar el dato que se eliminara, y se
	 * ingresa la lista que se quiere quitar el dato
	 * 
	 * @param datoEliminar
	 * @param listaAnterior
	 * @return nuevaLista
	 */
	public String[] delete(String datoEliminar, String[] listaAnterior) {

		int size = listaAnterior.length - 1;
		String[] nuevaLista = new String[size];

		int add = 0;

		for (String s : listaAnterior) {
			String[] datos = s.split(",");
			if (!datos[2].equals(datoEliminar)) {
				nuevaLista[add] = s;
				add++;
			}
		}
		return nuevaLista;
	}

	/***
	 * Se ingresa el dato clave para encontrar el dato que se eliminara, y se
	 * ingresa la lista que se quiere quitar el dato
	 * 
	 * @param datoEliminar
	 * @param listaAnterior
	 * @return nuevaLista
	 */
	public String[] deletePlanet(String datos, String[] listaAnterior) {

		int size = listaAnterior.length - 1; // Se crea una nueva lista con un espacion mayor que la lista anterior
		String[] nuevaLista = new String[size];

		int add = 0;

		for (String s : listaAnterior) {
			if (!s.equals(datos)) {
				nuevaLista[add] = s;
				add++;
			}
		}
		return nuevaLista;
	}

}
