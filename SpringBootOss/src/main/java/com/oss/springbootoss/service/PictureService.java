package com.oss.springbootoss.service;

import com.oss.springbootoss.entity.Picture;

import java.util.List;

/**
 * @Author: qsy
 * @Description: TODO
 * @Date: Created in 下午 3:55 2018/10/23/023
 */
public interface PictureService {

    void deletePicture(Integer id);

    void updatePicture(Picture picture);

    Picture getPicture(Integer id);

    void insertPicture(Picture picture);

    List<Picture> getAllPictures();

}
