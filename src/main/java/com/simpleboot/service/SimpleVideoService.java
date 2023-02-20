package com.simpleboot.service;

import com.simpleboot.entity.SimpleVideo;

import java.util.List;

/**
 * 视频Service接口
 *
 * @author administrator
 * @date 2023-02-17
 */
public interface SimpleVideoService
{
    /**
     * 查询视频
     *
     * @param videoId 视频ID
     * @return 视频
     */
    public SimpleVideo selectSimpleVideoById(Long videoId);

    /**
     * 查询视频列表
     *
     * @param simpleVideo 视频
     * @return 视频集合
     */
    public List<SimpleVideo> selectSimpleVideoList(SimpleVideo simpleVideo);

    /**
     * 新增视频
     *
     * @param simpleVideo 视频
     * @return 结果
     */
    public int insertSimpleVideo(SimpleVideo simpleVideo);

    /**
     * 修改视频
     *
     * @param simpleVideo 视频
     * @return 结果
     */
    public int updateSimpleVideo(SimpleVideo simpleVideo);

    /**
     * 删除视频
     *
     * @param videoId 视频ID
     * @return 结果
     */
    public int deleteSimpleVideoById(Long videoId);

    /**
     * 批量删除视频
     *
     * @param videoIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSimpleVideoByIds(String[] videoIds);
}
