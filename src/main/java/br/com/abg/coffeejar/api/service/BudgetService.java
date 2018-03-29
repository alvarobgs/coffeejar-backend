package br.com.abg.coffeejar.api.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.abg.coffeejar.api.model.Budget;
import br.com.abg.coffeejar.api.repository.BudgetRepository;
import br.com.abg.coffeejar.api.repository.filter.BudgetFilter;
import br.com.abg.coffeejar.api.utils.Validator;

/**
 * Serviço para a entidade Orçamento.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Service
public class BudgetService {

	/**
	 * Injeção do repositório para a entidade orçamento.
	 */
	@Autowired
	private BudgetRepository budgetRepository;

	/**
	 * Salva o orçamento.
	 *
	 * @param budget
	 * @return
	 */
	public Budget save(final Budget budget) {
		return this.budgetRepository.save(budget);
	}

	/**
	 * Atualiza o orçamento.
	 *
	 * @param id
	 * @param budget
	 *
	 * @return
	 */
	public Budget update(final Long id, final Budget budget) {
		final Budget budgetToUpdate = this.getById(id);
		BeanUtils.copyProperties(budgetToUpdate, budget, "id");
		this.budgetRepository.save(budgetToUpdate);
		return budgetToUpdate;
	}

	/**
	 * Retorna o orçamento por ID.
	 *
	 * @param id
	 *
	 * @return
	 */
	public Budget getById(final Long id) {
		final Budget budget = this.budgetRepository.getOne(id);

		if (Validator.isEmpty(budget)) {
			throw new EmptyResultDataAccessException(1);
		}
		return budget;
	}

	/**
	 * Remove orçamento por id.
	 *
	 * @param id
	 */
	public void remove(final Long id) {
		this.budgetRepository.deleteById(id);
	}

	/**
	 * Lista os orçamentos com filtro.
	 *
	 * @param filter
	 * @param pageable
	 *
	 * @return
	 */
	public Page<Budget> list(final BudgetFilter filter, final Pageable pageable) {
		return this.budgetRepository.list(filter, pageable);
	}
}
