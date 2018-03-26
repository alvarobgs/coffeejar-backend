package br.com.abg.coffeejar.api.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.abg.coffeejar.api.event.GeneratedResourceEvent;
import br.com.abg.coffeejar.api.model.Client;
import br.com.abg.coffeejar.api.repository.ClientRepository;

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
	 *
	 */
	@Autowired
	private ClientRepository clientRepository;

	/**
	 *
	 */
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Client> list() {
		return this.clientRepository.findAll();
	}

	@GetMapping("/{id}")
	public Client getById(@PathVariable final Long id) {
		return this.clientRepository.getOne(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Client> save(@Valid @RequestBody final Client client, final HttpServletResponse response) {
		final Client savedClient = this.clientRepository.save(client);
		publisher.publishEvent(new GeneratedResourceEvent(this, response, savedClient.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable final Long id) {
		this.clientRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@PathVariable final Long id, @Valid @RequestBody final Client client) {
		final Client clientToUpdate = this.clientRepository.getOne(id);
		BeanUtils.copyProperties(clientToUpdate, client, "id");
		this.clientRepository.save(clientToUpdate);
		return ResponseEntity.ok(clientToUpdate);
	}
}
