package com.simpleboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 视频对象 simple_video
 *
 * @author administrator
 * @date 2023-02-17
 */
@Data
@TableName("simple_video")
public class SimpleVideo
{
    private static final long serialVersionUID = 1L;

    /** 视频唯一标识 */
    @TableId
    private Long videoId;

    /** 视频封面地址 */
    @TableField("video_play_url")
    private String videoPlayUrl;

    /** 视频封面地址 */
    @TableField("video_cover_url")
    private Long videoCoverUrl;

    /** 视频的点赞总数 */
    @TableField("video_favorite_count")
    private Long videoFavoriteCount;

    /** 视频的评论总数 */
    @TableField("video_comment_count")
    private Long videoCommentCount;

    /** 是否点赞 */
    @TableField("video_is_favorite")
    private Integer videoIsFavorite;

    /** 视频标题 */
    @TableField("video_title")
    private String videoTitle;

    /** 创建时间 */
    @TableField("video_create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date videoCreateTime;

    /** 创建用户id */
    @TableField("video_create_id")
    private Long videoCreateId;

    /** 修改时间 */
    @TableField("video_modify_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date videoModifyTime;

    /** 修改用户id */
    @TableField("video_modify_id")
    private Long videoModifyId;

}
