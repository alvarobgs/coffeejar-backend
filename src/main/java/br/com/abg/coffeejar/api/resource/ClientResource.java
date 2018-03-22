package br.com.abg.coffeejar.api.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public void save(@RequestBody final Client client, final HttpServletResponse response) {
		final Client savedClient = this.clientRepository.save(client);

		final URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{code}")
											 .buildAndExpand(savedClient.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}
}
