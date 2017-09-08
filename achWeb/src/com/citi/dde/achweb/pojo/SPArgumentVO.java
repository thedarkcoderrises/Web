package com.citi.dde.achweb.pojo;

import java.io.Serializable;

import com.citi.dde.achweb.dao.IResultsetMapper;


/**
 * This pojo class contain the properties for store procedures
 *
 * @author SP18738
 *
 */

public class SPArgumentVO implements Serializable{

	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = -5570388070177772161L;
	private String argumentName;
	private Object argumentValue;
	private String argumentMode;
	private String argumentType;
	private String specialTypeName;
	private IResultsetMapper rowMapper;
	
	/**
	 * @return the argumentName
	 */
	public String getArgumentName() {
		return argumentName;
	}
	/**
	 * @param argumentName the argumentName to set
	 */
	public void setArgumentName(String argumentName) {
		this.argumentName = argumentName;
	}
	/**
	 * @return the argumentValue
	 */
	public Object getArgumentValue() {
		return argumentValue;
	}
	/**
	 * @param argumentValue the argumentValue to set
	 */
	public void setArgumentValue(Object argumentValue) {
		this.argumentValue = argumentValue;
	}
	/**
	 * @return the argumentMode
	 */
	public String getArgumentMode() {
		return argumentMode;
	}
	/**
	 * @param argumentMode the argumentMode to set
	 */
	public void setArgumentMode(String argumentMode) {
		this.argumentMode = argumentMode;
	}
	/**
	 * @return the argumentType
	 */
	public String getArgumentType() {
		return argumentType;
	}
	/**
	 * @param argumentType the argumentType to set
	 */
	public void setArgumentType(String argumentType) {
		this.argumentType = argumentType;
	}
	/**
	 * @return the rowMapper
	 */
	public IResultsetMapper getRowMapper() {
		return rowMapper;
	}
	/**
	 * @param rowMapper the rowMapper to set
	 */
	public void setRowMapper(IResultsetMapper rowMapper) {
		this.rowMapper = rowMapper;
	}
	/**
	 * @return the specialTypeName
	 */
	public String getSpecialTypeName() {
		return specialTypeName;
	}
	/**
	 * @param specialTypeName the specialTypeName to set
	 */
	public void setSpecialTypeName(String specialTypeName) {
		this.specialTypeName = specialTypeName;
	}
	
	@Override
	public String toString() {
		return "SPArgumentVO [argumentName=" + argumentName + ", argumentValue=" + argumentValue + ", argumentMode="
				+ argumentMode + ", argumentType=" + argumentType + ", specialTypeName=" + specialTypeName
				+ ", rowMapper=" + rowMapper + "]";
	}


}
