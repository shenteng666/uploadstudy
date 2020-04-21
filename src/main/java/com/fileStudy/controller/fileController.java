package com.fileStudy.controller;

import com.fileStudy.entity.file;
import com.fileStudy.service.fileService;
import com.sun.deploy.net.HttpResponse;
import com.sun.deploy.net.URLEncoder;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.coyote.http11.InputFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Myriven
 * @date 2020/4/6 21:45
 * @description
 */
@RestController
@RequestMapping("file")
public class fileController {

    @Autowired
    private fileService fileService;

    public String findAll(HttpSession session, Model model){
        List<file> fileList = fileService.findAll();
        //存到作用域
        model.addAttribute("files",fileList);
        return "";
    }

    /**
     * 上传文件
     * @return
     */
    @RequestMapping("upload")
    public String upload(MultipartFile file) throws Exception {
        //获取文件的原始名称
        String oldFileName = file.getOriginalFilename();
        //获取文件后缀
        String extension = "."+FilenameUtils.getExtension(oldFileName);
        //生成新文件名
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String newFileName=sdf+uuid+extension;

        //文件大小
        Long size = file.getSize();
        //文件类型
        String Type = file.getContentType();

        //生成存储文件的目录
        //String realPath = ResourceUtils.getURL("classpath:").getPath() + "/static/files";
        String realPath = ResourceUtils.getURL("classpath:").getPath();
        //System.out.println("======================>2"+ResourceUtils.getURL("classpath:").getPath());
        System.out.println(realPath);
        String dateFormat=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        System.out.println(realPath + "/" + dateFormat);
        File dir = new File(realPath + "/" + dateFormat);
        //判断是否存在
        if(!dir.exists()){
            dir.mkdir();
        }

        //处理文件上传
        file.transferTo(new File(dir,newFileName));

        //保存到数据库
        file fileObj = new file();
        fileObj.setOldFileName(oldFileName);
        fileObj.setNewFileName(newFileName);
        fileObj.setExt(extension);
        fileObj.setPath("/" + dateFormat);
        fileObj.setSize(String.valueOf(size));
        fileObj.setType(Type);

        //将图片信息保存到数据库
        int i = fileService.save(fileObj);
        //以下可以单写一个方法
        //List<file> fileList =new ArrayList<>();
        //if(i>0){
        //    fileList = fileService.findAll();
        //}

        return "上传成功";
    }

    /**
     *
     * @param id
     * @return
     * 文件下载必须要用唯一标识，通过唯一标识查找到文件名，
     */
    @RequestMapping("download")
    public void download(int id, HttpServletResponse response) throws Exception {
        //通过唯一标识id获取文件信息
        file downLoadFile = fileService.findById(id);
        //获取文件所在上传的路径
        String realpath = ResourceUtils.getURL("classpath:").getPath() + downLoadFile.getPath();
        //获取文件输入流
        FileInputStream fis = new FileInputStream(new File(realpath,downLoadFile.getNewFileName()));
        //如果是附件下载
        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode(downLoadFile.getOldFileName(),"UTF-8"));
        //获取响应输出流,返回响应
        ServletOutputStream os = response.getOutputStream();
        //将文件复制一份返回
        IOUtils.copy(fis,os);
        //关闭流
        IOUtils.closeQuietly(fis);
        IOUtils.closeQuietly(os);

    }

}
