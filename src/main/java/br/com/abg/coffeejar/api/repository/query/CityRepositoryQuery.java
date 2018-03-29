package br.com.abg.coffeejar.api.repository.query;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.abg.coffeejar.api.model.City;
import br.com.abg.coffeejar.api.repository.filter.CityFilter;

/**
 * Interface para os métodos personalizados das consultas da cidade.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public interface CityRepositoryQuery {

	/**
	 * Lista as cidades de acordo com o filtro.
	 *
	 * @param filter
	 * @param pageable
	 *
	 * @return
	 */
	Page<City> list(CityFilter filter, Pageable pageable);
}
