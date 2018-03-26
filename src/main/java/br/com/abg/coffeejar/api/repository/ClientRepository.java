package br.com.abg.coffeejar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abg.coffeejar.api.model.Client;
import br.com.abg.coffeejar.api.repository.query.ClientRepositoryQuery;

/**
 *
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public interface ClientRepository extends JpaRepository<Client, Long>, ClientRepositoryQuery {

}
