package br.com.abg.coffeejar.api.utils;

import java.util.Date;
import java.util.List;

/**
 * Classe que realiza validações diversas.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public class Validator {

	/**
	 * Valida se a data está nula.
	 */
	public static boolean isEmpty(final Date date) {
		return date == null;
	}

	/**
	 * Valida se a string está vazia.
	 */
	public static boolean isEmpty(final String string) {
		return string == null || string.equals("");
	}

	/**
	 * Valida se uma lista está vazia.
	 */
	public static boolean isEmpty(final List<?> list) {
		return list == null || list.isEmpty();
	}

	/**
	 * Valida se um objeto está vazio.
	 */
	public static boolean isEmpty(final Object object) {
		return object == null;
	}

	/**
	 * Valida se a string está nula.
	 */
	public static boolean isNull(final String string) {
		return string == null;
	}
}
