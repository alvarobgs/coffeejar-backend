package br.com.abg.coffeejar.api.repository.query;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.abg.coffeejar.api.model.Category;
import br.com.abg.coffeejar.api.repository.filter.CategoryFilter;

/**
 * Interface para os métodos personalizados das consultas da categoria.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public interface CategoryRepositoryQuery {

	/**
	 * Lista as categorias de acordo com o filtro.
	 *
	 * @param filter
	 * @param pageable
	 *
	 * @return
	 */
	Page<Category> list(CategoryFilter filter, Pageable pageable);
}
