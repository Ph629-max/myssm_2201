package com.bigdata.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/load")
public class FileLoadController {

    @RequestMapping("/upload")
    public String upload(MultipartFile upfile, HttpSession session) throws IOException {
        System.out.println("-------------------upload");
        // 获取上传文件的 原始名称
        String filename = upfile.getOriginalFilename();
        // 生成一个唯一的文件名
        String uniqueFilename = UUID.randomUUID().toString();
        // 获取文件后缀  扩展名
        String ext = FilenameUtils.getExtension(filename);// js  jpg png  java  class
        // 拼接出带后缀的唯一文件名
        String uniqueFilenameExt = uniqueFilename + "." + ext;

        // 获取上传文件的 类型
//        String contentType = upfile.getContentType();
//        System.out.println(contentType);

        System.out.println("===" + filename + "---" + uniqueFilename + "---" + ext + "---" + uniqueFilenameExt);

        // 保存文件
        String realPath = session.getServletContext().getRealPath("/upload");
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        upfile.transferTo(new File(realPath + File.separator + uniqueFilenameExt));
        return "uploadok";
    }

    @RequestMapping("/download")
    public void download(String name, HttpSession session, HttpServletResponse response) throws IOException {

        String realPath = session.getServletContext().getRealPath("/upload");
        String filePath = realPath + File.separator + name;
        System.out.println("---------" + filePath);

        //设置响应头  告知浏览器，要以附件的形式保存内容   filename=浏览器显示的下载文件名
        response.setHeader("content-disposition", "attachment;filename=" + name);

        // 响应
        IOUtils.copy(new FileInputStream(filePath), response.getOutputStream());

        //return null;
    }
}
