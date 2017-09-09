package com.liu.mapper;

import com.liu.model.Video;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liujiayu on 2017/8/1.
 */
@Component
public interface VideoMapper {

    List<Video> selectVideos();

    void insertVideo(Video video);

    List<Video> selectVideosByPid(int pid);

    Video selectVideoById(int id);
}
