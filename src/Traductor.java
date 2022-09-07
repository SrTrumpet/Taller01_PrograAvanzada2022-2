public class Traductor {

	/***
	 * Traduce el lenguaje extraterrestre a humano y viceversa
	 * 
	 * @param linea
	 * @return traduccion
	 */
	public String traductorExtraterrestreHumano(String linea) {

		String[] datos = linea.split(",");
		String frase = "";

		for (int i = 0; i < datos.length; i++) {
			String[] valores = datos[i].split("");
			frase = "";
			for (int j = 0; j < valores.length; j++) {
				if (valores[j].equals("A")) {
					valores[j] = "E";

				} else if (valores[j].equals("a")) {
					valores[j] = "e";

				} else if (valores[j].equals("E")) {
					valores[j] = "A";

				} else if (valores[j].equals("e")) {
					valores[j] = "a";

				} else if (valores[j].equals("O")) {
					valores[j] = "I";

				} else if (valores[j].equals("o")) {
					valores[j] = "i";

				} else if (valores[j].equals("I")) {
					valores[j] = "O";

				} else if (valores[j].equals("i")) {
					valores[j] = "o";
					
				}
				
				frase+= valores[j];
			}
			
			datos[i] = frase;
		}
		
		String traduccion = "";
		
		for(String s: datos) {
			traduccion+= (s+",");
		}
		
		return traduccion;
	}

}
