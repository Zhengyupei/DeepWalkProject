package com.liu.service.impl;

import com.liu.mapper.VideoMapper;
import com.liu.model.Video;
import com.liu.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liujiayu on 2017/8/1.
 */
@Service("videoService")
public class VideoServiceImpl implements IVideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> selectVideos(){
        return videoMapper.selectVideos();
    }

    @Override
    public void insertVideo(Video video){
        videoMapper.insertVideo(video);
    }

    @Override
    public List<Video> selectVideosByPid(int pid){
        return videoMapper.selectVideosByPid(pid);
    }

    @Override
    public Video selectVideoById(int id){
        return videoMapper.selectVideoById(id);
    }
}
