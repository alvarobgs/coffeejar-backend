package br.com.abg.coffeejar.api.repository.query.impl;


import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.abg.coffeejar.api.model.Budget;
import br.com.abg.coffeejar.api.repository.filter.BudgetFilter;
import br.com.abg.coffeejar.api.repository.query.BudgetRepositoryQuery;

/**
 * Implementação para os métodos personalizados das consultas do orçamento.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 * @since 1.0.0
 */
public class BudgetRepositoryImpl extends AbstractRepositoryImpl implements BudgetRepositoryQuery {

	/**
	 * Contexto para Entity Manager.
	 */
	@PersistenceContext
	protected EntityManager em;

	@Override
	public Page<Budget> list(final BudgetFilter filter, final Pageable pageable) {
		return new PageImpl<>(new ArrayList<>(), pageable, 0);
	}
}
