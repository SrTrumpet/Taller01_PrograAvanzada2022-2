
public class AmpliarRegistro {
	
	
	/***
	 * Recibe la lista a la que se le quiere añadir un nuevo dato, y el dato que se añadirá
	 * 
	 * @param datos
	 * @param listaAnterior
	 * @return nuevaLista
	 */
	public String[] add(String datos,String[] listaAnterior) {
		
		int size = listaAnterior.length+1;
		String[] nuevaLista = new String[size];
		
		int add = 0;
		
		for(String s: listaAnterior) {
			nuevaLista[add] = s;
			add++;
		}
		nuevaLista[size - 1] = datos;
		return nuevaLista;
	}

}
