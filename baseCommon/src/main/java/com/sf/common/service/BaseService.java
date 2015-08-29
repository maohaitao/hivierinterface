package com.sf.common.service;

import com.sf.common.database.dao.BaseDaoImpl;
import com.sf.common.exception.AppException;
import com.sf.common.reflection.Reflector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 描述：通用service，封装基本操作 创建时间：15/4/15 作者：yanghui
 */
@Service
public abstract class BaseService {
    @Autowired
    public BaseDaoImpl baseDao;

    public String getKey() {
        return "id";
    }

    private Field getDeclaredField(Class classz, String field) {
        if (StringUtils.isEmpty(field) || classz == null) {
            return null;
        }
        try {
            return classz.getDeclaredField(field);
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    private <T> List<String> getParamNames(T t) throws AppException {
        try {
            Reflector e = Reflector.forClass(t.getClass());
            List<String> paramNames = new ArrayList<String>();
            for (String propertyName : e.getGetablePropertyNames()) {
                Object value = e.getGetInvoker(propertyName).invoke(t, (Object[]) null);
                if (value == null) {
                    continue;
                }
                if (value instanceof String) {
                    if (!StringUtils.hasLength(value.toString())) {
                        continue;
                    }
                }
                paramNames.add(propertyName);
            }
            return paramNames;
        } catch (Exception e) {
            throw new AppException(1, e.getMessage());
        }
    }

    public <T> List<T> queryBySQL(String sql, Class<T> tClass, List<Object> params) throws AppException {
        return baseDao.list(sql, tClass, params);
    }

    public <T> List<T> queryByEntity(T t, List<String> params) throws AppException {
        return baseDao.list(t, params);
    }

    public <T> List<T> queryByEntity(T t) throws AppException {
        return baseDao.list(t, getParamNames(t));
    }

    public <T> List<T> queryByEntity(String sql, Class<T> tClass, List<Object> params) throws AppException {
        return baseDao.list(sql, tClass, params);
    }

    public <T> List<T> queryAll(Class<T> tClass) throws AppException {
        try {
            return queryByEntity(tClass.newInstance());
        } catch (InstantiationException e) {
            throw new AppException(1, e.getMessage());
        } catch (IllegalAccessException e) {
            throw new AppException(1, e.getMessage());
        }
    }

    public <T> void saveEntity(T t) throws AppException {
        try {
            if (t != null) {
                Reflector e = Reflector.forClass(t.getClass());
                Field idField = getDeclaredField(t.getClass(), getKey());
                if (idField == null) {
                    baseDao.add(t);
                } else {
                    Integer id = (Integer) e.getGetInvoker(getKey()).invoke(t, (Object[]) null);
                    if (id == null || id <= 0) {
                        Field createTimeField = getDeclaredField(t.getClass(), "createTime");
                        if (createTimeField != null) {
                            createTimeField.setAccessible(true);
                            createTimeField.set(t, new Date());
                        }
                        Integer key = baseDao.addReturnkey(t);
                        idField.setAccessible(true);
                        idField.set(t, key);
                    } else {
                        baseDao.update(t, getKey());
                    }
                }

            }
        } catch (Exception e) {
            throw new AppException(1, e.getMessage());
        }

    }

    public <T> int count(T t) {
        try {
            return baseDao.count(t, getParamNames(t));
        } catch (Exception e) {
            return 0;
        }
    }

    public <T> T findByEntity(T t) {
        try {
            Object o = baseDao.get(t, getParamNames(t));
            return (T) o;
        } catch (Exception e) {
            return null;
        }
    }

    public <T> T findBySQL(String sql, Class<T> tClass, List<Object> params) {
        try {
            Object o = baseDao.get(sql, tClass, params);
            return (T) o;
        } catch (AppException e) {
            return null;
        }
    }

    public <T> T findById(Object id, Class<T> tClass) {

        try {
            Object o;
            Field idField = getDeclaredField(tClass, getKey());
            if (!getKey().equals("id") && idField != null) {
                T t = tClass.newInstance();
                idField.setAccessible(true);
                idField.set(t, id);
                o = baseDao.get(t, getKey());
            } else {
                o = baseDao.get(id, tClass);
            }
            return (T) o;
        } catch (Exception e) {
            return null;
        }
    }

    public <T> boolean delete(T t) throws AppException {
        List<String> paramNames = getParamNames(t);
        if (paramNames.isEmpty()) {
            throw new AppException(1, "delete param is null");
        }
        return baseDao.delete(t, getParamNames(t)) > 0;
    }

    public boolean delete(Object id, Class classz) throws Exception {
        return baseDao.delete(id, classz) > 0;
    }

    public <T> boolean update(T t) throws Exception {
        Field id = getDeclaredField(t.getClass(), getKey());
        if (id == null || "".equals(id)) {
            throw new Exception("id is null");
        }

        return baseDao.update(t, getKey()) > 0;
    }


    /**
     * @param sql    查询的sql语句 ?通配
     * @param params 具体参数
     * @return
     */
    public List<Map<String, String>> getRowSet(String sql, Object... params) throws AppException {
        List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
        try {
            SqlRowSet sqlRowSet = baseDao.listRowSetSql(sql, params);
            if (sqlRowSet == null) {
                return maps;
            }
            SqlRowSetMetaData rsmd = sqlRowSet.getMetaData();
            int iColumnNumber = rsmd.getColumnCount();
            while (sqlRowSet.next()) {
                Map<String, String> rowMap = new HashMap<String, String>();
                for (int i = 1; i <= iColumnNumber; i++) {
                    rowMap.put(rsmd.getColumnLabel(i), sqlRowSet.getString(i));
                }
                maps.add(rowMap);
            }
        } catch (AppException e) {
            throw e;
        }
        return maps;
    }

    public <T> boolean update(T t, String... whereproperties) throws AppException {
        Integer result = 0;
        try {
            result = baseDao.update(t, whereproperties);
        } catch (AppException e) {
            throw e;
        }
        return result > 0;
    }


    public <T> int[] updateBatch(String sql, List<Object[]> paramslist) throws AppException {
        int[] result = null;
        try {
            result = baseDao.excuteBatch(sql, paramslist);
        } catch (AppException e) {
            throw e;
        }
        return result;
    }
}
