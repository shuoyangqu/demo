package com.oss.springbootoss.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author: qsy
 * @Description: TODO
 * @Date: Created in 下午 3:52 2018/10/23/023
 */
@Setter
@Getter
@Entity
@Table(name = "t_picture")
public class Picture {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 50)
    private String picName;

    @Column(length = 200)
    private String url;

}
