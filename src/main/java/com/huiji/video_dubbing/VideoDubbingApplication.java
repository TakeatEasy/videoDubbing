package com.huiji.video_dubbing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@MapperScan("com.huiji.video_dubbing.mapper")
@SpringBootApplication
@EnableConfigurationProperties()
public class VideoDubbingApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoDubbingApplication.class, args);
    }

}
