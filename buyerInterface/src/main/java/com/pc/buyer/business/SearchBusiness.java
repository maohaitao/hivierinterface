package com.pc.buyer.business;

import com.sf.common.model.search.CommonQueryObj;
import com.sf.common.model.search.SearchResultWrapper;

/**
 * @author hesin
 * @Created with： com.pc.buyer.business
 * @Des: 搜索业务接口
 * @date 2015/8/18
 */
public interface SearchBusiness {

    /**
     * 匹配搜索关键字
     *
     * @param key 输入的关键字
     * @return
     */
    public SearchResultWrapper searchKey(String key) throws Exception;

    /**
     * 搜索商品
     *
     * @return
     */
    public SearchResultWrapper searchIndex(CommonQueryObj query) throws Exception;
}
