package br.com.abg.coffeejar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abg.coffeejar.api.model.State;
import br.com.abg.coffeejar.api.repository.query.StateRepositoryQuery;

/**
 * Repositório para estado.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public interface StateRepository extends JpaRepository<State, Long>, StateRepositoryQuery {

}
