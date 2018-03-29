package br.com.abg.coffeejar.api.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Modelo abstrato para pedido de compra, venda, orcamento
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 * @since 1.0.0
 */
@MappedSuperclass
public abstract class AbstractOrder extends AbstractModel {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_abstract_order_";

	/**
	 * Data.
	 */
	@Getter
	@Setter
	@NotEmpty
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false)
	protected Date date;

	/**
	 * Descrição.
	 */
	@Getter
	@Setter
	@Size(max = 500)
	@Column(name = "description", length = 500)
	protected String description;

	/**
	 * Condição de pagamento.
	 */
	@Getter
	@Setter
	@Size(max = 100)
	@Column(name = "payment_condition", length = 100)
	protected String paymentCondition;

	/**
	 * Frete.
	 */
	@Getter
	@Setter
	@NotEmpty
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "freight_id", foreignKey = @ForeignKey(name = FK + "freight"), nullable = false)
	protected Freight freight;
}
