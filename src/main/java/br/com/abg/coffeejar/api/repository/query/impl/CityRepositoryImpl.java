package br.com.abg.coffeejar.api.repository.query.impl;


import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.abg.coffeejar.api.model.City;
import br.com.abg.coffeejar.api.repository.filter.CityFilter;
import br.com.abg.coffeejar.api.repository.query.CityRepositoryQuery;

/**
 * Implementação para os métodos personalizados das consultas das cidades.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 * @since 1.0.0
 */
public class CityRepositoryImpl extends AbstractRepositoryImpl implements CityRepositoryQuery {

	/**
	 * Contexto para Entity Manager.
	 */
	@PersistenceContext
	protected EntityManager em;

	@Override
	public Page<City> list(final CityFilter filter, final Pageable pageable) {
		return new PageImpl<>(new ArrayList<>(), pageable, 0);
	}
}
