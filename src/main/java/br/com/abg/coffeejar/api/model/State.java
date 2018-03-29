package br.com.abg.coffeejar.api.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
 * Entidade para estado.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@Table(name = "state", uniqueConstraints = {@UniqueConstraint(columnNames = { "name", "country_id" }, name = "uq_state")})
public class State extends AbstractModel {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_state_";

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
	@Column(name="name", length = 100)
	private String name;

	/**
	 * UF.
	 */
	@Getter
	@Setter
	@NotEmpty
	@Size(min = 2, max = 10)
	@Column(name="uf", length = 10)
	private String uf;

	/**
	 * País.
	 */
	@Getter
	@Setter
	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "country_id", foreignKey = @ForeignKey(name = FK + "country"))
	private Country country;

	/**
	 * Lista de cidades.
	 */
	@Getter
	@Setter
	@OneToMany(mappedBy = "state", fetch = FetchType.LAZY)
	private List<City> cities;

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(name).append(country).toHashCode();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof State))
			return false;
		final State state = (State) o;
		return new EqualsBuilder().append(name, state.name).append(country, state.country).isEquals();
	}
}
