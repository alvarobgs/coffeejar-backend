package br.com.abg.coffeejar.api.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entidade para país.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(of = { "name" }, callSuper = false)
@Table(name = "country")
public class Country extends AbstractModel {

	/**
	 * Nome.
	 */
	@Getter
	@Setter
	@NotEmpty
	@Size(min = 2, max = 100)
	@Column(name = "name", length = 100, unique = true, nullable = false)
	private String name;

	/**
	 * Sigla.
	 */
	@Getter
	@Setter
	@NotEmpty
	@Size(min = 2, max = 5)
	@Column(name = "abbreviation", length = 5, unique = true, nullable = false)
	private String abbreviation;

	/**
	 * Código telefonico do país.
	 */
	@Getter
	@Setter
	@NotEmpty
	@Size(min = 1, max = 5)
	@Column(name = "calling_code", length = 5, nullable = false)
	private Integer callingCode;

	/**
	 * Lista de estados.
	 */
	@Getter
	@Setter
	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	private List<State> states;
}
