package com.tmall.controller;

import com.tmall.pojo.HomeChunkData;
import com.tmall.pojo.HomeSwiperImage;
import com.tmall.service.IHomeChunkDataService;
import com.tmall.service.IHomeSwiperImageService;
import com.tmall.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 首页资源控制类，用于获取首页资源
 *
 * @ClassName: HomeController
 * @Author: Xlu
 * @Date: 2020/9/30 19:01
 * @Version 11
 **/
@Controller
@ResponseBody
@RequestMapping("/home")
public class HomeController {
    @Resource(name = "homeSwiperImageService")
    IHomeSwiperImageService swiperImageService;

    @Resource(name = "homeChunkDataService")
    IHomeChunkDataService chunkDataService;

    /**
     * 获取首页轮播图的数据，也就是图片链接
     *
     * @return java.lang.String
     * @Author Xlu
     * @Date 19:03 2020/9/30
     */
    @RequestMapping("/swiper/img")
    public String getSwiperData(HttpServletRequest req) {
        String serverName = req.getServerName();
        ArrayList<HomeSwiperImage> imageList = new ArrayList<>();

        List<HomeSwiperImage> allImages = swiperImageService.getAllImages();

        // 遍历结果，加上需要的头，添加到列表中
        for (HomeSwiperImage image : allImages) {
            image.setSrc("http://" + serverName + ":8080" + image.getSrc());
            imageList.add(image);
        }


        return JsonUtil.getJson(imageList);
    }

    /**
     * 获取首页中块的数据
     *
     * @param req 用来获取服务器名称
     * @return java.lang.String
     * @Author Xlu
     * @Date 17:09 2020/10/14
     */
    @RequestMapping("/chunk/data")
    public String getChunkData(HttpServletRequest req) {
        // 服务器链接
        String serverName = req.getServerName();
        ArrayList<HomeChunkData> list = new ArrayList<>();

        List<HomeChunkData> allChunkData = chunkDataService.getAllChunkData();
        for (HomeChunkData datum : allChunkData) {
            datum.setImgSrc("http://" + serverName + ":8080" + datum.getImgSrc());
            list.add(datum);
        }

        return JsonUtil.getJson(list);
    }

    @RequestMapping("/video")
    public String getVideo(HttpServletRequest req) {
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        HashMap<String, String> map3 = new HashMap<>();
        HashMap<String, String> map4 = new HashMap<>();

        map1.put("url" , "http://" + req.getServerName() + ":8080/tmall/static/video/1.mp4");
        map1.put("name" , "野牛历史");

        map2.put("url" , "http://" + req.getServerName() + ":8080/tmall/static/video/2.mp4");
        map2.put("name" , "有些狼性只有狗才向往，我们要当人，不要做畜生");

        map3.put("url" , "http://" + req.getServerName() + ":8080/tmall/static/video/3.mp4");
        map3.put("name" , "罗翔说刑法：抓别人鸭子肯定是盗窃行为，那么是否构成犯罪？");

        map4.put("url" , "http://" + req.getServerName() + ":8080/tmall/static/video/4.mp4");
        map4.put("name" , "超简单！两分钟学会知乎「图文转视频」工具");

        ArrayList list = new ArrayList<HashMap>();
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);

        return JsonUtil.getJson(list);
    }

}
