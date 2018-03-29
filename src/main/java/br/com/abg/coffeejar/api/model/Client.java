package br.com.abg.coffeejar.api.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.abg.coffeejar.api.enumeration.PersonType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entidade para clientes.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(of = { "name", "personType" }, callSuper = false)
@Table(name = "client")
public class Client extends AbstractModel {

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

	/**
	 * Documentos.
	 */
	@Getter
	@Setter
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Document> documents;

	/**
	 * Contatos.
	 */
	@Getter
	@Setter
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Contact> contacts;

	/**
	 * Endereços.
	 */
	@Getter
	@Setter
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Address> addresses;

	/**
	 * Construtor.
	 */
	public Client() {
		this.addresses = new ArrayList<>();
		this.contacts = new ArrayList<>();
		this.documents = new ArrayList<>();
	}
}
