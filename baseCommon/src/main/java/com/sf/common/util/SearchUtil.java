package com.sf.common.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sf.common.AppContext;
import com.sf.common.model.search.CommonQueryObj;
import com.sf.common.model.search.QueryFilter;
import com.sf.common.model.search.QuerySort;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;

import java.util.List;

/**
 * Created by YNzF on 2015/8/20.
 */
public class SearchUtil {
    public static CommonQueryObj parseQuery(JsonObject jsonObj) {
        return new Gson().fromJson(jsonObj, CommonQueryObj.class);
    }

    public static CommonQueryObj parseQuery(String jsonStr) {
        return new Gson().fromJson(jsonStr, CommonQueryObj.class);
    }

    public static SolrQuery convertToSolrQuery(JsonObject jsonObj) {
        return convertToSolrQuery(parseQuery(jsonObj));
    }
    public static SolrQuery convertToSolrQuery(CommonQueryObj obj) {
        SolrQuery query = new SolrQuery();
        //设置查询字符串及字段
        if(obj.getQueryStr()!=null && StringUtils.isNotBlank(obj.getQueryStr().getVal())) {
            if(StringUtils.isNotBlank(getFieldById(obj.getQueryStr().getField()))) {
                query.setQuery(getFieldById(obj.getQueryStr().getField())+":"+obj.getQueryStr().getVal());
            } else {
                query.setQuery(obj.getQueryStr().getVal());
            }
        }
        //设置返回的开始位置
        if(obj.getStart()<=0) query.setStart(obj.getStart());
        //设置返回结果的最大条数
        if(obj.getSize()<0) {
            query.setRows(AppContext.SEARCH_ENGINE_DEFAULT_ROWS);
        } else if(obj.getSize()>AppContext.SEARCH_ENGINE_MAX_ROWS) {
            query.setRows(AppContext.SEARCH_ENGINE_MAX_ROWS);
        } else {
            query.setRows(obj.getSize());
        }
        //设置queryFilter
        List<QueryFilter> qf = obj.getFilter();
        if(qf!=null && qf.size()>0) {
            for(QueryFilter f : qf) {
                if(StringUtils.isNotBlank(getFieldById(f.getField())) && StringUtils.isNotBlank(f.getVal())) {
                    query.addFilterQuery(getFieldById(f.getField()) + ":" + f.getVal());
                }
            }
        }

        List<QuerySort> sort = obj.getSort();
        if(sort!=null && sort.size()>0) {
            for(QuerySort s :sort) {
                if(StringUtils.isNotBlank(getFieldById(s.getField()))) {
                    query.addSort(getFieldById(s.getField()),s.getOrder()==0?SolrQuery.ORDER.desc: SolrQuery.ORDER.asc);
                }
            }
        }

        System.out.println(query.toString());
        return query;
    }

    public static String getFieldById(String id) {
        if("1".equals(id)) return "name";
        if("2".equals(id)) return "cate_name_all";
        if("3".equals(id)) return "brand_name";
        if("4".equals(id)) return "ori_price";
        if("5".equals(id)) return "ctime";
        if("6".equals(id)) return "sales_cnt";
        return null;
    }
}
