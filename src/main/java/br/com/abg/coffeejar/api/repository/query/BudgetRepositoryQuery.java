package br.com.abg.coffeejar.api.repository.query;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.abg.coffeejar.api.model.Budget;
import br.com.abg.coffeejar.api.repository.filter.BudgetFilter;

/**
 * Interface para os métodos personalizados das consultas do orçamento.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public interface BudgetRepositoryQuery {

	/**
	 * Lista os orçamentos de acordo com o filtro.
	 *
	 * @param filter
	 * @param pageable
	 *
	 * @return
	 */
	Page<Budget> list(BudgetFilter filter, Pageable pageable);
}
