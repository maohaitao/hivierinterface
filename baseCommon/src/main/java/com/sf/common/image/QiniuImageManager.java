package com.sf.common.image;

import com.qiniu.storage.BucketManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.StringUtils;
import com.sf.common.properties.PropertiesQiniuUtil;
import java.util.Date;

/**
 * @author hesin
 * @Created with： com.sf.common.image
 * @Des: 七牛处理
 * @date 2015/8/26
 */
public class QiniuImageManager {
    private Auth auth;
    private BucketManager bucketManager;
    private StringMap stringMap = new StringMap();
    private String token;
    private QiniuImageConfig imageConfig;
    private long createTokenTime = 0;

    private static QiniuImageManager imageManager = null;

    public static QiniuImageManager getInstance() {
        if (imageManager == null) {
            imageManager = new QiniuImageManager(null);
        }
        return imageManager;
    }

    public static QiniuImageManager getInstance(QiniuImageConfig imageConfig) {
        if (imageManager == null) {
            imageManager = new QiniuImageManager(imageConfig);
        }
        return imageManager;
    }
    private QiniuImageManager(QiniuImageConfig imageConfig) {
        initConifg(imageConfig);
        this.auth = Auth.create(this.imageConfig.getAccessKey(), this.imageConfig.getSecretKey());
        bucketManager = new BucketManager(auth);
        stringMap.put("scope", this.imageConfig.getScope());
        stringMap.put("fsizeLimit", this.imageConfig.getfSizeLimit());
        stringMap.put("endUser", this.imageConfig.getAppClient());
        stringMap.put("mimeLimit", this.imageConfig.getMimeLimit());
        stringMap.put("returnBody", this.imageConfig.getReturnBody());
    }

    private void initConifg(QiniuImageConfig imageConfig) {
        if (imageConfig == null) {
            imageConfig = new QiniuImageConfig();
            imageConfig.setAccessKey(PropertiesQiniuUtil.getValue("qiniu.access_key"));
            imageConfig.setSecretKey(PropertiesQiniuUtil.getValue("qiniu.secret_key"));
            imageConfig.setBucket(PropertiesQiniuUtil.getValue("qiniu.bucket"));
            imageConfig.setDomain(PropertiesQiniuUtil.getValue("qiniu.domain"));
            imageConfig.setAppClient(PropertiesQiniuUtil.getValue("qiniu.appclient"));
            imageConfig.setfSizeLimit(PropertiesQiniuUtil.getValue("qiniu.fsizeLimit", 0));
            imageConfig.setMimeLimit(PropertiesQiniuUtil.getValue("qiniu.mimeLimit"));
            imageConfig.setTokenExpires(PropertiesQiniuUtil.getValue("qiniu.token_expires", 0));
        }
        if (StringUtils.isNullOrEmpty(imageConfig.getAccessKey()) || StringUtils.isNullOrEmpty(imageConfig.getSecretKey())) {
            throw new NullPointerException("access_key and secret_key is NULL");
        }
        if (StringUtils.isNullOrEmpty(imageConfig.getBucket())) {
            throw new NullPointerException("bucket is NULL");
        }
        this.imageConfig = imageConfig;
    }

    public String getDomain() {
        return imageConfig.getDomain();
    }

    public String getToken() {
        long valid_token = (new Date().getTime() - createTokenTime) / 1000;
        if (createTokenTime == 0 || valid_token > this.imageConfig.getTokenExpires()) {
            token = auth.uploadToken(this.imageConfig.getBucket(), null, this.imageConfig.getTokenExpires(), stringMap);
            createTokenTime = new Date().getTime();
        }
        return token;
    }

    public String getToken(String bucket,String key){
        long valid_token = (new Date().getTime() - createTokenTime) / 1000;
        if (createTokenTime == 0 || valid_token > this.imageConfig.getTokenExpires()) {
            token = auth.uploadToken(bucket==null||"".equals(bucket.trim())?this.imageConfig.getBucket():bucket, key, this.imageConfig.getTokenExpires(), stringMap);
            createTokenTime = new Date().getTime();
        }
        return token;
    }

    public BucketManager getBucketManager() {
        return bucketManager;
    }

    public void setBucketManager(BucketManager bucketManager) {
        this.bucketManager = bucketManager;
    }


    public QiniuImageConfig getImageConfig() {
        return imageConfig;
    }

    public void setImageConfig(QiniuImageConfig imageConfig) {
        this.imageConfig = imageConfig;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }
}
