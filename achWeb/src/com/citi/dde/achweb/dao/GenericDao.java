package com.citi.dde.achweb.dao;



import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.citi.dde.achweb.pojo.SPArgumentVO;

public interface GenericDao<T, P extends Serializable> {

	String ARG_MODE_IN = "IN";
	String ARG_MODE_OUT = "OUT";
	String ARG_TYPE_VARCHAR = "VARCHAR";
	String ARG_TYPE_NUMBER = "NUMBER";
	String ARG_TYPE_CURSOR = "CURSOR";
	String ARG_TYPE_CLOB = "CLOB";
	String ARG_TYPE_STRUCT = "STRUCT";
	String ARG_TYPE_ARRAY = "ARRAY";
	
    public void save(T t);

    public void update(T t);
    
    public void saveOrUpdate(T t);

    public void delete(T t);

    public T findOneByExample(T t, P p);
    
    public Object findById(String pojoName,Long id);

    public int countRecords(Class<T> c, String string);
    
    public T findOneByQuery(String string);
    
    public List<T> findByParam(String string,Object[] values);
    
    public List<T> findByNamedParam(String string,Map<String,Object> valueMap);
    
    public List<T> findAllByQuery(String string);
    
    public List<T> findAllBySQLQuery(String string);
    
    public List<Object[]> fetchAllBySQLQuery(String string);
    
    public Session getCurrentSession();
    
    public List<T> findByPaging(String string,Integer page, Integer rows,String sort,String order,String restricClause) throws ClassNotFoundException;
    public List<T> findByPagingLoadOnce(String string,Integer page, Integer rows,String sort,String order,String restricClause) throws ClassNotFoundException;
    
    public long getCount(String string);
    
    public void deleteAll(Collection<T> col);
    
    public void saveOrUpdateAll(Collection<T> col);
    
    public int bulkUpdateOrDelete(String query,Object[] values);
    
    public Map<String, Object> executeProcedure(String prepareCall, List<SPArgumentVO> procArgsList) ;
    
    public int executeDmlHql(String query, String[] paramNames, Object[] paramValues);
    
    public int generateID(final String id, final String location);
    
    public long getRowCount(String clazz, String conditions);
    
    public long getRowCount(String clazz);
	
	public List findAllDistinct(String query,String selFileds ,String distinctCol);

	public List<T> findByPagingSpecialChar(String string, Integer page, Integer rows, String sort, String order, String clause) throws ClassNotFoundException;
	public Map<String, Object> executeFunction(String prepareCall, List<SPArgumentVO> procArgsList);
	
}
