package br.com.abg.coffeejar.api.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

/**
 *
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
public class GeneratedResourceEvent extends ApplicationEvent {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = -1748826560205497301L;

	/**
	 *
	 */
	@Getter
	private HttpServletResponse response;

	/**
	 *
	 */
	@Getter
	private Long id;

	/**
	 *
	 * @param source
	 * @param response
	 * @param id
	 */
	public GeneratedResourceEvent(final Object source, final HttpServletResponse response, final Long id) {
		super(source);
		this.response = response;
		this.id = id;
	}
}
