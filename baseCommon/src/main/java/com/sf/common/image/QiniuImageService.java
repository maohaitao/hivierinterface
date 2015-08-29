package com.sf.common.image;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FileInfo;
import com.sf.common.log.LogService;
import com.sf.common.util.JsonUtil;

import java.io.File;

/**
 * @author hesin
 * @Created with： com.sf.common.image
 * @Des: 七牛业务处理
 * @date 2015/8/26
 */
public class QiniuImageService {

    private QiniuImageManager qiniuImageManager;
    public QiniuImageService(){
        qiniuImageManager = QiniuImageManager.getInstance();
    }
    public QiniuImageService(QiniuImageConfig config){
        qiniuImageManager = QiniuImageManager.getInstance(config);
    }

    public String privateDownloadUrl(String url) {
        return qiniuImageManager.getAuth().privateDownloadUrl(url, 5);
    }

    /**
     * 上传图片可以指定bucket
     * @param file
     * @param bucket
     * @return
     */
    public QiniuImageInfo uploadFile(File file,String bucket) {
        String token = bucket==null||"".equals(bucket.trim())?qiniuImageManager.getToken():qiniuImageManager.getToken(bucket,null);
        UploadManager uploadManager = new UploadManager();
        try {
            Response response = uploadManager.put(file, file.getName(), token);
            if (response.isOK()) {
                QiniuImageInfo imageInfo = JsonUtil.parse(response.bodyString(), QiniuImageInfo.class);
                imageInfo.setUrl(qiniuImageManager.getImageConfig().getDomain() + File.separator + imageInfo.getKey());
                return imageInfo;
            }
        } catch (QiniuException e) {
            LogService.error("uploadFile,error", e);
        }
        return null;
    }

    /**
     * 上传图片可以指定bucket/文件名
     * @param key
     * @param file
     * @param bucket
     * @return
     */
    public QiniuImageInfo updateFile(String key, File file,String bucket) {
        String token = bucket==null||"".equals(bucket.trim())?qiniuImageManager.getToken(null,key):qiniuImageManager.getToken(bucket, key);
        UploadManager uploadManager = new UploadManager();
        try {
            Response response = uploadManager.put(file, key, token);
            if (response.isOK()) {
                QiniuImageInfo imageInfo = JsonUtil.parse(response.bodyString(), QiniuImageInfo.class);
                imageInfo.setUrl(qiniuImageManager.getImageConfig().getDomain() + File.separator + imageInfo.getKey());
                return imageInfo;
            }
        } catch (QiniuException e) {
            LogService.error("updateFile,error", e);
        }
        return null;
    }

    /**
     * 删除文件指定 空间
     * @param key 文件
     * @param bucket 空间
     * @return
     */
    public boolean deleteFile(String key,String bucket) {
        try {
            qiniuImageManager.getBucketManager().delete(bucket==null|| "".equals(bucket)?qiniuImageManager.getImageConfig().getBucket():bucket, key);
        } catch (QiniuException e) {
            LogService.error("deleteFile,error", e);
        }
        return true;
    }


    public FileInfo selectFile(String key,String bucket) {
        try {
            return qiniuImageManager.getBucketManager().stat(bucket==null|| "".equals(bucket)?qiniuImageManager.getImageConfig().getBucket():bucket, key);
        } catch (QiniuException e) {
            LogService.error("selectFile,error", e);
            return null;
        }
    }

    //-------------TODO 图片压缩/水印 处理


}
