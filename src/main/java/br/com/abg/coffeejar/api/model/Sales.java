package br.com.abg.coffeejar.api.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entidade para venda.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(of = { "order", "client" }, callSuper = false)
@Table(name = "sales")
public class Sales extends AbstractModel {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_sales_";

	/**
	 * Ordem.
	 */
	@Getter
	@Setter
	@Embedded
	private Order order;

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
	 * Nota fiscal
	 */
	@Getter
	@Setter
	@OneToOne
	@JoinColumn(name = "tax_receipt_id", foreignKey = @ForeignKey(name = FK + "tax_receipt"))
	private TaxReceipt taxReceipt;

	/**
	 * Lista de produtos da venda.
	 */
	@Getter
	@Setter
	@OneToMany(mappedBy = "sales", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SalesProduct> products;

	/**
	 * Construtor.
	 */
	public Sales() {
		this.order = new Order();
		this.products = new ArrayList<>();
	}
}
