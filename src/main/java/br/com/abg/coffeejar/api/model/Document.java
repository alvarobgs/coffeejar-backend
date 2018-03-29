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

import br.com.abg.coffeejar.api.enumeration.DocumentType;
import br.com.abg.coffeejar.api.utils.Validator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entidade para documento.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(of = { "number", "documentType" }, callSuper = false)
@Table(name = "document")
public class Document extends AbstractModel {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_document_";

	/**
	 * Número.
	 */
	@Getter
	@Setter
	@NotEmpty
	@Size(min = 5, max = 20)
	@Column(name = "number", length = 20, nullable = false)
	private String number;

	/**
	 * Tipo de documento.
	 */
	@Getter
	@Setter
	@NotEmpty
	@Enumerated(EnumType.STRING)
	@Column(name = "document_type", length = 25, nullable = false)
	private DocumentType documentType;

	/**
	 * Órgão emissor.
	 */
	@Getter
	@Setter
	@Column(name = "organ_issuer", length = 10)
	private String organIssuer;

	/**
	 * Cliente.
	 */
	@Getter
	@Setter
	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "client_id", foreignKey = @ForeignKey(name = FK + "client"), nullable = false)
	private Client client;

	/**
	 * Verifica se o documento é obrigatório.
	 *
	 * @return
	 */
	public boolean isRequired() {
		return !Validator.isEmpty(this.documentType) && this.documentType.isRequired();
	}
}
