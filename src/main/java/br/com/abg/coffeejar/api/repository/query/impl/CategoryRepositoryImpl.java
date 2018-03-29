package br.com.abg.coffeejar.api.repository.query.impl;


import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.abg.coffeejar.api.model.Category;
import br.com.abg.coffeejar.api.repository.filter.CategoryFilter;
import br.com.abg.coffeejar.api.repository.query.CategoryRepositoryQuery;

/**
 * Implementação para os métodos personalizados das consultas das categorias.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 * @since 1.0.0
 */
public class CategoryRepositoryImpl extends AbstractRepositoryImpl implements CategoryRepositoryQuery {

	/**
	 * Contexto para Entity Manager.
	 */
	@PersistenceContext
	protected EntityManager em;

	@Override
	public Page<Category> list(final CategoryFilter filter, final Pageable pageable) {
		return new PageImpl<>(new ArrayList<>(), pageable, 0);
	}
}
