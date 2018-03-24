package br.com.abg.coffeejar.api.exceptionhandler;

import lombok.Getter;

/**
 * Classe com as mensagens de erro
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 * @since 1.0.0
 */
public class Error {

	/**
	 *
	 */
	@Getter
	private String endUserMessage;

	/**
	 *
	 */
	@Getter
	private String developerMessage;

	/**
	 * Construtor.
	 *
	 * @param endUserMessage
	 * @param developerMessage
	 */
	public Error(final String endUserMessage, final String developerMessage) {
		this.endUserMessage = endUserMessage;
		this.developerMessage = developerMessage;
	}
}
