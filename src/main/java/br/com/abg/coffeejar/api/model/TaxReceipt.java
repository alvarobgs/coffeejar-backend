package br.com.abg.coffeejar.api.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Entidade para nota fiscal.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@Table(name = "tax_receipt")
public class TaxReceipt extends AbstractModel {
}
