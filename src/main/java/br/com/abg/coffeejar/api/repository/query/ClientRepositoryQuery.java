package br.com.abg.coffeejar.api.repository.query;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
	Page<Client> list(ClientFilter filter, Pageable pageable);
}
