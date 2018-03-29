package br.com.abg.coffeejar.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.Getter;
import lombok.Setter;

/**
 * Entidade para contato.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@Table(name = "contact")
public class Contact extends AbstractModel {

	/**
	 * Telefone.
	 */
	@Getter
	@Setter
	@Size(max = 20)
	@Column(name = "phone", length = 20)
	private String phone;

	/**
	 * Celular.
	 */
	@Getter
	@Setter
	@Size(max = 20)
	@Column(name = "mobile", length = 20)
	private String mobile;

	/**
	 * Site.
	 */
	@Getter
	@Setter
	@Size(max = 100)
	@Column(name = "web_site", length = 100)
	private String webSite;

	/**
	 * E-mail.
	 */
	@Getter
	@Setter
	@Size(max = 100)
	@Column(name = "mail", length = 100)
	private String mail;

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(phone).append(mobile).append(webSite).append(mail).toHashCode();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;

		if (!(o instanceof Contact))
			return false;

		final Contact contact = (Contact) o;

		return new EqualsBuilder().append(phone, contact.phone).append(mobile, contact.mobile).append(webSite, contact.webSite).append(mail, contact.mail).isEquals();
	}
}
