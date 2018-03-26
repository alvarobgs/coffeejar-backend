package br.com.abg.coffeejar.api.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Tratador de exceções.
 *
 * @author <a href="mail:alvaro.govone@waiodev.com.br">Alvaro Govone</a>
 *
 * @since 1.0.0
 */
@ControllerAdvice
public class CoffeeJarExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Injeção para as mensagens.
	 */
	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		return handleExceptionInternal(ex, this.generateErrorAsList("invalid.message", ExceptionUtils.getRootCauseMessage(ex)), headers, HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		return handleExceptionInternal(ex, this.generateErrorList(ex.getBindingResult()), headers, HttpStatus.BAD_REQUEST, request);
	}

	/**
	 * Tratamento de exceção de resultado não encontrado.
	 *
	 * @param ex
	 * @param request
	 */
	@ExceptionHandler({ EmptyResultDataAccessException.class })
	protected void handleEmptyResultDataAccessException(final EmptyResultDataAccessException ex, final WebRequest request) {
		handleExceptionInternal(ex, this.generateErrorAsList("resource.not.found", ExceptionUtils.getRootCauseMessage(ex)), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	/**
	 * Tratamento de exceção de violação de dados.
	 *
	 * @param ex
	 * @param request
	 */
	@ExceptionHandler({ DataIntegrityViolationException.class })
	protected void handleDataIntegrityViolationException(final DataIntegrityViolationException ex, final WebRequest request) {
		handleExceptionInternal(ex, this.generateErrorAsList("not.allowed.operation", ExceptionUtils.getRootCauseMessage(ex)), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	/**
	 * Gera lista de erros
	 *
	 * @return
	 */
	private List<Error> generateErrorList(final BindingResult bindingResult) {
		final List<Error> errors = new ArrayList<>();

		for (final FieldError fieldError : bindingResult.getFieldErrors()) {
			final String endUserMessage = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			final String developerMessage = fieldError.toString();
			errors.add(new Error(endUserMessage, developerMessage));
		}
		return errors;
	}

	/**
	 * Gera um novo erro com as mensagens em forma de lista.
	 *
	 * @param bundleKey
	 * @param devMsg
	 */
	private List<Error> generateErrorAsList(final String bundleKey, final String devMsg) {
		final String msg = messageSource.getMessage(bundleKey, null, LocaleContextHolder.getLocale());
		final Error error = new Error(msg, devMsg);
		return Arrays.asList(error);
	}
}
