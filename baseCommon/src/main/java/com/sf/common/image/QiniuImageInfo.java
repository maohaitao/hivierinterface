package com.sf.common.image;

/**
 * @author hesin
 * @Created with： com.sf.common.image
 * @Des: 图片返回bear
 * @date 2015/8/26
 */
public class QiniuImageInfo {
    public String key;
    public String hash;
    public int w;
    public int h;
    public String url;

    @Override
    public String toString() {
        return "QiniuImageInfo{" +
                "key='" + key + '\'' +
                ", hash='" + hash + '\'' +
                ", w=" + w +
                ", h=" + h +
                ", url='" + url + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
