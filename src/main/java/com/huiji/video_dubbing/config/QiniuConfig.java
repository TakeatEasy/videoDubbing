package com.huiji.video_dubbing.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class QiniuConfig {

    private String accessKey = "qsJ-Hn46sh_YnRX08qx8iQ7PgGU1ei7wI-gmicSy";

    private String secretKey = "OTHfkEoQgskmyzcmdge3rM-YdOFLdaSZ2Ct4N5wE";

    private String bucket = "videodubbing";
}
