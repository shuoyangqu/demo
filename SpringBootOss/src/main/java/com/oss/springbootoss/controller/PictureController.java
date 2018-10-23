package com.oss.springbootoss.controller;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.oss.springbootoss.entity.Picture;
import com.oss.springbootoss.service.PictureService;
import com.oss.springbootoss.util.OSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: TODO
 * @Date: Created in 下午 4:02 2018/10/23/023
 */
@Controller
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @GetMapping("/")
    public String toIndex() {
        return "add";
    }

    @GetMapping("/all")
    public List<Picture> getAllPictures() {
        return pictureService.getAllPictures();
    }

    @PostMapping("/insert")
    public String insertPicture(@RequestParam("fileupload") MultipartFile fileupload, String picName) throws OSSException, ClientException, IOException {
        Picture picture = new Picture();
        picture.setPicName(picName);
//        虽然传来的是文件，但是保存到数据库的是路径
        picture.setUrl(OSSUtil.getUrl(fileupload));
        pictureService.insertPicture(picture);
        return "show";

    }

    @ResponseBody
    @PutMapping("/update")
    public void updatePicture(Picture picture){
        pictureService.updatePicture(picture);
    }

    @ResponseBody
    @DeleteMapping("/delete/{id}")
    public void deletePicture(@PathVariable("id") Integer id ){
        pictureService.deletePicture(id);
    }

    @ResponseBody
    @GetMapping("/get/{id}")
    public Picture getPicture(@PathVariable("id")Integer id){
        return pictureService.getPicture(id);
    }






}
