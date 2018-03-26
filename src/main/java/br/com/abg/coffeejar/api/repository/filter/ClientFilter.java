package br.com.abg.coffeejar.api.repository.filter;

import br.com.abg.coffeejar.api.enumeration.PersonType;

import lombok.Getter;
import lombok.Setter;

/**
 * Filtro para os dados do cliente.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public class ClientFilter {

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private PersonType type;

}
