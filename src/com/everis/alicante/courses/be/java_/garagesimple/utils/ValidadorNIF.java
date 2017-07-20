package com.everis.alicante.courses.be.java_.garagesimple.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorNIF {

	public static boolean validaNif(String nif) {
		// logica de validacion google ^^:
		
		boolean correcto = false;

		Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");

		Matcher matcher = pattern.matcher(nif);

		if (matcher.matches()) {

			String letra = matcher.group(2);

			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

			int index = Integer.parseInt(matcher.group(1));

			index = index % 23;

			String reference = letras.substring(index, index + 1);

			if (reference.equalsIgnoreCase(letra)) {

				correcto = true;

			} else {

				correcto = false;

			}

		} else {

			correcto = false;

		}

		return correcto;

	}

}
