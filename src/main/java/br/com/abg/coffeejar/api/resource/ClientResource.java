package br.com.abg.coffeejar.api.resource;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.abg.coffeejar.api.event.GeneratedResourceEvent;
import br.com.abg.coffeejar.api.model.Client;
import br.com.abg.coffeejar.api.repository.filter.ClientFilter;
import br.com.abg.coffeejar.api.service.ClientService;

/**
 *
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/clients")
public class ClientResource {

	/**
	 * Injeção do serviço da entidade cliente.
	 */
	@Autowired
	private ClientService clientService;

	/**
	 * Publicação de eventos.
	 */
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public Page<Client> list(final ClientFilter filter, final Pageable pageable) {
		return this.clientService.list(filter, pageable);
	}

	@GetMapping("/{id}")
	public Client getById(@PathVariable final Long id) {
		return this.clientService.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Client> save(@Valid @RequestBody final Client client, final HttpServletResponse response) {
		final Client savedClient = this.clientService.save(client);
		publisher.publishEvent(new GeneratedResourceEvent(this, response, savedClient.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable final Long id) {
		this.clientService.remove(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@PathVariable final Long id, @Valid @RequestBody final Client client) {
		return ResponseEntity.ok(this.clientService.update(id, client));
	}
}
