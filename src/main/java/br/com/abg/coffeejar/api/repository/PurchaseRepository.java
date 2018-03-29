package br.com.abg.coffeejar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abg.coffeejar.api.model.Purchase;
import br.com.abg.coffeejar.api.repository.query.PurchaseRepositoryQuery;

/**
 * Repositório para pedido de compra.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public interface PurchaseRepository extends JpaRepository<Purchase, Long>, PurchaseRepositoryQuery {

}
