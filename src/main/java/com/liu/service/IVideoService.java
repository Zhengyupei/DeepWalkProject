package com.liu.service;

import com.liu.model.Video;

import java.util.List;

/**
 * Created by liujiayu on 2017/8/1.
 */
public interface IVideoService {

    public List<Video> selectVideos();

    public void insertVideo(Video video);
}
