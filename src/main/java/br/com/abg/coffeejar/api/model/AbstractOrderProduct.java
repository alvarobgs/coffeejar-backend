package br.com.abg.coffeejar.api.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Modelo abstrato para produto de compra, venda, orcamento
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 * @since 1.0.0
 */
@MappedSuperclass
public abstract class AbstractOrderProduct extends AbstractModel {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_abstract_order_product_";

	/**
	 * Produto.
	 */
	@Getter
	@Setter
	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = FK + "product"), nullable = false)
	protected Product product;

	/**
	 * Descrição.
	 */
	@Getter
	@Setter
	@Size(max = 500)
	@Column(name = "description", length = 500)
	protected String description;

	/**
	 * Quantidade.
	 */
	@Getter
	@Setter
	@NotEmpty
	@Column(name = "quantity", nullable = false)
	protected int quantity;

	/**
	 * Valor Unitário.
	 */
	@Getter
	@Setter
	@NotEmpty
	@Column(name = "unit_value", precision = 2, scale = 8, nullable = false)
	protected BigDecimal unitValue;
}
