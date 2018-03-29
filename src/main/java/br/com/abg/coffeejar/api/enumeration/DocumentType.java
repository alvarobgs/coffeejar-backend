package br.com.abg.coffeejar.api.enumeration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;

/**
 * Enum para tipo de documento.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public enum DocumentType {
	/**
	 * CNPJ.
	 */
	CNPJ(PersonType.JURIDICAL, true, false, "99.999.999/9999-99"),

	/**
	 * CPF.
	 */
	CPF(PersonType.INDIVIDUAL, true, false, "999.999.999-99"),

	/**
	 * Inscrição Estadual.
	 */
	IE(PersonType.JURIDICAL, false, false),

	/**
	 * Inscrição Estadual.
	 */
	IM(PersonType.JURIDICAL, false, false),

	/**
	 * RG.
	 */
	RG(PersonType.INDIVIDUAL, false, false),

	/**
	 * Documento para estrangeiro.
	 */
	OTHER(PersonType.INDIVIDUAL, true, true);

	/**
	 * Tipo de pessoa.
	 */
	@Getter
	private PersonType personType;

	/**
	 * Se o campo é obrigatório.
	 */
	@Getter
	private boolean required;

	/**
	 * Formato da máscara.
	 */
	@Getter
	private String mask;

	/**
	 * Se tipo de documento é de estrangeiro.
	 */
	@Getter
	private boolean foreign;

	/**
	 * Construtor privado.
	 */
	DocumentType() {

	}

	/**
	 * Construtor.
	 *
	 * @param personType Tipo de pessoa
	 * @param required Se o campo é obrigatório
	 * @param foreign Se é estrangeiro
	 */
	DocumentType(final PersonType personType, final boolean required, final boolean foreign) {
		this.personType = personType;
		this.required = required;
		this.foreign = foreign;
	}

	/**
	 * Construtor.
	 *
	 * @param personType Tipo de pessoa
	 * @param required Se o campo é obrigatório
	 * @param foreign Se é estrangeiro
	 * @param mask Formato da máscara
	 */
	DocumentType(final PersonType personType, final boolean required, final boolean foreign, final String mask) {
		this.personType = personType;
		this.required = required;
		this.foreign = foreign;
		this.mask = mask;
	}

	/**
	 * Filtra tipos de documento conforme o tipo da pessoa e nacionalidade.
	 *
	 * @param personType Tipo de pessoa
	 * @param foreign Se é estrangeiro
	 *
	 * @return {@link List} de {@link DocumentType}
	 */
	public static List<DocumentType> getDocumentTypeByPersonType(final PersonType personType, final boolean foreign) {
		return Arrays.stream(DocumentType.values()).filter(d -> d.getPersonType().equals(personType))
					 .filter(d -> d.foreign == foreign).collect(Collectors.toList());
	}
}
