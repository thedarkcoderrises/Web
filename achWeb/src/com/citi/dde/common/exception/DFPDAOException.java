package com.citi.dde.common.exception;

/**
 * This exception custom class for database access object exception for DFP
 * application
 * 
 * @author ap15253
 *
 */
public class DFPDAOException extends Exception {

	private static final long serialVersionUID = 4341700128826438959L;

	private String  errorMessage = "DFP MSG DAO Exception: [";

	/**
	 * Creates a new instance of <code>CSDAOException</code> without detail
	 * message.
	 */
	public DFPDAOException() {
		super();
	}

	/**
	 * Constructs an instance of <code>CSDAOException</code> with the specified
	 * detail message.
	 * 
	 * @param msg
	 *            the detail message.
	 */
	public DFPDAOException(String msg) {
		super(msg);
		this.errorMessage += msg;
	}

	/**
	 * @param exception
	 */
	public DFPDAOException(Exception exception) {
		super(exception);
		this.errorMessage += exception.toString();
	}

	/**
	 * @param throwable
	 */
	public DFPDAOException(Throwable throwable) {
		super(throwable);
		this.errorMessage += throwable.toString();
	}

	@Override
	public String toString() {
		return this.errorMessage + " ]";
	}
}