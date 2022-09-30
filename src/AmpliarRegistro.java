
public class AmpliarRegistro {

	/***
	 * Receives the list to which you want to add a new data, and the data to be added.
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
	 * Enter the key data to find the values to be deleted, and enter the list containing it
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
	 * Enter the key data to find the data to be removed, and enter the list you want to remove the data from.
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
