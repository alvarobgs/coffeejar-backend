package br.com.abg.coffeejar.api.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

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
@Table(name = "contact")
public class Contact extends AbstractModel {

	/**
	 * Nome do contato.
	 */
	@Getter
	@Setter
	@Size(max = 100)
	@Column(name = "name", length = 100)
	private String name;

	/**
	 * Itens de contato.
	 */
	@Getter
	@Setter
	@Size(max = 20)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ContactItem> items;

	/**
	 * Construtor.
	 */
	public Contact() {
		this.items = new ArrayList<>();
	}
}
