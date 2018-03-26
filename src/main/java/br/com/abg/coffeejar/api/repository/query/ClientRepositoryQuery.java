package br.com.abg.coffeejar.api.repository.query;

import java.util.List;

import br.com.abg.coffeejar.api.model.Client;
import br.com.abg.coffeejar.api.repository.filter.ClientFilter;

/**
 * Interface para os métodos personalizados das consultas do cliente.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public interface ClientRepositoryQuery {

	/**
	 * Lista os clientes de acordo com o filtro.
	 *
	 * @param filter
	 *
	 * @return
	 */
	List<Client> list(ClientFilter filter);
}
