package com.liu.service.impl;

import com.liu.mapper.ImageMapper;
import com.liu.model.Image;
import com.liu.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liujiayu on 2017/9/9.
 */
@Service("imageService")
public class ImageServiceImpl implements IImageService {

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public List<Image> selectImages(){
        return imageMapper.selectImages();
    }

    @Override
    public void insertImage(Image image){
        imageMapper.insertImage(image);
    }

    @Override
    public List<Image> selectImagesByVid(int vid){
        return imageMapper.selectImagesByVid(vid);
    }

}
