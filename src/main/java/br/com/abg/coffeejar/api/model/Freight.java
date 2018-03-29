package br.com.abg.coffeejar.api.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entidade para produtos do orçamento.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@ToString(callSuper = true)
@Table(name = "freight")
public class Freight extends AbstractModel {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_freight_";

	/**
	 * Observação.
	 */
	@Getter
	@Setter
	@Size(max = 500)
	@Column(name = "observation", length = 500)
	private String observation;

	/**
	 * Dias para previsão de entrega.
	 */
	@Getter
	@Setter
	@Column(name = "delivery_forecast")
	private int deliveryForecast;

	/**
	 * Valor do frete.
	 */
	@Getter
	@Setter
	@NotEmpty
	@Column(name = "value", precision = 2, scale = 8, nullable = false)
	private BigDecimal value;

	/**
	 * Endereço cadastrado para o frete.
	 */
	@Getter
	@Setter
	@JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = FK + "address"))
	private Address address;
}
