package br.ucsal.iot.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class DadosLixeiraUtil {

	private DadosLixeiraUtil() {
	}

	public static String capturarPeriodos(String textoDados) {
		String s = null;

		try {
			Pattern padrao = Pattern.compile("(([\\\\p|\\\\P])[0-9]+)");
			Matcher encontrador = padrao.matcher(textoDados);
			while (encontrador.find()) {
				s = encontrador.group().toUpperCase();
			}

		} catch (PatternSyntaxException e) {
			e.printStackTrace();
		}

		return s;
	}
	
	public static String capturarTemperaturas(String textoDados) {
		String s = null;

		try {
			Pattern padrao = Pattern.compile("(([\\\\t|\\\\T])[0-9]+)");
			Matcher encontrador = padrao.matcher(textoDados);
			while (encontrador.find()) {
				s = encontrador.group().toUpperCase();
			}

		} catch (PatternSyntaxException e) {
			e.printStackTrace();
		}

		return s;
	}
	
	public static String capturarNiveisMagnetismo(String textoDados) {
		String s = null;

		try {
			Pattern padrao = Pattern.compile("(([\\\\m|\\\\M])[0-9]+)");
			Matcher encontrador = padrao.matcher(textoDados);
			while (encontrador.find()) {
				s = encontrador.group().toUpperCase();
			}

		} catch (PatternSyntaxException e) {
			e.printStackTrace();
		}

		return s;
	}

	public static String capturarCapacidades(String textoDados) {
		String s = null;

		try {
			Pattern padrao = Pattern.compile("(([\\\\c|\\\\C])[0-9]+)");
			Matcher encontrador = padrao.matcher(textoDados);
			while (encontrador.find()) {
				s = encontrador.group().toUpperCase();
			}

		} catch (PatternSyntaxException e) {
			e.printStackTrace();
		}

		return s;
	}

	public static String capturarNiveisGas(String textoDados) {
		String s = null;

		try {
			Pattern padrao = Pattern.compile("(([\\\\g|\\\\G])[0-9]+)");
			Matcher encontrador = padrao.matcher(textoDados);
			while (encontrador.find()) {
				s = encontrador.group().toUpperCase();
			}

		} catch (PatternSyntaxException e) {
			e.printStackTrace();
		}

		return s;
	}

}
