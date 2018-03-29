package br.com.abg.coffeejar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abg.coffeejar.api.model.Budget;
import br.com.abg.coffeejar.api.repository.query.BudgetRepositoryQuery;

/**
 * Repositório para orçamento.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public interface BudgetRepository extends JpaRepository<Budget, Long>, BudgetRepositoryQuery {

}
