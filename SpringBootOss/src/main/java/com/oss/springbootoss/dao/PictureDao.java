package com.oss.springbootoss.dao;

import com.oss.springbootoss.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: qsy
 * @Description: 注释说明
 * @Date: Created in 下午 3:54 2018/10/23/023
 */
public interface PictureDao extends JpaRepository<Picture,Integer> {
}
