package com.liu.mapper;

import com.liu.model.Image;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liujiayu on 2017/9/9.
 */
@Component
public interface ImageMapper {

    List<Image> selectImages();

    void insertImage(Image image);

    List<Image> selectImagesByVid(int vid);

}
