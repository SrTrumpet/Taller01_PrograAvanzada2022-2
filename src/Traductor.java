public class Traductor {

	/***
	 * Translates extraterrestrial language into human language and vice versa.
	 * 
	 * @param linea
	 * @return traduccion
	 */
	public String traductorExtraterrestreHumano(String linea) {

		String[] datos = linea.split(",");
		String frase = "";
		String tipo = datos[7];
		String identificacion = datos[2];

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

			if (i == 7) {
				datos[i] = tipo;
			} else if (i == 2) {
				datos[i] = identificacion;
			}

			else {
				datos[i] = frase;
			}

		}

		String traduccion = "";

		for (String s : datos) {
			traduccion += (s + ",");
		}

		traduccion = cambiarMedidasExtraterrestreHumano(traduccion);

		return traduccion;
	}

	/***
	 * Change the measurements used by aliens to human (Age => 1 year human = 8
	 * years aliens, Weight => Grams to Kilograms, Height => cm to meters).
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

		int ultimoDato = 0;

		for (String s : datos) {
			if (ultimoDato == datos.length - 1) {
				nuevosDatos += (s);
			} else {
				nuevosDatos += (s + ",");
			}
			ultimoDato++;
		}

		return nuevosDatos;
	}

	/***
	 * Reverses previously changed measurements to be readable by humans
	 * 
	 * @param linea
	 * @return nuevosDatos
	 */

	public String rebertirMedidas(String linea) {

		String[] datos = linea.split(",");
		String frase = "";
		String tipo = datos[7];
		String identificacion = datos[2];

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

			if (i == 7) {
				datos[i] = tipo;
			} else if (i == 2) {
				datos[i] = identificacion;
			} else {
				datos[i] = frase;
			}

		}

		String traduccion = "";

		for (String s : datos) {
			traduccion += (s + ",");
		}

		String[] datos2 = traduccion.split(",");

		int edad = Integer.parseInt(datos[4]) * 8;
		datos2[4] = String.valueOf(edad);

		double altura = Double.parseDouble(datos[5]) * 100;
		datos2[5] = String.valueOf(altura);

		double peso = Double.parseDouble(datos[6]) * 1000;
		datos2[6] = String.valueOf(peso);

		String nuevosDatos = "";
		int ultimoDato = 0;

		for (String s : datos2) {
			if (ultimoDato == datos2.length - 1) {
				nuevosDatos += (s);
			} else {
				nuevosDatos += (s + ",");
			}
			ultimoDato++;
		}

		return nuevosDatos;
	}

	/***
	 * Change the data "Height" and "Weight" from Cm => Meter and Grams =>
	 * Kilograms.
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

	/***
	 * Change the data "Height" and "Weight" from Meter => Cm and Kilograms =>
	 * Grams.
	 * 
	 * @param linea
	 * @return
	 */
	public String rebertirMedidasHumanas(String linea) {

		String[] datos = linea.split(",");

		double altura = Double.parseDouble(datos[6]) * 100;
		datos[6] = String.valueOf(altura);

		double peso = Double.parseDouble(datos[7]) * 1000;
		datos[7] = String.valueOf(peso);

		String nuevosDatos = "";
		int ultimoDato = 0;

		for (String s : datos) {
			if (ultimoDato == datos.length - 1) {
				nuevosDatos += s;
			} else {
				nuevosDatos += (s + ",");
			}
			ultimoDato++;
		}
		return nuevosDatos;
	}

}
