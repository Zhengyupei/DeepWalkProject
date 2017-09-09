package com.liu.controller;

import com.liu.model.Image;
import com.liu.model.Video;
import com.liu.service.IImageService;
import com.liu.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liujiayu on 2017/9/9.
 */
@Controller
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private IImageService imageService;

    @Autowired
    private IVideoService videoService;

    @RequestMapping("/from/{vid}")
    public String imageFromVideo(Model model, @PathVariable int vid){
        List<Image> images = imageService.selectImagesByVid(vid);
        if (images == null){
            images = new ArrayList<>();
        }

        Video video = videoService.selectVideoById(vid);

        model.addAttribute("images", images);
        model.addAttribute("video", video);
        return "";
    }

    @RequestMapping("/all")
    public String allImage(Model model, HttpServletRequest request){
        int uid = (int) request.getSession().getAttribute("uid");

        List<Video> videos = videoService.selectVideosByPid(uid);

        List<Image> images = new ArrayList<>();
        for (Video video : videos){
            List<Image> temp = imageService.selectImagesByVid(video.getId());
            images.addAll(temp);
        }

        model.addAttribute("images", images);
        return "";
    }

}
