package com.huiji.video_dubbing.entity;

import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Response {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    private Response(){}

    //链式编程
    public static Response ok(){
        Response r = new Response();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    public static Response error(){
        Response r = new Response();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public Response success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Response message(String message){
        this.setMessage(message);
        return this;
    }

    public Response code(Integer code){
        this.setCode(code);
        return this;
    }

    public Response data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public Response data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

    @Data
    class ResultCode {

        private ResultCode () {}

        public static final int SUCCESS = 200;

        public static final int ERROR = 200;
    }
}
