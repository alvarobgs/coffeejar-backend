package br.com.abg.coffeejar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abg.coffeejar.api.model.Country;
import br.com.abg.coffeejar.api.repository.query.CategoryRepositoryQuery;

/**
 * Repositório para país.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public interface CountryRepository extends JpaRepository<Country, Long>, CategoryRepositoryQuery {

}
