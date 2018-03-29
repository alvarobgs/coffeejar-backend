package br.com.abg.coffeejar.api.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entidade para pedido de compra.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(of = { "order" }, callSuper = false)
@Table(name = "purchase")
public class Purchase extends AbstractModel {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_purchase_";

	/**
	 * Ordem.
	 */
	@Getter
	@Setter
	@Embedded
	private Order order;

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
	@OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PurchaseProduct> products;

	/**
	 * Construtor.
	 */
	public Purchase() {
		this.order = new Order();
		this.products = new ArrayList<>();
	}
}
