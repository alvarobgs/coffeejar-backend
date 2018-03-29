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
@EqualsAndHashCode(of = { "sales", "orderProduct" }, callSuper = false)
@Table(name = "sales_product", uniqueConstraints = @UniqueConstraint(name = "uq_sales_product", columnNames = { "product_id", "sales_id" }))
public class SalesProduct extends AbstractModel {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_sales_product_";

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
	@JoinColumn(name = "sales_id", foreignKey = @ForeignKey(name = FK + "sales"), nullable = false)
	private Sales sales;

	/**
	 * Construtor.
	 */
	public SalesProduct() {
		this.orderProduct = new OrderProduct();
	}
}
