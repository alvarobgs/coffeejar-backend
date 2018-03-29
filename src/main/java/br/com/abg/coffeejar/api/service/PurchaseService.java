package br.com.abg.coffeejar.api.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.abg.coffeejar.api.model.Purchase;
import br.com.abg.coffeejar.api.repository.PurchaseRepository;
import br.com.abg.coffeejar.api.repository.filter.PurchaseFilter;
import br.com.abg.coffeejar.api.utils.Validator;

/**
 * Serviço para a entidade Orçamento.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Service
public class PurchaseService {

	/**
	 * Injeção do repositório para a entidade pedido de compra.
	 */
	@Autowired
	private PurchaseRepository purchaseRepository;

	/**
	 * Salva o pedido de compra.
	 *
	 * @param purchase
	 * @return
	 */
	public Purchase save(final Purchase purchase) {
		return this.purchaseRepository.save(purchase);
	}

	/**
	 * Atualiza o pedido de compra.
	 *
	 * @param id
	 * @param purchase
	 *
	 * @return
	 */
	public Purchase update(final Long id, final Purchase purchase) {
		final Purchase purchaseToUpdate = this.getById(id);
		BeanUtils.copyProperties(purchaseToUpdate, purchase, "id");
		this.purchaseRepository.save(purchaseToUpdate);
		return purchaseToUpdate;
	}

	/**
	 * Retorna o pedido de compra por ID.
	 *
	 * @param id
	 *
	 * @return
	 */
	public Purchase getById(final Long id) {
		final Purchase purchase = this.purchaseRepository.getOne(id);

		if (Validator.isEmpty(purchase)) {
			throw new EmptyResultDataAccessException(1);
		}
		return purchase;
	}

	/**
	 * Remove pedido de compra por id.
	 *
	 * @param id
	 */
	public void remove(final Long id) {
		this.purchaseRepository.deleteById(id);
	}

	/**
	 * Lista os pedidos de compras com filtro.
	 *
	 * @param filter
	 * @return
	 */
	public Page<Purchase> list(final PurchaseFilter filter, final Pageable pageable) {
		return this.purchaseRepository.list(filter, pageable);
	}
}
