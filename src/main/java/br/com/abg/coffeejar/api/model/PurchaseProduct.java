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
@Table(name = "purchase_product", uniqueConstraints = @UniqueConstraint(name = "uq_purchase_product", columnNames = { "product_id", "purchase_id" }))
public class PurchaseProduct extends AbstractOrderProduct {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_purchase_product_";

	/**
	 * Compra.
	 */
	@Getter
	@Setter
	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "purchase_id", foreignKey = @ForeignKey(name = FK + "purchase"), nullable = false)
	private Purchase purchase;

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(product).append(purchase).toHashCode();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof PurchaseProduct))
			return false;
		final PurchaseProduct that = (PurchaseProduct) o;
		return new EqualsBuilder().append(product, that.product).append(purchase, that.purchase).isEquals();
	}
}
