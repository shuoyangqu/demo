package com.oss.springbootoss.util;

import com.aliyun.oss.OSSClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: qsy
 * @Description: 文件保存到OSS阿里云
 * @Date: Created in 下午 4:11 2018/10/23/023
 */
public  class OSSUtil {

    private static final String ENDPOINT="";
    private static final String ACCESSKEYID="";
    private static final String ACCESSKEYSECRET="";


    /**
     * 把文件保存到阿里云OSS，返回路径保存到数据库
     * @param fileupload
     * @return
     */
    public static String getUrl(MultipartFile fileupload) throws IOException {
//        创建OSSClient实例
        OSSClient ossClient=new OSSClient(ENDPOINT,ACCESSKEYID,ACCESSKEYSECRET);
//        文件桶
        String bucketName="iteam";
//        文件名格式
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
//        该桶中的文件key
        String dateString=sdf.format(new Date())+".jpg";
//        上传文件
        ossClient.putObject(bucketName,dateString,new ByteArrayInputStream(fileupload.getBytes()));

//        设置URL过期时间为100年，默认这里是int型，转换为long型即可
        Date expiration=new Date(System.currentTimeMillis()+36001*1000*24*365*100);
//        生成URL
        URL url=ossClient.generatePresignedUrl(bucketName,dateString,expiration);
        return url.toString();
    }



}
