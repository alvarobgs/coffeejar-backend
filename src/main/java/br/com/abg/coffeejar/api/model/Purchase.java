package br.com.abg.coffeejar.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

/**
 * Entidade para pedido de compra.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@Table(name = "purchase")
public class Purchase extends AbstractOrder {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_purchase_";

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
		super.date = new Date();
		super.freight = new Freight();
		this.products = new ArrayList<>();
	}
}
