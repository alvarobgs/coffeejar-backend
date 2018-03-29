package br.com.abg.coffeejar.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.Getter;
import lombok.Setter;

/**
 * Categoria de produto.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 * @since 1.0.0
 */
@Entity
@Table(name = "category")
public class Category extends AbstractModel {

	/**
	 * Nome.
	 */
	@Getter
	@Setter
	@NotEmpty
	@Size(min = 5, max = 100)
	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(name).toHashCode();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Category))
			return false;
		final Category category = (Category) o;
		return new EqualsBuilder().append(name, category.name).isEquals();
	}
}
