package br.com.abg.coffeejar.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.Getter;
import lombok.Setter;

/**
 * Entidade para cidade.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@Table(name = "city", uniqueConstraints = {@UniqueConstraint(columnNames = { "name", "state_id" }, name = "uq_city")})
public class City extends AbstractModel {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_city_";

	/**
	 * Código do IBGE.
	 */
	@Getter
	@Setter
	@Size(max = 10)
	@Column(name = "ibge_code", length = 10)
	private String ibgeCode;

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
	 * Estado.
	 */
	@Getter
	@Setter
	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "state_id", foreignKey = @ForeignKey(name = FK + "state"), nullable = false)
	private State state;

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(name).append(state).toHashCode();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof City))
			return false;
		final City city = (City) o;
		return new EqualsBuilder().append(name, city.name).append(state, city.state).isEquals();
	}
}
