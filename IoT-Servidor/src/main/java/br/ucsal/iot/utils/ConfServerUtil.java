package br.ucsal.iot.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ConfServerUtil {

	private ConfServerUtil() {
	}

	public static boolean validarIp(String IP) {

		if (Util.isNullOrEmpty(IP)) {
			return false;
		}

		try {
			Pattern padrao = Pattern.compile(
					"\\b(?:(?:2(?:[0-4][0-9]|5[0-5])|[0-1]?[0-9]?[0-9])\\.){3}(?:(?:2([0-4][0-9]|5[0-5])|[0-1]?[0-9]?[0-9]))\\b");
			Matcher encontrador = padrao.matcher(IP);
			while (encontrador.find()) {
				return true;
			}
		} catch (PatternSyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean validarPorta(String porta) {

		if (Util.isNullOrEmpty(porta)) {
			return false;
		}

		try {
			Pattern padrao = Pattern
					.compile("^([0-9]{1,4}|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]|6553[0-5])$");
			Matcher encontrador = padrao.matcher(porta);
			while (encontrador.find()) {
				return true;
			}
		} catch (PatternSyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}

}
