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
 * Entidade para produtos da compra.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@Table(name = "sales_product", uniqueConstraints = @UniqueConstraint(name = "uq_sales_product", columnNames = { "product_id", "sales_id" }))
public class SalesProduct extends AbstractOrderProduct {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_sales_product_";

	/**
	 * Compra.
	 */
	@Getter
	@Setter
	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "sales_id", foreignKey = @ForeignKey(name = FK + "sales"), nullable = false)
	private Sales sales;

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(product).append(sales).toHashCode();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof SalesProduct))
			return false;
		final SalesProduct that = (SalesProduct) o;
		return new EqualsBuilder().append(product, that.product).append(sales, that.sales).isEquals();
	}
}
