package br.com.abg.coffeejar.api.repository.query.impl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.abg.coffeejar.api.model.Client;
import br.com.abg.coffeejar.api.repository.filter.ClientFilter;
import br.com.abg.coffeejar.api.repository.query.ClientRepositoryQuery;

/**
 * Implementação para os métodos personalizados das consultas do cliente.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 * @since 1.0.0
 */
public class ClientRepositoryImpl extends AbstractRepositoryImpl implements ClientRepositoryQuery {

	/**
	 * Contexto para Entity Manager.
	 */
	@PersistenceContext
	protected EntityManager em;

	@Override
	public Page<Client> list(final ClientFilter filter, final Pageable pageable) {
		final StringBuilder strQuery = new StringBuilder();
		strQuery.append("SELECT c ");
		strQuery.append("FROM Client c ");
		strQuery.append("WHERE ");
		//FIXME definir filtros

		final Query query = this.em.createQuery(strQuery.toString());
		super.paginateQuery(query, pageable);
		//FIXME definir atributos como parâmetro

		//FIXME calcular o total.
		return new PageImpl<>(query.getResultList(), pageable, 0);
	}
}
