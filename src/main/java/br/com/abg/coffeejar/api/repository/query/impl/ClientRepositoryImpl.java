package br.com.abg.coffeejar.api.repository.query.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.abg.coffeejar.api.model.Client;
import br.com.abg.coffeejar.api.repository.filter.ClientFilter;
import br.com.abg.coffeejar.api.repository.query.ClientRepositoryQuery;

/**
 * Implementação para os métodos personalizados das consultas do cliente.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 * @since 1.0.0
 */
public class ClientRepositoryImpl implements ClientRepositoryQuery {

	@Override
	public List<Client> list(final ClientFilter filter) {
		return new ArrayList<>();
	}
}
