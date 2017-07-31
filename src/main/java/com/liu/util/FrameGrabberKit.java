package com.liu.util;

import com.liu.Constant.ConstantPath;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/5/7 0007.
 */
public class FrameGrabberKit {
    /*public static void randomGrabberFFmpegImage(String filePath, String targerFilePath, String targetFileName, int randomSize)
            throws Exception {
        FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault(filePath);
        ff.start();

        int ffLength = ff.getLengthInFrames();
        List<Integer> randomGrab = random(ffLength, randomSize);
        int maxRandomGrab = randomGrab.get(randomGrab.size() - 1);
        Frame f;
        int i = 0;
        while (i < ffLength) {
            f = ff.grabImage();
            if (randomGrab.contains(i)) {
                doExecuteFrame(f, targerFilePath, targetFileName, i);
            }
            if (i >= maxRandomGrab) {
                break;
            }
            i++;
        }
        ff.stop();
    }*/

    public static List<String> orderGrabberFFmpegImage(String filePath, String targetFilePath, String targetFileName
            , int num) throws Exception{
        FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault(filePath);
        ff.start();
        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(ConstantPath.AK, ConstantPath.SK);
        String token = auth.uploadToken("deepwalk");
        Frame f = null;
        int ffLength = ff.getLengthInFrames();
        List<String> urls = new ArrayList<>();
        for (int i = 0 ; i < ffLength && i < num ; i++){
            f = ff.grabImage();
            doExecuteFrame(f, targetFilePath, targetFileName, i, uploadManager, token, urls);
        }
        return urls;
    }

    public static void doExecuteFrame(Frame f, String targerFilePath, String targetFileName, int index,
                                      UploadManager uploadManager, String token, List<String> urls) {
        if (null == f || null == f.image) {
            return;
        }
        Java2DFrameConverter converter = new Java2DFrameConverter();
        String imageMat = "png";
        String FileName = targerFilePath + File.separator + targetFileName + "_" + index + "." + imageMat;
        BufferedImage bi = converter.getBufferedImage(f);
        File output = new File(FileName);
        if (output.exists()){
            output.delete();
        }
        try {
            ImageIO.write(bi, imageMat, output);
            Response response = uploadManager.put(output.getAbsoluteFile(),targetFileName + "_img" + index,token);
            urls.add(ConstantPath.QINIU_HEAD + targetFileName + "_img" + index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* public static List<Integer> random(int baseNum, int length) {
        List<Integer> list = new ArrayList<>(length);
        while (list.size() < length) {
            Integer next = (int) (Math.random() * baseNum);
            if (list.contains(next)) {
                continue;
            }
            list.add(next);
        }
        Collections.sort(list);
        return list;
    }*/
}
