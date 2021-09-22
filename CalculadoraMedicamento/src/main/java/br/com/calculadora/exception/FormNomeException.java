package br.com.calculadora.exception;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor // construtor para todos os atributos
@Accessors(chain = true) // gera os getters e setters
public class FormNomeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
