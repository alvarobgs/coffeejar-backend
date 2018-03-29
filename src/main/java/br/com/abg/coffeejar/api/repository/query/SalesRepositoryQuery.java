package br.com.abg.coffeejar.api.repository.query;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.abg.coffeejar.api.model.Product;
import br.com.abg.coffeejar.api.model.Sales;
import br.com.abg.coffeejar.api.repository.filter.ProductFilter;
import br.com.abg.coffeejar.api.repository.filter.SalesFilter;

/**
 * Interface para os métodos personalizados das consultas de vendas.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public interface SalesRepositoryQuery {

	/**
	 * Lista as vendas de acordo com o filtro.
	 *
	 * @param filter
	 * @param pageable
	 *
	 * @return
	 */
	Page<Sales> list(SalesFilter filter, Pageable pageable);
}
