package br.com.abg.coffeejar.api.repository.query.impl;


import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.abg.coffeejar.api.model.Purchase;
import br.com.abg.coffeejar.api.repository.filter.PurchaseFilter;
import br.com.abg.coffeejar.api.repository.query.PurchaseRepositoryQuery;

/**
 * Implementação para os métodos personalizados das consultas da compra.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 * @since 1.0.0
 */
public class PurchaseRepositoryImpl extends AbstractRepositoryImpl implements PurchaseRepositoryQuery {

	/**
	 * Contexto para Entity Manager.
	 */
	@PersistenceContext
	protected EntityManager em;

	@Override
	public Page<Purchase> list(final PurchaseFilter filter, final Pageable pageable) {
		return new PageImpl<>(new ArrayList<>(), pageable, 0);
	}
}
