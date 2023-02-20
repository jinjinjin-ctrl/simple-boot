package com.simpleboot.service.impl;

import com.simpleboot.entity.SimpleVideo;
import com.simpleboot.service.SimpleVideoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 视频Service业务层处理
 *
 * @author administrator
 * @date 2023-02-17
 */
@Service
public class SimpleVideoServiceImpl implements SimpleVideoService
{


    @Override
    public SimpleVideo selectSimpleVideoById(Long videoId) {
        return null;
    }

    @Override
    public List<SimpleVideo> selectSimpleVideoList(SimpleVideo simpleVideo) {
        return null;
    }

    @Override
    public int insertSimpleVideo(SimpleVideo simpleVideo) {
        return 0;
    }

    @Override
    public int updateSimpleVideo(SimpleVideo simpleVideo) {
        return 0;
    }

    @Override
    public int deleteSimpleVideoById(Long videoId) {
        return 0;
    }

    @Override
    public int deleteSimpleVideoByIds(String[] videoIds) {
        return 0;
    }
}
