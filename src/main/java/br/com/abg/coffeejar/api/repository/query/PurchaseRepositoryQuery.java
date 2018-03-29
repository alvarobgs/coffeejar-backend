package br.com.abg.coffeejar.api.repository.query;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.abg.coffeejar.api.model.Purchase;
import br.com.abg.coffeejar.api.repository.filter.PurchaseFilter;

/**
 * Interface para os métodos personalizados das consultas do pedido de compra.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public interface PurchaseRepositoryQuery {

	/**
	 * Lista os pedidos de compra de acordo com o filtro.
	 *
	 * @param filter
	 * @param pageable
	 *
	 * @return
	 */
	Page<Purchase> list(PurchaseFilter filter, Pageable pageable);
}
