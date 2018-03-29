package br.com.abg.coffeejar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abg.coffeejar.api.model.Category;
import br.com.abg.coffeejar.api.repository.query.CategoryRepositoryQuery;

/**
 * Repositório para categoria de produto.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryRepositoryQuery {

}
