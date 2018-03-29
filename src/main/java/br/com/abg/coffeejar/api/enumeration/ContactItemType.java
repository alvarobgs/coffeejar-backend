package br.com.abg.coffeejar.api.enumeration;

import lombok.Getter;

/**
 * Enum para tipo de item de contato.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public enum ContactItemType {

	/**
	 * Telefone fixo.
	 */
	PHONE("(99) 9999-9999"),

	/**
	 * Celular.
	 */
	MOBILE("(99) 99999-9999"),

	/**
	 * Site.
	 */
	WEBSITE(""),

	/**
	 * E-mail.
	 */
	MAIL("");

	/**
	 * Máscara.
	 */
	@Getter
	private String mask;

	/**
	 * Construtor.
	 */
	private ContactItemType() {}

	/**
	 * Construtor sobrescrito.
	 *
	 * @param mask
	 */
	private ContactItemType(final String mask) {
		this.mask = mask;
	}
}
