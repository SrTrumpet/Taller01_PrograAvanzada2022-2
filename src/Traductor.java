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

				frase += valores[j];
			}

			datos[i] = frase;
		}

		String traduccion = "";

		for (String s : datos) {
			traduccion += (s + ",");
		}


		traduccion = cambiarMedidasExtraterrestreHumano(traduccion);


		return traduccion;
	}

	/***
	 * Cambia las medidas usadas por los extraterrestres a humano (Edad => 1 año
	 * humano = 8 años extraterrestres, Peso => Gramos a Kilogramos, Altura => cm a
	 * metros)
	 * 
	 * @param linea
	 * @return nuevosDatos
	 */

	private String cambiarMedidasExtraterrestreHumano(String linea) {

		String[] datos = linea.split(",");

		int edad = Integer.parseInt(datos[4]) / 8;
		datos[4] = String.valueOf(edad);

		double altura = Double.parseDouble(datos[5]) / 100;
		datos[5] = String.valueOf(altura);

		double peso = Double.parseDouble(datos[6]) / 1000;
		datos[6] = String.valueOf(peso);

		String nuevosDatos = "";

		for (String s : datos) {
			nuevosDatos += (s + ",");
		}

		return nuevosDatos;
	}

	/***
	 * Cambia los datos "Altura" y "Peso", de Cm => Metro y Gramos => Kilogramos
	 * 
	 * @param linea
	 * @return
	 */
	public String cambiarMedidasHumanas(String linea) {

		String[] datos = linea.split(",");

		double altura = Double.parseDouble(datos[6]) / 100;
		datos[6] = String.valueOf(altura);

		double peso = Double.parseDouble(datos[7]) / 1000;
		datos[7] = String.valueOf(peso);

		String nuevosDatos = "";
		for (String s : datos) {
			nuevosDatos += (s + ",");
		}
		return nuevosDatos;
	}

}
