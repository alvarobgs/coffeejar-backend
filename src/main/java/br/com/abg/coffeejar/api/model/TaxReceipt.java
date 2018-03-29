package br.com.abg.coffeejar.api.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entidade para nota fiscal.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@Entity
@Table(name = "tax_receipt")
public class TaxReceipt extends AbstractModel {
}
