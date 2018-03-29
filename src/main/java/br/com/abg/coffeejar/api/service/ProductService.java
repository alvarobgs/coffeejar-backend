package br.com.abg.coffeejar.api.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.abg.coffeejar.api.model.Product;
import br.com.abg.coffeejar.api.repository.ProductRepository;
import br.com.abg.coffeejar.api.repository.filter.ProductFilter;
import br.com.abg.coffeejar.api.utils.Validator;

/**
 * Serviço para a entidade Orçamento.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Service
public class ProductService {

	/**
	 * Injeção do repositório para a entidade produto.
	 */
	@Autowired
	private ProductRepository productRepository;

	/**
	 * Salva o produto.
	 *
	 * @param product
	 * @return
	 */
	public Product save(final Product product) {
		return this.productRepository.save(product);
	}

	/**
	 * Atualiza o produto.
	 *
	 * @param id
	 * @param product
	 *
	 * @return
	 */
	public Product update(final Long id, final Product product) {
		final Product productToUpdate = this.getById(id);
		BeanUtils.copyProperties(productToUpdate, product, "id");
		this.productRepository.save(productToUpdate);
		return productToUpdate;
	}

	/**
	 * Retorna o produto por ID.
	 *
	 * @param id
	 *
	 * @return
	 */
	public Product getById(final Long id) {
		final Product product = this.productRepository.getOne(id);

		if (Validator.isEmpty(product)) {
			throw new EmptyResultDataAccessException(1);
		}
		return product;
	}

	/**
	 * Remove produto por id.
	 *
	 * @param id
	 */
	public void remove(final Long id) {
		this.productRepository.deleteById(id);
	}

	/**
	 * Lista os produtos com filtro.
	 *
	 * @param filter
	 * @param pageable
	 *
	 * @return
	 */
	public Page<Product> list(final ProductFilter filter, final Pageable pageable) {
		return this.productRepository.list(filter, pageable);
	}
}
