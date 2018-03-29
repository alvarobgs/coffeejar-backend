package br.com.abg.coffeejar.api.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.abg.coffeejar.api.model.City;
import br.com.abg.coffeejar.api.repository.CityRepository;
import br.com.abg.coffeejar.api.repository.filter.CityFilter;
import br.com.abg.coffeejar.api.utils.Validator;

/**
 * Serviço para a entidade Cidade.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Service
public class CityService {

	/**
	 * Injeção do repositório para a entidade cidade.
	 */
	@Autowired
	private CityRepository cityRepository;

	/**
	 * Salva o cidade.
	 *
	 * @param city
	 * @return
	 */
	public City save(final City city) {
		return this.cityRepository.save(city);
	}

	/**
	 * Atualiza o cidade.
	 *
	 * @param id
	 * @param city
	 *
	 * @return
	 */
	public City update(final Long id, final City city) {
		final City cityToUpdate = this.getById(id);
		BeanUtils.copyProperties(cityToUpdate, city, "id");
		this.cityRepository.save(cityToUpdate);
		return cityToUpdate;
	}

	/**
	 * Retorna o cidade por ID.
	 *
	 * @param id
	 *
	 * @return
	 */
	public City getById(final Long id) {
		final City city = this.cityRepository.getOne(id);

		if (Validator.isEmpty(city)) {
			throw new EmptyResultDataAccessException(1);
		}
		return city;
	}

	/**
	 * Remove cidade por id.
	 *
	 * @param id
	 */
	public void remove(final Long id) {
		this.cityRepository.deleteById(id);
	}

	/**
	 * Lista os cidades com filtro.
	 *
	 * @param filter
	 * @param pageable
	 *
	 * @return
	 */
	public Page<City> list(final CityFilter filter, final Pageable pageable) {
		return this.cityRepository.list(filter, pageable);
	}
}
