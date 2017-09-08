package com.citi.dde.achweb.config;

import java.util.Properties;

import javax.sql.DataSource;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.Log4jConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.citi.dde.common.util.CommonUtil;
import com.citi.dde.common.util.CsConstants;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@PropertySources({ @PropertySource("file:${CONFIG_PATH_ACH}/DB.properties"),
@PropertySource("file:${CONFIG_PATH_ACH}/hibernate.properties") })
@ComponentScan(basePackages = "com.citi.dde.*")
public class WebAppConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	Environment prop;

	@Bean
	public DataSource connectionPool() throws Exception {

		String host = prop.getProperty("db.host");
		String port = prop.getProperty("db.port");
		String hostString = prop.getProperty("db.hostString");
		String userName = prop.getProperty("db.userName");
		String minPoolSize = prop.getProperty("db.minPoolSize");
		String maxPoolSize = prop.getProperty("db.maxPoolSize");
		String driverManager = prop.getProperty("db.driverManager");

		PoolDataSource cpds = new PoolDataSourceImpl();
		cpds.setURL(CommonUtil.trim(CsConstants.urlPrefix + host + CsConstants.COLON + port + "/" + hostString));
		cpds.setUser(CommonUtil.trim(userName));
		cpds.setPassword("LA0DcDRx");// --UAT

		// cpds.setPassword(PWPDecrptor.getPWPDecrypt(userName, hostString,
		// scriptPath));
		cpds.setConnectionWaitTimeout(240);
		cpds.setInitialPoolSize(Integer.valueOf(minPoolSize));
		cpds.setMinPoolSize(Integer.valueOf(minPoolSize));
		cpds.setMaxPoolSize(Integer.valueOf(maxPoolSize));
		cpds.setAbandonedConnectionTimeout(240);
		cpds.setMaxIdleTime(240);
		cpds.setConnectionFactoryClassName(CommonUtil.trim(driverManager));
		return cpds;
	}

	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

	@Bean()
	@Autowired
	@Lazy(true)
	public SerializableLocalSessionFactoryBean sessionFactory(DataSource connectionPool) {
		SerializableLocalSessionFactoryBean bean = new SerializableLocalSessionFactoryBean();
		bean.setDataSource(connectionPool);
		Properties hibernateProps = new Properties();
		hibernateProps.put("hibernate.dialect", prop.getProperty("hibernate.dialect").trim());
		hibernateProps.put("hibernate.hbm2ddl.auto", prop.getProperty("hibernate.hbm2ddl.auto").trim());
		hibernateProps.put("hibernate.show_sql",true);
		hibernateProps.put("hibernate.format_sql",false);
		hibernateProps.put("hibernate.generate_statistics", prop.getProperty("hibernate.generate_statistics").trim());
		hibernateProps.put("hibernate.jdbc.batch_size", prop.getProperty("hibernate.jdbc.batch_size").trim());
		hibernateProps.put("hibernate.use_sql_comments",prop.getProperty("hibernate.use_sql_comments").trim());
		hibernateProps.put("hibernate.cache.use_second_level_cache", prop.getProperty("hibernate.cache.use_second_level_cache").trim());
		hibernateProps.put("hibernate.cache.use_query_cache",prop.getProperty("hibernate.cache.use_query_cache").toString());
		hibernateProps.put("hibernate.connection.release_mode", prop.getProperty("hibernate.connection.release_mode").trim());
		bean.setHibernateProperties(hibernateProps);
		bean.setPackagesToScan(prop.getProperty("hibernate.package.scan").trim());
		return bean;
	}
	
	@Bean
	JdbcTemplate jdbcTemplate(DataSource connectionPool){
		return new JdbcTemplate(connectionPool);
	}
	
	
	@Bean 
	public UrlBasedViewResolver viewResolver() { 
	    UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
	    viewResolver.setViewClass(TilesView.class);
	    return viewResolver;
	} 
	
	@Bean
	TilesConfigurer tilesConfigurer(){
		TilesConfigurer tc= 	new TilesConfigurer();
		tc.setDefinitions(getDefinations());
	    tc.setCheckRefresh(true);
		return tc;
	}

	private String[] getDefinations() {
		String[] tileDefs = new String[]{"/WEB-INF/tiles.xml"};
		return tileDefs ;
	}

	@Bean
	MethodInvokingFactoryBean log4jInitializer(){
		MethodInvokingFactoryBean mifb = new MethodInvokingFactoryBean();
		mifb.setTargetClass(Log4jConfigurer.class);
		mifb.setTargetMethod("initLogging");
		mifb.setArguments(new Object[]{"file:${CONFIG_PATH_ACH}/log4j.xml"});
		return mifb;
	}
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/css/**").addResourceLocations("/resources/css/");
	    registry.addResourceHandler("/resources/images/**").addResourceLocations("/resources/images/");
	    registry.addResourceHandler("/resources/js/**").addResourceLocations("/resources/js/");
	    registry.addResourceHandler("/resources/customjs/**").addResourceLocations("/resources/customjs/");
	}

}
