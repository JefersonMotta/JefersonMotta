package br.com.calculadora.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FormError {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime time;
	private String message;
	private HttpStatus status;

	public FormError() {
		time = LocalDateTime.now();
	}

	FormError(HttpStatus status) {
		this();
		this.status = status;
	}

	FormError(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.message = "Unexpected error";
	}

	FormError(HttpStatus status, String message, Throwable ex) {
		this();
		this.status = status;
		this.message = message;
	}

	// getters
	public LocalDateTime getTime() {
		return time;
	}

	public String getMsg() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
