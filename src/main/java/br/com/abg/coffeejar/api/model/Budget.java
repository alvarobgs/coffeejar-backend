package br.com.abg.coffeejar.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

/**
 * Entidade para orçamento.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@Table(name = "budget")
public class Budget extends AbstractOrder {

	/**
	 * Constante para chave estrangeira.
	 */
	@Transient
	private static final transient String FK = "fk_budget_";

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
	 * Lista de produtos do orçamento.
	 */
	@Getter
	@Setter
	@OneToMany(mappedBy = "budget", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BudgetProduct> products;

	/**
	 * Construtor.
	 */
	public Budget() {
		super.date = new Date();
		super.freight = new Freight();
		this.products = new ArrayList<>();
	}
}
