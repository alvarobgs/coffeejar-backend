package br.com.abg.coffeejar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abg.coffeejar.api.model.Sales;
import br.com.abg.coffeejar.api.repository.query.SalesRepositoryQuery;

/**
 * Repositório para venda.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public interface SalesRepository extends JpaRepository<Sales, Long>, SalesRepositoryQuery {

}
