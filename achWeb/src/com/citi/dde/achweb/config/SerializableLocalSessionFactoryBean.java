/**
 * 
 */
package com.citi.dde.achweb.config;

import java.io.Serializable;

/**
 * This class is used in hibernate configuration
 * @author mj84168
 *
 */
public class SerializableLocalSessionFactoryBean extends org.springframework.orm.hibernate4.LocalSessionFactoryBean implements Serializable {

	private static final long serialVersionUID = 7483922058324565898L;

}
