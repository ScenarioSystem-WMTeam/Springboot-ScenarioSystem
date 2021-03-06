package com.internship.scenariosystem.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

//阿里云oss帮助类
public class AliyunOssHelper {

    public static String getUUID(){
        String  id = UUID.randomUUID().toString();
        String uid = id.replaceAll("-","");
        return uid;
    }

    public static String uploadImage(MultipartFile mFile) throws IOException {
        String imageUrl = "";
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "您的id";
        String accessKeySecret = "您的密码";

        String urlPrefix = "https://systemdemo.oss-cn-beijing.aliyuncs.com/";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        File file = new File("d:\\test\\photo.jpg");
        mFile.transferTo(file);
        String fileName = getUUID()+".jpg";
        String pfileName = "photo/"+getUUID()+".jpg";

        //设置文件header类型 这样图片才能再浏览器显示出来
        ObjectMetadata omd = new ObjectMetadata();
        omd.setContentType("image/jpg");


//        // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
//        InputStream inputStream = new FileInputStream("D:\\localpath\\examplefile.txt");
        // 填写Bucket名称和Object完整路径。Object完整路径中不能包含Bucket名称。
//        ossClient.putObject("systemdemo", fileName, file,omd);
        ossClient.putObject("systemdemo", pfileName, file,omd);

        // 关闭OSSClient。
        ossClient.shutdown();
        //删除临时文件
        file.deleteOnExit();

        imageUrl = urlPrefix +pfileName;

        return  imageUrl;
    }
}
