package br.com.abg.coffeejar.api.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.Getter;
import lombok.Setter;

/**
 * Entidade para produtos do orçamento.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@Table(name = "budget_product", uniqueConstraints = @UniqueConstraint(name = "uq_budget_product", columnNames = { "product_id", "budget_id" }))
public class BudgetProduct extends AbstractOrderProduct {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_budget_product_";

	/**
	 * Orçamento.
	 */
	@Getter
	@Setter
	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "budget_id", foreignKey = @ForeignKey(name = FK + "budget"), nullable = false)
	private Budget budget;

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(product).append(budget).toHashCode();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof BudgetProduct))
			return false;
		final BudgetProduct that = (BudgetProduct) o;
		return new EqualsBuilder().append(product, that.product).append(budget, that.budget).isEquals();
	}
}
