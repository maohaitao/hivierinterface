package com.sf.common.image;

/**
 * @author hesin
 * @Created with： com.sf.common.image
 * @Des: 七牛的配置
 * @date 2015/8/26
 */
public class QiniuImageConfig {
    private String domain;
    private String accessKey;
    private String secretKey;
    private String bucket;
    private String appClient;
    private Integer fSizeLimit;
    private String mimeLimit;
    private String scope = "2";
    private Integer tokenExpires;
    private String returnBody = "{\"key\": $(key), \"hash\": $(etag), \"w\": $(imageInfo.width), \"h\": $(imageInfo.height)}";

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getAppClient() {
        return appClient;
    }

    public void setAppClient(String appClient) {
        this.appClient = appClient;
    }

    public Integer getfSizeLimit() {
        return fSizeLimit;
    }

    public void setfSizeLimit(Integer fSizeLimit) {
        this.fSizeLimit = fSizeLimit;
    }

    public String getMimeLimit() {
        return mimeLimit;
    }

    public void setMimeLimit(String mimeLimit) {
        this.mimeLimit = mimeLimit;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Integer getTokenExpires() {
        return tokenExpires;
    }

    public void setTokenExpires(Integer tokenExpires) {
        this.tokenExpires = tokenExpires;
    }

    public String getReturnBody() {
        return returnBody;
    }

    public void setReturnBody(String returnBody) {
        this.returnBody = returnBody;
    }
}
