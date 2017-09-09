package com.liu.controller;

import com.liu.Constant.ConstantCode;
import com.liu.Constant.ConstantPath;
import com.liu.model.Image;
import com.liu.model.People;
import com.liu.model.Video;
import com.liu.service.IImageService;
import com.liu.service.IPeopleService;
import com.liu.service.IVideoService;
import com.liu.util.FileUtil;
import com.liu.util.FrameGrabberKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
@Controller
@RequestMapping("/video")
public class VideoController {

    private static final Logger logger = LoggerFactory.getLogger(VideoController.class);

    @Autowired
    private IVideoService videoService;

    @Autowired
    private IPeopleService peopleService;

    @Autowired
    private IImageService imageService;


    @RequestMapping("/upload")
    public String videoUpload(@RequestParam("fileUpload") MultipartFile fileUpload,HttpServletRequest request,
                              Model model){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        int uid = (int) session.getAttribute("uid");
        People people = peopleService.selectPeopleByName(username);
        if (people == null){
            model.addAttribute("message", "请登录");
            return "/main/register";
        }

        String videoPath = FileUtil.filePathConcat(request.getSession().getServletContext().getRealPath("/"),
                ConstantPath.VIDEO_PATH, fileUpload.getOriginalFilename());
        Video video = videoTransfer(fileUpload, videoPath, people.getId());

        String imagePath = FileUtil.filePathConcat(request.getSession().getServletContext().getRealPath("/"),
                ConstantPath.IMAGE_PATH,
                fileUpload.getOriginalFilename().
                        substring(0, fileUpload.getOriginalFilename().lastIndexOf(".")));

        imageTransfer(videoPath, imagePath,
                fileUpload.getOriginalFilename().substring(0, fileUpload.getOriginalFilename().lastIndexOf(".")) + "_img"
                ,video);

        model.addAttribute("video", video);

        return "/main/index";
    }

    @RequestMapping("/show")
    public String videoShow(Model model, HttpServletRequest request){
        int uid = (int) request.getSession().getAttribute("uid");
        People people = peopleService.selectPeopleById(uid);

        if (people == null || people.getStatus() == ConstantCode.INVAILD){
            return "/main/register";
        }

        List<Video> videos = videoService.selectVideosByPid(people.getId());
        model.addAttribute("videos", videos);
        return "";
    }

    @RequestMapping("/which/{vid}")
    public String whichVideo(@PathVariable int vid, Model model){
        Video video = videoService.selectVideoById(vid);
        model.addAttribute("video", video);
        return "";
    }

    private void imageTransfer(String videoPath, String imagePath, String imageName, Video video){
        Image image = null;

        try{
            List<String> urls = FrameGrabberKit.orderGrabberFFmpegImage(videoPath, imagePath, imageName, ConstantPath.NUM);
            for (String url : urls){
                image = new Image();
                image.setName("暂无结果");
                image.setStatus(ConstantCode.VAILD);
                image.setUrl(url);
                image.setVid(video.getId());
                imageService.insertImage(image);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private Video videoTransfer(MultipartFile fileUpload, String videoPath, int pid){
        File videoFile = new File(videoPath);
        if (videoFile.exists()){
            videoFile.delete();
        }

        videoFile.mkdirs();
        Video video = null;

        try{
            video = new Video();
            fileUpload.transferTo(videoFile);
            video.setUrl(videoPath);
            video.setPid(pid);
            video.setStatus(ConstantCode.VAILD);
            video.setName(fileUpload.getOriginalFilename());
            videoService.insertVideo(video);
        } catch (IOException e){
            e.printStackTrace();
        }

        return video;
    }

}
