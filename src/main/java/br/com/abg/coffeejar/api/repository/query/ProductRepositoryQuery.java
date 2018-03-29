package br.com.abg.coffeejar.api.repository.query;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.abg.coffeejar.api.model.Product;
import br.com.abg.coffeejar.api.repository.filter.ProductFilter;

/**
 * Interface para os métodos personalizados das consultas do produto.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public interface ProductRepositoryQuery {

	/**
	 * Lista os produtos de acordo com o filtro.
	 *
	 * @param filter
	 * @param pageable
	 *
	 * @return
	 */
	Page<Product> list(ProductFilter filter, Pageable pageable);
}
