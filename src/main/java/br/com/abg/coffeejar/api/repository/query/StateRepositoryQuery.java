package br.com.abg.coffeejar.api.repository.query;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.abg.coffeejar.api.model.State;
import br.com.abg.coffeejar.api.repository.filter.StateFilter;

/**
 * Interface para os métodos personalizados das consultas de estado.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public interface StateRepositoryQuery {

	/**
	 * Lista os estados de acordo com o filtro.
	 *
	 * @param filter
	 * @param pageable
	 *
	 * @return
	 */
	Page<State> list(StateFilter filter, Pageable pageable);
}
