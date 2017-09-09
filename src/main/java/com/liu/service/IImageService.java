package com.liu.service;

import com.liu.model.Image;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liujiayu on 2017/9/9.
 */
public interface IImageService {

    List<Image> selectImages();

    void insertImage(Image image);

    List<Image> selectImagesByVid(int vid);

}
