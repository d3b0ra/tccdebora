package br.edu.ifms.salao.service.exception;

public class DataIntegrityException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataIntegrityException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

	public DataIntegrityException(String msg, Throwable cause) {
		// TODO Auto-generated constructor stub
		super(msg, cause);
	}
}
