package br.com.abg.coffeejar.api.event;

import java.net.URI;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 * @since 1.0.0
 */
@Component
public class GeneratedResourceListener implements ApplicationListener<GeneratedResourceEvent> {

	@Override
	public void onApplicationEvent(final GeneratedResourceEvent generatedResourceEvent) {
		final HttpServletResponse response = generatedResourceEvent.getResponse();
		final Long id = generatedResourceEvent.getId();

		final URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
												   .buildAndExpand(id).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}
}
