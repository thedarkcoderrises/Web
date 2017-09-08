package com.citi.dde.achweb.dao.daoimpl;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.citi.dde.achweb.dao.GenericDao;
import com.citi.dde.achweb.pojo.SPArgumentVO;

import oracle.jdbc.OracleTypes;





public class GenericDaoImpl<T, P extends Serializable> implements GenericDao<T, P> {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
    public void save(T t) {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public void update(T t) {
        sessionFactory.getCurrentSession().update(t);
    }

    @Override
    public void saveOrUpdate(T t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
    }

    @Override
    public void delete(T t) {
        sessionFactory.getCurrentSession().delete(t);
    }

    @Override
    public T findOneByExample(T t, P p) {
        try {
            sessionFactory.getCurrentSession().load(t, p);
            return t;
        } catch (Exception ex) {
            Logger.getLogger(t.getClass(), "No data found");
        }
        return null;
    }

    @Override
    public int countRecords(Class<T> c, String string) {
        return sessionFactory.getCurrentSession().createCriteria(c, string).list().size();
    }

    @Override
    public T findOneByQuery(String string)  {
        T t = null;
        List<T> list = sessionFactory.getCurrentSession().createQuery(string).list();
        if (list.size() > 1) {
            throw new RuntimeException("No record found in database when expected.");
        } else if (list.size() == 1) {
            t = list.get(0);
        }
        return t;
    }
    
    @Override
    public List<T> findByParam(String string,Object[] values) {
        T t = null;
        Query query = sessionFactory.getCurrentSession().createQuery(string);
        for(int i=0;i < values.length;i++)
        {
        	query.setParameter(i, values[i]);
        }
        List<T> list = query.list();
        return list;
    }
    
    @Override
    public List<T> findByNamedParam(String string,Map<String,Object> valueMap)  {
        T t = null;
        Query query = sessionFactory.getCurrentSession().createQuery(string);
        for (Map.Entry<String, Object> entry : valueMap.entrySet()) {
        	query.setParameter(entry.getKey(), entry.getValue());
        }
        List<T> list = query.list();
        return list;
    }

    @Override
    public List<T> findAllByQuery(String string) {
        return sessionFactory.getCurrentSession().createQuery(string).list();
    }

    @Override
    public List<T> findAllBySQLQuery(String string) {
        return sessionFactory.getCurrentSession().createSQLQuery(string).list();
    }

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public List<T> findByPaging(String string,Integer page, Integer rows,String sort,String order,String clause) {
    	Session session = sessionFactory.getCurrentSession();
    	int index;
    	String qry = null;
        
		Class clazz;
		try {
			clazz = Class.forName(string);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Class not found.");
		}
		
		if((clause != null) && !clause.equals(""))	
		{
			if(clause.contains("#"))
			{
				clause = clause.replaceAll("#"," and ");
			}
			qry=clause;
		}
		//CSLoggerImpl.logInfo(this.getClass(), "clause 123 - "+qry);
    	Criteria criteria ;
    	if(order.equalsIgnoreCase("asc"))
    	{
    		
    			if(qry!=null)
    			{
    				if(sort != null)
    				{
    					criteria = session.createCriteria(clazz).addOrder(Order.asc(sort)).add(Restrictions.sqlRestriction(qry));
    				}
    				else
    				{
    					criteria = session.createCriteria(clazz).add(Restrictions.sqlRestriction(qry));
    				}
    			}
    			else
    			{
    				if(sort != null)
    				{
    					criteria = session.createCriteria(clazz).addOrder(Order.asc(sort));
    				}
    				else
    				{
    					criteria = session.createCriteria(clazz);
    				}
    			}
    	}
    	else
    	{	
    		if(qry!=null)
			{
				if(sort != null)
				{
					criteria = session.createCriteria(clazz).addOrder(Order.desc(sort)).add(Restrictions.sqlRestriction(qry));
				}
				else
				{
					criteria = session.createCriteria(clazz).add(Restrictions.sqlRestriction(qry));
				}
			}
			else
			{
				if(sort != null)
				{
					criteria = session.createCriteria(clazz).addOrder(Order.desc(sort));
				}
				else
				{
					criteria = session.createCriteria(clazz);
				}
			}
    	}
    	if(null!=page && null!= rows){
    		criteria.setFirstResult((page-1)*rows);
        	criteria.setMaxResults(rows);
        }
    	return criteria.list();
    }
    
    @Override
    public List<T> findByPagingLoadOnce(String string,Integer page, Integer rows,String sort,String order,String clause) {
    	Session session = sessionFactory.getCurrentSession();
    	int index;
    	String qry = null;
        
		Class clazz;
		try {
			clazz = Class.forName(string);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Class not found.");
		}
		
		if((clause != null) && !clause.equals(""))	
		{
			if(clause.contains("#"))
			{
				clause = clause.replaceAll("#"," and ");
			}
			qry=clause;
		}
		//CSLoggerImpl.logInfo(this.getClass(), "clause 123 - "+qry);
    	Criteria criteria ;
    	if(order.equalsIgnoreCase("asc"))
    	{
    		
    			if(qry!=null)
    			{
    				if(sort != null)
    				{
    					criteria = session.createCriteria(clazz).addOrder(Order.asc(sort)).add(Restrictions.sqlRestriction(qry));
    				}
    				else
    				{
    					criteria = session.createCriteria(clazz).add(Restrictions.sqlRestriction(qry));
    				}
    			}
    			else
    			{
    				if(sort != null)
    				{
    					criteria = session.createCriteria(clazz).addOrder(Order.asc(sort));
    				}
    				else
    				{
    					criteria = session.createCriteria(clazz).addOrder(Order.desc(sort));
    				}
    			}
    	}
    	else
    	{	
    		if(qry!=null)
			{
				if(sort != null)
				{
					criteria = session.createCriteria(clazz).addOrder(Order.desc(sort)).add(Restrictions.sqlRestriction(qry));
				}
				else
				{
					criteria = session.createCriteria(clazz).add(Restrictions.sqlRestriction(qry));
				}
			}
			else
			{
				if(sort != null)
				{
					criteria = session.createCriteria(clazz).addOrder(Order.desc(sort));
				}
				else
				{
					criteria = session.createCriteria(clazz);
				}
			}
    	}
    	criteria.setFirstResult((page-1)*rows);
    	//criteria.setMaxResults(rows);
    	criteria.setMaxResults(2000);
    	//CSLoggerImpl.logInfo(this.getClass(), criteria.toString());
    	return criteria.list();
    }
    public long getCount(String string){
    	return sessionFactory.getCurrentSession().createQuery(string).list().size();
    	
    }
    
    
    @Override
    public void deleteAll(Collection<T> col) {
        Session session = sessionFactory.getCurrentSession();
        if(col != null && col.size() > 0)
        {
              for(T obj : col)
              {
                     session.delete(obj);
              }
        }
    }

    @Override
    public void saveOrUpdateAll(Collection<T> col){
    	
    	Session session = sessionFactory.getCurrentSession();
        if(col != null && col.size() > 0)
        {
              for(T obj : col)
              {
                     session.saveOrUpdate(obj);
              }
        }
    }

    @Override
    public int bulkUpdateOrDelete(String query,Object[] values){
    	
    	Session session = sessionFactory.getCurrentSession();
        Query hQuerry = session.createQuery(query);
        for(int i=0;i < values.length;i++)
        {
        	hQuerry.setParameter(i, values[i]);
        }
        int updatedEntities = hQuerry.executeUpdate();
        return updatedEntities;
    }
    private int csid = 0;
    public int generateID(final String id, final String location)
    {   	
    	if(id != null && location != null){
    		sessionFactory.getCurrentSession().doWork(new Work() {
    		  public void execute(Connection connection) throws SQLException {
    		    CallableStatement call = connection.prepareCall("{ ? = call CS_PKG_GEN_UTIL.CS_SF_GENERATE_ID(?,?) }");
    		    call.registerOutParameter(1, Types.INTEGER);
    		    call.setString(2, id);
    		    call.setString(3, location);
    		    call.execute();

    		    csid = call.getInt(1);
    		    call.close();
    		 }
    	});
    	}
    	return csid;
    }
    
    @Override
	public Map<String, Object> executeProcedure(String prepareCall, List<SPArgumentVO> procArgsList)
			 {
		//CSLoggerImpl.logDebug(this.getClass(), "{Prepare procedure call} - Starts");		

		Map<String, Object> resultMap = null;
		


			//CSLoggerImpl.logDebug(this.getClass(),
					//"{Prepare procedure call} - Arguments setup");

			CustomStoredProcedure spCall = new CustomStoredProcedure(prepareCall);
			spCall.compileArguments(procArgsList);
			resultMap = spCall.execute();

		
		//CSLoggerImpl.logDebug(this.getClass(), "{Execution procedure}  - Ends");

		return resultMap;
	}
    
    @Override
   	public Map<String, Object> executeFunction(String prepareCall, List<SPArgumentVO> procArgsList)
   			 {
   		//CSLoggerImpl.logDebug(this.getClass(), "{Prepare procedure call} - Starts");		

   		Map<String, Object> resultMap = null;
   		


   			//CSLoggerImpl.logDebug(this.getClass(),
   				//	"{Prepare procedure call} - Arguments setup");

   			CustomStoredProcedure spCall = new CustomStoredProcedure(prepareCall);
   			spCall.compileArguments(procArgsList,true);
   			resultMap = spCall.execute();

   		
   		//CSLoggerImpl.logDebug(this.getClass(), "{Execution procedure}  - Ends");

   		return resultMap;
   	}
    
	@Override
	public int executeDmlHql(String queryStr, String[] paramNames,Object[] paramValues) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(queryStr);
		for(int i=0;i < paramNames.length;i++)
		{
			query.setParameter(paramNames[i], paramValues[i]);
		}
		int result =  query.executeUpdate();
		return result;
	}
	
    /**
	 * Stored procedure class in spring way of implementation to make procedure
	 * call to participate in the Hibernate TransactionManager
	 * 
	 */
    class CustomStoredProcedure extends StoredProcedure {
    	

		Map<String, Object> inputs = new HashMap<String, Object>(1);

    	/**
		 * Constructor, which uses the underlying jdbc template to execute the procedure.
		 * @param sProcName
		 */
		public CustomStoredProcedure(String sProcName) {
			super(jdbcTemplate, sProcName);
		}
		
		/**
		 * Constructor, which carries the procedure name and datasource to which the call should be done
		 * @param dataSource
		 * @param sProcName
		 */
		public CustomStoredProcedure(DataSource dataSource, String sProcName) {
			super(dataSource, sProcName);
		}
		
		/**
		 * Used to compile the arguments to this class
		 * @param pArgsList
		 */
		public void compileArguments(List<SPArgumentVO> pArgsList) {
			if (pArgsList != null) {
				for (SPArgumentVO argumentVO : pArgsList) {
					// argument mode is IN
					if (ARG_MODE_IN.equals(argumentVO
							.getArgumentMode())) {
						if (ARG_TYPE_VARCHAR.equals(argumentVO
								.getArgumentType())) {
							declareParameter(new SqlParameter(argumentVO
									.getArgumentName(), Types.VARCHAR));
							inputs.put(argumentVO.getArgumentName(), argumentVO
									.getArgumentValue());
						}else if(ARG_TYPE_STRUCT.equals(argumentVO
								.getArgumentType())) {
							declareParameter(new SqlParameter(argumentVO.getArgumentName(), Types.STRUCT, argumentVO.getSpecialTypeName()));
								inputs.put(argumentVO.getArgumentName(),argumentVO.getArgumentValue());
						}else if(ARG_TYPE_NUMBER.equals(argumentVO
								.getArgumentType())) {
							declareParameter(new SqlParameter(argumentVO.getArgumentName(), Types.NUMERIC));
								inputs.put(argumentVO.getArgumentName(),argumentVO.getArgumentValue());
						}else if(ARG_TYPE_ARRAY.equals(argumentVO
								.getArgumentType())) {
							declareParameter(new SqlParameter(argumentVO.getArgumentName(), Types.ARRAY, argumentVO.getSpecialTypeName()));
							inputs.put(argumentVO.getArgumentName(),argumentVO.getArgumentValue());
						}
					} // argument mode is OUT
					else if (ARG_MODE_OUT.equals(argumentVO
							.getArgumentMode())) {
						if (ARG_TYPE_VARCHAR
								.equals(argumentVO.getArgumentType())) {
							declareParameter(new SqlOutParameter(argumentVO
									.getArgumentName(), Types.VARCHAR));							
						} else if(ARG_TYPE_NUMBER.equals(argumentVO
								.getArgumentType())) {
							declareParameter(new SqlOutParameter(argumentVO.getArgumentName(), Types.NUMERIC));								
						} else if (ARG_TYPE_CURSOR.equals(argumentVO
									.getArgumentType())) {								
							declareParameter(new SqlOutParameter(argumentVO.getArgumentName(), OracleTypes.CURSOR ,argumentVO.getRowMapper()));
						} else if (ARG_TYPE_ARRAY.equals(argumentVO
									.getArgumentType())) {	
							declareParameter(new SqlOutParameter(argumentVO.getArgumentName(), Types.ARRAY ,argumentVO.getSpecialTypeName()));
						} 								
					}
				}
			}
			compile();
		}
		
		
		/**
		 * Used to compile the arguments to this class
		 * @param pArgsList
		 */
		public void compileArguments(List<SPArgumentVO> pArgsList,boolean isfunc) {
			if (pArgsList != null) {
				for (SPArgumentVO argumentVO : pArgsList) {
					// argument mode is IN
					if (ARG_MODE_IN.equals(argumentVO
							.getArgumentMode())) {
						if (ARG_TYPE_VARCHAR.equals(argumentVO
								.getArgumentType())) {
							declareParameter(new SqlParameter(argumentVO
									.getArgumentName(), Types.VARCHAR));
							inputs.put(argumentVO.getArgumentName(), argumentVO
									.getArgumentValue());
						}else if(ARG_TYPE_STRUCT.equals(argumentVO
								.getArgumentType())) {
							declareParameter(new SqlParameter(argumentVO.getArgumentName(), Types.STRUCT, argumentVO.getSpecialTypeName()));
								inputs.put(argumentVO.getArgumentName(),argumentVO.getArgumentValue());
						}else if(ARG_TYPE_NUMBER.equals(argumentVO
								.getArgumentType())) {
							declareParameter(new SqlParameter(argumentVO.getArgumentName(), Types.NUMERIC));
								inputs.put(argumentVO.getArgumentName(),argumentVO.getArgumentValue());
						}else if(ARG_TYPE_ARRAY.equals(argumentVO
								.getArgumentType())) {
							declareParameter(new SqlParameter(argumentVO.getArgumentName(), Types.ARRAY, argumentVO.getSpecialTypeName()));
							inputs.put(argumentVO.getArgumentName(),argumentVO.getArgumentValue());
						}
					} // argument mode is OUT
					else if (ARG_MODE_OUT.equals(argumentVO
							.getArgumentMode())) {
						if (ARG_TYPE_VARCHAR
								.equals(argumentVO.getArgumentType())) {
							declareParameter(new SqlOutParameter(argumentVO
									.getArgumentName(), Types.VARCHAR));							
						} else if(ARG_TYPE_NUMBER.equals(argumentVO
								.getArgumentType())) {
							declareParameter(new SqlOutParameter(argumentVO.getArgumentName(), Types.NUMERIC));								
						} else if (ARG_TYPE_CURSOR.equals(argumentVO
									.getArgumentType())) {								
							declareParameter(new SqlOutParameter(argumentVO.getArgumentName(), OracleTypes.CURSOR ,argumentVO.getRowMapper()));
						} else if (ARG_TYPE_ARRAY.equals(argumentVO
									.getArgumentType())) {	
							declareParameter(new SqlOutParameter(argumentVO.getArgumentName(), Types.ARRAY ,argumentVO.getSpecialTypeName()));
						} 								
					}
				}
			}
			if(isfunc){
				setFunction(true);
			}
			compile();
		}
		
		/**
		 * execute the procedure and return the map.
		 * @return
		 */
		public Map<String, Object> execute() {	            
            return super.execute(inputs);
        }

    }
    
    @Override
	public long getRowCount(String clazz, String conditions) {
		return (Long) sessionFactory
				.getCurrentSession()
				.createQuery(
						"select count(*) from " + clazz + " where "
								+ conditions).iterate().next();
	}

	@Override
	public long getRowCount(String clazz) {
		return (Long) sessionFactory.getCurrentSession()
				.createQuery("select count(*) from " + clazz).iterate().next();
	}
		
	@Override
	public List findAllDistinct(String clazz, String selFields, String distinctCol) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);
		criteria.setProjection(Projections.distinct(Projections.property(distinctCol)));
		if(null!=selFields && !selFields.isEmpty())
			criteria.add(Restrictions.sqlRestriction(selFields));
		return criteria.list();
	}
	
	@Override
    public List<T> findByPagingSpecialChar(String string,Integer page, Integer rows,String sort,String order,String clause) {
    	Session session = sessionFactory.getCurrentSession();
    	int index;
    	String qry = clause;
        
		Class clazz;
		try {
			clazz = Class.forName(string);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Class not found.");
		}
		
		//CSLoggerImpl.logInfo(this.getClass(), "clause - "+qry);
    	Criteria criteria ;
    	if(order.equalsIgnoreCase("asc"))
    	{
    		
    			if(qry!=null)
    			{
    				if(sort != null)
    				{
    					criteria = session.createCriteria(clazz).addOrder(Order.asc(sort)).add(Restrictions.sqlRestriction(qry));
    				}
    				else
    				{
    					criteria = session.createCriteria(clazz).add(Restrictions.sqlRestriction(qry));
    				}
    			}
    			else
    			{
    				if(sort != null)
    				{
    					criteria = session.createCriteria(clazz).addOrder(Order.asc(sort));
    				}
    				else
    				{
    					criteria = session.createCriteria(clazz);
    				}
    			}
    	}
    	else
    	{	
    		if(qry!=null)
			{
				if(sort != null)
				{
					criteria = session.createCriteria(clazz).addOrder(Order.desc(sort)).add(Restrictions.sqlRestriction(qry));
				}
				else
				{
					criteria = session.createCriteria(clazz).add(Restrictions.sqlRestriction(qry));
				}
			}
			else
			{
				if(sort != null)
				{
					criteria = session.createCriteria(clazz).addOrder(Order.desc(sort));
				}
				else
				{
					criteria = session.createCriteria(clazz);
				}
			}
    	}
    	criteria.setFirstResult((page-1)*rows);
    	criteria.setMaxResults(rows);
    	//criteria.setMaxResults(1000);
    	//CSLoggerImpl.logInfo(this.getClass(), criteria.toString());
    	return criteria.list();
    }

	@Override
	public List<Object[]> fetchAllBySQLQuery(String string) {
		return sessionFactory.getCurrentSession().createSQLQuery(string).list();
	}

	@Override
	public Object findById(String pojoName, Long id) {
		Class clazz;
		try {
			clazz = Class.forName(pojoName);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Class not found.");
		}
		return  sessionFactory.getCurrentSession().createCriteria(clazz).add(Restrictions.idEq(id)).uniqueResult();
	}
	

}
