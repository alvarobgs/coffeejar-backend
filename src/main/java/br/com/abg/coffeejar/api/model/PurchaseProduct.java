package br.com.abg.coffeejar.api.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entidade para produtos da compra.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(of = { "purchase", "orderProduct" }, callSuper = false)
@Table(name = "purchase_product", uniqueConstraints = @UniqueConstraint(name = "uq_purchase_product", columnNames = { "product_id", "purchase_id" }))
public class PurchaseProduct extends AbstractModel {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_purchase_product_";

	/**
	 * Produto
	 */
	@Getter
	@Setter
	@Embedded
	private OrderProduct orderProduct;

	/**
	 * Compra.
	 */
	@Getter
	@Setter
	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "purchase_id", foreignKey = @ForeignKey(name = FK + "purchase"), nullable = false)
	private Purchase purchase;

	/**
	 * Construtor.
	 */
	public PurchaseProduct() {
		this.orderProduct = new OrderProduct();
	}
}
