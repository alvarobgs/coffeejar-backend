package br.com.abg.coffeejar.api.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.abg.coffeejar.api.model.Sales;
import br.com.abg.coffeejar.api.repository.SalesRepository;
import br.com.abg.coffeejar.api.repository.filter.SalesFilter;
import br.com.abg.coffeejar.api.utils.Validator;

/**
 * Serviço para a entidade Orçamento.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Service
public class SalesService {

	/**
	 * Injeção do repositório para a entidade pedido de venda.
	 */
	@Autowired
	private SalesRepository salesRepository;

	/**
	 * Salva o pedido de venda.
	 *
	 * @param sales
	 * @return
	 */
	public Sales save(final Sales sales) {
		return this.salesRepository.save(sales);
	}

	/**
	 * Atualiza o pedido de venda.
	 *
	 * @param id
	 * @param sales
	 *
	 * @return
	 */
	public Sales update(final Long id, final Sales sales) {
		final Sales salesToUpdate = this.getById(id);
		BeanUtils.copyProperties(salesToUpdate, sales, "id");
		this.salesRepository.save(salesToUpdate);
		return salesToUpdate;
	}

	/**
	 * Retorna o pedido de venda por ID.
	 *
	 * @param id
	 *
	 * @return
	 */
	public Sales getById(final Long id) {
		final Sales sales = this.salesRepository.getOne(id);

		if (Validator.isEmpty(sales)) {
			throw new EmptyResultDataAccessException(1);
		}
		return sales;
	}

	/**
	 * Remove pedido de venda por id.
	 *
	 * @param id
	 */
	public void remove(final Long id) {
		this.salesRepository.deleteById(id);
	}

	/**
	 * Lista os pedidos de vendas com filtro.
	 *
	 * @param filter
	 * @param pageable
	 *
	 * @return
	 */
	public Page<Sales> list(final SalesFilter filter, final Pageable pageable) {
		return this.salesRepository.list(filter, pageable);
	}
}
