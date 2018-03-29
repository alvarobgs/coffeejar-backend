package br.com.abg.coffeejar.api.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.abg.coffeejar.api.model.Country;
import br.com.abg.coffeejar.api.repository.CountryRepository;
import br.com.abg.coffeejar.api.utils.Validator;

/**
 * Serviço para a entidade Orçamento.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Service
public class CountryService {

	/**
	 * Injeção do repositório para a entidade país.
	 */
	@Autowired
	private CountryRepository countryRepository;

	/**
	 * Salva o país.
	 *
	 * @param country
	 * @return
	 */
	public Country save(final Country country) {
		return this.countryRepository.save(country);
	}

	/**
	 * Atualiza o país.
	 *
	 * @param id
	 * @param country
	 *
	 * @return
	 */
	public Country update(final Long id, final Country country) {
		final Country countryToUpdate = this.getById(id);
		BeanUtils.copyProperties(countryToUpdate, country, "id");
		this.countryRepository.save(countryToUpdate);
		return countryToUpdate;
	}

	/**
	 * Retorna o país por ID.
	 *
	 * @param id
	 *
	 * @return
	 */
	public Country getById(final Long id) {
		final Country country = this.countryRepository.getOne(id);

		if (Validator.isEmpty(country)) {
			throw new EmptyResultDataAccessException(1);
		}
		return country;
	}

	/**
	 * Remove país por id.
	 *
	 * @param id
	 */
	public void remove(final Long id) {
		this.countryRepository.deleteById(id);
	}

	/**
	 * Lista os paíss com filtro.
	 *
	 * @param filter
	 * @return
	 */
//	public Page<Country> list(final CountryFilter filter, final Pageable pageable) {
//		return this.countryRepository.list(filter, pageable);
//	}
}
