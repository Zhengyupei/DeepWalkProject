package com.liu.service;

import com.liu.model.Video;

import java.util.List;

/**
 * Created by liujiayu on 2017/8/1.
 */
public interface IVideoService {

    List<Video> selectVideos();

    void insertVideo(Video video);

    List<Video> selectVideosByPid(int pid);

    Video selectVideoById(int id);
}
