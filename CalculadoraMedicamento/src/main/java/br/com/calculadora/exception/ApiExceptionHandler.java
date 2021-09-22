package br.com.calculadora.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	// @Override
	// protected ResponseEntity<Object>
	@ExceptionHandler(value = FormNomeException.class)
	public ResponseEntity<Object> formNomeExceptionHandler(HttpServletRequest req, FormNomeException ex) {
		String errorMsg = "campo nome não foi preenchido.";
		FormError formError = new FormError(HttpStatus.BAD_REQUEST, errorMsg, ex);
		return defineResponseEntity(formError);
	}

	private ResponseEntity<Object> defineResponseEntity(FormError formError) {
		return new ResponseEntity<>(formError, formError.getStatus());
	}

}
