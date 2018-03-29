package br.com.abg.coffeejar.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.abg.coffeejar.api.enumeration.ContactItemType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entidade para contato.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(of = { "value", "type", "contact" }, callSuper = false)
@Table(name = "contact_item")
public class ContactItem extends AbstractModel {

	/**
	 * Valor
	 */
	@Getter
	@Setter
	@NotEmpty
	@Size(max = 20)
	@Column(name = "value", length = 20)
	private String value;

	/**
	 * Tipo de contato.
	 */
	@Getter
	@Setter
	@NotEmpty
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private ContactItemType type;

	/**
	 * Contato.
	 */
	@Getter
	@Setter
	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "contact_id", foreignKey = @ForeignKey(name = "fk_contact_item_contact"), nullable = false)
	private Contact contact;

}
