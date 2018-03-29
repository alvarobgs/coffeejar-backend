package br.com.abg.coffeejar.api.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.abg.coffeejar.api.model.State;
import br.com.abg.coffeejar.api.repository.StateRepository;
import br.com.abg.coffeejar.api.repository.filter.StateFilter;
import br.com.abg.coffeejar.api.utils.Validator;

/**
 * Serviço para a entidade Orçamento.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Service
public class StateService {

	/**
	 * Injeção do repositório para a entidade estado.
	 */
	@Autowired
	private StateRepository stateRepository;

	/**
	 * Salva o estado.
	 *
	 * @param state
	 * @return
	 */
	public State save(final State state) {
		return this.stateRepository.save(state);
	}

	/**
	 * Atualiza o estado.
	 *
	 * @param id
	 * @param state
	 *
	 * @return
	 */
	public State update(final Long id, final State state) {
		final State stateToUpdate = this.getById(id);
		BeanUtils.copyProperties(stateToUpdate, state, "id");
		this.stateRepository.save(stateToUpdate);
		return stateToUpdate;
	}

	/**
	 * Retorna o estado por ID.
	 *
	 * @param id
	 *
	 * @return
	 */
	public State getById(final Long id) {
		final State state = this.stateRepository.getOne(id);

		if (Validator.isEmpty(state)) {
			throw new EmptyResultDataAccessException(1);
		}
		return state;
	}

	/**
	 * Remove estado por id.
	 *
	 * @param id
	 */
	public void remove(final Long id) {
		this.stateRepository.deleteById(id);
	}

	/**
	 * Lista os estados com filtro.
	 *
	 * @param filter
	 * @return
	 */
	public Page<State> list(final StateFilter filter, final Pageable pageable) {
		return this.stateRepository.list(filter, pageable);
	}
}
