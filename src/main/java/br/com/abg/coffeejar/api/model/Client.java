package br.com.abg.coffeejar.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.abg.coffeejar.api.enumeration.PersonType;

import lombok.Getter;
import lombok.Setter;

/**
 * Entidade para clientes.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 * @since 1.0.0
 */
@Entity
@Table(name = "client")
public class Client extends AbstractEntity {

	/**
	 * Nome do cliente.
	 */
	@Getter
	@Setter
	@NotNull
	@Size(max = 100)
	@Column(name = "name", length = 100, nullable = false)
	private String name;

	/**
	 * Tipo de pessoa.
	 */
	@Getter
	@Setter
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "person_type", length = 25, nullable = false)
	private PersonType personType;


	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Client))
			return false;

		final Client client = (Client) o;

		if (!name.equals(client.name))
			return false;
		return personType == client.personType;
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + personType.hashCode();
		return result;
	}
}
