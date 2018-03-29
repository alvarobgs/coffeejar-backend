package br.com.abg.coffeejar.api.repository.query;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.abg.coffeejar.api.model.Country;
import br.com.abg.coffeejar.api.repository.filter.CountryFilter;

/**
 * Interface para os métodos personalizados das consultas do país.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public interface CountryRepositoryQuery {

	/**
	 * Lista os países de acordo com o filtro.
	 *
	 * @param filter
	 * @param pageable
	 *
	 * @return
	 */
	Page<Country> list(CountryFilter filter, Pageable pageable);
}
