package br.ucsal.iot.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class DadosLixeiraUtil {

	private DadosLixeiraUtil() {
	}

	public static Integer capturarPeriodos(String textoDados) {
		String s = null;
		Integer i = null;

		try {
			Pattern padrao = Pattern.compile("(([\\\\p|\\\\P])[0-9]+)");
			Matcher encontrador = padrao.matcher(textoDados);
			while (encontrador.find()) {
				s = encontrador.group().trim().toUpperCase().replace("P", "");
				i = Integer.parseInt(s);
			}

		} catch (PatternSyntaxException e) {
			e.printStackTrace();
		}

		return i;
	}
	
	public static Integer capturarTemperaturas(String textoDados) {
		String s = null;
		Integer i = null;

		try {
			Pattern padrao = Pattern.compile("(([\\\\t|\\\\T])[0-9]+)");
			Matcher encontrador = padrao.matcher(textoDados);
			while (encontrador.find()) {
				s = encontrador.group().trim().toUpperCase().replace("T", "");
				i = Integer.parseInt(s);
			}

		} catch (PatternSyntaxException e) {
			e.printStackTrace();
		}

		return i;
	}
	
	public static Integer capturarNiveisMagnetismo(String textoDados) {
		String s = null;
		Integer i = null;

		try {
			Pattern padrao = Pattern.compile("(([\\\\m|\\\\M])[0-9]+)");
			Matcher encontrador = padrao.matcher(textoDados);
			while (encontrador.find()) {
				s = encontrador.group().trim().toUpperCase().replace("M", "");
				i = Integer.parseInt(s);
			}

		} catch (PatternSyntaxException e) {
			e.printStackTrace();
		}

		return i;
	}

	public static Integer capturarCapacidades(String textoDados) {
		String s = null;
		Integer i = null;

		try {
			Pattern padrao = Pattern.compile("(([\\\\c|\\\\C])[0-9]+)");
			Matcher encontrador = padrao.matcher(textoDados);
			while (encontrador.find()) {
				s = encontrador.group().trim().toUpperCase().replace("C", "");
				i = Integer.parseInt(s);
			}

		} catch (PatternSyntaxException e) {
			e.printStackTrace();
		}

		return i;
	}

	public static Integer capturarNiveisGas(String textoDados) {
		String s = null;
		Integer i = null;

		try {
			Pattern padrao = Pattern.compile("(([\\\\g|\\\\G])[0-9]+)");
			Matcher encontrador = padrao.matcher(textoDados);
			while (encontrador.find()) {
				s = encontrador.group().trim().toUpperCase().replace("G", "");
				i = Integer.parseInt(s);
			}
		} catch (PatternSyntaxException e) {
			e.printStackTrace();
		}

		return i;
	}

}
