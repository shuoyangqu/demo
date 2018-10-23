package com.oss.springbootoss.service;

import com.oss.springbootoss.dao.PictureDao;
import com.oss.springbootoss.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: qsy
 * @Description: TODO
 * @Date: Created in 下午 3:57 2018/10/23/023
 */
@Service(value = "picture")
public class PictureServiceimpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;

    @Override
    public void deletePicture(Integer id) {
        pictureDao.deleteById(id);
    }

    @Override
    public void updatePicture(Picture picture) {
        pictureDao.save(picture);
    }

    @Override
    public Picture getPicture(Integer id) {
        return pictureDao.getOne(id);
    }

    @Override
    public void insertPicture(Picture picture) {
        pictureDao.save(picture);
    }

    @Override
    public List<Picture> getAllPictures() {
        return pictureDao.findAll();
    }
}
