package br.com.abg.coffeejar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abg.coffeejar.api.model.City;
import br.com.abg.coffeejar.api.repository.query.CityRepositoryQuery;

/**
 * Repositório para cidade.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public interface CityRepository extends JpaRepository<City, Long>, CityRepositoryQuery {

}
