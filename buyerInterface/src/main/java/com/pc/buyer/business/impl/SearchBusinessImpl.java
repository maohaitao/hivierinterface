package com.pc.buyer.business.impl;

import com.google.gson.Gson;
import com.pc.buyer.business.SearchBusiness;
import com.pc.buyer.common.AppContext;
import com.sf.common.model.search.*;
import com.sf.common.util.SearchUtil;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.util.NamedList;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.business.impl
 * @Des: 搜索具体业务接口实现
 * @date 2015/8/18
 */
@Service
public class SearchBusinessImpl implements SearchBusiness {

    @Override
    public SearchResultWrapper<InputSuggest> searchKey(String key) throws Exception {
        SearchResultWrapper wrapper = new SearchResultWrapper();
        SolrClient client = new HttpSolrClient(AppContext.SEARCH_URL + AppContext.SEARCH_ENGINE_CORE_SUGGEST);
        SolrQuery query = new SolrQuery();
        query.setQuery(key);
        query.setStart(0);
        QueryResponse response = client.query(query);
        wrapper.setStatus(response.getStatus());
        NamedList header = response.getHeader();
        wrapper.setqTime(Integer.parseInt(header.get("QTime").toString()));
        wrapper.setStatus(Integer.parseInt(header.get("status").toString()));
        wrapper.setNumFound(response.getResults().getNumFound());
        wrapper.setStart(response.getResults().getStart());
        List<InputSuggest> results = response.getBeans(InputSuggest.class);
        wrapper.setResults(results);
        return wrapper;
    }

    @Override
    /**
     * 搜索商品
     */
    public SearchResultWrapper searchIndex(CommonQueryObj query) throws Exception {
        SearchResultWrapper wrapper = new SearchResultWrapper();
        SolrClient client = new HttpSolrClient(AppContext.SEARCH_URL + AppContext.SEARCH_ENGINE_CORE_COMMODITY);
        SolrQuery solrQuery = SearchUtil.convertToSolrQuery(query);
        solrQuery.setFields("id");
        QueryResponse response = client.query(solrQuery);

        wrapper.setStatus(response.getStatus());
        NamedList header = response.getHeader();
        wrapper.setqTime(Integer.parseInt(header.get("QTime").toString()));
        wrapper.setStatus(Integer.parseInt(header.get("status").toString()));
        wrapper.setNumFound(response.getResults().getNumFound());
        wrapper.setStart(response.getResults().getStart());
        List<ComoditesRs> results = response.getBeans(ComoditesRs.class);
        wrapper.setResults(results);
        return wrapper;
    }

    public static void main(String[] args) throws Exception {
        SearchBusinessImpl impl = new SearchBusinessImpl();
        CommonQueryObj obj = new CommonQueryObj();
        QueryStr queryStr = new QueryStr();
        queryStr.setField("0");
        queryStr.setVal("耐克");
        obj.setQueryStr(queryStr);
        obj.setSize(10);
        obj.setStype(1);
        obj.setStart(0);

        System.out.println(new Gson().toJson(impl.searchKey("nike")));
        String json = "{\n" +
                "  \"queryStr\": {\"field\": 0, \"val\": \"nike\"},\n" +
                "  \"stype\": 0,\n" +
                "  \"start\": 0,\n" +
                "  \"size\": 10\n" +
//                "  \"filter\": [\n" +
//                "    {\n" +
//                "      \"field\": 1,\n" +
//                "      \"val\": \"xxxx\"\n" +
//                "    }\n" +
//                "    {\n" +
//                "      \"field\": 3,\n" +
//                "      \"val\": \"xxxx\"\n" +
//                "    }\n" +
//                "  ]\n" +
//                "  \"sort\": [\n" +
//                "    {\n" +
//                "      \"field\": 1,\n" +
//                "      \"order\": 1\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"field\": 2,\n" +
//                "      \"order\": 0\n" +
//                "    }\n" +
//                "  ]\n" +
                "}";
//        JsonObject queryJo = new Gson().fromJson(json, JsonObject.class);
//        System.out.println(new Gson().toJson(impl.searchIndex(obj)));
    }

}
