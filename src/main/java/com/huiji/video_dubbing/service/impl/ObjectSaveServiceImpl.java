package com.huiji.video_dubbing.service.impl;

import com.google.gson.Gson;
import com.huiji.video_dubbing.config.QiniuConfig;
import com.huiji.video_dubbing.service.IObjectSaveService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@Slf4j
public class ObjectSaveServiceImpl implements IObjectSaveService {

    @Autowired
    QiniuConfig qiniuConfig;

    /*
        输入是上传的字节流，返回音乐文件的存储类型
     */
    @Override
    public String saveObject(InputStream inputStream, String fileName) {
        // 上传到对象存储华北服务器

        Configuration cfg = new Configuration(Region.region1());
        UploadManager uploadManager = new UploadManager(cfg);

        Auth auth = Auth.create(qiniuConfig.getAccessKey(), qiniuConfig.getSecretKey());
        String upToken = auth.uploadToken(qiniuConfig.getBucket());

        Response response = null;
        try {
            response = uploadManager.put(inputStream, fileName, upToken, null, null);
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        } catch (QiniuException e) {
            log.error(e.getLocalizedMessage());
        }

        return "r41ky2hz7.hb-bkt.clouddn.com" + fileName;
    }

    @Override
    public String saveMusic(InputStream inputStream, String fileName) {
        fileName = "/music/" + fileName;
        return saveObject(inputStream, fileName);
    }

    @Override
    public String saveVideo(InputStream inputStream, String fileName) {
        fileName = "/video/" + fileName;
        return saveObject(inputStream, fileName);
    }


}
