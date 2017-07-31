package com.liu.controller;

import com.liu.model.Video;
import com.liu.service.IVideoService;
import com.liu.util.FrameGrabberKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
@Controller
@RequestMapping("/")
public class VideoController {

    private static final Logger logger = LoggerFactory.getLogger(VideoController.class);

    @Autowired
    private IVideoService videoService;

    @RequestMapping(value = {"/index", "/"})
    public String index(){
        return "/main/index";
    }

    @RequestMapping(value = {"/file/upload"})
    public String fileUpload(@RequestParam(value = "fileUpload", required = true)MultipartFile fileUpload,
                             HttpServletRequest request, Model model){
        String filePath = request.getSession().getServletContext().getRealPath("/") + "/upload/video";
        if (!(new File(filePath)).exists()){
            new File(filePath).mkdirs();
        }

        String fileName = filePath + "/" + fileUpload.getOriginalFilename();
        File upload = new File(fileName);
        if (upload.exists()){
            upload.delete();
        }

        try{
            fileUpload.transferTo(upload);
            String targetFile = request.getSession().getServletContext().getRealPath("/") + "/upload/img/" +
                    fileUpload.getOriginalFilename().substring(0, fileUpload.getOriginalFilename().lastIndexOf("."));
            if (!(new File(targetFile)).exists()){
                new File(targetFile).mkdirs();
            }
            List<String> urls = FrameGrabberKit.orderGrabberFFmpegImage(fileName, targetFile,
                    fileUpload.getOriginalFilename().substring(0, fileUpload.getOriginalFilename().lastIndexOf(".")) + "_img", 10);
            model.addAttribute("message", "已经成功");

            Video video;
            int i = 0;
            for (String url : urls){
                video = new Video();
                video.setUrl(url);
                video.setImageName(fileUpload.getOriginalFilename().substring(0, fileUpload.getOriginalFilename().lastIndexOf(".")) + "_img" + i);
                video.setVideoName(fileUpload.getOriginalFilename().substring(0, fileUpload.getOriginalFilename().lastIndexOf(".")));
                videoService.insertVideo(video);
                i++;
            }

            //new File(targetFile).delete();
        } catch (IOException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        return "/main/index";
    }

}
