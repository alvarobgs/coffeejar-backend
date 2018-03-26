package br.com.abg.coffeejar.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.abg.coffeejar.api.model.Client;
import br.com.abg.coffeejar.api.repository.ClientRepository;
import br.com.abg.coffeejar.api.repository.filter.ClientFilter;
import br.com.abg.coffeejar.api.utils.Validator;

/**
 * Serviço para a entidade cliente.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Service
public class ClientService {

	/**
	 * Injeção do repositório para a entidade cliente.
	 */
	@Autowired
	private ClientRepository clientRepository;

	/**
	 * Salva o cliente.
	 *
	 * @param client
	 * @return
	 */
	public Client save(final Client client) {
		return this.clientRepository.save(client);
	}

	/**
	 * Atualiza o cliente.
	 *
	 * @param id
	 * @param client
	 *
	 * @return
	 */
	public Client update(final Long id, final Client client) {
		final Client clientToUpdate = this.getById(id);
		BeanUtils.copyProperties(clientToUpdate, client, "id");
		this.clientRepository.save(clientToUpdate);
		return clientToUpdate;
	}

	/**
	 * Retorna o cliente por ID.
	 *
	 * @param id
	 *
	 * @return
	 */
	public Client getById(final Long id) {
		final Client client = this.clientRepository.getOne(id);

		if (Validator.isEmpty(client)) {
			throw new EmptyResultDataAccessException(1);
		}
		return client;
	}

	/**
	 * Remove cliente por id.
	 *
	 * @param id
	 */
	public void remove(final Long id) {
		this.clientRepository.deleteById(id);
	}

	/**
	 * Lista os clientes com filtro.
	 *
	 * @param filter
	 * @return
	 */
	public List<Client> list(final ClientFilter filter) {
		if (Validator.isEmpty(filter)) {
			return this.clientRepository.findAll();
		}
		return this.clientRepository.list(filter);
	}
}
