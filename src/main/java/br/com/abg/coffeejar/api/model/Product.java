package br.com.abg.coffeejar.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Entidade para produto.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@Table(name = "product")
public class Product extends AbstractModel {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_product_";

	/**
	 * Nome.
	 */
	@Getter
	@Setter
	@NotEmpty
	@Size(min = 5, max = 100)
	@Column(name = "name", length = 100, nullable = false)
	private String name;

	/**
	 * Categoria.
	 */
	@Getter
	@Setter
	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = FK + "category"), nullable = false)
	private Category category;
}
