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
 * Entidade para produtos do orçamento.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(of = { "budget", "orderProduct" }, callSuper = false)
@Table(name = "budget_product", uniqueConstraints = @UniqueConstraint(name = "uq_budget_product", columnNames = { "product_id", "budget_id" }))
public class BudgetProduct extends AbstractModel {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_budget_product_";

	/**
	 * Produto
	 */
	@Getter
	@Setter
	@Embedded
	private OrderProduct orderProduct;

	/**
	 * Orçamento.
	 */
	@Getter
	@Setter
	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "budget_id", foreignKey = @ForeignKey(name = FK + "budget"), nullable = false)
	private Budget budget;

	/**
	 * Construtor.
	 */
	public BudgetProduct() {
		this.orderProduct = new OrderProduct();
	}
}
