package br.com.abg.coffeejar.api.utils;

/**
 * Classe que realiza validações diversas.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public class Validator {

	/**
	 * Verifica se o objeto está vazio.
	 *
	 * @param object
	 *
	 * @return
	 */
	public static boolean isEmpty(final Object object) {
		return object == null;
	}
}
