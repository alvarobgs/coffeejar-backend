package br.com.abg.coffeejar.api.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.abg.coffeejar.api.model.Category;
import br.com.abg.coffeejar.api.repository.CategoryRepository;
import br.com.abg.coffeejar.api.repository.filter.CategoryFilter;
import br.com.abg.coffeejar.api.utils.Validator;

/**
 * Serviço para a entidade Categoria.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Service
public class CategoryService {

	/**
	 * Injeção do repositório para a entidade categoria.
	 */
	@Autowired
	private CategoryRepository categoryRepository;

	/**
	 * Salva o categoria.
	 *
	 * @param category
	 * @return
	 */
	public Category save(final Category category) {
		return this.categoryRepository.save(category);
	}

	/**
	 * Atualiza o categoria.
	 *
	 * @param id
	 * @param category
	 *
	 * @return
	 */
	public Category update(final Long id, final Category category) {
		final Category categoryToUpdate = this.getById(id);
		BeanUtils.copyProperties(categoryToUpdate, category, "id");
		this.categoryRepository.save(categoryToUpdate);
		return categoryToUpdate;
	}

	/**
	 * Retorna o categoria por ID.
	 *
	 * @param id
	 *
	 * @return
	 */
	public Category getById(final Long id) {
		final Category category = this.categoryRepository.getOne(id);

		if (Validator.isEmpty(category)) {
			throw new EmptyResultDataAccessException(1);
		}
		return category;
	}

	/**
	 * Remove categoria por id.
	 *
	 * @param id
	 */
	public void remove(final Long id) {
		this.categoryRepository.deleteById(id);
	}

	/**
	 * Lista os categorias com filtro.
	 *
	 * @param filter
	 * @param pageable
	 *
	 * @return
	 */
	public Page<Category> list(final CategoryFilter filter, final Pageable pageable) {
		return this.categoryRepository.list(filter, pageable);
	}
}
