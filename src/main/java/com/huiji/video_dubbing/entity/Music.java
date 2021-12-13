package com.huiji.video_dubbing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author huiji
 * @since 2021-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Music对象", description="")
public class Music implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "music_id", type = IdType.AUTO)
    private Integer musicId;

    private String musicName;

    private String musicUrl;

}
