package br.com.abg.coffeejar.api.repository.query.impl;

import javax.persistence.Query;

import org.springframework.data.domain.Pageable;


/**
 * Repositório abstrato
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public abstract class AbstractRepositoryImpl {

	/**
	 * Seta os dados da paginação na query.
	 *
	 * @param query
	 * @param pageable
	 */
	protected void paginateQuery(final Query query, final Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int pageSize = pageable.getPageSize();
		int firstElement = currentPage * pageSize;

		query.setFirstResult(firstElement);
		query.setMaxResults(pageSize);
	}
}
