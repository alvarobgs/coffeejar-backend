package br.com.abg.coffeejar.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.abg.coffeejar.api.enumeration.AddressType;

import lombok.Getter;
import lombok.Setter;

/**
 * Entidade para endereço.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@Table(name = "address")
public class Address extends AbstractModel {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_address_";

	/**
	 * Logradouro.
	 */
	@Getter
	@Setter
	@NotEmpty
	@Size(min = 2, max = 100)
	@Column(name = "place", length = 100, nullable = false)
	private String place;

	/**
	 * Número.
	 */
	@Getter
	@Setter
	@NotEmpty
	@Size(min = 1, max = 20)
	@Column(name = "number", length = 20, nullable = false)
	private String number;

	/**
	 * Bairro.
	 */
	@Getter
	@Setter
	@NotEmpty
	@Size(min = 2, max = 100)
	@Column(name = "district", length = 100, nullable = false)
	private String district;

	/**
	 * CEP.
	 */
	@Getter
	@Setter
	@Size(min = 2, max = 20)
	@Column(name = "zip_code", length = 20)
	private String zipCode;

	/**
	 * Complemento.
	 */
	@Getter
	@Setter
	@Size(max = 100)
	@Column(name = "complement", length = 100)
	private String complement;

	/**
	 * Tipo de endereço.
	 */
	@Getter
	@Setter
	@NotEmpty
	@Enumerated(EnumType.STRING)
	@Column(name = "address_type", nullable = false)
	private AddressType addressType;

	/**
	 * Cidade.
	 */
	@Getter
	@Setter
	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "city_id", foreignKey = @ForeignKey(name = FK + "city"), nullable = false)
	private City city;
}
