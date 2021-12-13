package com.huiji.video_dubbing.controller;


import com.huiji.video_dubbing.entity.Music;
import com.huiji.video_dubbing.entity.Response;
import com.huiji.video_dubbing.entity.UserVideo;
import com.huiji.video_dubbing.service.IMusicService;
import com.huiji.video_dubbing.service.IObjectSaveService;
import com.huiji.video_dubbing.service.IUserVideoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huiji
 * @since 2021-12-13
 */
@RestController
@RequestMapping("/video")
@Slf4j
public class UserVideoController {

    @Autowired
    IUserVideoService videoService;

    @Autowired
    IObjectSaveService objectSaveService;

    @ApiOperation(value = "视频上传")
    @PostMapping("/upload")
    @ResponseBody
    public Response uploadMusic(@RequestParam("file") MultipartFile file){
//        上传文件
        String fileName = file.getOriginalFilename();
        String url = null;
        try {
            url = objectSaveService.saveVideo(file.getInputStream(), fileName);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
//        保存记录到数据库
        UserVideo video = new UserVideo();
        video.setVideoName(fileName);
        video.setVideoUrl(url);
        videoService.save(video);
        return Response.ok();
    }

}
