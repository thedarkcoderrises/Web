package com.citi.dde.common.exception;

/**
 * This class is used to handle the service and controller layer exception for
 * application
 * 
 * @author ap15253(Ankita Pal)
 *
 */
public class DFPException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errosMessage = "DFP MSG Exception: [";

	/**
	 * Creates a new instance of <code>DFPException</code> without detail
	 * message.
	 */
	public DFPException() {
		super();
	}

	/**
	 * Constructs an instance of <code>DFPException</code> with the specified
	 * detail message.
	 * 
	 * @param msg
	 *            the detail message.
	 */
	public DFPException(String msg) {
		super(msg);
		this.errosMessage += msg;
	}

	public DFPException(Exception exception) {
		super(exception);
		this.errosMessage += exception.toString();
	}

	public DFPException(Throwable throwable) {
		super(throwable);
		this.errosMessage += throwable.toString();
	}

	public String toString() {
		return this.errosMessage + " ]";
	}

}
